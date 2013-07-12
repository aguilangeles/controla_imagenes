/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Helpers.LastID;
import Entidades.LlenarTrazaDao;
import Helpers.Archivo;
import Helpers.Traza;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import Helpers.IdentificarExtension;
import Entidades.Pdf_NombreMasNumero;
import Helpers.IdentificarParent;


import tratamientoruta.BuscarPaginasPdf;
import tratamientoruta.CrearElRamdom;
import Entidades.Conexion;
import Entidades.TipodeUsuario;
import VentanaDos.Ventana_2;

/**
 *
 * @author MUTNPROD003
 */
public class Worker extends SwingWorker<Object, Object> {

    private Conexion conexion = new Entidades.Conexion();
    private TipodeUsuario usarioTipo;
    private int idDocumento;
    private int idVerificacion;
    private int idUsuario;
    private JFrame controles;
    private int idTraza;
    private JTextField ruta;
    private static List<Object> listaFiles = new ArrayList<>();
    private List<Integer> idControl;
    private String parent;
    private PDF_listarDirectorio listar;
    private String extension;
    private String ultimaCarpeta;

    public Worker(JFrame Controles, JTextField ruta, List<Integer> idControles, int idDocumento, int idVerificacion, int idUsuario) {
        this.controles = Controles;
        this.ruta = ruta;
        this.idControl = idControles;
        this.idDocumento = idDocumento;
        this.idVerificacion = idVerificacion;
        this.idUsuario = idUsuario;
        IdentificarParent ret = new IdentificarParent(new File(ruta.getText()));
        this.parent = (ret.getParent());
        String prueba = this.parent;
        String retorno="";
        if(prueba.contains("\\")){
                String replace = prueba.replace("\\", ", ");
                String [] rsplit = replace.split(", ");
                for(int i = 0; i<rsplit.length;i++){
                   retorno =(rsplit[i]);
            }
           this.ultimaCarpeta=(retorno);

        }

    }

    @Override
    protected String doInBackground() {
        if (conexion.isConexion()) {
            idTraza = new LastID(conexion, "traza").lastId();
           IdentificarExtension ext = new IdentificarExtension(ruta.getText());
            extension = (IdentificarExtension.getExtension());
            switch (extension) {
                case ".tif":
                    List listaTif = IdentificarExtension.getLista();
                    Traza trazaTif = new Traza(listaTif.size(), idVerificacion, idUsuario, idDocumento, conexion, parent, ultimaCarpeta);
                    CrearElRamdom ramdomListTif = new CrearElRamdom(listaTif, trazaTif.getCantidadMuestreada());
                    List<Object> ramdomTif = ramdomListTif.getSeleccion();
                    for (Object obj : ramdomTif) {
                        try {
                            String tif = (String) obj;
                            int parentlength = parent.length() + 1;
                            String adaptarFile = tif.substring(parentlength);
                            String filename = URLEncoder.encode(adaptarFile, "UTF-8");
                            Archivo archivo = new Archivo(conexion, idTraza, filename, 0);
                            imagenyControl();
                        } catch (UnsupportedEncodingException ex) {
                            JOptionPane.showMessageDialog(controles, ex.getMessage(), Worker.class.getName(), JOptionPane.ERROR_MESSAGE);

                        }
                    }
                    break;
                case ".pdf":

                    BuscarPaginasPdf getPages = new BuscarPaginasPdf();
                    List<Object> listaPdf = getPages.getLista();
                    Traza trazaPdf = new Traza(listaPdf.size(), idVerificacion, idUsuario, idDocumento, conexion, parent, ultimaCarpeta);
                    File file = new File(listaPdf.get(1).toString());
                    CrearElRamdom ramdomListPdf = new CrearElRamdom(listaPdf, trazaPdf.getCantidadMuestreada());
                    List<Object> ramdomPdf = ramdomListPdf.getSeleccion();
                    for (Object o : ramdomPdf) {
                        try {

                            Pdf_NombreMasNumero pagina = (Pdf_NombreMasNumero) o;
                            int parentlength = parent.length() + 1;
                            String adaptarFile = pagina.getNombre().substring(parentlength);
                            String filename = URLEncoder.encode(adaptarFile, "UTF-8");
                            int page = pagina.getNumeroPagina();
                            Archivo archivo = new Archivo(conexion, idTraza, filename, page);
                            imagenyControl();
                        } catch (UnsupportedEncodingException ex) {
                            JOptionPane.showMessageDialog(controles, ex.getMessage(), Worker.class.getName(), JOptionPane.ERROR_MESSAGE);

                        }
                    }

                    break;
                case ".jpg":
                    JOptionPane.showMessageDialog(null, "no esta configurado para el trabajo");
                    //aca lo mismo
                    break;
                case ".png":
                    List listaPng = IdentificarExtension.getLista();
                    Traza trazaPng = new Traza(listaPng.size(), idVerificacion, idUsuario, idDocumento, conexion, parent, ultimaCarpeta);
                    CrearElRamdom ramdomList = new CrearElRamdom(listaPng, trazaPng.getCantidadMuestreada());
                    List<Object> ramdom = ramdomList.getSeleccion();
                    for (Object obj : ramdom) {
                        try {
                            String tif = (String) obj;
                            int parentlength = parent.length() + 1;
                            String adaptarFile = tif.substring(parentlength);
                            String filename = URLEncoder.encode(adaptarFile, "UTF-8");
                            Archivo archivo = new Archivo(conexion, idTraza, filename, 0);
                            imagenyControl();
                        } catch (UnsupportedEncodingException ex) {
                            JOptionPane.showMessageDialog(controles, ex.getMessage(), Worker.class.getName(), JOptionPane.ERROR_MESSAGE);
                            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "no esta configurado para el trabajo");
                    isCancelled();
                    break;

            }
        }


        return null;
    }

    private void imagenyControl() {
        int id = getIdTraza() + 1;
        for (Integer idarchivo : idControl) {
            int lasid = new LastID(conexion, "archivo").lastId();
            String ret = "Insert into qualitys.traza_archivo_controles "
                    + "(idtraza, idarchivo, idcontrol, estado) VALUES "
                    + "(" + id + ", " + lasid + ", " + idarchivo + ", " + 0 + ");";
            conexion.executeUpdate(ret);
        }
    }

    public String getExtension() {
        return extension;
    }

    @Override
    protected void done() {
        if (!isCancelled()) {
            conexion.desconectar();
            int trazaID = 0;
            Conexion con = new Conexion();
            if (con.isConexion()) {
                int resultado = new LastID(con, "traza").lastId();
                trazaID = (resultado == 0) ? 1 : resultado;
                LlenarTrazaDao trazaDao = new LlenarTrazaDao(trazaID, parent, con, getExtension());
//                new VentanaSecundaria(trazaDao.getTraza()).setVisible(true);
                new Ventana(trazaDao.getTraza()).setVisible(true);
                con.desconectar();
            }else{
                System.out.println("problemas en el done");
            }
            controles.dispose();
        }
    }

    public int getIdTraza() {
        return idTraza;
    }

    public String getParent() {
        return parent;
    }
}

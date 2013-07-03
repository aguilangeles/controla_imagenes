/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package additems;

import Entidades.LlenarTrazaDao;
import VentanaVisual.Ventana;
import helper.Archivo;
import helper.Traza;
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
import tratamientoruta.EncontrarExtension;
import tratamientoruta.PaginaPdf;
import tratamientoruta.FindParent;


import tratamientoruta.GetPages;
import tratamientoruta.RamdomList;
import Entidades.Conexion;
import Entidades.TipodeUsuario;

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

    public Worker(JFrame Controles, JTextField ruta, List<Integer> idControles, int idDocumento, int idVerificacion, int idUsuario) {
        this.controles = Controles;
        this.ruta = ruta;
        this.idControl = idControles;
        this.idDocumento = idDocumento;
        this.idVerificacion = idVerificacion;
        this.idUsuario = idUsuario;
        FindParent ret = new FindParent(new File(ruta.getText()));
        this.parent = (ret.findParent());

    }

    @Override
    protected String doInBackground() {
        if (conexion.isConexion()) {
            idTraza = new LastID(conexion, "traza").lastId();
           EncontrarExtension ext = new EncontrarExtension(ruta.getText());
            extension = (EncontrarExtension.getExtension());
            switch (extension) {
                case ".tif":
                    List listaTif = EncontrarExtension.getLista();
                    Traza trazaTif = new Traza(listaTif.size(), idVerificacion, idUsuario, idDocumento, conexion);
                    RamdomList ramdomListTif = new RamdomList(listaTif, trazaTif.getCantidadMuestreada());
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

                    GetPages getPages = new GetPages();
                    List<Object> listaPdf = getPages.getLista();
                    Traza trazaPdf = new Traza(listaPdf.size(), idVerificacion, idUsuario, idDocumento, conexion);
                    File file = new File(listaPdf.get(1).toString());
                    RamdomList ramdomListPdf = new RamdomList(listaPdf, trazaPdf.getCantidadMuestreada());
                    List<Object> ramdomPdf = ramdomListPdf.getSeleccion();
                    for (Object o : ramdomPdf) {
                        try {
                            PaginaPdf pagina = (PaginaPdf) o;
                            int parentlength = parent.length() + 1;
                            String adaptarFile = pagina.getNombre().substring(parentlength);
                            String filename = URLEncoder.encode(adaptarFile, "UTF-8");
                            int page = pagina.getIdPagina();
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
                    List listaPng = EncontrarExtension.getLista();
                    Traza trazaPng = new Traza(listaPng.size(), idVerificacion, idUsuario, idDocumento, conexion);
                    RamdomList ramdomList = new RamdomList(listaPng, trazaPng.getCantidadMuestreada());
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
//            }
//        }
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

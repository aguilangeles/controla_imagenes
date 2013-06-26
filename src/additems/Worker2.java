/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package additems;

import Entidades.LlenarTrazaDao;
import Paneles.Ventana;
import Rangos.Paq.LastID;
import com.sun.pdfview.PDFFile;
import helper.Archivo;
import helper.Traza;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import org.apache.pdfbox.pdmodel.PDDocument;
import tratamientoruta.PaginaPdf;
import tratamientoruta.Sublote;
import tratamientoruta.VolumenPDF;
import writeproperties.Conexion;
import writeproperties.TipodeUsuario;

/**
 *
 * @author MUTNPROD003
 */
public class Worker2 extends SwingWorker<Object, Object> {
    private static PDFFile pdfFile;
    private List<VolumenPDF> lista;
    private writeproperties.Conexion conexion = new writeproperties.Conexion();
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

    public Worker2(JFrame Controles, JTextField ruta, List<Integer> idControles, int idDocumento, int idVerificacion, int idUsuario) {
            this.controles = Controles;
            this.ruta = ruta;
            this.idControl = idControles;
            this.idDocumento =idDocumento;
            this.idVerificacion=idVerificacion;
            this.idUsuario=idUsuario;
            File directorio = new File(ruta.getText());//<--
            listarDirectorio(directorio);//<--
            listarDeep();
            iterarLista();

    }

    @Override
    protected String doInBackground() throws Exception {
        if (conexion.isConexion()) {
            idTraza = new LastID(conexion, "traza").lastId();
            HashSet<Object> hash = new HashSet<>();
            int tamanioLote = listaFiles.size();
            Traza traza = new Traza(tamanioLote, idVerificacion, idUsuario, idDocumento, conexion);
            while (hash.size() < traza.getCantidadMuestreada()) {
                Integer a1 = new Integer(new java.util.Random().nextInt(tamanioLote));
                hash.add(a1);
            }
            ArrayList ListaHash = new ArrayList(hash);
            Collections.sort(ListaHash);
            Iterator it = ListaHash.iterator();
            while (it.hasNext()) {
                Integer idTif = (Integer) it.next();
                PaginaPdf pagina = (PaginaPdf) listaFiles.get(idTif);
                String filename = URLEncoder.encode(pagina.getNombre(), "UTF-8");
                int page = pagina.getIdPagina();
                Archivo archivo = new Archivo(conexion, idTraza, filename, page);
                imagenyControl();
            }
        }
        return null;
    }
    private  void imagenyControl() {
        int id = getIdTraza() + 1;
        for (Integer idarchivo : idControl) {
            int lasid =new LastID(conexion, "archivo").lastId();
            String ret = "Insert into qualitys.traza_archivo_controles "
                    + "(idtraza, idarchivo, idcontrol, estado) VALUES "
                    + "("+id+ ", "+ lasid + ", " + idarchivo + ", " + 0 + ");";
            conexion.executeUpdate(ret);
        }
    }
    @Override
    protected void done() {
        if (!isCancelled()) {
            conexion.desconectar();
            int trazaID = 0;
            Conexion con = new Conexion();
                if(con.isConexion()){
                int resultado = new LastID(con, "traza").lastId();
                trazaID = (resultado ==0)?1:resultado;
//                LlenarTrazaDao trazaDao = new LlenarTrazaDao(trazaID, getParent(),con);
//
//                new Ventana(trazaDao.getTraza()).setVisible(true);
//                new Ventana(trazaDao.getTraza()).setVisible(true);
                con.desconectar();
           }
            controles.dispose();
        }

    }

    public int getIdTraza() {
        return idTraza;
    }

    public void listarDirectorio(File f) {
        lista = new ArrayList<>();
        int contador = 0;
        File[] files = f.listFiles();
        parent = files[1].getParent();
        for (int x = 0; x < files.length; x++) {
            if (files[x].isDirectory()) {
                contador++;
                String absolutePath = files[x].getAbsolutePath();
                VolumenPDF directorio = new VolumenPDF(contador, absolutePath, null);
                lista.add(directorio);
            }
        }
    }

    public String getParent() {
        return parent;
    }

    public List<Sublote> listarDirectorio_1(File f) {
        Sublote sublote;
        List<Sublote> listSub = new ArrayList<>();
        boolean pdf;
        int contador = 0;
        File[] files = f.listFiles();
        for (int x = 0; x < files.length; x++) {
            pdf = (files[x].getName().endsWith(".pdf")) ? true : false;
            if (pdf) {
                try {
                    contador++;
                    String absolutePath = (files[x].getAbsolutePath());
                    String fileName = (files[x].getName());
                    PDDocument doc = PDDocument.load(absolutePath);
                    int pagina = doc.getDocumentCatalog().getAllPages().size();
                    sublote = new Sublote(contador, absolutePath, getParent(), fileName, pagina);
                    System.out.println(sublote);
                    listSub.add(sublote);
                    doc.close();
                } catch (IOException ex) {
                    Logger.getLogger(Worker2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }//fin for
        return listSub;
    }
    private void listarDeep() {
        for (VolumenPDF volumen : lista) {
            File f = new File(volumen.getAbsolutePath());
            volumen.setSublotes(listarDirectorio_1(f));
        }
    }

    private int iterarLista() {
        int contador = 0;
        for (VolumenPDF v : getLista()) {
            for (Sublote sub : v.getSublotes()) {
                for (PaginaPdf pdf : sub.getPdfpagina()) {
                    System.out.println(pdf);
                    contador++;
                    listaFiles.add(pdf);
                }
            }
        }
        return contador;

    }
    public  List<VolumenPDF> getLista() {
        return lista;
    }
}

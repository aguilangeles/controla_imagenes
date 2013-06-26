/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package additems;

import Entidades.LlenarTrazaDao;
import Paneles.Ventana;
import Rangos.Paq.LastID;
import helper.Archivo;
import helper.Traza;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import writeproperties.TipodeUsuario;

/**
 *
 * @author MUTNPROD003
 */
public class Worker1 extends SwingWorker<Object, Object> {
    private writeproperties.Conexion conexion=new writeproperties.Conexion();
     private TipodeUsuario usarioTipo;
    private int idDocumento;
    private int idVerificacion;
    private int idUsuario;
    private JFrame controles;
    private int idTraza;
    private JTextField ruta;
    private static List<String> listaFiles = new ArrayList<>();
    private List<Integer> idControl;

    public Worker1(JFrame Controles, JTextField ruta, List<Integer> idControles, int idDocumento, int idVerificacion, int idUsuario) {
            this.controles = Controles;
            this.ruta = ruta;
            this.idControl = idControles;
            this.idDocumento =idDocumento;
            this.idVerificacion=idVerificacion;
            this.idUsuario=idUsuario;
            File directorio = new File(ruta.getText());//<--
            listarDirectorio(directorio);//<--

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
                String ret = URLEncoder.encode(listaFiles.get(idTif), "UTF-8");
                Archivo archivo = new Archivo(conexion, idTraza, ret,0);
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
            int ret = 0;
            writeproperties.Conexion c = new writeproperties.Conexion();
                if(c.isConexion()){
                int resultado = new LastID(conexion, "traza").lastId();
                ret = (resultado ==0)?1:resultado;
//                LlenarTrazaDao trazaDao = new LlenarTrazaDao(ret, "",c);
//                new Ventana(trazaDao.getTraza()).setVisible(true);
                c.desconectar();
           }
            controles.dispose();
        }

    }

    public int getIdTraza() {
        return idTraza;
    }

    public static void listarDirectorio(File f) {
        boolean isTif;
        File[] files = f.listFiles();
        System.out.println();
        for (int x = 0; x < files.length; x++) {
            isTif = (files[x].getName().endsWith(".tif")) ? true : false;
            if (files[x].isDirectory()) {
                System.out.println(files[x].getAbsolutePath());
                listarDirectorio(files[x]);
            }
            if (isTif) {
                String ret = (files[x].getAbsolutePath());
                String ret2 = (files[x].getName()+"\t"+files[x].getParent()+"\t"+files[x].getPath());
                System.out.println(ret2);
                listaFiles.add(ret);

               }
            }
        }
}

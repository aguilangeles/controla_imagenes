/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MUTNPROD003
 */
public class LlenarTrazaDao {
    private int id;
    private Conexion conexion;
    private TrazaDao traza;
    private String parent;
    private String extension;
    private boolean pdfFile;


    public LlenarTrazaDao(int trazaID, String parent, Conexion con, String extension) {
        try {
            this.id = trazaID;
            this.parent = URLEncoder.encode(parent + "\\", "UTF-8");//parent+"\\";
            //System.out.println(parent);
            this.conexion = con;
            this.extension = extension;
            switch (extension) {
                case ".tif":
                    this.pdfFile =false;
                    llenartraza();
                    break;
                case ".pdf":
                    this.pdfFile=true;
                    llenartraza();
                    break;
                    case ".png":
                    this.pdfFile =false;
                    llenartraza();
                    break;
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(LlenarTrazaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        private TrazaDao llenartraza() {
            traza = new TrazaDao(id, new LlenarArchivo(conexion, id, parent, isPdfFile()).getListaArchivos(),
                    extension,new LlenarTipos(conexion, id).getListadeTipos());
            return traza;
        }

//        private TrazaDao llenarTrazaParaTif() {
//            traza = new TrazaDao(id, new LlenarArchivo(conexion, id, parent).getListaArchivos(),
//                    new LlenarTipos(conexion, id).getListadeTipos());
//            return traza;
//        }

        public TrazaDao getTraza() {
            return traza;
        }

    public boolean isPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(boolean pdfFile) {
        this.pdfFile = pdfFile;
    }

    @Override
    public String toString() {
        return "LlenarTrazaDao{" + "id=" + id + ", traza=" + traza + '}';
    }

}

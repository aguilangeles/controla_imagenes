/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class LlenarTrazaDao {
  private JLabel procesando;
    private int id;
    private Conexion conexion;
    private TrazaDao traza;
    private String parent;
    private String extension;
    private boolean pdfFile;


  public LlenarTrazaDao(int trazaID, String parent, Conexion con, String extension, JLabel procesando) {
    try {
      this.id = trazaID;
      this.parent = URLEncoder.encode(parent + "\\", "UTF-8");//parent+"\\";
      this.conexion = con;
      this.extension = extension;
      this.procesando=procesando;
      switch (extension) {
        case ".tif":
        case ".png":
        case ".jpg":
          this.pdfFile = false;
          llenartraza();
          break;
        case ".pdf":
          this.pdfFile = true;
          llenartraza();
          break;
      }
    } catch (UnsupportedEncodingException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Llenar Traza : encoding", JOptionPane.ERROR_MESSAGE);

//      Logger.getLogger(LlenarTrazaDao.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

        private TrazaDao llenartraza() {
            traza = new TrazaDao(id, new LlenarArchivo(conexion, id, parent, isPdfFile(), procesando).getListaArchivos(),
                    extension,new LlenarTipos(conexion, id).getListadeTipos());
            return traza;
        }


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

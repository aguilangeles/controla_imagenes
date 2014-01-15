/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import entidad.Imagen;
import Helpers.MensajeJoptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Genera una lista de los archivos insertados en la base de datos según el
 * idtraza.
 *
 * @author MUTNPROD003
 */
public class SelectArchivobyTrazaList {

  private String className = SelectArchivobyTrazaList.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  private List<Object> imagenProcesadaList = new ArrayList<>();
  MensajeJoptionPane mensaje = new MensajeJoptionPane(null, type);

  public SelectArchivobyTrazaList(Conexion conexion, int idTraza, String parent, boolean isVolume) {
    getArchivo(conexion, idTraza, parent);
  }

  private void getArchivo(Conexion conexion, int idTraza, String parent) {
    Imagen imagen;
    try
      {
      String query = "SELECT id "
              + ", ruta_archivo "
              + ", pagina_pdf "
              + "FROM qualitys.archivo "
              + "where idtraza = " + idTraza + ";";
      conexion.executeQuery(query);
      while (conexion.resulset.next())
        {
        int id = conexion.resulset.getInt(1);
        String ruta_archivo = conexion.resulset.getString(2);
        int pagina = conexion.resulset.getInt(3);
        imagen = new Imagen(id, ruta_archivo, parent, pagina);
        imagenProcesadaList.add(imagen);
        }
      } catch (SQLException ex)
      {
      mensaje.getMessage(ex.getMessage(), className);
      }
  }

  public List<Object> getImagenesList() {
    return imagenProcesadaList;
  }
}

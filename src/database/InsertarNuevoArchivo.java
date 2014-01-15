/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Helpers.MensajeJoptionPane;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Inserta en archivo, id, ruta, numero de pagina y estado cero
 *
 * @author MUTNPROD003
 */
public class InsertarNuevoArchivo {

  private static final String className = InsertarNuevoArchivo.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  MensajeJoptionPane msg = new MensajeJoptionPane(null, type);
  private Conexion conexion;
  private int id = 1;
  private int idcategoria;
  private String ruta;
  private int page;

  public InsertarNuevoArchivo(Conexion conexion,
          int id, String ruta, int page, JLabel procesando, int idcategoria) {
    this.conexion = conexion;
    this.id += id;
    this.ruta = ruta;
    this.page = page;
    this.idcategoria = idcategoria;
    archivo_Insertar(procesando);
  }

  private boolean archivo_Insertar(JLabel procesando) {
    int estado = 0;
    String insertar = "Insert into qualitys.archivo "
            + "( idTraza"
            + ", ruta_archivo "
            + ", estado"
            + ", pagina_pdf "
            + ", idCategoria) "
            + " VALUES (" + id
            + ", '" + ruta
            + "', " + estado
            + ", " + page
            + ", " + idcategoria
            + ");";
    procesando.setText("Insertando en DB " + ruta);
    try
      {
      conexion.executeUpdate(insertar);
      } catch (SQLException ex)
      {
      msg.getMessage(ex.getMessage(), className);
      }
    return false;
  }
}

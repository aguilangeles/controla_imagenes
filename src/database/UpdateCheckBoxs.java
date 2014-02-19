/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import helper.MensajeJoptionPane;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Modifica el estado del archivo (en funcion de lo que lee en los check box) Si
 * el archivo posee un cb tildado, su estado sera 0
 *
 * @author MUTNPROD003
 */
public class UpdateCheckBoxs {

  private static final String className = UpdateCheckBoxs.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  MensajeJoptionPane msg = new MensajeJoptionPane(null, type);
  private int estado;
  private int idtrazaArchivo;
  private Conexion conexion;

  public UpdateCheckBoxs(int estado, int idtrazaArchivo, Conexion conexion) {
    this.estado = estado;
    this.idtrazaArchivo = idtrazaArchivo;
    this.conexion = conexion;
  }

  public void updateEstadoTraza() {
    String update = "UPDATE traza_archivo_controles "
            + "SET estado = " + estado
            + " WHERE id= " + idtrazaArchivo + ";";
    try {
      conexion.executeUpdate(update);
    } catch (SQLException ex) {
      msg.getMessage(ex.getMessage(), className);
    }
  }

  public void updateEstadoArchivo(int id) {
    String update = "UPDATE archivo SET estado =  1 WHERE id = " + id + ";";
    try {
      conexion.executeUpdate(update);
    } catch (SQLException ex) {
      msg.getMessage(ex.getMessage(), className);
    }
  }
}

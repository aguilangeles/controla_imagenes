/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import database.Conexion;
import entidad.Usuario;
import helper.MensajeJoptionPane;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * setea la fecha de ingreso del usuario validado
 *
 * @author MUTNPROD003
 */
public class UpdateFechaIngreso {

  public UpdateFechaIngreso() {
  }

  public UpdateFechaIngreso(Usuario usuario) {
    setFecha(usuario);
  }

  private void setFecha(Usuario usuario) {
    Conexion conexion = new Conexion();
    if (conexion.isConexion())
      {
      try
        {
        String update = "UPDATE `qualitys`.`usuarios` "
                + "SET`fecha_ingreso` = '"
                + usuario.getFechaUltimoIngreso()
                + "' WHERE id = "
                + usuario.getId() + ";";
        conexion.executeUpdate(update);
        conexion.isConexionClose();
        } catch (SQLException ex)
        {
        MensajeJoptionPane mensaje = new MensajeJoptionPane(null, JOptionPane.ERROR_MESSAGE);
        mensaje.getMessage(ex.getMessage(), UpdateFechaIngreso.class.getName());
        }
      }
  }
}

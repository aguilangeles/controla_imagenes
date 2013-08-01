/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Entidades.Conexion;
import Entidades.TipodeUsuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * setea la fecha de ingreso del usuario validado
 *
 * @author MUTNPROD003
 */
public class SetFechaUltimoIngresoUsuario {

  private TipodeUsuario tipoUsuario;

  public SetFechaUltimoIngresoUsuario() {
  }

  SetFechaUltimoIngresoUsuario(TipodeUsuario usuarioTipo) {
    this.tipoUsuario = usuarioTipo;
    setFecha();
  }

  private void setFecha() {
    Conexion conexion = new Conexion();
    if (conexion.isConexion()) {
      try {
        String ret = "UPDATE `qualitys`.`usuarios` SET`fecha_ingreso` = '"
                + tipoUsuario.getFechaUltimoIngreso() + "' WHERE id = "
                + tipoUsuario.getId() + ";";
        conexion.executeUpdate(ret);
        conexion.desconectar();
      } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en Seteo de Fecha", JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(SetFechaUltimoIngresoUsuario.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}

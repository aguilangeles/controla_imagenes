/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Entidades.Conexion;
import Daos.Usuario;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * setea la fecha de ingreso del usuario validado
 *
 * @author MUTNPROD003
 */
public class SetFechaDeIngreso {

  public SetFechaDeIngreso() {
  }

  SetFechaDeIngreso(Usuario usuario) {
    setFecha(usuario);
  }

  private void setFecha(Usuario usuario) {
    Conexion conexion = new Conexion();
    if (conexion.isConexion()) {
      try {
        String ret = "UPDATE `qualitys`.`usuarios` SET`fecha_ingreso` = '"
                + usuario.getFechaUltimoIngreso() + "' WHERE id = "
                + usuario.getId() + ";";
        conexion.executeUpdate(ret);
        conexion.isConexionClose();
      } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en Seteo de Fecha", JOptionPane.ERROR_MESSAGE);
//        Logger.getLogger(SetFechaDeIngreso.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}

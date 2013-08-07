/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Daos.Usuario;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public final class ValidarIngreso {

  private String aName;
  private String aPassw;
  private Usuario usuarioValidado = null;
  private boolean usuario;

  public ValidarIngreso(String aName, String aPassw) {
    this.aName = aName.trim();
    this.aPassw = aPassw.trim();
    verificarUsuarioEnBaseDeDatos();

  }

  private void verificarUsuarioEnBaseDeDatos() {
    Conexion conexion = new Conexion();
    try {
      if (conexion.isConexion()) {
        conexion.executeQuery("SELECT id, nombre, password, tipo, estado FROM usuarios;");
        while (conexion.resulset.next()) {
          int id = conexion.resulset.getInt(1);
          String nombre = conexion.resulset.getString(2);
          String contrasenia = conexion.resulset.getString(3);
          int tipo = conexion.resulset.getInt(4);
          int estado = conexion.resulset.getInt(5);
          Usuario user = new Usuario(id, nombre, contrasenia, tipo, estado);
          if (isUsuarioExistente_y_Activo(user)) {
            usuario = true;
            usuarioValidado = user;
          }
        }
      }
      conexion.isConexionClose();
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, e.getMessage(), "Error en la Validación del Usuario", JOptionPane.ERROR_MESSAGE);
    }
  }

  private boolean isUsuarioExistente_y_Activo(Usuario tipoUsuari) {
    if (tipoUsuari.getNombre().equalsIgnoreCase(aName)
            && tipoUsuari.getPassw().equalsIgnoreCase(aPassw)
            && tipoUsuari.isActivo()) {
      return true;
    }
    return false;
  }

  public boolean isUsuario() {
    return usuario;
  }

  public void setUsuario(boolean usuario) {
    this.usuario = usuario;
  }

  public Usuario getUsuarioValidado() {
    return usuarioValidado;
  }

  public void setTipoUsuario(Usuario tipoUsuario) {
    this.usuarioValidado = tipoUsuario;
  }
}

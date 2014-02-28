/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import entidad.Usuario;
import helper.MensajeJoptionPane;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Busca en la base de datos todos los usuarios, y los compara con los datos de
 * ingreso en el frame. Si los campos son validados y es usuario activo, permite
 * acceder al Panel de Control
 *
 * @author MUTNPROD003
 */
public final class SelectUsuarioyCategoria {

  private static final String className = SelectUsuarioyCategoria.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  MensajeJoptionPane msg = new MensajeJoptionPane(null, type);
  private Usuario usuarioValidado = null;
  private boolean usuario;

  public SelectUsuarioyCategoria(String aName, String aPassw) {
    String name = aName.trim();
    String password = aPassw.trim();
    verificarUsuarioEnBaseDeDatos(name, password);

  }

  private void verificarUsuarioEnBaseDeDatos(String name, String password) {
    Conexion conexion = new Conexion();
    try
      {
      if (conexion.isConexion())
        {
        conexion.executeQuery("SELECT id "
                + ", nombre"
                + ", password"
                + ", tipo"
                + ", estado"
                + " FROM usuarios;");
        while (conexion.resulset.next())
          {
          int id = conexion.resulset.getInt(1);
          String nombre = conexion.resulset.getString(2);
          String contrasenia = conexion.resulset.getString(3);
          int tipo = conexion.resulset.getInt(4);
          int estado = conexion.resulset.getInt(5);
          Usuario aUsuario = new Usuario(id, nombre, contrasenia, tipo, estado);
          if (userExistsandIsActive(aUsuario, name, password))
            {
            usuario = true;
            usuarioValidado = aUsuario;
            }
          }
        }
      conexion.isConexionClose();
      } catch (SQLException e)
      {
      msg.getMessage(e.getMessage(), className);
      }
  }

  private boolean userExistsandIsActive(Usuario tipoUsuari, String aName, String aPassw) {
    if (tipoUsuari.getNombre().equalsIgnoreCase(aName)
            && tipoUsuari.getPassw().equalsIgnoreCase(aPassw)
            && tipoUsuari.isActivo())
      {
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

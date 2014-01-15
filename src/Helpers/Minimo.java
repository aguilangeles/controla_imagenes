/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import database.Conexion;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class Minimo {

  private Conexion conexion = new Conexion();

  public Minimo() {
  }

  public int minimoMasUno(int id) {
    int ret = 1;
    if (conexion.isConexion())
      {
      try
        {
        conexion.executeQuery("SELECT maximo FROM qualitys.rangos_qs where id =" + id);
        while (conexion.resulset.next())
          {
          ret += conexion.resulset.getInt(1);
          }
        } catch (SQLException ex)
        {
        new MensajeJoptionPane(null, JOptionPane.ERROR_MESSAGE).getMessage(ex.getMessage(), Minimo.class.getName());
        }
      }
    conexion.isConexionClose();
    return ret;
  }
}

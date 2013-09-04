/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import BasedeDatos.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author MUTNPROD003
 */
public class Minimo {
    private Conexion conexion=new Conexion();

  public Minimo() {
  }


  public int minimoMasUno(int id) {
    int ret = 0;
    if (conexion.isConexion()) {
      try {
        conexion.executeQuery("SELECT maximo FROM qualitys.rangos_qs where id =" + id);
        while (conexion.resulset.next()) {
          ret = conexion.resulset.getInt(1);
        }
      } catch (SQLException ex) {
        Logger.getLogger(Minimo.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    conexion.isConexionClose();
    int resultado= ret+1;
    return resultado;
  }
//SELECT maximo FROM qualitys.rangos_qs where id =1;

}

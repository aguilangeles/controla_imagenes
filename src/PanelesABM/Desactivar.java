/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelesABM;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import Entidades.Conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class Desactivar {
  private Conexion conexion;private DefaultTableModel modelo;
  private String tablaDB;
  private int aID,  tablaEstado;
  public static final String DB_FAIL="Error en el update Estado";

//    public Desactivar(Conexion conexion, DefaultTableModel modelo, String tablaDB, int aID, int tablaEstado) {
////        modificarEstado(conexion, modelo, tablaDB, aID, tablaEstado);
//    }

  public Desactivar(Conexion conexion, DefaultTableModel modelo, String tablaDB, int aID, int tablaEstado) {
    this.conexion = conexion;
    this.modelo = modelo;
    this.tablaDB = tablaDB;
    this.aID = aID;
    this.tablaEstado = tablaEstado;
  }



  private int obtenerEstado(Conexion conexion, String tablaDB, int ide) {
    int ret = 0;
    try {
      String getEstado = "SELECT estado FROM " + tablaDB + " where id = " + ide + ";";
      conexion.ExecuteSql(getEstado);
      while (conexion.resulset.next()) {
        int estado = conexion.resulset.getInt(1);
        if (estado == 1) {
          ret = 2;
        } else if (estado == 2) {
          ret = 1;
        }
      }
    } catch (SQLException ex) {
      Logger.getLogger(Desactivar.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ret;
  }

  public boolean modificarEstado() {
    int ide = aID + 1;
    int estado = obtenerEstado(conexion, tablaDB, ide);
    String set = "UPDATE `" + tablaDB + "` SET  `estado` = " + estado + " WHERE id =" + ide + ";";
    try {
      conexion.executeUpdate(set);
      modelo.setValueAt(estado, aID, tablaEstado);
      return true;
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage(),DB_FAIL , JOptionPane.ERROR_MESSAGE);
      return false;
    }
  }

}

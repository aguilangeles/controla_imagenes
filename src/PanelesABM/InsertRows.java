/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelesABM;

import javax.swing.table.DefaultTableModel;
import Entidades.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class InsertRows {

  private Conexion conexion;
  private DefaultTableModel modelo;
  public static final String BD_FAIL = "Error en los contenidos ingresados";

  public InsertRows(Conexion conexion, DefaultTableModel modelo) {
    this.conexion = conexion;
    this.modelo = modelo;
  }

  public boolean insert_newRango(int id) {
    String insertar = "INSERT INTO `qualitys`.`rangos_qs`"
            + "(`minimo`, `maximo`, `muestra`, `cant_rechazo`, `estado`) "
            + "VALUES (" + modelo.getValueAt(id, 1)
            + ", " + modelo.getValueAt(id, 2)
            + ", " + modelo.getValueAt(id, 3)
            + ", " + modelo.getValueAt(id, 4)
            + ", " + estadoValido(modelo, id, 5)
            + ");";
    try {
      conexion.executeUpdate(insertar);
      return true;
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      Logger.getLogger(InsertRows.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }

  }

  public boolean insert_newControl(int id) {
    String insertar = "INSERT INTO `controles` (`descripcion`, `texto`, `imagen`, "
            + "`estado`) VALUES( '"
            + modelo.getValueAt(id, 1)
            + "', '" + modelo.getValueAt(id, 2)
            + "', '" + modelo.getValueAt(id, 3)
            + "'," + estadoValido(modelo, id, 4) + " );";
    try {
      conexion.executeUpdate(insertar);
      return true;
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage(), BD_FAIL, JOptionPane.ERROR_MESSAGE);
      return false;
    }
  }

  private int estadoValido(DefaultTableModel modelo, int ide, int columna) {
    int ret = 0;
    int caso = (int) modelo.getValueAt(ide, columna);
    switch (caso) {
      case 1:
        ret = caso;
        break;
      case 2:
        ret = caso;
        break;
      default:
        String valorInput = JOptionPane.showInputDialog(null, "El estado debe ser '"
                + "'1' activo, '2' inactivo", JOptionPane.QUESTION_MESSAGE);
        ret = Integer.parseInt(valorInput);
        break;
    }
    modelo.setValueAt(ret, ide, columna);
    return ret;
  }
  private int tipo(DefaultTableModel modelo, int ide, int columna) {
    int ret = 0;
    int caso = (int) modelo.getValueAt(ide, columna);
    switch (caso) {
      case 1:
        ret = caso;
        break;
      case 2:
        ret = caso;
        break;
      default:
        String valorInput = JOptionPane.showInputDialog(null, "El usuario debe ser '"
                + "'1' admin, '2' carga", JOptionPane.QUESTION_MESSAGE);
        ret = Integer.parseInt(valorInput);
        break;
    }
    modelo.setValueAt(ret, ide, columna);
    return ret;
  }

  public boolean insert_newUsuario(int id) {
    String up = "INSERT INTO `qualitys`.`usuarios`(`nombre`, `password`, `tipo`, `estado`, `fecha_ingreso`) "
            + "VALUES ('" + modelo.getValueAt(id, 1)
            + "', '" + modelo.getValueAt(id, 2)
            + "', " + tipo(modelo, id, 3)
            + ", " + estadoValido(modelo, id, 4)
            + ", '0000-00-00 00:00:00');";// esta fecha no es la de ultimo ingreso , sino la de creacion, y no esta creada en la db.
    try {
      conexion.executeUpdate(up);
      return true;
    } catch (SQLException ex) {
      Logger.getLogger(InsertRows.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
  }
}

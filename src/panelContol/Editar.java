/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panelContol;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import database.Conexion;
import helper.MensajeJoptionPane;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class Editar {

  private String classname = Editar.class.getName();
  private MensajeJoptionPane msg;
  private int selectedData;
  private JTable tabla;
  private Conexion conexion;
  private DefaultTableModel modelo;

  public Editar(Conexion conexion, DefaultTableModel modelo) {
    this.conexion = conexion;
    this.modelo = modelo;
  }

  public boolean rangos_SetRow(int ide) {
    int masId = ide + 1;
    String updateRangos = "UPDATE `qualitys`.`rangos_qs` SET  "
            + "`minimo` = " + modelo.getValueAt(ide, 1)
            + ", `maximo` = " + modelo.getValueAt(ide, 2)
            + ", `muestra` = " + modelo.getValueAt(ide, 3)
            + ", `cant_rechazo` = " + modelo.getValueAt(ide, 4)
            + ", `estado` = " + estadoValido(modelo, ide, 5)
            + " WHERE id =" + masId + ";";
    try
      {
      conexion.executeUpdate(updateRangos);
      return true;
      } catch (SQLException ex)
      {
      msg = new MensajeJoptionPane(null, JOptionPane.ERROR_MESSAGE);
      msg.getMessage(ex.getMessage(), classname);
      return false;
      }
  }

  public boolean controles_SetRow(int id) {
    int masId = id + 1;
    String set = "UPDATE `controles` SET `descripcion` = '" + modelo.getValueAt(id, 1)
            + "', `texto` = '" + modelo.getValueAt(id, 2)
            + "',`imagen` = '" + modelo.getValueAt(id, 3)
            + "', `estado` = " + estadoValido(modelo, id, 4)
            + " WHERE id = " + masId + ";";
    try
      {
      conexion.executeUpdate(set);
      return true;
      } catch (SQLException ex)
      {
      msg.getMessage(ex.getMessage(), classname);
      return false;
      }
  }

  private int estadoValido(DefaultTableModel modelo, int ide, int columna) {
    int ret = 0;
    int caso = (int) modelo.getValueAt(ide, columna);
    switch (caso)
      {
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

  public void verificaciones_setRow() {
    // no tiene editar, la verificacion.
  }

  public boolean usuarios_setRow(int id) {
    try
      {
      int masId = id + 1;
      String set = "UPDATE `qualitys`.`usuarios` "
              + "SET `nombre` = '" + modelo.getValueAt(id, 1)
              + "', `password` = '" + modelo.getValueAt(id, 2)
              + "', `tipo` = " + tipo(modelo, id, 3)
              + ", `estado` = " + estadoValido(modelo, id, 4)
              + " WHERE id = " + masId + ";";
      conexion.executeUpdate(set);
      return true;
      } catch (SQLException ex)
      {
      msg.getMessage(ex.getMessage(), classname);
      return false;
      }
  }

  private int tipo(DefaultTableModel modelo, int ide, int columna) {
    int ret = 0;
    int caso = (int) modelo.getValueAt(ide, columna);
    switch (caso)
      {
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
}

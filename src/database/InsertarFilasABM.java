/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import helper.MensajeJoptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Genera una nueva fila en los campos Rango, Control Usuario
 *
 * @author MUTNPROD003
 */
public class InsertarFilasABM {

  private Conexion conexion;
  private DefaultTableModel modelo;
  public static final String BD_FAIL = "Error en los contenidos ingresados";
  private static final String className = InsertarFilasABM.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  MensajeJoptionPane msg = new MensajeJoptionPane(null, type);

  public InsertarFilasABM(Conexion conexion, DefaultTableModel modelo) {
    this.conexion = conexion;
    this.modelo = modelo;
  }

  public boolean nuevoRango(int id) {
    String insertar = "INSERT INTO `qualitys`.`rangos_qs`"
            + "(`minimo`"
            + ", `maximo`"
            + ", `muestra`"
            + ", `cant_rechazo`"
            + ", `estado`) "
            + "VALUES (" + modelo.getValueAt(id, 1)
            + ", " + modelo.getValueAt(id, 2)
            + ", " + modelo.getValueAt(id, 3)
            + ", " + modelo.getValueAt(id, 4)
            + ", " + asegurarseEstadoValido(modelo, id, 5)
            + ");";
    try
      {
      conexion.executeUpdate(insertar);
      return true;
      } catch (SQLException ex)
      {
      msg.getMessage(ex.getMessage(), BD_FAIL);
      return false;
      }
  }

  public boolean nuevoControl(int id) {
    String insertar = "INSERT INTO `controles` "
            + "(`descripcion`"
            + ", `texto`"
            + ", `imagen`"
            + ", `estado`) "
            + "VALUES( '"
            + modelo.getValueAt(id, 1)
            + "', '" + modelo.getValueAt(id, 2)
            + "', '" + modelo.getValueAt(id, 3)
            + "'," + asegurarseEstadoValido(modelo, id, 4) + " );";
    try
      {
      conexion.executeUpdate(insertar);
      return true;
      } catch (SQLException ex)
      {
      msg.getMessage(ex.getMessage(), BD_FAIL);
      return false;
      }
  }

  public boolean nuevoUsuario(int id) {
    String up = "INSERT INTO `qualitys`.`usuarios`"
            + "(`nombre`"
            + ", `password`"
            + ", `tipo`"
            + ", `estado`"
            + ", `fecha_ingreso`) "
            + "VALUES ('" + modelo.getValueAt(id, 1)
            + "', '" + modelo.getValueAt(id, 2)
            + "', " + asegurarseTipoValido(modelo, id, 3)
            + ", " + asegurarseEstadoValido(modelo, id, 4)
            + ", '0000-00-00 00:00:00');";
    // esta fecha no es la de ultimo ingreso , sino la de creacion, y no esta creada en la db.
    try
      {
      conexion.executeUpdate(up);
      return true;
      } catch (SQLException ex)
      {
      msg.getMessage(ex.getMessage(), BD_FAIL);
      return false;
      }
  }

  private int asegurarseEstadoValido(DefaultTableModel modelo, int ide, int columna) {
    int ret;
    int caso = (int) modelo.getValueAt(ide, columna);
    switch (caso)
      {
      case 1:
      case 2:
        ret = caso;
        break;
      default:
        String valorInput = JOptionPane.showInputDialog(null, "El estado debe ser '"
                + "'1' activo, '2' inactivo", "Estado invalido", JOptionPane.QUESTION_MESSAGE);
        ret = Integer.parseInt(valorInput);
        break;
      }
    modelo.setValueAt(ret, ide, columna);
    return ret;
  }

  private int asegurarseTipoValido(DefaultTableModel modelo, int ide, int columna) {
    int ret;
    int caso = (int) modelo.getValueAt(ide, columna);
    switch (caso)
      {
      case 1:
      case 2:
        ret = caso;
        break;
      default:
        String valorInput = JOptionPane.showInputDialog(null, "El usuario debe ser '"
                + "'1' admin, '2' carga", "Tipo de usuario invalido", JOptionPane.QUESTION_MESSAGE);
        ret = Integer.parseInt(valorInput);
        break;
      }
    modelo.setValueAt(ret, ide, columna);
    return ret;
  }
}

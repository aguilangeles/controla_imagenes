/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PaneldeControl;

import database.InsertarFilasABM;
import database.SelectLastID;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import database.Conexion;
import helper.MensajeJoptionPane;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class RangosDao extends ABMPaneles {

  private String classname = RangosDao.class.getName();
  private static final String NOMBRE_TABLA = "rangos_qs;";
  private Conexion aConexion;
  private JTable aTable;
  private int lastId;
  private boolean editable;
  private Editar editar;
  private InsertarFilasABM insertar;

  public RangosDao(Conexion conexion, JTable tabla) {
    this.aConexion = conexion;
    this.aTable = tabla;
    DefaultTableModel modelo = modelar();
    aTable.setModel(modelo);
    this.editar = new Editar(aConexion, modelo);
    this.insertar = new InsertarFilasABM(aConexion, modelo);
  }

  private DefaultTableModel modelar() {
    DefaultTableModel model = new DefaultTableModel() {
      @Override
      public boolean isCellEditable(int fila, int columna) {
        if (columna == 0)
          {
          return false;
          }
        return isEditable();
      }

      @Override
      public Class getColumnClass(int col) {
        switch (getColumnCount())
          {
          case 0:
            return Integer.class;
          case 1:
            return Integer.class;
          case 2:
            return Integer.class;
          case 3:
            return Integer.class;
          case 4:
            return Integer.class;
          default:
            return Integer.class;
          }
      }
    };
    setTitulos(model);
    setConsulta(model);
    return model;
  }

  private void setConsulta(DefaultTableModel model) {
    List<Object[]> lista = new ArrayList<>();
    if (aConexion.isConexion())
      {
      try
        {
        aConexion.executeQuery("SELECT * FROM " + NOMBRE_TABLA);
        while (aConexion.resulset.next())
          {
          lista.add(new Object[]
            {
            aConexion.resulset.getInt(1), aConexion.resulset.getInt(2),
            aConexion.resulset.getInt(3), aConexion.resulset.getInt(4),
            aConexion.resulset.getInt(5), aConexion.resulset.getInt(6)
            });
          }
        } catch (SQLException ex)
        {
        MensajeJoptionPane msg = new MensajeJoptionPane(tabla, JOptionPane.ERROR_MESSAGE);
        msg.getMessage(ex.getMessage(), classname);
        }
      }
    consulta(model, lista);
  }

  private void setTitulos(DefaultTableModel model) {
    String split = "id, minimo, maximo, muestra, rechazos, estado";
    titulos(model, split);
  }

  public int getLastId() {
    return new SelectLastID(aConexion, NOMBRE_TABLA).getUltimoID();
  }

  public Editar getEditar() {
    return editar;
  }

  public InsertarFilasABM getInsertar() {
    return insertar;
  }

  public boolean isEditable() {
    return editable;
  }

  public void setEditable(boolean editable) {
    this.editable = editable;
  }
}

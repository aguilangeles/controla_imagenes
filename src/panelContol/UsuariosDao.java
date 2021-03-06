/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panelContol;

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
public class UsuariosDao extends ABMPaneles {

  private static final String NOMBRE_TABLA = "usuarios";
  private Conexion aConexion;
  private JTable aTable;
  private Editar editar;
  private InsertarFilasABM insertar;
  private boolean editable;
  private int lastId;

  public UsuariosDao(JTable tabla, Conexion conexion) {
    super(conexion, tabla);
    this.aTable = tabla;
    this.aConexion = conexion;
    DefaultTableModel modelo = verTodos();
    aTable.setModel(modelo);
    centrarColumna(0);
    centrarColumna(3);
    centrarColumna(4);
    this.editar = new Editar(aConexion, modelo);
    this.insertar = new InsertarFilasABM(aConexion, modelo);
  }

  private DefaultTableModel verTodos() {
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
        switch (getColumnName(col))
          {
          case "id":
            return Integer.class;
          case "nombre"://nombre
            return String.class;
          case "password"://password
            return String.class;
          case "tipo"://tipo
            return Integer.class;
          default://estado
            return Integer.class;
          }
      }
    };

    setTitulos(model);
    setConsulta(model);
    return model;
  }

  private void setTitulos(DefaultTableModel model) {
    String split = "id, nombre, password, tipo, estado";
    titulos(model, split);
  }

  private void setConsulta(DefaultTableModel model) {
    List<Object[]> lista = new ArrayList<>();
    if (aConexion.isConexion())
      {

      try
        {
        aConexion.executeQuery("SELECT id, nombre, password, tipo, estado FROM qualitys." + NOMBRE_TABLA + ";");
        while (aConexion.resulset.next())
          {
          lista.add(new Object[]
            {
            aConexion.resulset.getInt(1), aConexion.resulset.getString(2),
            aConexion.resulset.getString(3), aConexion.resulset.getInt(4),
            aConexion.resulset.getInt(5)
            });
          }
        } catch (SQLException ex)
        {
        MensajeJoptionPane msg = new MensajeJoptionPane(tabla, JOptionPane.ERROR_MESSAGE);
        msg.getMessage(ex.getMessage(), UsuariosDao.class.getName());
        }
      }
    consulta(model, lista);
  }

  public int getLastId() {
    return new SelectLastID(aConexion, NOMBRE_TABLA).getUltimoID();
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

  public Editar getEditar() {
    return editar;
  }
}

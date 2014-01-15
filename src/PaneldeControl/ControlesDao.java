/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PaneldeControl;

import database.InsertarFilasABM;
import entidad.ColumnaTamanio;
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
public class ControlesDao extends ABMPaneles {

  private static String className = ControlesDao.class.getName();
  private MensajeJoptionPane msg ;
  private Conexion aConexion;
  private static final String NOMBRE_TABLA = "controles";
  private JTable aTable;
  private boolean editable;
  private Editar editar;
  private InsertarFilasABM insertar;
  private int lastId;

  public ControlesDao(JTable tabla, Conexion conexion) {
    super(conexion, tabla);
    this.aTable = tabla;
    this.aConexion = conexion;
    DefaultTableModel modelo = modelo();
    aTable.setModel(modelo);
    setAnchoFilas();
    setCellRenderer();
    altoCeldas(modelo, aTable);
    centrarColumna(0);
    centrarColumna(4);
    this.editar = new Editar(conexion, modelo);
    this.insertar = new InsertarFilasABM(conexion, modelo);
  }

  private DefaultTableModel modelo() {
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
          case "nombre":
            return String.class;
          case "descripción":
            return String.class;
          case "imagen":
            return String.class;
          default://estado
            return Integer.class;
          }
      }
    };
    setTitulos(model);
    setConsulta(model);
    return model;
  }

  private void setAnchoFilas() {
    List<ColumnaTamanio> list = new ArrayList<>();
    list.add(new ColumnaTamanio(0, 20));
    list.add(new ColumnaTamanio(1, 90));
    list.add(new ColumnaTamanio(2, 500));
    list.add(new ColumnaTamanio(3, 70));
    list.add(new ColumnaTamanio(4, 25));
    anchoColumnas(aTable, list);

  }

  private void setCellRenderer() {
    ArrayList<ColumnaTamanio> lista = new ArrayList<>();
    lista.add(new ColumnaTamanio(1, 0));
    lista.add(new ColumnaTamanio(2, 0));
    cellRenderer(lista, 70);
  }

  private void setTitulos(DefaultTableModel model) {
    String split = "id, nombre, descripción, imagen, Est";
    titulos(model, split);
  }
//

  private void setConsulta(DefaultTableModel model) {
    List<Object[]> lista = new ArrayList<>();
    if (aConexion.isConexion())
      {
      try
        {
        aConexion.executeQuery("SELECT id, descripcion, texto, imagen , estado FROM qualitys." + NOMBRE_TABLA + ";");
        while (aConexion.resulset.next())
          {
          Object[] oo = new Object[]
            {
            aConexion.resulset.getInt(1),
            aConexion.resulset.getString(2),
            aConexion.resulset.getString(3),
            aConexion.resulset.getString(4),
            aConexion.resulset.getInt(5)
            };
          lista.add(oo);
          }
        } catch (SQLException ex)
        {
       msg=new MensajeJoptionPane(null, JOptionPane.ERROR_MESSAGE);
       msg.getMessage(ex.getMessage(), className);
        }

      }
    consulta(model, lista);
  }

  public void setEditable(boolean editable) {
    this.editable = editable;
  }

  public int getLastId() {
    return new SelectLastID(aConexion, NOMBRE_TABLA).getUltimoID();
  }

  public Editar getEditar() {
    return editar;
  }

  public boolean isEditable() {
    return editable;
  }

  public InsertarFilasABM getInsertar() {
    return insertar;
  }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panelContol;

import entidad.ColumnaTamanio;
import entidad.TiposDeControl;
import entidad.TiposVerificacion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import database.Conexion;
import helper.MensajeJoptionPane;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class VerificacionDao extends ABMPaneles {

  private String classname = VerificacionDao.class.getName();
  private MensajeJoptionPane msg;
  private Conexion aConexion;
  private JTable aTable;
  private boolean editable;
  private TiposVerificacion verificacion;
  private final List<TiposVerificacion> listaVerificacion = new ArrayList<>();

  public VerificacionDao(JTable tabla, Conexion conexion)
  {
    super(conexion, tabla);
    this.aTable = tabla;
    this.aConexion = conexion;
    DefaultTableModel modelo = modelarFilasyColumnas();
    aTable.setModel(modelo);
    setAnchoColumna();
    setAltoFilas();
    altoCeldas(modelo, aTable);
    centrarColumna(0);
    centrarColumna(4);
  }

  private DefaultTableModel modelarFilasyColumnas()
  {
    DefaultTableModel model = new DefaultTableModel() {
      @Override
      public boolean isCellEditable(int fila, int columna)
      {
        if (columna == 0)
        {
          return false;
        }
        return isEditable();
      }

      @Override
      public Class getColumnClass(int col)
      {
        switch (getColumnName(col))
        {
          case "id":
            return Integer.class;
          case "nombre"://nombre
            return String.class;
          case "descripcion"://password
            return String.class;
          case "controles"://controles, separados por comas
            return String.class;
          default://estado
            return Integer.class;
        }
      }
    };
    setTitulos(model);
    llenarListaTiposVerificacion();
    llenarTabla(model);
    return model;
  }

  private void llenarListaTiposVerificacion()
  {
    if (aConexion.isConexion())
    {
      try
      {
        aConexion.executeQuery("SELECT * FROM tipos_verificacion;");
        while (aConexion.resulset.next())
        {
          int id = aConexion.resulset.getInt(1);
          String nombre = aConexion.resulset.getString(2);
          String descripcion = aConexion.resulset.getString(3);
          int estado = aConexion.resulset.getInt(4);
          verificacion = new TiposVerificacion(id, nombre, descripcion, estado, null);
          listaVerificacion.add(verificacion);
        }
      } catch (SQLException ex)
      {
        msg = new MensajeJoptionPane(tabla, JOptionPane.ERROR_MESSAGE);
        msg.getMessage(ex.getMessage(), classname);
      }
    }
  }

  private void llenarTabla(DefaultTableModel model)
  {
    List<Object[]> lista = new ArrayList<>();
    for (TiposVerificacion t : listaVerificacion)
    {
      List<TiposDeControl> tiposcontrolList = listaTiposControl(t.getId());
      
      t.setListaControles(listaTiposControl(t.getId()));
      String ret = t.getListaControles().toString();
      String trat = ret.substring(1, ret.length() - 1).replace(", ", "\n");
      lista.add(new Object[]
      {
        t.getId(), t.getNombre(), t.getDescripcion(), trat, t.getEstado()
      });
    }
    consulta(model, lista);
  }

  public List<TiposDeControl> listaTiposControl(int id)
  {
    List<TiposDeControl> tipos = new ArrayList<>();
    TiposDeControl tcv;
    if (aConexion.isConexion())
    {
      try
      {
        String ret = "SELECT  v.idControl, c.descripcion "
                + "FROM controles_verificacion v join controles c on v.idControl = c.id "
                + "where v.idVerificacion =" + id + ";";
        aConexion.executeQuery(ret);
        while (aConexion.resulset.next())
        {
	  int id_ =aConexion.resulset.getInt(1);
	  String descripcion=aConexion.resulset.getString(2);
          tcv = new TiposDeControl(id_, descripcion );
          tipos.add(tcv);
        }
      } catch (SQLException ex)
      {
        msg.getMessage(ex.getMessage(), classname);
      }
    }
    return tipos;
  }

  public boolean isEditable()
  {
    return editable;
  }

  private void setAnchoColumna()
  {
    List<ColumnaTamanio> lista = new ArrayList<>();
    lista.add(new ColumnaTamanio(0, 20));
    lista.add(new ColumnaTamanio(1, 100));
    lista.add(new ColumnaTamanio(2, 130));
    lista.add(new ColumnaTamanio(3, 230));
    lista.add(new ColumnaTamanio(4, 20));
    anchoColumnas(aTable, lista);
  }

  private void setAltoFilas()
  {
    List<ColumnaTamanio> l = new ArrayList<>();
    l.add(new ColumnaTamanio(2, 0));
    l.add(new ColumnaTamanio(3, 0));
    cellRenderer(l, 100);
  }

  private void setTitulos(DefaultTableModel model)
  {
    String split = "id, nombre, descripcion, controles, est";
    titulos(model, split);
  }
}

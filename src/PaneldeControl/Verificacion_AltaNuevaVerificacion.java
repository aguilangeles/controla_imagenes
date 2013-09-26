/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PaneldeControl;

import Entidades.TiposDeControl;
import BasedeDatos.GetUltimoIDInsertado;
import VentanaPrincipal.TiposVerificacion;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import BasedeDatos.Conexion;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class Verificacion_AltaNuevaVerificacion {
  private String nombre;
  private String descripcion;
  private List<Object> tablaDestinoSeleccionado;
  private Conexion conexion;
  private TiposVerificacion tipos_verificacion;
  private DefaultTableModel modelo;
  private JTable tabla;

  Verificacion_AltaNuevaVerificacion(String text, String text0, List<Object> idTipoControl, Conexion conexion, DefaultTableModel modelo, JTable tabla) {
    this.nombre = text;
    this.descripcion = text0;
    this.tablaDestinoSeleccionado = idTipoControl;
    this.conexion = conexion;
    this.modelo = modelo;
    this.tabla = tabla;

  }

  public boolean inserTipos_verificacion() {
    String insertar = "INSERT INTO `qualitys`.`tipos_verificacion`(`nombre`,`descripcion`,`estado`)VALUES"
            + "('" + nombre + "', '" + descripcion + "',1);";
    try {
      conexion.executeUpdate(insertar);
      return true;
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Insercion Tipos Verificacion", JOptionPane.ERROR_MESSAGE);
      return false;
    }
  }

  public boolean insertarTipos_Control() {
    boolean ret = false;
    GetUltimoIDInsertado lastid = new GetUltimoIDInsertado(conexion, "tipos_verificacion");
    int id = lastid.getUltimoID();
    tipos_verificacion = new TiposVerificacion(id, getNombre(), getDescripcion(), 1, null);
    for (Object o : tablaDestinoSeleccionado) {
      TiposDeControl tipo = (TiposDeControl) o;
      String insertar = "INSERT INTO `qualitys`.`controles_verificacion`(`idVerificacion`,`idControl`)"
              + "VALUES(" + id + "," + tipo.getId() + ")";
      try {
        conexion.executeUpdate(insertar);
        ret = true;
      } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Insertar Controles Verificacion", JOptionPane.ERROR_MESSAGE);
        ret = false;
      }
    }
    return ret;
  }

  public void insertarModelo() {
    List<TiposDeControl> tiposControlVerificacionList = new ArrayList<>();
    for (Object object : tablaDestinoSeleccionado) {
      TiposDeControl tc = (TiposDeControl) object;/*int id, String nombre, boolean check, String texto, String imagen*/
      TiposDeControl control = new TiposDeControl(tc.getId(), tc.getTexto());
      tiposControlVerificacionList.add(control);
    }
    tipos_verificacion.setListaControles(tiposControlVerificacionList);
    String ret = tipos_verificacion.getListaControles().toString();
    String trat = ret.substring(1, ret.length() - 1).replace(", ", "\n");
    modelo.addRow(new Object[]{tipos_verificacion.getId(), tipos_verificacion.getNombre(), tipos_verificacion.getDescripcion(), trat, tipos_verificacion.getEstado()});
    int row = tabla.getRowCount() - 1;
    Rectangle rect = tabla.getCellRect(row, 0, true);
    tabla.scrollRectToVisible(rect);
    tabla.clearSelection();
    tabla.setRowSelectionInterval(row, row);
    modelo.fireTableDataChanged();
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public List<Object> getIdtipocontrol() {
    return tablaDestinoSeleccionado;
  }

  public void setIdtipocontrol(List<Object> idtipocontrol) {
    this.tablaDestinoSeleccionado = idtipocontrol;
  }
}

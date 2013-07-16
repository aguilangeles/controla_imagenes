/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelesABM;

import Entidades.TiposConCheck;
import Entidades.TrazaDao;
import Helpers.ButtonEditor;
import Helpers.ButtonRenderer;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maria
 */
public class PoblarTablaCheckBox {
  private JTable tablaCheck;
  private DefaultTableModel model;
  private TrazaDao traza;

  public PoblarTablaCheckBox(JTable tablaCheck, DefaultTableModel model, TrazaDao traza) {
    this.tablaCheck = tablaCheck;
    this.model = model;
    this.traza = traza;
    poblarTabla();
  }
  
  
  
  private void poblarTabla() {
    model = (DefaultTableModel) tablaCheck.getModel();
    ajustarAnchoColumnas();
    List<TiposConCheck> lt = traza.getListaTipos();
    for (TiposConCheck tipos : lt) {
      boolean ischeck = tipos.isCheck();
      String nombre = tipos.getNombre();
      String boton = "Boton";
      Object[] object = new Object[]{ischeck, nombre, tipos.getId()};
      tablaCheck.getColumn("?").setCellRenderer(new ButtonRenderer());
      tablaCheck.getColumn("?").setCellEditor(
              new ButtonEditor(new JCheckBox(), lt));
      model.addRow(object);
    }
  }

  private void ajustarAnchoColumnas() {
    tablaCheck.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    tablaCheck.getColumnModel().getColumn(0).setPreferredWidth(20);
    tablaCheck.getColumnModel().getColumn(1).setPreferredWidth(230);
    tablaCheck.getColumnModel().getColumn(2).setPreferredWidth(20);
  }
  
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

import Daos.TiposDeControl;
import Daos.TrazaDao;
import Helpers.ButtonEditor;
import Helpers.ButtonRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maria
 */
public class TablaCheckBox {

  private DefaultTableModel model;
  private JTable tablaCheck;
  private TrazaDao traza;

  public TablaCheckBox(DefaultTableModel model, JTable tablaCheck, TrazaDao traza) {
    this.model = model;
    this.tablaCheck = tablaCheck;
    this.traza = traza;
    poblar();
  }
  

  private void poblar() {

    model = (DefaultTableModel) tablaCheck.getModel();
    setAnchoColumnas();
    List<TiposDeControl> listatipos = traza.getListaTipos();
    for (TiposDeControl tipos : listatipos) {
      boolean ischeck = tipos.isCheck();
      String nombre = tipos.getNombre();
      String boton = "Boton";
      Object[] object = new Object[]{ischeck, nombre, tipos.getId()};
      tablaCheck.getColumn("?").setCellRenderer(new ButtonRenderer());
      tablaCheck.getColumn("?").setCellEditor(
              new ButtonEditor(new JCheckBox(), listatipos));
      model.addRow(object);
    }
    tablaCheck.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0, false), "moveToNextCell");
  }
  private AbstractAction moveToNextCell =
          new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
              int col = tablaCheck.getSelectedColumn() + 1;
              tablaCheck.setColumnSelectionInterval(0, 0);
            }
          };

  private void setAnchoColumnas() {
    tablaCheck.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    tablaCheck.getColumnModel().getColumn(0).setPreferredWidth(20);
    tablaCheck.getColumnModel().getColumn(1).setPreferredWidth(210);
    tablaCheck.getColumnModel().getColumn(2).setPreferredWidth(20);
  }
}

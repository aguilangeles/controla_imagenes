/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panelContol;

import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class AgregarBoton {

  public AgregarBoton() {
  }


  public AgregarBoton(DefaultTableModel modelo, JTable tabla, JButton guardar, Object[] ob) {
    add(modelo, tabla, guardar, ob);
  }

  private void add(DefaultTableModel modelo, JTable tabla, JButton salvar, Object[] ob) {
    modelo.addRow(ob);
    tabla.repaint();
    salvar.setVisible(true);
  }

  public void addWithRectangle(Object[] ob,DefaultTableModel modelo, JTable tabla,JButton salvar) {
    modelo.addRow(ob);
    int row = tabla.getRowCount() - 1;
    Rectangle rect = tabla.getCellRect(row, 0, true);
    tabla.scrollRectToVisible(rect);
    tabla.clearSelection();
    tabla.setRowSelectionInterval(row, row);
    modelo.fireTableDataChanged();
    salvar.setVisible(true);
  }
}

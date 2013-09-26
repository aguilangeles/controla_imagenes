/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import VentanaPrincipal.AyudaVisual;
import Entidades.TiposDeControl;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 * Permite que la tercer columna del la tabla tenga comportamiento de
 * jbutton
 * @author MUTNPROD003
 */
public class ButtonEditor extends DefaultCellEditor {

  protected JButton button;
  private String label;
  private boolean isPushed;
  private AyudaVisual ayuda;
  private List<TiposDeControl> listado;

  public ButtonEditor(JCheckBox jCheckBox, List<TiposDeControl> listado) {
    super(jCheckBox);
    button = new JButton();
    button.setOpaque(true);
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
    this.listado = listado;

  }

  @Override
  public Component getTableCellEditorComponent(JTable table, Object value,
          boolean isSelected, int row, int column) {
    if (isSelected)
      {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
      } else
      {
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
      }
    label = (value == null) ? "" : value.toString();
    button.setText(label);
    isPushed = true;
    return button;
  }

  @Override
  public Object getCellEditorValue() {
    String ret="";
    if (isPushed)
      {
      for (TiposDeControl t : listado)
        {
        int id = Integer.parseInt(button.getText());
        if (t.getId() == id)
          {
          ayuda = new AyudaVisual(t.getNombre(), t.getTexto(), t.getImagen());
          ayuda.setVisible(true);
          }
        }
      }
    isPushed = false;
    ret = label;
    return ret;
  }

  @Override
  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }

  @Override
  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
}

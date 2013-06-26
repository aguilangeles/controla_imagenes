/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import Paneles.AyudaVisual;
import Entidades.TiposConCheck;
import Entidades.TrazaDao;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author MUTNPROD003
 */
public class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private String label;
    private boolean isPushed;
    private AyudaVisual ayuda;
    private List<TiposConCheck> listado;

    public ButtonEditor(JCheckBox jCheckBox, List<TiposConCheck> listado) {
        super(jCheckBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
        this.listado=listado;

    }
    public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } else {
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
    label = (value == null) ? "" : value.toString();
    button.setText(label);
    isPushed = true;
    return button;
  }

    public Object getCellEditorValue() {
        if (isPushed) {
            for (TiposConCheck t : listado) {
                int id = Integer.parseInt(button.getText());
                if (t.getId() == id) {
                    ayuda = new AyudaVisual(t.getNombre(), t.getTexto(), t.getImagen());
                    ayuda.setVisible(true);
                }
            }
      //
      //
//      JOptionPane.showMessageDialog(button, label + ": Ouch!");
      // System.out.println(label + ": Ouch!");
    }
    isPushed = false;
    return new String(label);
  }

  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }

  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
}

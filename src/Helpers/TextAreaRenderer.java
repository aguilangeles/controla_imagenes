/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

/**
 *
 * //hace que la tabla donde se implemente tenga comportamiento de jtextarea //y
 * se puedan dividir los textos para que las filas no queden muy extensas
 *
 * @author MUTNPROD003
 */
public class TextAreaRenderer extends JTextArea implements TableCellRenderer {

  public TextAreaRenderer() {
    setLineWrap(true);
    setWrapStyleWord(true);
  }

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value
          , boolean isSelected
          , boolean hasFocus
          , int row
          , int column) {
    setText((String) value);
    return this;
  }
}

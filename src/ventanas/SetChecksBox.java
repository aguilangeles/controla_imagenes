/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import database.SelectTiposControlbyArchivo;
import entidad.TiposDeControl;
import javax.swing.JTable;

/**
 *
 * @author MUTNPROD003
 */
public class SetChecksBox {

  private JTable tablaCheck;
  private int id;

  public SetChecksBox(JTable tablaCheck) {
    this.tablaCheck = tablaCheck;
  }

  public void set(int id) {
    //TODO
    //esto no funciona porque no le llega NADA!!!!!!!!
    for (int index = 0; index < tablaCheck.getRowCount(); index++) {
      SelectTiposControlbyArchivo controles = new SelectTiposControlbyArchivo(id);
      for (TiposDeControl t : controles.getTiposControlList()) {
        String nombre = (String) tablaCheck.getValueAt(index, 1);
        if (nombre.equals(t.getNombre())) {
          tablaCheck.setValueAt(t.isCheck(), index, 0);
        }
      }
    }
    Runtime gar = Runtime.getRuntime();
    gar.gc();
  }

  public void setDoc(int id, int idsublote) {
    for (int index = 0; index < tablaCheck.getRowCount(); index++) {
      SelectTiposControlbyArchivo controles = new SelectTiposControlbyArchivo(id, idsublote);
      for (TiposDeControl t : controles.getTiposControlList()) {
        String nombre = (String) tablaCheck.getValueAt(index, 1);
        if (nombre.equals(t.getNombre())) {
          tablaCheck.setValueAt(t.isCheck(), index, 0);
        }
      }
    }
    Runtime gar = Runtime.getRuntime();
    gar.gc();
  }
}

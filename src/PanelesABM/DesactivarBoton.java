/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelesABM;

import Entidades.Conexion;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class DesactivarBoton {

  public DesactivarBoton(JTable tabla, Conexion conexion, DefaultTableModel modelo, String nombreTabla,  int columna, JLabel mensaje) {

  getDesactivar(tabla, conexion, modelo, nombreTabla,  columna, mensaje);
  }

  private void getDesactivar(JTable tabla, Conexion conexion, DefaultTableModel modelo, String nombreTabla, int columna, JLabel mensaje) {
//    rangosDao.setEditable(true);
    int idjtext = (tabla.getSelectedRow());
    Desactivar desactivar1 = new Desactivar(conexion, modelo, nombreTabla, idjtext, columna);
    if (desactivar1.modificarEstado()) {
      mensaje.setText("<html>Estado<br>Modificado</html>");
      tabla.repaint();
    }
  }
}

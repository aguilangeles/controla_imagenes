/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panelContol;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *activa el modulo de edicion
 * @author aguilangeles@gmail.com
 */
public class AltaBajaYModificacionBoton {
//

  public AltaBajaYModificacionBoton(JTable tabla, JButton ABM, JButton agregar, JButton editar, JButton desactivar, JInternalFrame internal) {
    activarABM(tabla, ABM, agregar, editar, desactivar, internal);
  }

  private void activarABM(JTable tabla, JButton ABM, JButton agregar, JButton editar, JButton desactivar, JInternalFrame internal) {
    JOptionPane.showMessageDialog(tabla,
            MensajeABM.INSTRUCCIONES);
    ABM.setEnabled(false);
    internal.setTitle("Módulo de Edición");
    agregar.setVisible(true);
    editar.setVisible(true);
    desactivar.setVisible(true);
  }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Daos.Usuario;
import PanelesABM.CargarLote;
import PanelesABM.Verificacion_CargarComboBoxs;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**Chequea que existan tipos de verificacion y documentos aplicables al Lote,
 * antes de permitir el ingreso
 *
 * @author aguilangeles@gmail.com
 */
public class ControlDocumentosyVerificaciones {

  public ControlDocumentosyVerificaciones(JFrame panelControl, Usuario usuario) {
    cargar(panelControl, usuario);
  }

  private void cargar(JFrame panelControl, final Usuario usuario) {
    final Verificacion_CargarComboBoxs vc = new Verificacion_CargarComboBoxs();
    vc.llenarQualitys();
    vc.llenarDocumentos();
    if (vc.getDocumentoList().isEmpty()) {
      JOptionPane.showMessageDialog(panelControl, "No existen tipos de documento para aplicar al Lote",
              "Error en la carga Tipo de Documento", JOptionPane.INFORMATION_MESSAGE);
    } else if (vc.getVerificacionList().isEmpty()) {
      JOptionPane.showMessageDialog(panelControl, "No existen tipos de Verificación para aplicar al Lote",
              "Error en la carga Tipo de Verificación", JOptionPane.ERROR_MESSAGE);
    } else {
      java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
          new CargarLote(usuario, vc.getTipoDocumento(), vc.getTipoVerificacion()).setVisible(true);
        }
      });
      panelControl.dispose();
    }

  }
}

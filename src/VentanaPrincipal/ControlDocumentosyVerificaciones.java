/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaPrincipal;

import PaneldeControl.CargarLote;
import PaneldeControl.Verificacion_CargarComboBoxs;
import javax.swing.JFrame;

/**
 * Chequea que existan tipos de verificacion y documentos aplicables al Lote,
 * antes de permitir el ingreso
 *
 * @author aguilangeles@gmail.com
 */
public class ControlDocumentosyVerificaciones {

  public ControlDocumentosyVerificaciones(JFrame panelControl) {
    cargar(panelControl);
  }

  private void cargar(final JFrame panelControl) {
    final Verificacion_CargarComboBoxs vc = new Verificacion_CargarComboBoxs();
    vc.llenarQualitys();    //llena el combo de verificacion
    vc.llenarDocumentos(); //llena el combo documentos
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new CargarLote(vc.getTipoDocumento(), vc.getTipoVerificacion(),
                panelControl).setVisible(true);
      }
    });
  }
}

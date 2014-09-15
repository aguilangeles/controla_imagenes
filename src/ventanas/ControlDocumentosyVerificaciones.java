/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import javax.swing.JFileChooser;
import panelContol.CargarLote;
import panelContol.Verificacion_CargarComboBoxs;
import javax.swing.JFrame;
import panelContol.TryFilechooser;

/**
 * Chequea que existan tipos de verificacion y documentos aplicables al Lote,
 * antes de permitir el ingreso
 *
 * @author aguilangeles@gmail.com
 */
public class ControlDocumentosyVerificaciones {
  private TryFilechooser myfilechooser;

  public ControlDocumentosyVerificaciones(JFrame panelControl, TryFilechooser filechooser) {
    this.myfilechooser=filechooser;
    cargar(panelControl, myfilechooser);
  }

  private void cargar(final JFrame panelControl, final TryFilechooser myfilechooser) {
    final Verificacion_CargarComboBoxs vc = new Verificacion_CargarComboBoxs();
    vc.llenarQualitys();    //llena el combo de verificacion
    vc.llenarDocumentos(); //llena el combo documentos
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new CargarLote(vc.getTipoDocumento(), vc.getTipoVerificacion(),
                panelControl, myfilechooser).setVisible(true);
      }
    });
  }
}

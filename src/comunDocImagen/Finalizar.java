/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunDocImagen;

import database.SelectDocsRechazados;
import database.SelectImagenesRechazadas;
import entidad.TrazaDao;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import reporteFinal.Reporte;
import reporteFinal.ReporteDocumento;
import ventanas.Guardar;
import ventanas.MostrarInternalFramesForDocument;

/**
 *
 * @author Maria
 */
public class Finalizar {

    private MostrarInternalFramesForDocument frameForDocument;
    private JInternalFrame internalFrame;
    private TrazaDao traza;
    private JLabel rutaLabel;
    private JTable tabla;
    private JLabel pageLabel;
    private JFrame ventana;
    private boolean isDocument;

    public Finalizar(MostrarInternalFramesForDocument mostDoc, JInternalFrame internal, TrazaDao traza, JLabel rutaLabel, JTable tabla, JLabel pageLabel, JFrame vDocument, Boolean isDocument) {
        this.frameForDocument = mostDoc;
        this.internalFrame = internal;
        this.traza = traza;
        this.rutaLabel = rutaLabel;
        this.tabla = tabla;
        this.pageLabel = pageLabel;
        this.ventana = vDocument;
        this.isDocument = isDocument;
        finalizar();
    }

    private void finalizar() {
        Guardar save = new Guardar();
        if (isDocument) {
            String parcial = frameForDocument.getParcialSoTotal();
            String interno = internalFrame.getTitle().toString().replace(parcial, "");
            save.guardarDoc(traza, rutaLabel.getText(), tabla, pageLabel, interno);
            SelectDocsRechazados numeroRechazo
                    = new SelectDocsRechazados(traza.getId());

            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new ReporteDocumento(traza.getId()).setVisible(true);
                }
            });
        } else {
            save.guardar(traza, rutaLabel.getText(), tabla, pageLabel);
            SelectImagenesRechazadas numeroRechazo
                    = new SelectImagenesRechazadas(traza.getId());
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Reporte(traza.getId()).setVisible(true);
                }
            });
        }
        ventana.dispose();
    }
}

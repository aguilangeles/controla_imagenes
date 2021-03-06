/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import reporteFinal.AutomaticoRoA;

/**
 * Genera un reporte de la tabla descriptiva.
 *
 * @author aguilangeles@gmail.com
 */
public class EscribeInformeDocumento {

  private static final String className = EscribeInformeDocumento.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  private MensajeJoptionPane msg = new MensajeJoptionPane(null, type);
  private String UBICACION;

  public EscribeInformeDocumento(JTable tablaDetalles, String observaciones, JButton finalizar, JTable descripcion, String UBICACION) {
    String estadoS = AutomaticoRoA.getStatusName();
    this.UBICACION = UBICACION;
    write(tablaDetalles, estadoS, observaciones, finalizar, descripcion);
  }

  private void write(JTable tablaDetalles, String estado, String observaciones, JButton finalizar, JTable descripcion) {
    FileWriter fichero = null;
    PrintWriter pw = null;
    try
      {
      fichero = new FileWriter(UBICACION, true);
      pw = new PrintWriter(new BufferedWriter(fichero));
      for (int row = 0; row < tablaDetalles.getRowCount(); row++)
        {
        pw.println(tablaDetalles.getValueAt(row, 0) + ": " + tablaDetalles.getValueAt(row, 1));
        }

      pw.println("Documentos rechazados  ");
      for (int row = 0; row < descripcion.getRowCount(); row++)
        {
        pw.println(descripcion.getValueAt(row, 0) + ": " + descripcion.getValueAt(row, 1));
        }

      pw.println("Estado: " + estado);
      pw.println("Observaciones: " + observaciones);
      pw.println("Versi�n  app: " + VersionEImageIcon.VERSION);
      pw.close();
      } catch (IOException ex)
      {
      msg.getMessage(ex.getMessage(), className);
      } finally
      {
      if (null != fichero)
        {
        try
          {
          String path = "C:/_App/Qualitys/";
          ImageIcon icon = new ImageIcon("Logos\\test_50.png");
          JOptionPane.showMessageDialog(null, "Podr� visualizar una s�ntesis del reporte en\n\t"
                  + path + UBICACION + "\n", "Informe Final", JOptionPane.INFORMATION_MESSAGE, icon);
          fichero.close();
          } catch (IOException ex)
          {
          msg.getMessage(ex.getMessage(), className);
          }
        }
      }
  }
}

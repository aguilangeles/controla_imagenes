/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * Genera un reporte de la tabla descriptiva.
 *
 * @author aguilangeles@gmail.com
 */
public class EscribeInformeDocumento {

  private static final String UBICACION = "Reporte/" + new Time().getDateForTXT() + ".txt";

  public EscribeInformeDocumento(JTable tablaDetalles, boolean estado, String observaciones, JButton finalizar, JTable descripcion) {
    String estadoS;
    if (estado)
      {
      estadoS = "Aceptado.";
      } else
      {
      estadoS = "Rechazado.";
      }
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
        pw.println(descripcion.getValueAt(row, 1) + ": " + descripcion.getValueAt(row, 2));
        }

      pw.println("Estado: " + estado);
      pw.println("Observaciones: " + observaciones);
      pw.println("Versi�n  app: " + VersionEImageIcon.VERSION);
      pw.close();
      } catch (IOException ex)
      {
      JOptionPane.showMessageDialog(tablaDetalles, ex.getMessage(),
              "Excepci�n en la escritura del reporte", JOptionPane.ERROR_MESSAGE);

      Logger.getLogger(EscribeInformeDocumento.class.getName()).log(Level.SEVERE, null, ex);
      } finally
      {
      if (null != fichero)
        {
        try
          {
          fichero.close();
          JOptionPane.showMessageDialog(null, "Podr� visualizar una s�ntesis del reporte en\n\t"
                  + UBICACION + "\n", "Reporte final", JOptionPane.INFORMATION_MESSAGE);
          } catch (IOException ex)
          {
          JOptionPane.showMessageDialog(tablaDetalles, ex.getMessage(),
                  "Error al cerrar archivo informe.txt", JOptionPane.ERROR_MESSAGE);
          }
        }
      }
  }
}

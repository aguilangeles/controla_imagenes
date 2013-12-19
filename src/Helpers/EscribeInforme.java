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
public class EscribeInforme {

  private static final String UBICACION = "Reporte/" + new Time().getDateForTXT() + ".txt";

  public EscribeInforme(JTable tabla, boolean estado, String observaciones, JButton finalizar) {
    String estadoS;
    if (estado)
      {
      estadoS="Aceptado.";
      }else{
      estadoS="Rechazado.";
    }
    write(tabla, estadoS, observaciones, finalizar);
  }

  private void write(JTable tablaDetalles, String estado, String observaciones, JButton finalizar) {
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
      pw.println("Estado: " + estado);
      pw.println("Observaciones: " + observaciones);
      pw.println("Versión  app: " + VersionEImageIcon.VERSION);
      pw.close();
      } catch (IOException ex)
      {
      JOptionPane.showMessageDialog(tablaDetalles, ex.getMessage(),
              "Excepción en la escritura del reporte", JOptionPane.ERROR_MESSAGE);

      Logger.getLogger(EscribeInforme.class.getName()).log(Level.SEVERE, null, ex);
      } finally
      {
      if (null != fichero)
        {
        try
          {
          fichero.close();
          JOptionPane.showMessageDialog(null, "Podrá visualizar una síntesis del reporte en\n\t"
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

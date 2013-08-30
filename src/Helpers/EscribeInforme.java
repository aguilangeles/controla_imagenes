/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class EscribeInforme {

  private static final String UBICACION = "Reporte/informe.txt";

  public EscribeInforme(JTable tabla, boolean estado, String observaciones) {
    String estadoS = (estado) ? "Aceptado" : "Rechazado";
    write(tabla, estadoS, observaciones);
  }

  private void write(JTable tablaDetalles, String estado, String observaciones) {
    FileWriter fichero = null;
    PrintWriter pw = null;
    try {
      fichero = new FileWriter(UBICACION);
      pw = new PrintWriter(fichero);
      for (int row = 0; row < tablaDetalles.getRowCount(); row++) {
        pw.println(tablaDetalles.getValueAt(row, 0) + ": " + tablaDetalles.getValueAt(row, 1) + "\n");
      }
      pw.println("Estado: " + estado + "\n");
      pw.println("Observaciones: " + observaciones + "\n");
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(tablaDetalles, ex.getMessage(), "Excepci�n en la escritura del reporte", JOptionPane.ERROR_MESSAGE);

      Logger.getLogger(EscribeInforme.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (null != fichero) {
        try {
          fichero.close();
          JOptionPane.showMessageDialog(tablaDetalles, "Podr� visualizar una s�ntesis del reporte en\n\t" + UBICACION+"\n");
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(tablaDetalles, ex.getMessage(), "Error al cerrar archivo informe.txt", JOptionPane.ERROR_MESSAGE);
          Logger.getLogger(EscribeInforme.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
  }
}

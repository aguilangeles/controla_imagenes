/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * Genera un reporte de la tabla descriptiva.
 *
 * @author aguilangeles@gmail.com
 */
public class EscribeInforme {

  private static final String className = EscribeInforme.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  private MensajeJoptionPane msg = new MensajeJoptionPane(null, type);
  private String UBICACION = "Reporte/" + new Time().getDateForTXT() + ".txt";

  public EscribeInforme(JTable tabla, boolean estado, String observaciones, JButton finalizar, int idTraza) {
    String estadoS;
    if (estado)
      {
      estadoS = "Aceptado.";
      } else
      {
      estadoS = "Rechazado.";
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
      pw.println("Imagenes rechazadas: ");
      for (ImagenyRechazo ii : GetRechazosPorImagen.getListaImg())
        {
        pw.println(ii);
        }
      pw.println("Estado: " + estado);
      pw.println("Observaciones: " + observaciones);
      pw.println("Versión  app: " + VersionEImageIcon.VERSION);
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
          ImageIcon img = new ImageIcon("Logos\\test_50.png");
          JOptionPane.showMessageDialog(null, "Podrá visualizar una síntesis del reporte en\n\t"
                  + UBICACION + "\n", "Generación de Informe  en .txt", JOptionPane.INFORMATION_MESSAGE, img);
          fichero.close();
          } catch (IOException ex)
          {
          msg.getMessage(ex.getMessage(), className);
          }
        }
      }
  }
}

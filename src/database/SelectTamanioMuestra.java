/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import entidad.Rangos_qs;
import helper.MensajeJoptionPane;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Verifica que el tamanio del lote ingresado, este contenido en alguno de los
 * rangos de la base de datos.
 *
 * @author MUTNPROD003
 */
public class SelectTamanioMuestra {

  private static final String className = SelectTamanioMuestra.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  MensajeJoptionPane msg = new MensajeJoptionPane(null, type);
//
  private Conexion conexion = new Conexion();
  private static int muestra, idRango;

  public SelectTamanioMuestra(int tamanioLote) {
    muestraRango(tamanioLote);
  }

  private void muestraRango(int aTamanioLote) {
    if (conexion.isConexion())
      {
      try
        {
        String query = "SELECT id "
                + ", minimo"
                + " , maximo"
                + " , muestra"
                + " , cant_rechazo"
                + "  FROM  rangos_qs ;";
        conexion.executeQuery(query);
        while (conexion.resulset.next())
          {

          int minimo = conexion.resulset.getInt(2);
          int maximo = conexion.resulset.getInt(3);
          if (aTamanioLote >= minimo && aTamanioLote <= maximo)
            {
            muestra = conexion.resulset.getInt(4);
            idRango = (conexion.resulset.getInt(1));
            int rechazos = conexion.resulset.getInt(5);
            Rangos_qs rangos_qs = new entidad.Rangos_qs(idRango, minimo, maximo, muestra, rechazos);
            }
          }
        conexion.isConexionClose();
        } catch (SQLException ex)
        {
        msg.getMessage(ex.getMessage(), className);
        }
      }
  }

  public static int getMuestra() {
    return muestra;
  }

  public static int getIdRango() {
    return idRango;
  }
}

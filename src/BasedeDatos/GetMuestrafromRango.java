/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import Helpers.MensajeJoptionPane;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Verifica que el tamanio del lote ingresado, este contenido en alguno de los
 * rangos de la base de datos.
 *
 * @author MUTNPROD003
 */
public class GetMuestrafromRango {

  private Conexion conexion = new Conexion();
  private static int muestra, idRango;
  private static final String className = GetMuestrafromRango.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  MensajeJoptionPane msg = new MensajeJoptionPane(null, type);

  public GetMuestrafromRango(int tamanioLote) {
    //tocado para que funcione con muestra en imagenes o muestra en idc
    muestraRango(tamanioLote);
  }

  private void muestraRango(int aTamanioLote) {
    if (conexion.isConexion())
      {
      try
        {
        String query = "select  minimo "
                + ", maximo "
                + ", muestra "
                + ", id "
                + " from rangos_qs";
        conexion.executeQuery(query);
        while (conexion.resulset.next())
          {
          int minimo = conexion.resulset.getInt(1);
          int maximo = conexion.resulset.getInt(2);
          if (aTamanioLote >= minimo && aTamanioLote <= maximo)
            {
            muestra = conexion.resulset.getInt(3);
            idRango = (conexion.resulset.getInt(4));
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

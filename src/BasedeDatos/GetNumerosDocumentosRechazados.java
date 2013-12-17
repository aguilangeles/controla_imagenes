/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Cuenta la cantidad de imagenes con estado 1 (rechazado) e incluye esa
 * cantidad en la traza bajo nro_rechazo.
 *
 * @author MUTNPROD003
 */
public class GetNumerosDocumentosRechazados {

  public GetNumerosDocumentosRechazados(int idTraza) {
    int contador = 0;
    int numero = 0;
    Conexion c = new Conexion();
    if (c.isConexion())
      {
      try
        {
        String q = "SELECT  distinct "
                + " ars.idsublote "
                + " from archivo a "
                + " join qualitys.archivo_sublote ars "
                + " on a.id=ars.idarchivo "
                + " join sublotes ss "
                + " on ars.idsublote= ss.id "
                + " where a.idtraza = " + idTraza
                + " and a.estado = 1;";
        c.executeQuery(q);
        while (c.resulset.next())
          {
          contador++;
          numero = c.resulset.getInt(1);
          System.out.println("id sublote estado 1 " + numero);
          }
        String update = "UPDATE `qualitys`.`traza` "
                + "SET `nro_rechazo` = " + contador
                + " WHERE id = " + idTraza + ";";
        c.executeUpdate(update);
        c.isConexionClose();
        } catch (SQLException ex)
        {
        JOptionPane.showMessageDialog(null, ex.getMessage(),
                "Numero de Rechazo", JOptionPane.ERROR_MESSAGE);
        }
      }
  }
}

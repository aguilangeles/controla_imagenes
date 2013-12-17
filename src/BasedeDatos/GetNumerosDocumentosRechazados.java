/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Cuenta la cantidad de imagenes con estado 1 (rechazado) e incluye esa
 * cantidad en la traza bajo nro_rechazo.
 *
 * @author MUTNPROD003
 */
public class GetNumerosDocumentosRechazados {

  private List<Integer> idSubloteRechazado = new ArrayList<>();

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
          idSubloteRechazado.add(numero);
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
    iterar();
  }

  private void iterar() {
    for (Integer in : idSubloteRechazado)
      {
      System.out.println(" set id sublote " + in);
      //setearEstadoDocumento(in);
      }
  }

  private void setearEstadoDocumento(int idSublote) {
    Conexion conexion = new Conexion();
    if (conexion.isConexion())
      {

      try
        {
        String update = "UPDATE `qualitys`.`sublotes`"
                + " SET"
                + "`estado` = 1"
                + "WHERE id= " + idSublote + ";";
        conexion.executeUpdate(update);
        conexion.isConexionClose();
        } catch (SQLException ex)
        {
        Logger.getLogger(GetNumerosDocumentosRechazados.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
  }
}

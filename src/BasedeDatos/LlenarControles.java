/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import Entidades.ControlPorImagen;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Obtiene de la db los controles asociados a los archivos incluidos en la traza
 *
 * @author MUTNPROD003
 */
public class LlenarControles {

  private int idTraza;
  private int idImagen;
  private List<ControlPorImagen> controlesList = new ArrayList<>();

  public LlenarControles(int idTraza, int idImagen, Conexion conexion) {
//    System.out.println("entro en llenar controles ");
    this.idTraza = idTraza;
    this.idImagen = idImagen;
    llenarControles(conexion);
  }

  private List<ControlPorImagen> llenarControles(Conexion conexion) {
    try
      {
      ControlPorImagen control;
      String query = "select tac.id "
              + ",  tac.idcontrol "
              + ", c.descripcion "
              + " from traza_archivo_controles tac "
              + " join controles c "
              + " on c.id = tac.idcontrol "
              + " where tac.idtraza = " + idTraza
              + " and tac.idarchivo = " + idImagen + ";";
//        System.out.println(query);
      conexion.executeQuery(query);
      while (conexion.resulset.next())
        {
        int trzaArchivo = conexion.resulset.getInt(1);
        int controlidArchivo = conexion.resulset.getInt(2);
        String descripcion = conexion.resulset.getString(3);
        control = new ControlPorImagen(idImagen, trzaArchivo, controlidArchivo, descripcion, false);
        System.out.println("llenar controles ");
        System.out.println(" control " + control);
        controlesList.add(control);
        }
      } catch (SQLException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Llenar Controles ", JOptionPane.ERROR_MESSAGE);
      }
    return controlesList;
  }

  public List<ControlPorImagen> getControlesList() {
    return controlesList;
  }
}

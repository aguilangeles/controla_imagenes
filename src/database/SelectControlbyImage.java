/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import entidad.ControlPorImagen;
import helper.MensajeJoptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Obtiene de la db los controles asociados a los archivos incluidos en la traza
 *
 * @author MUTNPROD003
 */
public class SelectControlbyImage {

  private static final String className = SelectControlbyImage.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  MensajeJoptionPane msg = new MensajeJoptionPane(null, type);
  private int idTraza;
  private int idImagen;
  private int idSublote;
  private List<ControlPorImagen> controlesList = new ArrayList<>();

  public SelectControlbyImage(int idTraza, int idImagen, Conexion conexion) {
    this.idTraza = idTraza;
    this.idImagen = idImagen;
    llenarControles(conexion);
  }

//  public SelectControlbyImage(int idTraza, int idImagen, int idSublote, Conexion conexion) {
//    this.idTraza = idTraza;
//    this.idImagen = idImagen;
//    this.idSublote = idSublote;
//    llenarControlesSubList(conexion);
//  }

  private List<ControlPorImagen> llenarControles(Conexion conexion) {
    try {
      ControlPorImagen control;
      String query = "select tac.id "
              + ",  tac.idcontrol "
              + ", c.descripcion "
              + " from traza_archivo_controles tac "
              + " join controles c "
              + " on c.id = tac.idcontrol "
              + " where tac.idtraza = " + idTraza
              + " and tac.idarchivo = " + idImagen + ";";
      conexion.executeQuery(query);
      while (conexion.resulset.next()) {
        int trzaArchivo = conexion.resulset.getInt(1);
        int controlidArchivo = conexion.resulset.getInt(2);
        String descripcion = conexion.resulset.getString(3);
        control = new ControlPorImagen(idImagen, trzaArchivo, controlidArchivo, descripcion, false);
        controlesList.add(control);
      }
    } catch (SQLException ex) {
      msg.getMessage(ex.getMessage(), className);
    }
    return controlesList;
  }

//  private List<ControlPorImagen> llenarControlesSubList(Conexion conexion) {
//    try {
//      ControlPorImagen control;
//      String query = "select tac.id "
//              + ",  tac.idcontrol "
//              + ", c.descripcion "
//              + " from traza_archivo_controles tac "
//              + " join controles c "
//              + " on c.id = tac.idcontrol "
//              + " join sublotes s "
//              + " on tac.idtraza = s.idtraza"
//              + " where tac.idtraza = " + idTraza
//              + " and tac.idarchivo = " + idImagen
//              + " and s.id  = " + idSublote
//              + ";";
//      conexion.executeQuery(query);
//      while (conexion.resulset.next()) {
//        int trzaArchivo = conexion.resulset.getInt(1);
//        int controlidArchivo = conexion.resulset.getInt(2);
//        String descripcion = conexion.resulset.getString(3);
//        control = new ControlPorImagen(idImagen, trzaArchivo, idSublote, controlidArchivo, descripcion, false);
////        System.out.println("=" + control.toString());
//        controlesList.add(control);
//      }
//    } catch (SQLException ex) {
//      msg.getMessage(ex.getMessage(), className);
//    }
//    return controlesList;
//  }

  public List<ControlPorImagen> getControlesList() {
    return controlesList;
  }
}

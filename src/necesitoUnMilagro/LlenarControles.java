/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

import Daos.ControlPorImagen;
import Entidades.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class LlenarControles {

    private int idTraza;
    private int idTif;
    private List<ControlPorImagen> listaControles = new ArrayList<>();

    public LlenarControles(int idTraza, int idTif, Conexion conexion){
        this.idTraza = idTraza;
        this.idTif=idTif;
        llenarControles(conexion);
    }

  private List<ControlPorImagen> llenarControles(Conexion conexion) {
    try {
      ControlPorImagen control;
      String query = "select tac.id,  tac.idcontrol, c.descripcion "
              + "from traza_archivo_controles tac "
              + "join controles c "
              + "on c.id = tac.idcontrol "
              + "where tac.idtraza = " + idTraza + " and tac.idarchivo = " + idTif + ";";
      conexion.executeQuery(query);
      while (conexion.resulset.next()) {
        int trzaArchivo = conexion.resulset.getInt(1);
        int controlidArchivo = conexion.resulset.getInt(2);
        String descripcion = conexion.resulset.getString(3);
        control = new ControlPorImagen(idTif, trzaArchivo, controlidArchivo, descripcion, false);
        listaControles.add(control);
      }
    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Llenar Controles ", JOptionPane.ERROR_MESSAGE);

//      Logger.getLogger(LlenarControles.class.getName()).log(Level.SEVERE, null, ex);
    }

    return listaControles;
  }

    public List<ControlPorImagen> getLista() {
        return listaControles;
    }
}

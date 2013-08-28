/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

import Entidades.Conexion;
import Daos.TiposDeControl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author MUTNPROD003
 */
public class ObtenerControles {

  private Conexion conexion = new Conexion();
  private int idArchivo;
  private int idArchivoTraza;
  private int idTraza;
  private JTable tabla;
  private List<TiposDeControl> listadoTipos = new ArrayList<>();

  public ObtenerControles(int idArchivo) {
    this.idArchivo = idArchivo;
    traerChecks();
  }

  public ObtenerControles(int idArchivo, JTable tabla) {
    this.idArchivo = idArchivo;
    this.tabla = tabla;
    traerChecks();
    // poblarTabla();
  }

  private List<TiposDeControl> traerChecks() {
    TiposDeControl tipos;
    if (conexion.isConexion()) {
      try {
        String query = "SELECT  tac.idcontrol ,c.descripcion , tac.estado "
                + "FROM qualitys.traza_archivo_controles tac join controles c"
                + " on tac.idcontrol = c.id where idarchivo = " + idArchivo + ";";
        conexion.executeQuery(query);
        while (conexion.resulset.next()) {
          int estado = conexion.resulset.getInt(3);
          boolean isEstado = (estado == 0) ? false : true;
          tipos = new TiposDeControl(conexion.resulset.getInt(1), conexion.resulset.getString(2), isEstado, null, null);
          listadoTipos.add(tipos);
        }
        conexion.isConexionClose();

      } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Obtener control por Imagen", JOptionPane.ERROR_MESSAGE);

//                Logger.getLogger(ObtenerControles.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return listadoTipos;
  }

  public List<TiposDeControl> getListadoTipos() {
    return listadoTipos;
  }
//    private void poblarTabla(){
//         for (TiposDeControl t : getListadoTipos()) {
//            for (int index = 0; index < tabla.getRowCount(); index++) {
//                System.out.println(t.getImagen());
//                tabla.setValueAt(t.isCheck(), index, 0);
//            }
//        }
//    }
}

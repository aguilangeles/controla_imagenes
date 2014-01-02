
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import Entidades.TiposDeControl;
import Helpers.MensajeJoptionPane;
//import VentanaPrincipal.CantidadControlesPorVerificacion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Obtiene la verificacion asociada a la traza. Y con ella una lista de los
 * controles asociados.
 *
 * @author MUTNPROD003
 */
public class ControlesporVerificacionList {

  private static final String className = ControlesporVerificacionList.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  private Conexion conexion;
  private int idTraza;
  MensajeJoptionPane msg = new MensajeJoptionPane(null, type);
//    private static int cantidadControles; borrar
  private List<TiposDeControl> tiposdeControlList = new ArrayList<>();

  public ControlesporVerificacionList(Conexion conectar, int id) {
    this.conexion = conectar;
    this.idTraza = id;
    getLista();
  }

  private List<TiposDeControl> getLista() {
    try
      {
      Runtime gar = Runtime.getRuntime();
      TiposDeControl tipos;
//                cantidadControles = new CantidadControlesPorVerificacion(conexion, idTraza).getCantidad();
      String query = "select v.idControl"
              + ", c.descripcion "
              + ", c.texto"
              + ", c.imagen "
              + " from controles_verificacion v"
              + " join controles c "
              + " on v.idControl = c.id "
              + " where idVerificacion = "
              + " (SELECT  t.idVerificacion FROM qualitys.traza  t where t.id = " + idTraza + ");";//
      conexion.executeQuery(query);
      while (conexion.resulset.next())
        {
        int idcontroles = conexion.resulset.getInt(1);
        String descripcion = conexion.resulset.getString(2);
        String texto = conexion.resulset.getString(3);
        String imagen = conexion.resulset.getString(4);
        tipos = new TiposDeControl(idcontroles, descripcion, false, texto, imagen);
        tiposdeControlList.add(tipos);
        }
      conexion.isConexionClose();
      gar.gc();
      } catch (SQLException ex)
      {
      msg.getMessage(ex.getMessage(), className);
      }
    return tiposdeControlList;
  }

  public List<TiposDeControl> getTiposDeControlList() {
    return tiposdeControlList;
  }
}

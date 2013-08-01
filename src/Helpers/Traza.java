/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Entidades.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public final class Traza {

    private Conexion conexion;
    private int idUsuario;
    private int idTipoDocumento;
    private int idVerificacion;
    private int tamanioLote;
    private String rutaCompleta;
    private String ultimaCarpeta;
    private int muestra;
    private int idRango;

  public Traza(Conexion conexion, int idUsuario, int idTipoDocumento,
          int idVerificacion, int tamanioLote, String rutaCompleta, String ultimaCarpeta, int muestra, int idRango) {
    this.conexion = conexion;
    this.idUsuario = idUsuario;
    this.idTipoDocumento = idTipoDocumento;
    this.idVerificacion = idVerificacion;
    this.tamanioLote = tamanioLote;
    this.rutaCompleta = rutaCompleta.replace("\\", "\\\\");
    this.ultimaCarpeta=ultimaCarpeta;
    this.muestra = muestra;
    this.idRango = idRango;
    insertTraza();
  }

  private void insertTraza() {
    int numeroRechazo = 0;
    String fecha = new Time().toString();
    String insert = "Insert into qualitys.traza "
            + "(fecha_control,"
            + " rutaCompleta, "
            + " ultimaCarpeta, "
            + "tamanio_lote, "
            + "cantidad_muestreada, "
            + "nro_rechazo, "
            + "idRango, "
            + "idVerificacion, "
            + "idUsuarios, "
            + "idTipoDocumento) "
            + "VALUES ('" + fecha
            + "', '" + rutaCompleta
            + "', '" + ultimaCarpeta
            + "', " + tamanioLote
            + ", " + muestra
            + ", " + numeroRechazo
            + ", " + idRango
            + ", " + idVerificacion
            + ", " + idUsuario
            + ", " + idTipoDocumento
            + ");";
    //cambiar por booleano
      try {
        conexion.executeUpdate(insert);
      } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, ex.getMessage(), "Insertar Traza", JOptionPane.ERROR_MESSAGE);

//        Logger.getLogger(Traza.class.getName()).log(Level.SEVERE, null, ex);
      }


  }
}

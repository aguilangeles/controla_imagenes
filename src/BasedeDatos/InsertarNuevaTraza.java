/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import Helpers.Time;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Genera una nueva traza a insertar en la base de datos
 *
 * @author MUTNPROD003
 */
public final class InsertarNuevaTraza {

  private static String MENSAJE_SQL = "Cannot add or update a child row: "
          + "a foreign key constraint fails (`qualitys`.`traza`, CONSTRAINT "
          + "`fk_traza_rango` FOREIGN KEY (`idRango`) REFERENCES `rangos_qs` "
          + "(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION)";
  private static final String RANGO_INEXISTENTE = "No existe un rango que"
          + " se pueda aplicar al tamanio del volumen.\n"
          + "Edite la tabla 'Rangos'.";
  private Conexion conexion;
  private int idUsuario;
  private int idTipoDocumento;
  private int idVerificacion;
  private int tamanioLote;
  private String rutaCompleta;
  private String ultimaCarpeta;
  private int muestra;
  private int idRango;

  public InsertarNuevaTraza(Conexion conexion, int idUsuario, int idTipoDocumento,
          int idVerificacion, int tamanioLote, String rutaCompleta, String ultimaCarpeta, int muestra, int idRango) {
    this.conexion = conexion;
    this.idUsuario = idUsuario;
    this.idTipoDocumento = idTipoDocumento;
    this.idVerificacion = idVerificacion;
    this.tamanioLote = tamanioLote;
    this.rutaCompleta = rutaCompleta.replace("\\", "\\\\");
    this.ultimaCarpeta = ultimaCarpeta;
    this.muestra = muestra;
    this.idRango = idRango;
    insertTraza();
  }

  private boolean insertTraza() {
    int numeroRechazo = 0;
    String fecha = new Time().toString();
    String insertar = "Insert into qualitys.traza "
            + "(fecha_control"
            + ", rutaCompleta "
            + ", ultimaCarpeta "
            + ", tamanio_lote "
            + ", cantidad_muestreada "
            + ", nro_rechazo "
            + ", idRango "
            + ", idVerificacion "
            + ", idUsuarios "
            + ", idTipoDocumento) "
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
    try
      {
      System.out.println(insertar);
      conexion.executeUpdate(insertar);
      return true;
      } catch (SQLException ex)
      {
      if (ex.getMessage().equals(MENSAJE_SQL))
        {
        JOptionPane.showMessageDialog(null, RANGO_INEXISTENTE,
                "Sin rangos que aplicar al volumen", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
        return false;
        } else
        {
        JOptionPane.showMessageDialog(null, ex.getMessage(),
                "Insertar Traza", JOptionPane.ERROR_MESSAGE);
        return false;
        }
      }
  }
}

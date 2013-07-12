/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Entidades.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MUTNPROD003
 */
public class Traza {
    private Entidades.Conexion conexion ;
    private int cantidadMuestreada;
    private int idRango;
    private int tamanioLote;
    private int idVerificacion;
    private int idUsuario;
    private int idTipoDocumento;
    private String rutaCompleta;
    private String ultimaCarpeta;

    public Traza(int tamanioLote, int idVerificacion, int idUsuario, int idTipoDocumento, Conexion conexion, String rutaCompleta, String ultimaCarpeta) {
        this.tamanioLote = tamanioLote;
        this.idVerificacion = idVerificacion;
        this.idUsuario = idUsuario;
        this.idTipoDocumento = idTipoDocumento;
        this.conexion=conexion;
        this.rutaCompleta=rutaCompleta;
        this.ultimaCarpeta=ultimaCarpeta;
        insertTraza();
    }

    private void insertTraza() {
            if(conexion.isConexion()){
            try {
                //todo ruta completa y ultima carpeta
                muestraRango();
                int numeroRechazo = 0;
                String fecha = new Time().toString();
                String insert = "Insert into qualitys.traza "
                        + "(fecha_control,"
                        + " rutaCompleta, "
                        + " ultimaCarpeta, "
                        + " tamanio_lote, "
                        + "cantidad_muestreada, "
                        + "nro_rechazo, idRango, "
                        + "idVerificacion, "
                        + "idUsuarios, "
                        + "idTipoDocumento) "
                        + "VALUES ('" + fecha
                        + "', '" + rutaCompleta
                        + "', '" + ultimaCarpeta
                        + "', " + tamanioLote
                        + ", " + getCantidadMuestreada()
                        + ", " + numeroRechazo
                        + ", " + getIdRango()
                        + ", "+idVerificacion
                        + ", "+idUsuario
                        + ", "+idTipoDocumento
                        +");";
                conexion.executeUpdate(insert);
            } catch (SQLException ex) {
                Logger.getLogger(Traza.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    }
    private void muestraRango() throws SQLException {
        if (conexion.isConexion()) {
            String query = "select  minimo,maximo, muestra, id from rangos_qs";
            conexion.ExecuteSql(query);
            while (conexion.resulset.next()) {
                int minimo = conexion.resulset.getInt(1);
                int maximo = conexion.resulset.getInt(2);
                int valor = tamanioLote;
                if (valor >= minimo && valor <= maximo) {
                    cantidadMuestreada = (conexion.resulset.getInt(3));
                    idRango = (conexion.resulset.getInt(4));

                }
            }
        }
    }

    public int getIdRango() {
        return idRango;
    }
    public int getCantidadMuestreada() {
        return cantidadMuestreada;
    }
}

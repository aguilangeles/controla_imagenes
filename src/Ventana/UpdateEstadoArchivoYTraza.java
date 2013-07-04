/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Entidades.Conexion;

/**
 *
 * @author MUTNPROD003
 */
public class UpdateEstadoArchivoYTraza {
    private int estado;
    private boolean end = false;
    private int idtrazaArchivo;

    public UpdateEstadoArchivoYTraza(int estado, int idtrazaArchivo) {
        this.estado = estado;
        this.idtrazaArchivo = idtrazaArchivo;
    }

    public void updateEstadoTrazaArchivo() {
        Conexion conexion = new Conexion();
        if (conexion.isConexion()) {
            String update = "UPDATE traza_archivo_controles SET estado = "
                    + estado + " WHERE id= " + idtrazaArchivo + ";";
            conexion.executeUpdate(update);
            conexion.desconectar();

        }
    }

    // no deberia permirtir algo fuera de 0 o 1
    public void updateEstadoArchivo(int id) {
            Entidades.Conexion conexion = new Entidades.Conexion();
           if(conexion.isConexion()){
            String update ="UPDATE archivo SET estado =  1 WHERE id = "+id+";";
            conexion.executeUpdate(update);
            conexion.desconectar();
        }
    }
}

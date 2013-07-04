/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Entidades.Conexion;
import Entidades.TipodeUsuario;

/**
 *setea la fecha de ingreso del usuario validado
 * @author MUTNPROD003
 */
public class SetFechaUltimoIngresoUsuario {

    private TipodeUsuario tipoUsuario;

    public SetFechaUltimoIngresoUsuario() {
    }

    SetFechaUltimoIngresoUsuario(TipodeUsuario usuarioTipo) {
        this.tipoUsuario=usuarioTipo;
        setFecha();
    }

    private void setFecha() {
        Conexion conexion = new Conexion();
        if (conexion.isConexion()) {
            String ret = "UPDATE `qualitys`.`usuarios` SET`fecha_ingreso` = '"
                    + tipoUsuario.getFechaUltimoIngreso() + "' WHERE id = "
                    + tipoUsuario.getId() + ";";
            conexion.executeUpdate(ret);
            conexion.desconectar();
        }
    }
}

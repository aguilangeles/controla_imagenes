/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import writeproperties.Conexion;
import writeproperties.TipodeUsuario;

/**
 *setea la fecha de ingreso del usuario validado
 * @author MUTNPROD003
 */
public class setUsuarioFecha {

    private TipodeUsuario tipoUsuario;

    public setUsuarioFecha() {
    }

    setUsuarioFecha(TipodeUsuario usuarioTipo) {
        this.tipoUsuario=usuarioTipo;
        setUsuarioFecha();
    }

    private void setUsuarioFecha() {
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

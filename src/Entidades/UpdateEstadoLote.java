/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import javax.swing.JTextArea;

/**
 *
 * @author MUTNPROD003
 */
public class UpdateEstadoLote {
    private writeproperties.Conexion conexion;
    private int idtraza;
    private JTextArea mensaje;
    private int setEstado;

    public UpdateEstadoLote(writeproperties.Conexion conexion,int idtraza, boolean estado, JTextArea mensaje) {
        this.conexion=conexion;
        this.idtraza = idtraza;
        this.mensaje = mensaje;
        this.setEstado=(!estado)?0:1;
        update();
    }

    private void update() {
        String observaciones = mensaje.getText();
        String update = "UPDATE `qualitys`.`traza` "
                + "SET `estadoLote` = " + setEstado + ", `observaciones` = '" + observaciones + "' "
                + "WHERE id =" + idtraza + ";";
        conexion.executeUpdate(update);
    }
}

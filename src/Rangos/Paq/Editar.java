/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rangos.Paq;

import javax.swing.table.DefaultTableModel;
import writeproperties.Conexion;

/**
 *
 * @author MUTNPROD003
 */
public class Editar {
    private Conexion conexion;
    private DefaultTableModel modelo;

    public Editar(Conexion conexion, DefaultTableModel modelo) {
        this.conexion = conexion;
        this.modelo = modelo;
    }

    public void rangos_SetRow(int ide) {
        int masId = ide + 1;
        String updateRangos = "UPDATE `qualitys`.`rangos_qs` SET  "
                + "`minimo` = " + modelo.getValueAt(ide, 1)
                + ", `maximo` = " + modelo.getValueAt(ide, 2)
                + ", `muestra` = " + modelo.getValueAt(ide, 3)
                + ", `cant_rechazo` = " + modelo.getValueAt(ide, 4)
                + ", `estado` = " + modelo.getValueAt(ide, 5)
                + " WHERE id =" + masId + ";";
        conexion.executeUpdate(updateRangos);
    }

    public void controles_SetRow(int id) {
        int masId = id + 1;
        String set = "UPDATE `controles` SET `descripcion` = '" + modelo.getValueAt(id, 1)
                + "', `texto` = '" + modelo.getValueAt(id, 2)
                + "',`imagen` = '" + modelo.getValueAt(id, 3)
                + "', `estado` = " + modelo.getValueAt(id, 4)
                + " WHERE id = " + masId + ";";
        conexion.executeUpdate(set);
    }
    public void verificaciones_setRow(){
        // no tiene editar, la verificacion.
    }
    public void usuarios_setRow(int id) {

        int masId = id + 1;
        String set = "UPDATE `qualitys`.`usuarios` "
                + "SET `nombre` = '" + modelo.getValueAt(id, 1)
                + "', `password` = '" + modelo.getValueAt(id, 2)
                + "', `tipo` = " + modelo.getValueAt(id, 3)
                + ", `estado` = " + modelo.getValueAt(id, 4)
                + " WHERE id = " + masId + ";";
        conexion.executeUpdate(set);
    }

}

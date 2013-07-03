/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelesABM;

import javax.swing.table.DefaultTableModel;
import Entidades.Conexion;

/**
 *
 * @author MUTNPROD003
 */
public class InsertRows {
    private Conexion conexion;
    private DefaultTableModel modelo;

    public InsertRows(Conexion conexion, DefaultTableModel modelo) {
        this.conexion=conexion;
        this.modelo = modelo;
    }


    public void insert_newRango(int id) {
        int activo = 1;
        String insertar = "INSERT INTO `qualitys`.`rangos_qs`"
                + "(`minimo`, `maximo`, `muestra`, `cant_rechazo`, `estado`) "
                + "VALUES (" + modelo.getValueAt(id, 1)
                + ", " + modelo.getValueAt(id, 2)
                + ", " + modelo.getValueAt(id, 3)
                + ", " + modelo.getValueAt(id, 4)
                + ", " + activo
                + ");";
        conexion.executeUpdate(insertar);
    }

    public void insert_newControl(int id) {
        String insertar = "INSERT INTO `controles` (`descripcion`, `texto`, `imagen`, "
                + "`estado`) VALUES( '"
                + modelo.getValueAt(id, 1)
                + "', '" + modelo.getValueAt(id, 2)
                + "', '" + modelo.getValueAt(id, 3)
                + "'," + modelo.getValueAt(id, 4) + " );";
        conexion.executeUpdate(insertar);
    }

    public void insert_newUsuario(int id) {
        String up = "INSERT INTO `qualitys`.`usuarios`(`nombre`, `password`, `tipo`, `estado`, `fecha_ingreso`) "
                + "VALUES ('" + modelo.getValueAt(id, 1)
                + "', '" + modelo.getValueAt(id, 2)
                + "', " + modelo.getValueAt(id, 3)
                + ", " + modelo.getValueAt(id, 4)
                + ", '0000-00-00 00:00:00');";// esta fecha no es la de ultimo ingreso , sino la de creacion, y no esta creada en la db.
        conexion.executeUpdate(up);
    }
}

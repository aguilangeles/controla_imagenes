/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rangos.Paq;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import writeproperties.Conexion;

/**
 *
 * @author MUTNPROD003
 */
public class Desactivar {
    private int id;
    private DefaultTableModel modelo;
    private Conexion conexion ;
    private String tablaDB;
    private int tablaEstado;



    public Desactivar(int id, DefaultTableModel modelo, Conexion conexion, String tablaDB, int tablaEstado) {
        this.id = id;
        this.modelo = modelo;
        this.conexion = conexion;
        this.tablaDB = tablaDB;
        this.tablaEstado =tablaEstado;
        desactivar();
    }


    private int estado(int ide) {
        int ret = 0;
        try {
            String getEstado = "SELECT estado FROM "+tablaDB+" where id = " + ide + ";";
            conexion.ExecuteSql(getEstado);
            while (conexion.resulset.next()) {
                int estado = conexion.resulset.getInt(1);
                if (estado == 1) {
                    ret = 2;
                } else if (estado == 2) {
                    ret = 1;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Desactivar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    private void desactivar(){
        int ide =id+1;
        int estado =estado(ide);
        String set ="UPDATE `"+tablaDB+"` SET  `estado` = "+estado+" WHERE id ="+ide+";";
        conexion.executeUpdate(set);
        modelo.setValueAt(estado, id, tablaEstado);
    }

}

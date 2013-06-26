/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MUTNPROD003
 */
public class PoblarTablaDiscriminacionTipos extends JFrame {

    private int idtraza;
    private writeproperties.Conexion conexion ;
    private JTable tabla;
    private int idcontrol;
    private String descrip;
    private int cantidad;

    public PoblarTablaDiscriminacionTipos(int idtraza, writeproperties.Conexion conexion, JTable tabla) {
        this.idtraza = idtraza;
        this.conexion = conexion;
        this.tabla = tabla;
        crearTabla();
    }




    private void crearTabla() {
        DefaultTableModel modelo = poblarSegundatabla();
        tabla.setModel(modelo);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(365);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(30);

    }


    private DefaultTableModel poblarSegundatabla() {
        DefaultTableModel modelTipos = new DefaultTableModel(){
                @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        modelTipos.addColumn("id");
        modelTipos.addColumn("Descripcion");
        modelTipos.addColumn("Cantidad");
        try {
            String query = "select tac.idcontrol  , c.descripcion ,"
                    + " count(tac.estado) as 'cantidad' "
                    + " from traza_archivo_controles "
                    + "tac join controles c on tac.idcontrol = c.id"
                    + " where tac.idtraza = " + idtraza + " and tac.estado = 1  group by tac.idcontrol ";
            conexion.ExecuteSql(query);
            while (conexion.resulset.next()) {
                idcontrol = conexion.resulset.getInt(1);
                descrip = conexion.resulset.getString(2);
                cantidad = conexion.resulset.getInt(3);
                modelTipos.addRow(new Object[]{idcontrol, descrip, cantidad});

            }
        } catch (SQLException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelTipos;
        }

//    private String cargarInformacion(){
//        String ret =idcontrol+", "+ descrip+", "+cantidad;
//        return ret;
//    }


    private void consulta() {
        try {
            String query = "select tac.idcontrol  , c.descripcion ,"
                    + " count(tac.estado) as 'cantidad' "
                    + " from traza_archivo_controles "
                    + "tac join controles c on tac.idcontrol = c.id"
                    + " where tac.idtraza = " + idtraza + " and tac.estado = 1  group by tac.idcontrol ";
            conexion.ExecuteSql(query);
            while (conexion.resulset.next()) {
                idcontrol = conexion.resulset.getInt(1);
                descrip = conexion.resulset.getString(2);
                cantidad = conexion.resulset.getInt(3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

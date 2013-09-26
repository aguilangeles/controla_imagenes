/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReporteLote;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import BasedeDatos.Conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class Tabla_TiposDeControlCantidad extends JFrame {

    private int idtraza;
    private Conexion conexion ;
    private JTable tabla;

    private int idControl;
    private String descripcion;
    private int cantidad;

    public Tabla_TiposDeControlCantidad(int idtraza, Conexion conexion, JTable tabla) {
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
        tabla.getColumnModel().getColumn(1).setPreferredWidth(360);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(30);

    }


    private DefaultTableModel poblarSegundatabla() {
        DefaultTableModel modelTipos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        modelTipos.addColumn("id");
        modelTipos.addColumn("Descripcion");
        modelTipos.addColumn("Ct");
        CantidadesEncontradasDeErroresPorTDC(modelTipos);
        return modelTipos;
    }

    private void CantidadesEncontradasDeErroresPorTDC(DefaultTableModel modelTipos) {
        try {
            String query = "select tac.idcontrol  , c.descripcion ,"
                    + " count(tac.estado) as 'cantidad' "
                    + " from traza_archivo_controles "
                    + "tac join controles c on tac.idcontrol = c.id"
                    + " where tac.idtraza = " + idtraza
                    + " and tac.estado = 1  "
                    + "group by tac.idcontrol ";
            conexion.executeQuery(query);
            while (conexion.resulset.next()) {
                idControl = conexion.resulset.getInt(1);
                descripcion = conexion.resulset.getString(2);
                cantidad = conexion.resulset.getInt(3);
                modelTipos.addRow(new Object[]{idControl, descripcion, cantidad});

            }
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Cantidad de errores por TDC", JOptionPane.ERROR_MESSAGE);

//            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

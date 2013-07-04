/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelesABM;

import Helpers.LastID;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Entidades.Conexion;

/**
 *
 * @author MUTNPROD003
 */
public class RangosDao {
    private static final String NOMBRE_TABLA="rangos_qs;";
    private Conexion conexion;
    private JTable tabla;
    private JButton abm;
    private int lastId;
    private boolean editable;
    private Editar editar;
    private InsertRows insertar;


    public RangosDao(Conexion conexion, JTable tabla, JButton abm) {
        this.conexion = conexion;
        this.tabla = tabla;
        this.abm = abm;
        llenartabla();
    }


    private void llenartabla() {
        DefaultTableModel modelo = verTodos();
        editar = new Editar(conexion, modelo);
        insertar = new InsertRows(conexion, modelo);
        tabla.setModel(modelo);
    }

    private DefaultTableModel verTodos() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                if (columna == 0) {
                    return false;
                }
                return isEditable();
            }

            @Override
            public Class getColumnClass(int col) {
                switch (getColumnCount()) {
                    case 0:
                        return Integer.class;
                    case 1:
                        return Integer.class;
                    case 2:
                        return Integer.class;
                    case 3:
                        return Integer.class;
                    case 4:
                        return Integer.class;
                    default:
                        return Integer.class;
                }
            }
        };
        model.addColumn("id");
        model.addColumn("minimo");
        model.addColumn("maximo");
        model.addColumn("muestra");
        model.addColumn("rechazos");
        model.addColumn("estado");

        if (conexion.isConexion()) {
            try {
                conexion.ExecuteSql("SELECT * FROM "+NOMBRE_TABLA);
                while (conexion.resulset.next()) {
                    model.addRow(new Object[]{conexion.resulset.getInt(1), conexion.resulset.getInt(2),
                                conexion.resulset.getInt(3), conexion.resulset.getInt(4),
                                conexion.resulset.getInt(5), conexion.resulset.getInt(6)});
                }
            } catch (SQLException ex) {
                Logger.getLogger(RangosDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return model;
    }

    public int getLastId() {
        return new LastID(conexion, NOMBRE_TABLA).lastId();
    }

    public Editar getEditar() {
        return editar;
    }

    public InsertRows getInsertar() {
        return insertar;
    }

//    public void abmActionPerformed(java.awt.event.ActionEvent evt) {
//        switch (evt.getActionCommand()) {
//            case "Activar ABM":
//                editable = true;
//                break;
//            case "Guardar":
//                editable = false;
//                break;
//        }
//    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }



}

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
public class UsuariosDao {
    private static final String NOMBRE_TABLA ="usuarios";
    private Conexion conexion;
    private JTable tabla;
    private JButton abm;
    private Editar editar;
    private InsertRows insertar;
    private boolean editable;
    private int lastId;

    public UsuariosDao(JTable tabla, Conexion conexion, JButton abm) {
        this.tabla = tabla;
        this.conexion=conexion;
        this.abm = abm;
        llenartabla();
    }

    private void llenartabla() {
        DefaultTableModel modelo = verTodos();
        tabla.setModel(modelo);
        editar=new Editar(conexion, modelo);
        insertar = new InsertRows(conexion, modelo);
    }

    private DefaultTableModel verTodos() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                if(columna==0){
                    return false;
                }
                return isEditable();
            }

            @Override
            public Class getColumnClass(int col) {
                switch (getColumnName(col)) {
                    case "id":
                        return Integer.class;
                    case "nombre"://nombre
                        return String.class;
                    case "password"://password
                        return String.class;
                    case "tipo"://tipo
                        return Integer.class;
                    default://estado
                        return Integer.class;
                }
            }
        };
        model.addColumn("id");
        model.addColumn("nombre");
        model.addColumn("password");
        model.addColumn("tipo");
        model.addColumn("estado");

        if (conexion.isConexion()) {
            try {
                conexion.ExecuteSql("SELECT id, nombre, password, tipo, estado FROM qualitys." + NOMBRE_TABLA + ";");
                while (conexion.resulset.next()) {
                    model.addRow(new Object[]{conexion.resulset.getInt(1), conexion.resulset.getString(2),
                        conexion.resulset.getString(3), conexion.resulset.getInt(4),
                        conexion.resulset.getInt(5)});
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return model;
    }

    public int getLastId() {
        return new LastID(conexion, NOMBRE_TABLA).lastId();
    }

    public InsertRows getInsertar() {
        return insertar;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Editar getEditar() {
        return editar;
    }


}

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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class RangosDao extends ABMPaneles{
    private static final String NOMBRE_TABLA="rangos_qs;";
    private Conexion aConexion;
    private JTable aTable;
    private int lastId;
    private boolean editable;
    private Editar editar;
    private InsertRows insertar;


    public RangosDao(Conexion conexion, JTable tabla) {
        this.aConexion = conexion;
        this.aTable = tabla;
        DefaultTableModel modelo = modelar();
        aTable.setModel(modelo);
        this.editar = new Editar(aConexion, modelo);
        this.insertar = new InsertRows(aConexion, modelo);
   }

    private DefaultTableModel modelar() {
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
        setTitulos(model);
        setConsulta(model);
        return model;
    }
    private void setConsulta(DefaultTableModel model) {
        List<Object[]> lista = new ArrayList<>();
        if (aConexion.isConexion()) {
            try {
                aConexion.ExecuteSql("SELECT * FROM "+NOMBRE_TABLA);
                while (aConexion.resulset.next()) {
                    lista.add(new Object[]{aConexion.resulset.getInt(1), aConexion.resulset.getInt(2),
                                aConexion.resulset.getInt(3), aConexion.resulset.getInt(4),
                                aConexion.resulset.getInt(5), aConexion.resulset.getInt(6)});
                }
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Llenar Tabla Rangos", JOptionPane.ERROR_MESSAGE);

//                Logger.getLogger(RangosDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        consulta(model, lista);
    }

    private void setTitulos(DefaultTableModel model) {
        String split ="id, minimo, maximo, muestra, rechazos, estado";
        titulos(model, split);
    }
        public int getLastId() {
        return new LastID(aConexion, NOMBRE_TABLA).lastId();
    }

    public Editar getEditar() {
        return editar;
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
}

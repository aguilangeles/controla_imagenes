/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelesABM;

import Entidades.Conexion;
import Helpers.LastID;
import Helpers.TextAreaRenderer;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MUTNPROD003
 */
public class ControlesDao {
    private Conexion conexion;
    private static final String NOMBRE_TABLA="controles";
    private JTable tabla;
    private JButton abm;
    private boolean editable;
    private Editar editar;
    private InsertRows insertar;
    private int lastId;

    public ControlesDao(JTable tabla, Conexion conexion,  JButton abm) {
        this.tabla = tabla;
        this.conexion=conexion;
        this.abm = abm;
        llenartabla();
    }

    private void llenartabla() {
        DefaultTableModel modelo = modeldo();
        tabla.setModel(modelo);
        ajusteLargoFila();
        ajusteAltoCelda(modelo);
        editar=new Editar(conexion, modelo);
        insertar=new InsertRows(conexion, modelo);

    }

    private DefaultTableModel modeldo() {
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
                    case "nombre":
                        return String.class;
                    case "descripción":
                        return String.class;
                    case "imagen":
                        return String.class;
                    default://estado
                        return Integer.class;
                }
            }

        };
        titulos(model);

        if (conexion.isConexion()) {
            consulta(model);
        }
        return model;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }


   

    public int getLastId() {
        return new LastID(conexion, NOMBRE_TABLA).lastId();
    }

    public Editar getEditar() {
        return editar;
    }

    public boolean isEditable() {
        return editable;
    }

    public InsertRows getInsertar() {
        return insertar;
    }

    private void titulos(DefaultTableModel model) {
        model.addColumn("id");
        model.addColumn("nombre");
        model.addColumn("descripción");
        model.addColumn("imagen");
        model.addColumn("activo");
    }

    private void consulta(DefaultTableModel model) {
        try {
            conexion.ExecuteSql("SELECT id, descripcion, texto, imagen , estado FROM qualitys."+NOMBRE_TABLA+";");
            while (conexion.resulset.next()) {
                model.addRow(new Object[]{conexion.resulset.getInt(1),
                    conexion.resulset.getString(2),
                    conexion.resulset.getString(3),
                    conexion.resulset.getString(4),
                    conexion.resulset.getInt(5)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ajusteAltoCelda(DefaultTableModel modelo) {
        tabla.setRowHeight(70);
        int row = tabla.getRowCount()-1;
        if(row>0){
        Rectangle rect = tabla.getCellRect(row, 0, true);
        tabla.scrollRectToVisible(rect);
        tabla.clearSelection();
        tabla.setRowSelectionInterval(row, row);
        modelo.fireTableDataChanged();
        }
    }

    private void ajusteLargoFila() {
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(90);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(500);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(70);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(25);
        tabla.getColumnModel().getColumn(2).setCellRenderer(new TextAreaRenderer());
        tabla.getColumnModel().getColumn(1).setCellRenderer(new TextAreaRenderer());
    }


}

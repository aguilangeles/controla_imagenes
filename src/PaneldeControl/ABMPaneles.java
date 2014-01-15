/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PaneldeControl;

import entidad.ColumnaTamanio;
import database.Conexion;
import Helpers.TextAreaRenderer;
import java.awt.Rectangle;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MUTNPROD003
 */
public class ABMPaneles {
    protected Conexion conexion;
    protected JTable tabla;

    public ABMPaneles() {
    }
    public ABMPaneles(Conexion conexion, JTable tabla) {
        this.conexion = conexion;
        this.tabla = tabla;
    }

    public void altoCeldas(DefaultTableModel modelo, JTable tabla) {
        int row = tabla.getRowCount() - 1;
        if (row > 0) {
            Rectangle rect = tabla.getCellRect(row, 0, true);
            tabla.scrollRectToVisible(rect);
            tabla.clearSelection();
            tabla.setRowSelectionInterval(row, row);
            modelo.fireTableDataChanged();
        }
    }

    public void anchoColumnas(JTable tabla, List<ColumnaTamanio> listado) {
        for (ColumnaTamanio t : listado) {
            tabla.getColumnModel().getColumn(t.getColumna()).setPreferredWidth(t.getTamanio());
        }
    }

    public void consulta(DefaultTableModel model, List<Object[]> lista) {
        for (Object[] m : lista) {
            model.addRow(m);
        }
    }

    public void cellRenderer(List<ColumnaTamanio> lista, int rowHeigth) {
        for (ColumnaTamanio cl : lista) {
            tabla.getColumnModel().getColumn(cl.getColumna()).setCellRenderer(new TextAreaRenderer());
        }
        tabla.setRowHeight(rowHeigth);
    }

    public void titulos(DefaultTableModel model, String titulos) {
        String[] split = titulos.split(", ");
        for (int i = 0; i < split.length; i++) {
            model.addColumn(split[i]);
        }
    }
    public void centrarColumna(int column) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        tabla.getColumnModel().getColumn(column).setCellRenderer(tcr);
    }
}

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
<<<<<<< HEAD
import Entidades.Conexion;
import java.util.ArrayList;
import java.util.List;
=======
>>>>>>> dfe2936d0bda8775694b5029d291ce8c8ab95bde

/**
 *
 * @author MUTNPROD003
 */
public class ControlesDao extends ABMPaneles {

    private Conexion aConexion;
    private static final String NOMBRE_TABLA = "controles";
    private JTable aTable;
    private boolean editable;
    private Editar editar;
    private InsertRows insertar;
    private int lastId;

<<<<<<< HEAD
    public ControlesDao(JTable tabla, Conexion conexion) {
        super(conexion, tabla);
        this.aTable = tabla;
        this.aConexion = conexion;
        DefaultTableModel modelo = modelar();
        aTable.setModel(modelo);
        setAnchoFilas();
        setCellRenderer();
        altoCeldas(modelo, aTable);
        centrarColumna(0);
        centrarColumna(4);
        this.editar = new Editar(conexion, modelo);
        this.insertar = new InsertRows(conexion, modelo);
    }

    private DefaultTableModel modelar() {
=======
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
>>>>>>> dfe2936d0bda8775694b5029d291ce8c8ab95bde
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
<<<<<<< HEAD
        setTitulos(model);
        setConsulta(model);
        return model;
    }
    private void setAnchoFilas() {
        List<ColumnaTamanio> list = new ArrayList<>();
        list.add(new ColumnaTamanio(0, 20));
        list.add(new ColumnaTamanio(1, 90));
        list.add(new ColumnaTamanio(2, 500));
        list.add(new ColumnaTamanio(3, 70));
        list.add(new ColumnaTamanio(4, 25));
        anchoColumnas(aTable, list);

    }

    private void setCellRenderer() {
        ArrayList<ColumnaTamanio> lista = new ArrayList<>();
        lista.add(new ColumnaTamanio(1, 0));
        lista.add(new ColumnaTamanio(2, 0));
        cellRenderer(lista, 70);
    }

    private void setTitulos(DefaultTableModel model) {
        String split = "id, nombre, descripcion, imagen, est";
        titulos(model, split);
    }
//
    private void setConsulta(DefaultTableModel model) {
        List<Object[]> lista = new ArrayList<>();
        if (aConexion.isConexion()) {
            try {
                aConexion.ExecuteSql("SELECT id, descripcion, texto, imagen , estado FROM qualitys." + NOMBRE_TABLA + ";");
                while (aConexion.resulset.next()) {
                    Object[] oo = new Object[]{aConexion.resulset.getInt(1),
                        aConexion.resulset.getString(2),
                        aConexion.resulset.getString(3),
                        aConexion.resulset.getString(4),
                        aConexion.resulset.getInt(5)};
                    lista.add(oo);

                }
            } catch (SQLException ex) {
                Logger.getLogger(ControlesDao.class.getName()).log(Level.SEVERE, null, ex);
            }
=======
        titulos(model);

        if (conexion.isConexion()) {
            consulta(model);
>>>>>>> dfe2936d0bda8775694b5029d291ce8c8ab95bde
        }
        consulta(model, lista);
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public int getLastId() {
        return new LastID(aConexion, NOMBRE_TABLA).lastId();
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
<<<<<<< HEAD
=======

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


>>>>>>> dfe2936d0bda8775694b5029d291ce8c8ab95bde
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import Verificacion.TiposVerificacion;
import Verificacion.TiposVerificacion.TiposControlVf;
import helper.TextAreaRenderer;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import writeproperties.Conexion;

/**
 *
 * @author MUTNPROD003
 */
public class VerificacionDao {
    private Conexion conexion;
    private JTable tabla;
    private JButton abm;
    private boolean editable;
    private TiposVerificacion verificacion;
    private List<TiposVerificacion> listaV = new ArrayList<>();

    public VerificacionDao(JTable tabla, Conexion conexion,  JButton abm) {
        this.tabla = tabla;
        this.conexion=conexion;
        this.abm = abm;
        modelarTabla();
    }

    private void modelarTabla() {
        DefaultTableModel modelo = modelarFilasyColumnas();
        tabla.setModel(modelo);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(130);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(230);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(20);
        tabla.getColumnModel().getColumn(2).setCellRenderer(new TextAreaRenderer());
        tabla.getColumnModel().getColumn(3).setCellRenderer(new TextAreaRenderer());
        tabla.setRowHeight(100);
        int row = tabla.getRowCount()-1;
        if(row>0){
        Rectangle rect = tabla.getCellRect(row, 0, true);
        tabla.scrollRectToVisible(rect);
        tabla.clearSelection();
        tabla.setRowSelectionInterval(row, row);
        modelo.fireTableDataChanged();
        }
    }

    private DefaultTableModel modelarFilasyColumnas() {
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
                    case "descripcion"://password
                        return String.class;
                    case "controles"://controles, separados por comas
                        return String.class;
                    default://estado
                        return Integer.class;
                }
            }
        };
        model.addColumn("id");
        model.addColumn("nombre");
        model.addColumn("descripcion");
        model.addColumn("controles");
        model.addColumn("est");
        llenarListaTiposVerificacion();
        llenarTabla(model);
        return model;
    }

    private void llenarListaTiposVerificacion(){
        if (conexion.isConexion()) {
            try {
                conexion.ExecuteSql("SELECT * FROM tipos_verificacion;");
                while (conexion.resulset.next()) {
                    int id = conexion.resulset.getInt(1);
                    String nombre =conexion.resulset.getString(2);
                    String descripcion =conexion.resulset.getString(3);
                    int estado =conexion.resulset.getInt(4);
                    verificacion = new TiposVerificacion(id, nombre, descripcion, estado, null);
                    listaV.add(verificacion);
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private void llenarTabla(DefaultTableModel model){
        for(TiposVerificacion t  : listaV){
            t.setListaControles(listaTiposControl(t.getId()));
            String ret = t.getListaControles().toString();
            String trat = ret.substring(1,ret.length()-1).replace(", ", "\n");
            model.addRow(new Object[]{t.getId(), t.getNombre(), t.getDescripcion(), trat ,t.getEstado()});
        }
    }

    public List<TiposControlVf> listaTiposControl(int id) {
        List<TiposControlVf> tipos = new ArrayList<>();
        TiposControlVf tcv;
        if (conexion.isConexion()) {
            try {
                String ret = "SELECT  v.idControl, c.descripcion "
                        + "FROM controles_verificacion v join controles c on v.idControl = c.id "
                        + "where v.idVerificacion =" + id + ";";
                conexion.ExecuteSql(ret);
                while (conexion.resulset.next()) {
                    tcv = new TiposVerificacion.TiposControlVf(conexion.resulset.getInt(1), conexion.resulset.getString(2));
                    tipos.add(tcv);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage()+this.getClass());
            }
        }
        return tipos;
    }

    public boolean isEditable() {
        return editable;
    }
}

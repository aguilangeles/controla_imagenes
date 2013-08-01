/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Entidades.Imagen;
import Entidades.TiposConCheck;
import Entidades.TrazaDao;
import Helpers.ButtonEditor;
import Helpers.ButtonRenderer;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MUTNPROD003
 */
class PoblarTabla {

    public PoblarTabla(JTable jTable1, DefaultTableModel model, TrazaDao traza) {
        model = (DefaultTableModel) jTable1.getModel();
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(230);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(20);
        ListIterator<Imagen> iterator = traza.getListaTif().listIterator();
        List<TiposConCheck> lt = traza.getListaTipos();
        for (TiposConCheck tipos : lt) {
            boolean ischeck = tipos.isCheck();
            String nombre = tipos.getNombre();
            String boton = "Boton";
            Object[] object = new Object[]{ischeck, nombre, tipos.getId()};
            jTable1.getColumn("?").setCellRenderer(new ButtonRenderer());
            jTable1.getColumn("?").setCellEditor(
                    new ButtonEditor(new JCheckBox(), lt));
            model.addRow(object);
        }
    }
}

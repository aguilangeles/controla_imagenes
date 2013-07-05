/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Entidades.TiposConCheck;
import javax.swing.JTable;

/**
 *
 * @author MUTNPROD003
 */
public class SetChecksBox {
    private JTable tablaCheck;

    public SetChecksBox(JTable tablaCheck) {
        this.tablaCheck = tablaCheck;
    }

    public void setEstadoChecksBoxs(int id) {
        for (int index = 0; index < tablaCheck.getRowCount(); index++) {
            ObtenerTiposDeControl controles = new ObtenerTiposDeControl(id);
            for (TiposConCheck tipos : controles.getListadoTipos()) {
                String nombre = (String) tablaCheck.getValueAt(index, 1);
                if (nombre.equals(tipos.getNombre())) {
                    tablaCheck.setValueAt(tipos.isCheck(), index, 0);
                }
            }
        }
    }
}

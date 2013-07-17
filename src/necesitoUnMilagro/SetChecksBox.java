/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

import Entidades.TiposConCheck;
import Ventana.ObtenerTiposDeControl;
import javax.swing.JTable;

/**
 *
 * @author MUTNPROD003
 */
public class SetChecksBox {

    private JTable tablaCheck;
    private int id;

    public SetChecksBox(JTable tablaCheck) {
        this.tablaCheck = tablaCheck;

    }
    public void set(int id) {
        for (int index = 0; index < tablaCheck.getRowCount(); index++) {
            ObtenerTiposDeControl cont = new ObtenerTiposDeControl(id);
            for (TiposConCheck t : cont.getListadoTipos()) {
                String nombre = (String) tablaCheck.getValueAt(index, 1);
                if (nombre.equals(t.getNombre())) {
                    tablaCheck.setValueAt(t.isCheck(), index, 0);
                }
            }
        }
    }
}

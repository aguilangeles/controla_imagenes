/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import javax.swing.JTable;

/**
 *
 * @author MUTNPROD003
 */
public class Guardar {
    private boolean end;
    private TrazaDao traza;
    private String nombre;
    private JTable tablaCheck;
    private UpdateChecs updateChecs;

    public Guardar(TrazaDao traza, String nombre, JTable tablaCheck) {
        this.traza = traza;
        this.nombre = nombre;
        this.tablaCheck = tablaCheck;
        guardar();
    }

    private void guardar() {
        Imagen tif = traza.getTifByName(nombre);
        LlenarControles controles = new LlenarControles(traza.getId(), tif.getId());
        for (ControlByArchivo controlxArchivo : controles.getLista()) {
            for (int index = 0; index < tablaCheck.getRowCount(); index++) {
                String descripcion = (String) tablaCheck.getValueAt(index, 1);
                boolean check = (boolean) tablaCheck.getValueAt(index, 0);
                if (descripcion.equals(controlxArchivo.getDescripcion())) {
                    controlxArchivo.setCheck(check);
                    updateChecs = new UpdateChecs(controlxArchivo.getEstado(), controlxArchivo.getIdTrazaArchivoControl());
                    updateChecs.update();
                    if (check) {
                        updateChecs.updateEstadoArchivo(tif.getId());
                    }
                }
            }
        }
    }

    public boolean isEnd() {
        return end;
    }

}

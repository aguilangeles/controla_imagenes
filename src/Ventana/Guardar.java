/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Entidades.ControlPorArchivo;
import Entidades.Imagen;
import Entidades.LlenarControles;
import Entidades.TrazaDao;
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
    private UpdateEstadoArchivoYTraza updateChecs;

    public Guardar(TrazaDao traza, String nombre, JTable tablaCheck) {
        this.traza = traza;
        this.nombre = nombre;
        this.tablaCheck = tablaCheck;
        guardarCambiosCheckBoxs();
    }

    private void guardarCambiosCheckBoxs() {

        Imagen imagen = traza.getTifByName(nombre);
        LlenarControles llenarControles = new LlenarControles(traza.getId(), imagen.getId());
        for (ControlPorArchivo controlxArchivo : llenarControles.getLista())
        {
            for (int i = 0; i < tablaCheck.getRowCount(); i++)
            {
                String descripcion = (String) tablaCheck.getValueAt(i, 1);
                boolean check = (boolean) tablaCheck.getValueAt(i, 0);
                uptadeEstadoCheckBox(descripcion, controlxArchivo, check, imagen);
            }
        }
    }

    private void updateEstadoArchivo(boolean check, Imagen imagen) {
        if (check)
        {
            updateChecs.updateEstadoArchivo(imagen.getId());
        }
    }

    private void uptadeEstadoCheckBox(String descripcion, ControlPorArchivo controlxArchivo, boolean check, Imagen imagen) {
        if (descripcion.equals(controlxArchivo.getDescripcion()))
        {
            controlxArchivo.setCheck(check);
            updateChecs = new UpdateEstadoArchivoYTraza(controlxArchivo.getEstado(), controlxArchivo.getIdTrazaArchivoControl());
            updateChecs.updateEstadoTrazaArchivo();
            updateEstadoArchivo(check, imagen);
        }
    }
     private void guardar() {
        Imagen tif = traza.getTifByName(nombre);
        LlenarControles controles = new LlenarControles(traza.getId(), tif.getId());
        for (ControlPorArchivo controlxArchivo : controles.getLista()) {
            for (int index = 0; index < tablaCheck.getRowCount(); index++) {
                String descripcion = (String) tablaCheck.getValueAt(index, 1);
                boolean check = (boolean) tablaCheck.getValueAt(index, 0);
                if (descripcion.equals(controlxArchivo.getDescripcion())) {
                    controlxArchivo.setCheck(check);
                    updateChecs = new UpdateEstadoArchivoYTraza(controlxArchivo.getEstado(), controlxArchivo.getIdTrazaArchivoControl());
                    updateChecs.updateEstadoTrazaArchivo();
                    if (check) {
                        updateChecs.updateEstadoArchivo(tif.getId());
                    }
                }
            }
        }
    }
}

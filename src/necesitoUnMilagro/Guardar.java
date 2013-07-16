/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

import Entidades.Imagen;
import Entidades.TrazaDao;
import javax.swing.JLabel;
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

    private int idtraza, idimagen, page;
    private JLabel pagina;


    public Guardar(TrazaDao traza, String nombre, JTable tablaCheck) {
        this.traza = traza;
        this.nombre = nombre;
        this.tablaCheck = tablaCheck;
        guardar();
    }

    public Guardar(TrazaDao traza, String nombre, JTable tablaCheck, JLabel pagina, boolean pdf) {
        this.traza = traza;
        this.nombre = nombre;
        this.tablaCheck = tablaCheck;
        if(pdf){
            setNumeroPagina(pagina);
        }else{
            this.page=0;
        }
        guardar();
    }




    private void guardar() {
//        Imagen tif = traza.getTifByName(nombre);
        Imagen tif = traza.getTifByNameAndPage(nombre, page);
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

    private void setNumeroPagina(JLabel pagina) {
        try {

//        if (pagina.getText().equals("Pagina:  ")) {
//            this.page = 0;
//        } else {
//            if{
            String rem = pagina.getText().replace("Pagina:", "").trim();
            int numeroPagina = Integer.parseInt(rem) - 1;
            this.page = numeroPagina;
//        }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}

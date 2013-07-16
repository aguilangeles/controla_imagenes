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


//    public Guardar(TrazaDao traza, String nombre, JTable tablaCheck) {
//        this.traza = traza;
//        this.nombre = nombre;
//        this.tablaCheck = tablaCheck;
//        guardar();
//    }

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
        Imagen aImagen = traza.getImageByNameAndPage(nombre, page);
        LlenarControles controles = new LlenarControles(traza.getId(), aImagen.getId());
        for (ControlesPorImagen controlesImagen : controles.getLista()) {
            for (int index = 0; index < tablaCheck.getRowCount(); index++) {
                String rowDescripcion = (String) tablaCheck.getValueAt(index, 1);
                boolean check = (boolean) tablaCheck.getValueAt(index, 0);
                if (rowDescripcion.equals(controlesImagen.getDescripcion())) {
                    controlesImagen.setCheck(check);
                    updateChecs = new UpdateChecs(controlesImagen.getEstado(), controlesImagen.getIdTrazaArchivoControl());
                    updateChecs.update();
                    if (check) {
                        updateChecs.updateEstadoArchivo(aImagen.getId());
                    }
                }
            }
        }
    }

    private void setNumeroPagina(JLabel pagina) {
        try {
            String rem = pagina.getText().replace("Pagina:", "").trim();
            int numeroPagina = Integer.parseInt(rem) - 1;
            this.page = numeroPagina;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}

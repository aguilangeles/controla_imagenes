/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Entidades.Imagen;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;

/**
 *
 * @author MUTNPROD003
 */
class PrimerImagen {
private int contador;
private Imagen siguientes;
    public PrimerImagen(boolean pdf, JInternalFrame internal, Imagen nextImagen,
            JButton anterior, JLabel ruta, JTable jTable1, int contador, int size
            , JScrollPane scrollimage, JSlider slider, int zoom, JLabel pagina)
    {
        this.contador=contador;
       try {
            internal.setMaximum(false);
            this.siguientes = nextImagen;//trae el ramdom
            anterior.setEnabled(false);
            String rutaDb = siguientes.getRutaDb();//ruta de archivo
            internal.setTitle("Imagen " + contador + "/" + size);
            ruta.setText(rutaDb);
            internal.setVisible(true);
            String verImagen = primeraImagen(pdf, siguientes,pagina);
            VisualizarImagen visualizarImagen = new VisualizarImagen(verImagen, scrollimage, slider, zoom);
            int id = siguientes.getId();
            new SetChecksBox(jTable1).setEstadoChecksBoxs(id);
            this.contador++;
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       private String primeraImagen(boolean ispdf, Imagen siguientes, JLabel pagina) {
        String ret;
        if (ispdf) {
            ImagenesWorker worker = new ImagenesWorker(siguientes.getRuta_archivo(), siguientes.getParent(), siguientes.getPagina());
            worker.execute();
            ret = worker.doInBackground();
            siguientes.setRutaTemp(ret);
            pagina.setText("Pagina: " + siguientes.getPagina());
        } else {
            ret = siguientes.getRuta_archivo();
            pagina.setVisible(false);
        }
        return ret;
    }

    public int getContador() {
        return contador;
    }

    public Imagen getSiguientes() {
        return siguientes;
    }

    public void setSiguientes(Imagen siguientes) {
        this.siguientes = siguientes;
    }


}

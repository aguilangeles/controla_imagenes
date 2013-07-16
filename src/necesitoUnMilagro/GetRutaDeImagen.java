/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

import Entidades.Imagen;
import Ventana.ImagenesWorker;
import javax.swing.JLabel;

/**
 *
 * @author MUTNPROD003
 */
public final class GetRutaDeImagen {
    private String siguienteRuta, anteriorRuta;

    private Imagen imagen;
    private JLabel pagina;
    private boolean pdf;

    public GetRutaDeImagen(Imagen imagen, boolean pdf,JLabel pagina) {
        this.imagen = imagen;
        this.pdf = pdf;
        this.pagina=pagina;
        anteriorImagen();
        siguienteImagen();
    }



    private String anteriorImagen() {
        String visualizacion = "";
//        tabla.requestFocusInWindow();
//        Previus previus = new Previus(internal, tabla, siguiente, ruta, pagina, sizeRamdom);
//        previus.setearInternalFrame(contador, imagen);
        if (pdf) {
            anteriorRuta = imagen.getRutaTemp();
        } else if (!pdf) {
            anteriorRuta = imagen.getRuta_archivo();
        }
        return anteriorRuta;
    }

    public String siguienteImagen()  {
        String ruta_temp = "";
//        Next proximo = new Next(anterior, siguiente, sizeRamdom,
//                internal, ruta, pagina, tabla);
//        tabla.requestFocusInWindow();
        if (pdf) {
            ImagenesWorker worker = new ImagenesWorker(imagen.getRuta_archivo(), imagen.getParent(), imagen.getPagina());
            worker.execute();
            siguienteRuta = worker.doInBackground();
            imagen.setRutaTemp(ruta_temp);

        } else if (!pdf) {
            siguienteRuta = imagen.getRuta_archivo();
            pagina.setVisible(false);
        }
//        proximo.crearInternalFrame(contador++, imagen);
        return siguienteRuta;
    }

    public String getSiguienteRuta() {
        return siguienteRuta;
    }

    public void setSiguienteRuta(String siguienteRuta) {
        this.siguienteRuta = siguienteRuta;
    }

    public String getAnteriorRuta() {
        return anteriorRuta;
    }

    public void setAnteriorRuta(String anteriorRuta) {
        this.anteriorRuta = anteriorRuta;
    }

}
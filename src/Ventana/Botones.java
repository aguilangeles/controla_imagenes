/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Entidades.Imagen;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import necesitoUnMilagro.Next;
import necesitoUnMilagro.Previus;
import necesitoUnMilagro.SetChecksBox;

/**
 *
 * @author MUTNPROD003
 */
public class Botones {

    private boolean pdf;
    private boolean hasNext;
    private JTable tabla;
    private JLabel ruta;
    private JLabel pagina;
    private JButton siguiente;
    private JButton anterior;
    private JInternalFrame internal;
    private int sizeRamdom;
    private int contador;
    private Imagen imagen;

    public Botones(JButton anterior,
            JButton siguiente,
            int sizeRamdom,
            JInternalFrame internal,
            JLabel ruta, JLabel pagina,
            JTable tabla, Imagen imagen,
            boolean pdf, boolean hasNext, int contador) {
        //
        this.anterior = anterior;
        this.siguiente = siguiente;
        this.sizeRamdom = sizeRamdom;
        this.internal = internal;
        this.ruta = ruta;
        this.pagina = pagina;
        this.tabla = tabla;
                new SetChecksBox(tabla).set(imagen.getId());

        this.imagen = imagen;
        this.pdf = pdf;
        this.hasNext = hasNext;
        this.contador = contador;
    }

    public Botones(JTable tabla, JLabel ruta,
            JLabel pagina, JButton siguiente,
            JInternalFrame internal, int sizeRamdom,
            boolean pdf, Imagen imagen, int contador) {
        this.tabla = tabla;
        this.ruta = ruta;
        this.pagina = pagina;
        this.siguiente = siguiente;
        this.internal = internal;
        this.sizeRamdom = sizeRamdom;
        this.pdf = pdf;
        this.imagen = imagen;
        this.contador = contador;
    }

    public String Anterior() {
        Imagen imagenAnterior = imagen;
        Previus previus = new Previus(internal, tabla, siguiente, ruta, pagina, sizeRamdom);
        previus.anteriorInternalFrame(contador, imagenAnterior);
        String aRuta = ruta_temporal_anterior(imagenAnterior);
        return aRuta;
    }

    public String Siguiente() {
        Next proximo = new Next(anterior, siguiente, sizeRamdom,
                internal, ruta, pagina, tabla);
        Imagen isNext = imagen;
        String aRuta = ruta_temporal_Siguiente(isNext);
        proximo.siguienteInternalFrame(contador++, isNext);
        return aRuta;
    }

    private String ruta_temporal_Siguiente(Imagen isNext) {
        String aRuta = null;
        if (pdf) {
            ImagenesWorker worker = new ImagenesWorker(isNext.getRuta_archivo(), isNext.getParent(), isNext.getPagina());
            worker.execute();
            aRuta = worker.doInBackground();
            isNext.setRutaTemp(aRuta);
        } else if (!pdf) {
            aRuta = isNext.getRuta_archivo();
            pagina.setVisible(false);
        }
        return aRuta;
    }

    private String ruta_temporal_anterior(Imagen imagenAnterior) {
        String aRuta="";
        if (pdf) {
            aRuta = imagenAnterior.getRutaTemp();
        } else if (!pdf) {
            aRuta = imagenAnterior.getRuta_archivo();
        }
        return aRuta;
    }
}
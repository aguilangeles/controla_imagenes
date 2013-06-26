/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import Entidades.Imagen;
import Entidades.ImagenesWorker;
import additems.Next;
import additems.Previus;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author MUTNPROD003
 */
public class Adelante_Atras_boton {

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

    public Adelante_Atras_boton(JButton anterior,
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
        this.imagen = imagen;
        this.pdf = pdf;
        this.hasNext = hasNext;
        this.contador = contador;
    }

    public Adelante_Atras_boton(JTable tabla, JLabel ruta,
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

    public String VerAnterior() {
        String visualizacion = "";
        tabla.requestFocusInWindow();
        Imagen imagenAnterior = imagen;
        Previus previus = new Previus(siguiente, internal, ruta, pagina, sizeRamdom, tabla);
        previus.setearInternalFrame(contador, imagenAnterior);
        if (pdf) {
            visualizacion = imagenAnterior.getRutaTemp();
        } else if (!pdf) {
            visualizacion = imagenAnterior.getRuta_archivo();
        }
        return visualizacion;
    }

    public String VerSiguientes() throws Exception {
        String ruta_temp = "";
        Next proximo = new Next(anterior, siguiente, sizeRamdom,
                internal, ruta, pagina, tabla);
        tabla.requestFocusInWindow();
        Imagen isNext = imagen;
        if (pdf) {
            ImagenesWorker worker = new ImagenesWorker(isNext.getRuta_archivo(), isNext.getParent(), isNext.getPagina());
            worker.execute();
            ruta_temp = worker.doInBackground();
            isNext.setRutaTemp(ruta_temp);

        } else if (!pdf) {
            ruta_temp = isNext.getRuta_archivo();
            pagina.setVisible(false);
        }
        proximo.crearInternalFrame(contador++, isNext, hasNext);
        return ruta_temp;
    }
}
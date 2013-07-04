/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author MUTNPROD003
 */
public class Pdf_NombreMasNumero {
        private String nombre;//nombre
        private int numeroPagina;

        public Pdf_NombreMasNumero(String nombre, int numeroPagina) {
            this.nombre = nombre;
            this.numeroPagina = numeroPagina;
        }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public String getNombre() {
        return nombre;
    }


        @Override
        public String toString() {
            return nombre + ": " + numeroPagina ;
        }



}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamientoruta;

/**
 *
 * @author MUTNPROD003
 */
public class PaginaPdf {

        private int idPagina;
        private String nombre;//nombre
        private String absolute;//absoluta
        private String parent;//hacerrelativa
        private String relativa;//hacerrelativa

        public PaginaPdf(String nombre, int idPagina) {
            this.nombre = nombre;
            this.idPagina = idPagina;
        }

    public int getIdPagina() {
        return idPagina;
    }

    public String getNombre() {
        return nombre;
    }


        @Override
        public String toString() {
            return nombre + ": " + idPagina ;
        }



}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamientoruta;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MUTNPROD003
 */
public class ListaRutas {

    private List<Pagina> lista = new ArrayList<>();

    public List<Pagina> cargarLista() {
        lista.add(new Pagina(2, "C%3A%5CAngeles%5Creducido%5CFRP_20130507_002%5CFRP_0001_2013-05-07_11-00-58.pdf"));
        lista.add(new Pagina(1, "C%3A%5CAngeles%5Creducido%5CFRP_20130507_002%5CFRP_0002_2013-05-07_11-00-58.pdf"));
        lista.add(new Pagina(3, "C%3A%5CAngeles%5Creducido%5CFRP_20130507_002%5CFRP_0003_2013-05-07_11-00-58.pdf"));
        return lista;

    }

    public static class Pagina {
        int numero;
        String nombre;

        public Pagina(int numero, String nombre) {
            this.numero = numero;
            this.nombre = nombre;
        }

        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        public String getNombre() {
            String sin="";
            if(nombre.endsWith(".pdf")){
                String p = ".pdf";
                nombre.replace(p, "");
            }
            String ret ="";
            try {
                 ret = URLDecoder.decode(nombre, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(ListaRutas.class.getName()).log(Level.SEVERE, null, ex);
            }
                return ret;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }


    }


}

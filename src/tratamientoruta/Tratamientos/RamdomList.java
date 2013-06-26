/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamientoruta.Tratamientos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author MUTNPROD003
 */
public class RamdomList {
    private List<Object> lista;
    private List<Object> seleccion = new ArrayList<>();
    private int rango;

    public RamdomList(List<Object> lista, int rango) {
        this.lista = lista;
        this.rango = rango;
        ramdom();

    }


    private  void ramdom() {
        HashSet<Object> hash = new HashSet<>();
        int tamanioLote = lista.size();
        while (hash.size() < rango) {
            Integer a1 = new Integer(new java.util.Random().nextInt(tamanioLote));
            hash.add(a1);
        }
        ArrayList ListaHash = new ArrayList(hash);
        Collections.sort(ListaHash);
        Iterator it = ListaHash.iterator();
        while (it.hasNext()) {
            Integer idTif = (Integer) it.next();
            seleccion.add(lista.get(idTif));
        }
    }

    public List<Object> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(List<Object> seleccion) {
        this.seleccion = seleccion;
    }

}

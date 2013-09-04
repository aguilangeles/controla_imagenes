/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author MUTNPROD003
 */
public class CrearElRamdom {
    private List<Object> lista;
    private List<Object> seleccion = new ArrayList<>();
    private int tamanio,rango;

    public CrearElRamdom(List<Object> lista, int rango) {
        this.lista = lista;
        this.rango = rango;
        this.tamanio =lista.size();
        generarRamdom();
    }
    private  void generarRamdom() {
        HashSet<Object> hash = new HashSet<>();
        while (hash.size() < rango) {
            Integer a1 = new Integer(new java.util.Random().nextInt(tamanio));
       if (!hash.contains(a1)) {
        hash.add(a1);
      }
        }
        ArrayList ListaHash = new ArrayList(hash);
        Collections.sort(ListaHash);
        Iterator it = ListaHash.iterator();
        while (it.hasNext()) {
            Integer imagen = (Integer) it.next();
            seleccion.add(lista.get(imagen));
        }
    }

    public List<Object> getSeleccion() {
        return seleccion;
    }
    public void setSeleccion(List<Object> seleccion) {
        this.seleccion = seleccion;
    }

}
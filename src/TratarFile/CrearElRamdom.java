/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import java.util.List;
import java.util.Stack;

/**
 *
 * @author MUTNPROD003
 */
public class CrearElRamdom {

  private List<Object> lista;
//  private List<Object> seleccion = new ArrayList<>();
  private int muestra;
  private Stack<Object> stack = new Stack<>();

  public CrearElRamdom(List<Object> lista, int muestra) {
    this.lista = lista;
    this.muestra = muestra;
    generarRamdom();
  }

  private void generarRamdom() {
    /*Replace for Stack*/
    int posicion = 0;
//    int muestra = muestra;
    for (int i = 0; i < muestra; i++)
      {
      posicion = (int) Math.floor(Math.random() * muestra);
      while (stack.contains(lista.get(posicion)))
        {
        posicion = (int) Math.floor(Math.random() * muestra);
        }
      stack.push(lista.get(posicion));
      }
  }

  //  private void generarRamdom() {
  //    HashSet<Object> hash = new HashSet<>();
  //    while (hash.size() < rango)
  //      {
  //      Integer a1 = new Integer(new java.util.Random().nextInt(tamanio));
  //      if (!hash.contains(a1))
  //        {
  //        hash.add(a1);
  //        }
  //      }
  //    ArrayList ListaHash = new ArrayList(hash);
  //    Collections.sort(ListaHash);
  //    Iterator it = ListaHash.iterator();
  //    while (it.hasNext())
  //      {
  //      Integer imagen = (Integer) it.next();
  //      seleccion.add(lista.get(imagen));
  //  }
  //  }
  public Stack<Object> getStack() {
    return stack;
  }
//  public List<Object> getSeleccion() {
//    return seleccion;
//  }
//
//  public void setSeleccion(List<Object> seleccion) {
//    this.seleccion = seleccion;
//  }
}

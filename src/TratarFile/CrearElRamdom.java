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
    int posicion = 0;
    for (int i = 0; i < muestra; i++)
      {
      posicion = (int) new java.util.Random().nextInt(muestra+1);
//      posicion = (int) Math.floor(Math.random() * muestra+1);
      while (stack.contains(lista.get(posicion)))
        {
        posicion = (int) new java.util.Random().nextInt(muestra+1);
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
}

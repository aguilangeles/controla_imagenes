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
      posicion = (int) new java.util.Random().nextInt(muestra + 1);
      while (stack.contains(lista.get(posicion)))
        {
        posicion = (int) new java.util.Random().nextInt(muestra + 1);
        }
      stack.push(lista.get(posicion));
      }
  }

  public Stack<Object> getStack() {
    return stack;
  }
}

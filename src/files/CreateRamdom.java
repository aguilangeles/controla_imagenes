/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.util.List;
import java.util.Stack;

/**
 *
 * @author MUTNPROD003
 */
public class CreateRamdom {

  private List<Object> listaObject;
  private int muestra;
  private Stack<Object> stack = new Stack<>();

  public CreateRamdom(List<Object> lista, int muestra) {
    this.listaObject = lista;
    this.muestra = muestra;
    this.stack = createRamdomList();
  }

  private Stack<Object> createRamdomList() {
    Stack<Object> stack1 = new Stack<>();
    int posicion;
    for (int i = 0; i < muestra; i++)
      {
      posicion = (int) new java.util.Random().nextInt(muestra + 1);
      while (stack1.contains(listaObject.get(posicion)))
        {
        posicion = (int) new java.util.Random().nextInt(muestra + 1);
        }
      stack1.push(listaObject.get(posicion));
      }
    return stack1;
  }

  public Stack<Object> getStack() {
    return stack;
  }
}

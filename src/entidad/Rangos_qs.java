/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class Rangos_qs {
  private static  int id;
  private static int minimo;
  private static int maximo;
  private static int muestra;
  private static int rechazo;

  public Rangos_qs(int id, int minimo, int maximo, int muestra, int rechazo) {
    Rangos_qs.id = id;
    Rangos_qs.minimo = minimo;
    Rangos_qs.maximo = maximo;
    Rangos_qs.muestra = muestra;
    Rangos_qs.rechazo = rechazo;
  }

  public static int getId() {
    return id;
  }

  public static void setId(int id) {
    Rangos_qs.id = id;
  }

  public static int getMinimo() {
    return minimo;
  }

  public static void setMinimo(int minimo) {
    Rangos_qs.minimo = minimo;
  }

  public static int getMaximo() {
    return maximo;
  }

  public static void setMaximo(int maximo) {
    Rangos_qs.maximo = maximo;
  }

  public static int getMuestra() {
    return muestra;
  }

  public static void setMuestra(int muestra) {
    Rangos_qs.muestra = muestra;
  }

  public static int getRechazo() {
    return rechazo;
  }

  public static void setRechazo(int rechazo) {
    Rangos_qs.rechazo = rechazo;
  }




}

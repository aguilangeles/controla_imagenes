/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reporteFinal;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class AutomaticoRoA {

  private static boolean aceptar;
  private int numeroRechazo;
  private int cantidadRechazada;
  private static String statusName;
  private static int statusValue;

  public AutomaticoRoA(int numeroRechazo, int cantidadRechazada) {
    this.numeroRechazo = numeroRechazo;
    this.cantidadRechazada = cantidadRechazada;
    getstatus();

  }

  private void getstatus() {
    if(numeroRechazo >= cantidadRechazada){
      aceptar = true;
      statusName="ACEPTADO";
      statusValue=1;
    }else if(numeroRechazo < cantidadRechazada){
      aceptar=false;
      statusName="RECHAZADO";
      statusValue=0;
    }
  }

  public static boolean isAceptar() {
    return aceptar;
  }

  public static void setAceptar(boolean aceptar) {
    AutomaticoRoA.aceptar = aceptar;
  }

  public static String getStatusName() {
    return statusName;
  }

  public static void setStatusName(String statusName) {
    AutomaticoRoA.statusName = statusName;
  }

  public static int getStatusValue() {
    return statusValue;
  }

  public static void setStatusValue(int statusValue) {
    AutomaticoRoA.statusValue = statusValue;
  }


 
}

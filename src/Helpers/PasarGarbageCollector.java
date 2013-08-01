/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

/**
 *
 * @author MUTNPROD003
 */
public class PasarGarbageCollector {

  public PasarGarbageCollector() {
    pasarGarbageCollector();
  }

  public void pasarGarbageCollector() {
    Runtime garbage = Runtime.getRuntime();
    garbage.gc();
  }
}

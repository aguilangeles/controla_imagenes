/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author MUTNPROD003
 */
class TeclasListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
                case KeyEvent.VK_E:
                    System.out.println("siguiente");
                 //   siguienteSuceso();
                    break;
                case KeyEvent.VK_R:
                    System.out.println("anterior");
                  //  AnteriorSuceso();
                    break;
                case KeyEvent.VK_P:
                    System.out.println("no implementado");
                    break;
            }
    }



}

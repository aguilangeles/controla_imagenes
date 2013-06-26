/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import writeproperties.Conexion;
import writeproperties.Usuario;

/**
 *
 * @author MUTNPROD003
 */
public class TestValidacionUsuario {
    private static final String VALIDAR_STRING="El campo no puede estar vacio";
    private static final String CONEXION_EXITOSA = "\nLa conexion ha sido exitosa .\n\nEl programa se cerrará\nPara ingresar al panel de "
            + "control debera ingresar su usuario y password validado en la DB";
    private String urlS;
    private String databaseS;
    private String usuarioS;
    private String passwordS;
    private Conexion validar;
    private JButton aceptar;
    private boolean test;
    private JFrame validarUsuario;
    private Usuario aUsuario;

    public TestValidacionUsuario(JTextField url, JTextField database, JTextField usuario,
            JTextField password, Conexion validar, JButton aceptar, boolean test, JFrame validarUsuario) {
        
        this.urlS = url.getText().trim();
        
        this.databaseS = database.getText().trim();
        this.usuarioS = usuario.getText().trim();
        this.passwordS = password.getText().trim();
        this.validar = validar;
        this.aceptar = aceptar;
        this.test = test;
        this.validarUsuario = validarUsuario;
        this.aUsuario = new Usuario(urlS, databaseS, usuarioS, passwordS);
        usuarioAceptar(aUsuario);
        
    }

    private void usuarioAceptar(Usuario user) {
        SetearArchivoConfiguracion setProperties = new SetearArchivoConfiguracion(user.getUrl(), user.getBase(), user.getUsuario(), user.getPassword());
        if (validar.isConexion()) {
            aceptar.setBackground(Color.GREEN);
            aceptar.setText("Conexion Exitosa");
            if (!test) {
                JOptionPane.showMessageDialog(aceptar, CONEXION_EXITOSA, "Configuracion inicial", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            } else {
                aceptar.setText("Test Exitoso");
                JOptionPane.showMessageDialog(aceptar, "Conexion exitosa", "Test de Conexion", JOptionPane.INFORMATION_MESSAGE);
                validarUsuario.dispose();
            }
        } else {
            aceptar.setBackground(Color.RED);
            aceptar.setText("Error");
            //arreglar esto
            JOptionPane.showMessageDialog(aceptar,
                    "\nLa conexion ha fallado .\n\nEl programa se cerrará\nContactese con el adminstrador ", "Falla en la config. inicial", JOptionPane.ERROR_MESSAGE);
            System.exit(0);

        }
    }
  public  void validarStrings(String sString) {
        if (sString.trim().isEmpty()) {
            throw new RuntimeException(VALIDAR_STRING);
        }
    }
    
}

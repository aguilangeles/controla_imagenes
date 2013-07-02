/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Refactor;

import Paneles.SetearArchivoConfiguracion;
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
public class TestBaseDeDatos {

    private static final String STRING_VALIDO = "El campo no puede estar vacio";
    private static final String CONEXION_EXITOSA = "\nLa conexion ha sido exitosa .\n\nEl programa se cerrará\nPara ingresar al panel de "
            + "control debera ingresar su usuario y password validado en la DB";
    private String thisUrl;
    private String thisDatabase;
    private String thisUsuario;
    private String thisPassw;
    private Conexion validar;
    private JButton aceptar;
    private boolean test;
    private JFrame validarUsuario;
    private Usuario aUsuario;

    public TestBaseDeDatos(JTextField url, JTextField database, JTextField usuario,
            JTextField password, Conexion conexion, JButton aceptar, boolean isTest, JFrame validarUsuario) {
        try {
            this.thisUrl = validarString(url.getText());
            this.thisDatabase = validarString(database.getText());
            this.thisUsuario = validarString(usuario.getText());
            this.thisPassw = validarString(password.getText());
            this.validar = conexion;
            this.aceptar = aceptar;
            this.test = isTest;
            this.validarUsuario = validarUsuario;
            this.aUsuario = new Usuario(thisUrl, thisDatabase, thisUsuario, thisPassw);
            testConexion(aUsuario);
        } catch (RuntimeException aRuntimeExc) {
            JOptionPane.showMessageDialog(null, aRuntimeExc.getMessage(), "Campo sin valor", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void testConexion(Usuario aUsuario) {
        SetearArchivoConfiguracion setProperties = new SetearArchivoConfiguracion(aUsuario.getUrl(), aUsuario.getBase(), aUsuario.getUsuario(), aUsuario.getPassword());
        if (validar.isConexion()) {
            aceptar.setBackground(Color.GREEN);
            aceptar.setText("Conexion Exitosa");
            if (!test) {
                JOptionPane.showMessageDialog(validarUsuario, CONEXION_EXITOSA, "Configuracion inicial", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            } else {
                aceptar.setText("Test Exitoso");
                JOptionPane.showMessageDialog(validarUsuario, "Conexion exitosa", "Test de Conexion", JOptionPane.INFORMATION_MESSAGE);
                validarUsuario.dispose();
            }
        } else {
            aceptar.setBackground(Color.RED);
            aceptar.setText("Error");
            //arreglar esto
            // arreglar con que?

            JOptionPane.showMessageDialog(validarUsuario,
                    "\nLa conexion ha fallado .\n\nEl programa se cerrará\nContactese con el adminstrador ", "Falla en la config. inicial", JOptionPane.ERROR_MESSAGE);
            System.exit(0);

        }
    }

    private String validarString(String aString) {
        if (aString.trim().isEmpty()) {
            throw new RuntimeException(STRING_VALIDO);
        }
        return aString;
    }
}

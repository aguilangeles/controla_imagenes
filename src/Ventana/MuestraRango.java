/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Entidades.Conexion;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class MuestraRango {

    private Conexion conexion = new Conexion();
    private int muestra, idRango;

    public MuestraRango(int tamanioLote) {
        muestraRango(tamanioLote);
    }

    private void muestraRango(int aTamanioLote) {
        if (conexion.isConexion()) {
            try {
                String query = "select  minimo , maximo, muestra, id from rangos_qs";
                conexion.executeQuery(query);
                while (conexion.resulset.next()) {
                    int minimo = conexion.resulset.getInt(1);
                    int maximo = conexion.resulset.getInt(2);
                    if (aTamanioLote >= minimo && aTamanioLote <= maximo) {
                        muestra = conexion.resulset.getInt(3);
                        idRango = (conexion.resulset.getInt(4));
                    }
                }
                conexion.isConexionClose();
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Poblar tabla de Rangos", JOptionPane.ERROR_MESSAGE);

//                Logger.getLogger(MuestraRango.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int getMuestra() {
        return muestra;
    }


    public void setMuestra(int muestra) {
        this.muestra = muestra;
    }

    public int getIdRango() {
        return idRango;
    }

    public void setIdRango(int idRango) {
        this.idRango = idRango;
    }
}

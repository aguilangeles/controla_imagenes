/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReporteLote;

import javax.swing.JTextArea;
import Entidades.Conexion;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class UpdateEstadoLote {
    private Conexion conexion;
    private int idtraza;
    private JTextArea mensaje;
    private int setEstado;

    public UpdateEstadoLote(Conexion conexion,int idtraza, boolean estado, JTextArea mensaje) {
        this.conexion=conexion;
        this.idtraza = idtraza;
        this.mensaje = mensaje;
        this.setEstado=(!estado)?0:1;
        update();
    }

    private void update() {
        String observaciones = mensaje.getText();
        String update = "UPDATE `qualitys`.`traza` "
                + "SET `estadoLote` = " + setEstado + ", `observaciones` = '" + observaciones + "' "
                + "WHERE id =" + idtraza + ";";
      try {
        conexion.executeUpdate(update);
      } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, ex.getMessage(), "Seteo Estado Lote", JOptionPane.ERROR_MESSAGE);
      }
    }
}

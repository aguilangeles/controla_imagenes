/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entidades.Conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class ListaControlesActivos {
private Conexion conexion ;
    private List<TipoControl> lista=new ArrayList<>();

    public ListaControlesActivos(Conexion conexion) {
        this.conexion=conexion;
        poblarLista();
    }

    private List<TipoControl> poblarLista() {
        TipoControl tipo;

        if (conexion.isConexion()) {
            try {
                conexion.executeQuery("Select id, descripcion from controles where estado = 1 ");
                while (conexion.resulset.next()) {
                    int id = conexion.resulset.getInt(1);
                    String descripcion = conexion.resulset.getString(2);
                    tipo = new TipoControl(id, descripcion);
                    lista.add(tipo);
                }
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Lista de controles Activos", JOptionPane.ERROR_MESSAGE);

//                Logger.getLogger(ListaControlesActivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public List<TipoControl> getLista() {
        return lista;
    }

    public static class TipoControl {
        private int id;
        private String descripcion;

        public TipoControl(int id, String descripcion) {
            this.id = id;
            this.descripcion = descripcion;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        @Override
        public String toString() {
            return  id + "-" + descripcion ;
        }
    }
}

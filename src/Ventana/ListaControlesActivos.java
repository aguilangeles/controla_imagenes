/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entidades.Conexion;

/**
 *
 * @author MUTNPROD003
 */
public class ListaControlesActivos {
private Conexion conexion ;
    private List<TipoDeControl> lista=new ArrayList<>();

    public ListaControlesActivos(Conexion conexion) {
        this.conexion=conexion;
        poblarLista();
    }

    private List<TipoDeControl> poblarLista() {
        TipoDeControl tipo;

        if (conexion.isConexion()) {
            try {
                conexion.ExecuteSql("Select id, descripcion from controles where estado = 1 ");
                while (conexion.resulset.next()) {
                    int id = conexion.resulset.getInt(1);
                    String descripcion = conexion.resulset.getString(2);
                    tipo = new TipoDeControl(id, descripcion);
                    lista.add(tipo);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ListaControlesActivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public List<TipoDeControl> getLista() {
        return lista;
    }

    public static class TipoDeControl {
        private int id;
        private String descripcion;

        public TipoDeControl(int id, String descripcion) {
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

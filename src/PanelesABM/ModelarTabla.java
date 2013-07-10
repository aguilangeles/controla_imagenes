/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelesABM;

import Entidades.Conexion;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maria
 */
public class ModelarTabla {
    
    private Conexion Conexion;
    private String nombreTabla;
    private JTable tabla;
    private boolean editable;
    private Editar editar;
    private InsertRows insertRows;
    private int lastId;
    
    public DefaultTableModel modelo() {
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        
        
        return modelo;
    }
}

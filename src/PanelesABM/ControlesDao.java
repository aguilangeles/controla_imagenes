/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelesABM;

//<<<<<<< HEAD
import Helpers.UltimoIdInsertado;
//>>>>>>> 0615e0f24e513e8a126fa9b3d14fc37ac5a6304d
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//<<<<<<< HEAD
import Entidades.Conexion;
import java.util.ArrayList;
import java.util.List;
//=======
//>>>>>>> dfe2936d0bda8775694b5029d291ce8c8ab95bde

/**
 *
 * @author MUTNPROD003
 */
public class ControlesDao extends ABMPaneles {

    private Conexion aConexion;
    private static final String NOMBRE_TABLA = "controles";
    private JTable aTable;
    private boolean editable;
    private Editar editar;
    private InsertRows insertar;
    private int lastId;

//<<<<<<< HEAD
    public ControlesDao(JTable tabla, Conexion conexion) {
        super(conexion, tabla);
        this.aTable = tabla;
        this.aConexion = conexion;
        DefaultTableModel modelo = modeldo();
        aTable.setModel(modelo);
        setAnchoFilas();
        setCellRenderer();
        altoCeldas(modelo, aTable);
        centrarColumna(0);
        centrarColumna(4);
        this.editar = new Editar(conexion, modelo);
        this.insertar = new InsertRows(conexion, modelo);
    }
//

    private DefaultTableModel modeldo() {
//>>>>>>> dfe2936d0bda8775694b5029d291ce8c8ab95bde
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                if (columna == 0) {
                    return false;
                }
                return isEditable();
            }

            @Override
            public Class getColumnClass(int col) {
                switch (getColumnName(col)) {
                    case "id":
                        return Integer.class;
                    case "nombre":
                        return String.class;
                    case "descripción":
                        return String.class;
                    case "imagen":
                        return String.class;
                    default://estado
                        return Integer.class;
                }
            }
        };
//<<<<<<< HEAD
        setTitulos(model);
        setConsulta(model);
        return model;
    }
    private void setAnchoFilas() {
        List<AnchoDeColumna> list = new ArrayList<>();
        list.add(new AnchoDeColumna(0, 20));
        list.add(new AnchoDeColumna(1, 90));
        list.add(new AnchoDeColumna(2, 500));
        list.add(new AnchoDeColumna(3, 70));
        list.add(new AnchoDeColumna(4, 25));
        anchoColumnas(aTable, list);

    }

    private void setCellRenderer() {
        ArrayList<AnchoDeColumna> lista = new ArrayList<>();
        lista.add(new AnchoDeColumna(1, 0));
        lista.add(new AnchoDeColumna(2, 0));
        cellRenderer(lista, 70);
    }

    private void setTitulos(DefaultTableModel model) {
        String split = "id, nombre, descripcion, imagen, est";
        titulos(model, split);
    }
//
    private void setConsulta(DefaultTableModel model) {
        List<Object[]> lista = new ArrayList<>();
        if (aConexion.isConexion()) {
            try {
                aConexion.ExecuteSql("SELECT id, descripcion, texto, imagen , estado FROM qualitys." + NOMBRE_TABLA + ";");
                while (aConexion.resulset.next()) {
                    Object[] oo = new Object[]{aConexion.resulset.getInt(1),
                        aConexion.resulset.getString(2),
                        aConexion.resulset.getString(3),
                        aConexion.resulset.getString(4),
                        aConexion.resulset.getInt(5)};
                    lista.add(oo);

                }
            } catch (SQLException ex) {
                Logger.getLogger(ControlesDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        consulta(model, lista);
    }
    }
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public int getLastId() {
        return new UltimoIdInsertado(aConexion, NOMBRE_TABLA).getUltimoId();
    }

    public Editar getEditar() {
        return editar;
    }

    public boolean isEditable() {
        return editable;
    }

    public InsertRows getInsertar() {
        return insertar;
    }
}
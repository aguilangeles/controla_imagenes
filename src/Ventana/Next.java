/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Entidades.Imagen;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author MUTNPROD003
 */
public class Next extends JFrame {

    private JButton anterior;
    private JButton siguiente;
    private int sizeRamdom;
    private JInternalFrame internal;
    private JLabel titulo;
    private JLabel pagina;
    private JTable tabla;
    
    
    public Next(JButton anterior, JButton siguiente,
            int sizeRamdom, JInternalFrame internal, JLabel titulo, JLabel pagina, JTable tabla) {
        this.anterior = anterior;
        this.siguiente = siguiente;
        this.sizeRamdom = sizeRamdom;
        this.internal = internal;
        this.titulo = titulo;
        this.pagina=pagina;
        this.tabla = tabla;
    }

    public void crearInternalFrame(int contador, Imagen tif, boolean ishasNext) {
        int id = tif.getId();
        new SetChecksBox(tabla).setEstadoChecksBoxs(id);
        siguiente.setText("Siguiente");
        anterior.setEnabled(true);
        internal.setTitle("Imagen " + contador + "/" + sizeRamdom);
        String rutaPdf = tif.getRutaDb();
        int mas = tif.getPagina()+1;
        String page = "Pagina: " +mas;
        titulo.setText(rutaPdf);
        pagina.setText(page);
        internal.setVisible(true);
        contador++;
    }


}

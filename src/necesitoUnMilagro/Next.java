/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

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

    public void crearInternalFrame(int contador, Imagen tif) {
        anterior.setEnabled(true);
        int id = tif.getId();
        String rutaPdf = tif.getRutaDb();
        internal.setTitle("Imagen " + contador + "/" + sizeRamdom);
        new SetChecksBox(tabla).set(id);
        titulo.setText(rutaPdf);
        internal.setVisible(true);
        siguiente.setText("Siguiente");
        String page = "Pagina: " + tif.getPagina();
        pagina.setText(page);
        contador++;
    }


}

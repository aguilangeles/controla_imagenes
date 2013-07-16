/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

import Entidades.Imagen;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author MUTNPROD003
 */
public class Previus {
    private JButton siguiente;
    private JInternalFrame internal;
    private JLabel titulo;
    private JLabel pagina;
    private int sizeRamdom;
    private JTable tabla;

    public Previus(JInternalFrame internal, JTable tabla, JButton siguiente, JLabel titulo, JLabel pagina, int sizeRamdom) {
        this.siguiente = siguiente;
        this.internal = internal;
        this.titulo = titulo;
        this.pagina=pagina;
        this.sizeRamdom = sizeRamdom;
        this.tabla = tabla;
    }

    public void anteriorInternalFrame(int contador, Imagen tif) {
        siguiente.setEnabled(true);
        internal.setTitle("Imagen " + contador + "/" + sizeRamdom);
        String rutaPdf = tif.getRutaDb();
        String page = "Pagina: " + tif.getPagina();
        titulo.setText(rutaPdf);
        pagina.setText(page);
        int id = tif.getId();
        new SetChecksBox(tabla).set(id);
        contador--;
    }
}

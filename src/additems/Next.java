/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package additems;

import Entidades.Imagen;
import Entidades.ObtenerControles;
import Entidades.SetChecksBox;
import Entidades.TiposConCheck;
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
        new SetChecksBox(tabla).setFirstBoolean(id);
        siguiente.setText("Siguiente");
        anterior.setEnabled(true);
        internal.setTitle("Imagen " + contador + "/" + sizeRamdom);
        String rutaPdf = tif.getRutaDb();
        String page = "Pagina: " + tif.getPagina();
        titulo.setText(rutaPdf);
        pagina.setText(page);
        internal.setVisible(true);
        contador++;
    }


}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamientoruta;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import tratamientoruta.VisualizarConvertido.ImageComponent;

/**
 *
 * @author MUTNPROD003
 */
public class TratamientoRuta {
    private int zoom = 25;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int ret = 0;
        String pablo = "//UTNNAS006//intercambio//Pablo//SEFIN//201305L01V01";
        String maria = "C:\\Angeles\\reducido";
       // Conversor convert = new Conversor(maria);
//
////        final URL lenna =
////        new URL("http://upload.wikimedia.org/wikipedia/en/2/24/Lenna.png");
//        String ruta ="C:\\Angeles\\reducido\\FRP_20130508_001\\FRP_0003_2013-05-08_09-46-24.tmp_1.jpg";
//    final JSlider slider = new JSlider(0, 1000, 500);
//    final ImageComponent image = new ImageComponent(ruta);
//    slider.addChangeListener(new ChangeListener() {
//        @Override
//        public void stateChanged(ChangeEvent e) {
//            image.setZoom(2. * slider.getValue() / slider.getMaximum());
//        }
//    });
//
//    JFrame frame = new JFrame("Test");
//    frame.add(slider, BorderLayout.NORTH);
//
//    frame.add(new JScrollPane(image));
//
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    frame.setSize(400, 300);
//    frame.setVisible(true);
       /////////////////////////
        NewClass nueva = new NewClass(maria);
        int contador=0;
        for (VolumenPDF v : nueva.getLista()) {
            for(Sublote sub : v.getSublotes()){
                for( PaginaPdf pdf : sub.getPdfpagina()){
                    contador++;
                    System.out.println(contador+" "+pdf.getNombre() +"\t_"+pdf.getIdPagina());
                }
            }
        }
        System.out.println(contador);
    }
}
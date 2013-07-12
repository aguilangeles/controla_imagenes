/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Entidades.Imagen;
import Entidades.TiposConCheck;
import Entidades.TrazaDao;
import Helpers.ButtonEditor;
import Helpers.ButtonRenderer;
import ReporteLote.Reporte;
import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MUTNPROD003
 */
public class VentanaSecundaria extends javax.swing.JFrame {

    private DefaultTableModel model;
    private TrazaDao traza;
    private ImagenesWorker worker;
    private boolean hasNext;
    private boolean hasPrevius;
    private boolean pdf;
    private boolean guardado;
    private int contador = 1;
    private int contador2 = 2;
    private int zoom;
    private int sizeRandom;
    private ListIterator iterator;
    private MyOwnFocusTraversalPolicy newPolicy;

    /**
     * Creates new form VentanaSecundaria
     *
     * @param traza
     */
    public VentanaSecundaria(TrazaDao traza) {
        initComponents();
        jTable1.requestFocus();
        this.traza = traza;
        poblarTabla();
        guardado = true;
        terminar.setEnabled(false);
        this.zoom=25;
        pdf = (traza.getExtension().equals(".pdf")) ? true : false;
        internal(pdf);
        ordenarComponentes();
    }

    private void ordenarComponentes(){
          Vector<Component> order = new Vector<Component>(4);
        order.add(jTable1);
        order.add(siguiente);
        order.add(anterior);
        order.add(terminar);
        newPolicy = new MyOwnFocusTraversalPolicy(order);
    }
 private void internal(boolean ispdf) {
        try {
            internal.setMaximum(false);
            Imagen siguientes = nextImagen();//trae el ramdom
            anterior.setEnabled(false);
            String rutaDb = siguientes.getRutaDb();//ruta de archivo
            internal.setTitle("Imagen " + contador + "/" + getSizeRamdom());
            ruta.setText(rutaDb);
            internal.setVisible(true);
            String verImagen = primeraImagen(ispdf, siguientes);
            VisualizarImagen visualizarImagen = new VisualizarImagen(verImagen, scrollImage, slider, getZoom());
            int id = siguientes.getId();
            new SetChecksBox(jTable1).setEstadoChecksBoxs(id);
            contador++;
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Ventana_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ListIterator getIterator() {
        return iterator;
    }
private void poblarTabla() {
        model = (DefaultTableModel) jTable1.getModel();
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(230);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(20);
        iterator = traza.getListaTif().listIterator();
        List<TiposConCheck> lt = traza.getListaTipos();
        for (TiposConCheck tipos : lt) {
            boolean ischeck = tipos.isCheck();
            String nombre = tipos.getNombre();
            String boton = "Boton";
            Object[] object = new Object[]{ischeck, nombre, tipos.getId()};
            jTable1.getColumn("?").setCellRenderer(new ButtonRenderer());
            jTable1.getColumn("?").setCellEditor(
                    new ButtonEditor(new JCheckBox(), lt));
            model.addRow(object);
        }
//        jTable1.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
//                .put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0, false), "moveToNextCell");
    }
    private Imagen nextImagen() {
        Imagen tif = null;
        try {
            ListIterator it = getIterator
                    ();
            tif = (Imagen) it.next();
            hasNext = (!it.hasNext()) ? false : true;
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        return tif;
    }

    private Imagen previus() {
        Imagen tif = null;
        try {
            ListIterator it = getIterator();
            tif = (Imagen) it.previous();
            hasPrevius = (!it.hasPrevious()) ? false : true;
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        return tif;
    }
    private void ActionGuardar() {
        Guardar save = new Guardar(traza, ruta.getText().toString(), jTable1);
        final int id = traza.getId();
        NumeroDeArchivosRechazados numeroRechazo = new NumeroDeArchivosRechazados(id);
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Reporte(id).setVisible(true);
            }
        });
        dispose();
    }

    private static class MyOwnFocusTraversalPolicy  extends FocusTraversalPolicy{
               Vector<Component> order;

        public MyOwnFocusTraversalPolicy(Vector<Component> order) {
            this.order = new Vector<Component>(order.size());
            this.order.addAll(order);
        }
        @Override
        public Component getComponentAfter(Container focusCycleRoot,
                                           Component aComponent)
        {
            int idx = (order.indexOf(aComponent) + 1) % order.size();
            return order.get(idx);
        }

        @Override
        public Component getComponentBefore(Container focusCycleRoot,
                                            Component aComponent)
        {
            int idx = order.indexOf(aComponent) - 1;
            if (idx < 0) {
                idx = order.size() - 1;
            }
            return order.get(idx);
        }

        @Override
        public Component getDefaultComponent(Container focusCycleRoot) {
            return order.get(0);
        }

        @Override
        public Component getLastComponent(Container focusCycleRoot) {
            return order.lastElement();
        }

        @Override
        public Component getFirstComponent(Container focusCycleRoot) {
            return order.get(0);
        }

    }


    private void siguienteSuceso() {
        String ruta_temp;
        try {
            Guardar guardar = new Guardar(traza, ruta.getText().toString(), jTable1);
            int setSize = getSizeRamdom() + 1;
            setSizeRandom(setSize);
            setZoom(slider.getValue());
            ruta_temp = new Botones(anterior, siguiente, getSizeRamdom(),
                    internal, ruta, pagina, jTable1, nextImagen(),
                    pdf, isHasNext(), contador++).Siguiente();
            VisualizarImagen visualizarImagen = new VisualizarImagen(ruta_temp, scrollImage, slider, getZoom());
            if (!isHasNext()) {
                siguiente.setEnabled(false);
                terminar.setEnabled(true);
            }
        } catch (Exception ex) {
            Logger.getLogger(Ventana_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void AnteriorSuceso() {
        String visualizacion = "";
        Guardar save = new Guardar(traza, ruta.getText().toString(), jTable1);
        int descontar = 1;
        int der = contador - descontar;
        setContador(der);
        visualizacion = new Botones(jTable1, ruta
                , pagina, siguiente,
                internal, getSizeRamdom(), pdf, previus(), getContador()).Anterior();
        VisualizarImagen visualizarImagen = new VisualizarImagen(visualizacion, scrollImage, slider, getZoom());
        if (!hasPrevius) {
            anterior.setEnabled(false);
        }
    }

    public int getZoom() {
        return slider.getValue();
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public boolean isGuardado() {
        return guardado;
    }

    public void setGuardado(boolean guardado) {
        this.guardado = guardado;
    }

    public int getContador() {
        return contador;
    }

    public boolean isHasPrevius() {
        return hasPrevius;
    }

    public void setHasPrevius(boolean hasPrevius) {
        this.hasPrevius = hasPrevius;
    }

    public int getSizeRamdom() {
        return traza.getListaTif().size();
    }

    public void setSizeRandom(int sizeRamdom) {
        this.sizeRandom = sizeRamdom;
    }
  private String primeraImagen(boolean ispdf, Imagen siguientes) {
        String ret;
        if (ispdf) {
            worker = new ImagenesWorker(siguientes.getRuta_archivo(), siguientes.getParent(), siguientes.getPagina());
            worker.execute();
            ret = worker.doInBackground();
            siguientes.setRutaTemp(ret);
            pagina.setText("Pagina: " + siguientes.getPagina());
        } else {
            ret = siguientes.getRuta_archivo();
            pagina.setVisible(false);
        }
        return ret;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        desk = new javax.swing.JDesktopPane();
        internal = new javax.swing.JInternalFrame();
        ruta = new javax.swing.JLabel();
        pagina = new javax.swing.JLabel();
        slider = new javax.swing.JSlider();
        scrollImage = new javax.swing.JScrollPane();
        siguiente = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        terminar = new javax.swing.JButton();
        scrolTabla = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        internal.setVisible(true);

        ruta.setText("Ruta:");

        pagina.setText("Pagina");

        slider.setValue(25);

        javax.swing.GroupLayout internalLayout = new javax.swing.GroupLayout(internal.getContentPane());
        internal.getContentPane().setLayout(internalLayout);
        internalLayout.setHorizontalGroup(
            internalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(internalLayout.createSequentialGroup()
                .addGroup(internalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(internalLayout.createSequentialGroup()
                        .addComponent(ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(pagina, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                    .addComponent(scrollImage))
                .addContainerGap())
        );
        internalLayout.setVerticalGroup(
            internalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(internalLayout.createSequentialGroup()
                .addGroup(internalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pagina, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollImage, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addContainerGap())
        );

        internal.setBounds(10, 10, 590, 390);
        desk.add(internal, javax.swing.JLayeredPane.DEFAULT_LAYER);

        siguiente.setText("Siguiente");
        siguiente.setFocusCycleRoot(true);
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });

        anterior.setText("jButton2");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        terminar.setText("jButton3");

        scrolTabla.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Nombre", "?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setFocusCycleRoot(true);
        jTable1.setFocusTraversalPolicyProvider(true);
        jTable1.setNextFocusableComponent(siguiente);
        jTable1.setSurrendersFocusOnKeystroke(true);
        jTable1.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jTable1HierarchyChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        scrolTabla.setViewportView(jScrollPane1);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(39, 39, 39)
                .addComponent(siguiente)
                .addGap(51, 51, 51)
                .addComponent(anterior)
                .addGap(43, 43, 43)
                .addComponent(terminar)
                .addGap(37, 37, 37))
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(desk, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrolTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(desk, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrolTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(37, 37, 37)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siguiente)
                    .addComponent(anterior)
                    .addComponent(terminar)
                    .addComponent(jButton1))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        // TODO add your handling code here:
        siguienteSuceso();
    }//GEN-LAST:event_siguienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        sigue();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jTable1HierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1HierarchyChanged

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anteriorActionPerformed

//    private void siguienteSuceso() {
//        Imagen sig = nextImagen();
//        String ruta_temp;
//        try {
//            Guardar guardar = new Guardar(traza, ruta.getText().toString(), jTable1);
//            int setSize = getSizeRandom() + 1;
//            setSizeRandom(setSize);
//            setZoom(slider.getValue());
//            ruta_temp = new Botones(anterior, siguiente, getSizeRandom(),
//                    internal, ruta, pagina, jTable1, sig,
//                    pdf, isHasNext(), contador2++).Siguiente();
//            VisualizarImagen visualizarImagen = new VisualizarImagen(ruta_temp, scrollImage, slider, getZoom());
//            if (!isHasNext()) {
//                siguiente.setEnabled(false);
//                terminar.setEnabled(true);
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(Ventana_1.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }


    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VentanaSecundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VentanaSecundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VentanaSecundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VentanaSecundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentanaSecundaria(traza).setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anterior;
    private javax.swing.JDesktopPane desk;
    private javax.swing.JInternalFrame internal;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel pagina;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JLabel ruta;
    private javax.swing.JScrollPane scrolTabla;
    private javax.swing.JScrollPane scrollImage;
    private javax.swing.JButton siguiente;
    private javax.swing.JSlider slider;
    private javax.swing.JButton terminar;
    // End of variables declaration//GEN-END:variables
}

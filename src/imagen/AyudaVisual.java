/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagen;

import helper.VersionEImageIcon;
import java.io.File;

/**
 *
 * @author MUTNPROD003
 */
public class AyudaVisual extends javax.swing.JFrame {

  private String descripcion;
  private String texto;
  private String imagen;
  private VersionEImageIcon vic = new VersionEImageIcon();

  /**
   * Creates new form AyudaVisual
   *
   * @param descripcion
   * @param texto
   * @param imagen
   */
  public AyudaVisual(String descripcion, String texto, String imagen) {
    this.descripcion = descripcion;
    this.texto = texto;
    this.imagen = imagen;
    initComponents();
    vic.newColorFromPanel(jPanel1);
    cerrar.requestFocus();
    setTitle(this.descripcion);
    jLabel1.setText(descripcion);
    tratarTexto(texto);
    visualizar(imagen);
  }

  private void visualizar(String image) {
    String ruta = "AyudaImagenes" + File.separator + image;
    VisualizarImagen vimg = new VisualizarImagen(scrollImage, jSlider1);
    vimg.visualizarImagen(ruta, jSlider1.getValue());
  }

  public AyudaVisual(String image) {
    this.imagen = image;
    initComponents();
    vic.newColorFromPanel(jPanel1);
    VisualizarImagen vig = new VisualizarImagen(scrollImage, jSlider1);
    vig.visualizarImagen(imagen, jSlider1.getValue());
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    scrollImage = new javax.swing.JScrollPane();
    jScrollPane2 = new javax.swing.JScrollPane();
    mensaje = new javax.swing.JTextArea();
    cerrar = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    jSlider1 = new javax.swing.JSlider();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 102), 2));

    scrollImage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    scrollImage.setFocusable(false);

    mensaje.setEditable(false);
    mensaje.setColumns(20);
    mensaje.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
    mensaje.setRows(5);
    mensaje.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    mensaje.setFocusable(false);
    jScrollPane2.setViewportView(mensaje);

    cerrar.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
    cerrar.setMnemonic('c');
    cerrar.setText("Cerrar");
    cerrar.setToolTipText("alt+c");
    cerrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cerrarActionPerformed(evt);
      }
    });
    cerrar.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        cerrarKeyPressed(evt);
      }
    });

    jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
    jLabel1.setFocusable(false);

    jSlider1.setPaintLabels(true);
    jSlider1.setPaintTicks(true);
    jSlider1.setValue(25);
    jSlider1.setOpaque(false);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jScrollPane2)
          .addComponent(scrollImage))
        .addContainerGap())
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addGap(0, 183, Short.MAX_VALUE)
        .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(193, 193, 193))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(scrollImage, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(15, 15, 15))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGap(1, 1, 1))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
      dispose();
    }//GEN-LAST:event_cerrarActionPerformed

  private void cerrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cerrarKeyPressed
    dispose();
  }//GEN-LAST:event_cerrarKeyPressed

  private void tratarTexto(String texto) {
    mensaje.setLineWrap(true);
    mensaje.setWrapStyleWord(true);
    mensaje.setText(texto);
  }
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
//            java.util.logging.Logger.getLogger(AyudaVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AyudaVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AyudaVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AyudaVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AyudaVisual().setVisible(true);
//            }
//        });
//    }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton cerrar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JSlider jSlider1;
  private javax.swing.JTextArea mensaje;
  private javax.swing.JScrollPane scrollImage;
  // End of variables declaration//GEN-END:variables
}
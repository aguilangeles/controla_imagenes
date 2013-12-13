/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaPrincipal;

import BasedeDatos.GetNumerosImagenesRechazadas;
import Entidades.Imagen;
import Entidades.TrazaDao;
//import Helpers.RutaMouseListener;
import Helpers.VersionEImageIcon;
import ReporteLote.Reporte;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class Ventana extends javax.swing.JFrame {

  private int sizeRamdom;
  private int contador = 0;
  private int cantidad = 1;
  private DefaultTableModel model;
  private TrazaDao traza;
  private boolean pdf;
  private boolean tif;
  private final TablaCheckBox tablaCheckBox;

  /**
   * Creates new form Ventana
   *
   * @param trazadao
   */
  public Ventana(TrazaDao trazadao) {
    iniciar(trazadao);
    setExtendedState(6);
    VersionEImageIcon version = new VersionEImageIcon(this);
    initComponents();
    tabla.requestFocus();
    this.traza = trazadao;
    this.pdf = (traza.getExtension().equals(".pdf")) ? true : false;// discrimina entre pdf y otros
    this.tif = isImagenTif(pdf, traza.getExtension());
    this.tablaCheckBox = new TablaCheckBox(model, tabla, traza);//llena la tabla con los contenidos adecuados
    //TODO pdf versus tif,png y jpg
    tabla.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
    terminar.setEnabled(false);
    anterior.setEnabled(false);
    getFirstImage(pdf);
   // rutaLabel.addMouseListener(new RutaMouseListener());
    siguiente.addKeyListener(keylistener());
    anterior.addKeyListener(keylistener());
  }

  private KeyListener keylistener() {
    KeyListener kl = new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
        myKeyEvt(e, "KeyTyped");
      }

      @Override
      public void keyPressed(KeyEvent e) {
        myKeyEvt(e, "keyReleased");
      }

      @Override
      public void keyReleased(KeyEvent e) {
        myKeyEvt(e, "keyPressed");
      }

      private void myKeyEvt(KeyEvent e, String text) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_KP_LEFT || key == KeyEvent.VK_LEFT)
          {
          setBackImage();
          } else if (key == KeyEvent.VK_KP_RIGHT || key == KeyEvent.VK_RIGHT)
          {
          getNextImage();
          }
      }
    };
    return kl;
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    panelInicial = new javax.swing.JPanel();
    desktopPane = new javax.swing.JDesktopPane();
    internal = new javax.swing.JInternalFrame();
    jScrollPane2 = new javax.swing.JScrollPane();
    tabla = new javax.swing.JTable();
    jPanel1 = new javax.swing.JPanel();
    siguiente = new javax.swing.JButton();
    anterior = new javax.swing.JButton();
    combo = new javax.swing.JComboBox();
    jLabel1 = new javax.swing.JLabel();
    entera = new javax.swing.JButton();
    ampliar = new javax.swing.JButton();
    rutaLabel = new javax.swing.JLabel();
    pageLabel = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    panelScroll = new javax.swing.JPanel();
    scrollImage = new javax.swing.JScrollPane();
    terminar = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    setBackground(new java.awt.Color(230, 252, 238));

    panelInicial.setBackground(new java.awt.Color(230, 252, 238));

    internal.setBackground(new java.awt.Color(230, 252, 238));
    internal.setIconifiable(true);
    internal.setMaximizable(true);
    internal.setResizable(true);
    internal.setVisible(true);

    tabla.setModel(new javax.swing.table.DefaultTableModel(
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
    jScrollPane2.setViewportView(tabla);

    jPanel1.setOpaque(false);

    siguiente.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    siguiente.setMnemonic('S');
    siguiente.setText("Siguiente");
    siguiente.setToolTipText("ALT+S");
    siguiente.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        siguienteActionPerformed(evt);
      }
    });

    anterior.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    anterior.setMnemonic('a');
    anterior.setText("Anterior");
    anterior.setToolTipText("ALT+A");
    anterior.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        anteriorActionPerformed(evt);
      }
    });

    combo.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "150%", "125%", "100%", "75%", "50%", "25%" }));

    jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel1.setText("Ver Imagen al");

    entera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageicon/1383002591_zoom-best-fit_1.png"))); // NOI18N
    entera.setToolTipText("Ajustar una pagina entera a la ventana");

    ampliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageicon/1383001847_stock_zoom-page-width_1.png"))); // NOI18N
    ampliar.setToolTipText("Ajustar al ancho de ventana");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(siguiente)
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(33, 33, 33)
            .addComponent(ampliar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(anterior, javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addComponent(entera, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(21, 21, 21))))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(9, 9, 9)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel1))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(entera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ampliar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
    );

    rutaLabel.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
    rutaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    pageLabel.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
    pageLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    pageLabel.setText("pagina:  ");

    jLabel2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel2.setText("Tipos de Control");

    panelScroll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

    javax.swing.GroupLayout panelScrollLayout = new javax.swing.GroupLayout(panelScroll);
    panelScroll.setLayout(panelScrollLayout);
    panelScrollLayout.setHorizontalGroup(
      panelScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(scrollImage, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
    );
    panelScrollLayout.setVerticalGroup(
      panelScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(scrollImage)
    );

    terminar.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    terminar.setMnemonic('t');
    terminar.setText("Terminar");
    terminar.setToolTipText("ALT+T");
    terminar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        terminarActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout internalLayout = new javax.swing.GroupLayout(internal.getContentPane());
    internal.getContentPane().setLayout(internalLayout);
    internalLayout.setHorizontalGroup(
      internalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(internalLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(internalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(internalLayout.createSequentialGroup()
            .addComponent(rutaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(pageLabel)
            .addGap(11, 11, 11))
          .addComponent(panelScroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(internalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(terminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        .addContainerGap())
    );
    internalLayout.setVerticalGroup(
      internalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(internalLayout.createSequentialGroup()
        .addGroup(internalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(internalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(rutaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pageLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(internalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(internalLayout.createSequentialGroup()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(terminar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(panelScroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(9, 9, 9))
    );

    internal.setBounds(0, 0, 960, 500);
    desktopPane.add(internal, javax.swing.JLayeredPane.DEFAULT_LAYER);

    javax.swing.GroupLayout panelInicialLayout = new javax.swing.GroupLayout(panelInicial);
    panelInicial.setLayout(panelInicialLayout);
    panelInicialLayout.setHorizontalGroup(
      panelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
    );
    panelInicialLayout.setVerticalGroup(
      panelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panelInicial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panelInicial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void terminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarActionPerformed
    setFinalizar();
  }//GEN-LAST:event_terminarActionPerformed

  private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
    setBackImage();
  }//GEN-LAST:event_anteriorActionPerformed

  private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
    getNextImage();
  }//GEN-LAST:event_siguienteActionPerformed

  private Imagen goImagen(int contador) {
    int limiteSuperior = getSizeRamdom() - 1;
    Imagen imagen = traza.getImagenList().get(contador);
    if (contador == limiteSuperior)
      {
      siguiente.setEnabled(false);
      terminar.setEnabled(true);
      }
    return imagen;
  }

  private Imagen backImagen(int contador) {
    int limiteInferior = 0;
    Imagen imagen = traza.getImagenList().get(contador);
    if (limiteInferior == contador)
      {
      anterior.setEnabled(false);
      }
    return imagen;
  }
  /**
   * @param args the command line arguments
   */
//  public static void main(String args[]) {
//    /* Set the Nimbus look and feel */
//    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//     */
//    try {
//      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//        if ("Nimbus".equals(info.getName())) {
//          javax.swing.UIManager.setLookAndFeel(info.getClassName());
//          break;
//        }
//      }
//    } catch (ClassNotFoundException ex) {
//      java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    } catch (InstantiationException ex) {
//      java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    } catch (IllegalAccessException ex) {
//      java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//      java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    }
//    //</editor-fold>
//
//    /* Create and display the form */
//    java.awt.EventQueue.invokeLater(new Runnable() {
//      public void run() {
//        new Ventana().setVisible(true);
//      }
//    });
//  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton ampliar;
  private javax.swing.JButton anterior;
  private javax.swing.JComboBox combo;
  private javax.swing.JDesktopPane desktopPane;
  private javax.swing.JButton entera;
  private javax.swing.JInternalFrame internal;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JLabel pageLabel;
  private javax.swing.JPanel panelInicial;
  private javax.swing.JPanel panelScroll;
  private javax.swing.JLabel rutaLabel;
  private javax.swing.JScrollPane scrollImage;
  private javax.swing.JButton siguiente;
  private javax.swing.JTable tabla;
  private javax.swing.JButton terminar;
  // End of variables declaration//GEN-END:variables

  private boolean isImagenTif(boolean pdf, String extension) {
//    System.out.println("extension " +extension);
//    if (!pdf && extension.equalsIgnoreCase(".tif"))
//      {
//      return true;
//      }
    return true;
  }

  private void iniciar(TrazaDao traza) {
    traza.getImagenList();
  }

  private void getFirstImage(boolean pdf) {
    Imagen siguientes = goImagen(contador);//trae el ramdom
   // RutaMouseListener.getAdyacentes(pdf, siguientes);
    new MostrarInternalFrames(traza, desktopPane, internal,
            anterior, pdf, tif, combo, scrollImage,
            cantidad, getSizeRamdom(), rutaLabel, pageLabel, tabla, siguiente,
            panelScroll, ampliar, entera).mostrarPrimeraImagen(siguientes);
  }

  private void getNextImage() {
    contador++;
    cantidad++;
    Imagen imagen1 = goImagen(contador);
    //RutaMouseListener.getAdyacentes(pdf, imagen1);
    new MostrarInternalFrames(traza, desktopPane, internal,
            anterior, pdf, tif, combo, scrollImage,
            cantidad, getSizeRamdom(), rutaLabel, pageLabel, tabla, siguiente,
            panelScroll, ampliar, entera).setNextImage(imagen1);

  }

  private void setBackImage() {
    contador--;
    cantidad--;
    Imagen pr = backImagen(contador);
   // RutaMouseListener.getAdyacentes(pdf, pr);
    new MostrarInternalFrames(traza, desktopPane, internal,
            anterior, pdf, tif, combo, scrollImage,
            cantidad, getSizeRamdom(), rutaLabel, pageLabel, tabla, siguiente,
            panelScroll, ampliar, entera).setBackImage(pr);

  }

  private void setFinalizar() {
    Guardar save = new Guardar();
    save.guardar(traza, rutaLabel.getText(), tabla, pageLabel, pdf);
    GetNumerosImagenesRechazadas numeroRechazo =
            new GetNumerosImagenesRechazadas(traza.getId());
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Reporte(traza.getId()).setVisible(true);
      }
    });
    dispose();
  }

  private int getSizeRamdom() {
    return traza.getImagenList().size();
  }
}

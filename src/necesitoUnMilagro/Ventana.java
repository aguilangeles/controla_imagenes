/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

import Daos.Imagen;
import Daos.TrazaDao;
import Helpers.VersionEImageIcon;
import ReporteLote.Reporte;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
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
  private final SetChecksBox setCB;
  private final Guardar save;
  private final GetRutaDeImagen rutadeimagen;
  private final TablaCheckBox tablaCheckBox;
  private ImageDrawingComponent imageDraw = new ImageDrawingComponent();

  /**
   * Creates new form Ventana
   *
   * @param trazadao
   */
  public Ventana(TrazaDao trazadao) {
    iniciar(trazadao);
    VersionEImageIcon version = new VersionEImageIcon(this);
    initComponents();
    tabla.requestFocus();
    this.traza = trazadao;
    this.setCB = new SetChecksBox(tabla);//trae los estados desde la base de datos
    setExtendedState(6);
    this.save = new Guardar();// salva los contenidos del internalframe
    this.rutadeimagen = new GetRutaDeImagen(); // llama al conversor de pdf y devuelve la ruta de imagen
    this.pdf = (traza.getExtension().equals(".pdf")) ? true : false;// discrimina entre pdf y otros
    this.tif = isImagenTif(pdf, traza.getExtension());

    this.tablaCheckBox = new TablaCheckBox(model, tabla, traza);//llena la tabla con los contenidos adecuados
    //TODO pdf versus tif,png y jpg
    tabla.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
    terminar.setEnabled(false);
    internal(pdf);
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
    desktop = new javax.swing.JDesktopPane();
    internal = new javax.swing.JInternalFrame();
    jScrollPane2 = new javax.swing.JScrollPane();
    tabla = new javax.swing.JTable();
    jPanel1 = new javax.swing.JPanel();
    siguiente = new javax.swing.JButton();
    anterior = new javax.swing.JButton();
    jComboBox1 = new javax.swing.JComboBox();
    jLabel1 = new javax.swing.JLabel();
    terminar = new javax.swing.JButton();
    rutaJL = new javax.swing.JLabel();
    page = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jPanel2 = new javax.swing.JPanel();
    scrollImage = new javax.swing.JScrollPane();

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

    jComboBox1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "150%", "125%", "100%", "75%", "50%", "25%", " " }));

    jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel1.setText("Ver Imagen al");

    terminar.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    terminar.setMnemonic('t');
    terminar.setText("Terminar");
    terminar.setToolTipText("ALT+T");
    terminar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        terminarActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(siguiente)
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(anterior, javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
      .addComponent(terminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(siguiente, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
          .addComponent(anterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(9, 9, 9)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel1))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(terminar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    rutaJL.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
    rutaJL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    page.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 12)); // NOI18N
    page.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    page.setText("pagina:22");

    jLabel2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel2.setText("Tipos de Control");

    scrollImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 0), 2));

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(scrollImage)
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(scrollImage)
    );

    javax.swing.GroupLayout internalLayout = new javax.swing.GroupLayout(internal.getContentPane());
    internal.getContentPane().setLayout(internalLayout);
    internalLayout.setHorizontalGroup(
      internalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(internalLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(internalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(internalLayout.createSequentialGroup()
            .addComponent(rutaJL, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
            .addComponent(page)
            .addGap(11, 11, 11))
          .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(internalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
          .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    internalLayout.setVerticalGroup(
      internalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(internalLayout.createSequentialGroup()
        .addGroup(internalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(internalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(rutaJL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(page, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(internalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(internalLayout.createSequentialGroup()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );

    internal.setBounds(0, 0, 820, 410);
    desktop.add(internal, javax.swing.JLayeredPane.DEFAULT_LAYER);

    javax.swing.GroupLayout panelInicialLayout = new javax.swing.GroupLayout(panelInicial);
    panelInicial.setLayout(panelInicialLayout);
    panelInicialLayout.setHorizontalGroup(
      panelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(desktop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
    );
    panelInicialLayout.setVerticalGroup(
      panelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(desktop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
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
    // TODO add your handling code here:
    setFinalizar();
  }//GEN-LAST:event_terminarActionPerformed

  private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
    // TODO add your handling code here:
    setBackImage();
  }//GEN-LAST:event_anteriorActionPerformed

  private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
    // TODO add your handling code here:
    setNextImage();
  }//GEN-LAST:event_siguienteActionPerformed
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
  private javax.swing.JButton anterior;
  private javax.swing.JDesktopPane desktop;
  private javax.swing.JInternalFrame internal;
  private javax.swing.JComboBox jComboBox1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JLabel page;
  private javax.swing.JPanel panelInicial;
  private javax.swing.JLabel rutaJL;
  private javax.swing.JScrollPane scrollImage;
  private javax.swing.JButton siguiente;
  private javax.swing.JTable tabla;
  private javax.swing.JButton terminar;
  // End of variables declaration//GEN-END:variables

  private void iniciar(TrazaDao traza) {
    traza.getListaTif();

  }

  private boolean isImagenTif(boolean pdf, String extension) {
    if (!pdf && extension.equalsIgnoreCase(".tif")) {
      return true;
    }
    return false;
  }

  private void internal(boolean pdf) {
    try {
      internal.setMaximum(true);
      anterior.setEnabled(false);
      Imagen siguientes = goImagen(contador);//trae el ramdom
      setTituloYRutaLabel(siguientes);
      String ruta = rutadeimagen.siguienteImagen(pdf, siguientes);
      setLabelPagina(pdf, siguientes);
      imageDraw.cargarImage(ruta, pdf, tif, jComboBox1);
      scrollImage.getViewport().add(imageDraw);
      setCB.set(siguientes.getId());
    } catch (PropertyVetoException ex) {
      Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private Imagen goImagen(int contador) {
    int limiteSuperior = getSizeRamdom() - 1;
    Imagen imagen = traza.getListaTif().get(contador);
    if (contador == limiteSuperior) {
      siguiente.setEnabled(false);
      terminar.setEnabled(true);
    }
    return imagen;
  }

  private Imagen backImagen(int contador) {
    int limiteInferior = 0;
    Imagen imagen = traza.getListaTif().get(contador);
    if (limiteInferior == contador) {
      anterior.setEnabled(false);
    }
    return imagen;
  }

  private void setTituloYRutaLabel(Imagen siguientes) {
    internal.setTitle("Imagen " + cantidad + "/" + getSizeRamdom());
    rutaJL.setText(siguientes.getRutaInsertadaEnDB());
  }

  private void setLabelPagina(boolean pdf, Imagen siguientes) {
    if (pdf) {
      int page1 = siguientes.getPagina() + 1;
      page.setText("Pagina: " + page1);
    } else {
      page.setVisible(false);
    }
  }

  private void guardarYLimpiar(JLabel rutaJlabel, JTable tablaCheck, JLabel pagina, boolean pdf) {
    save.guardar(traza, rutaJlabel.getText(), tablaCheck, pagina, pdf);
    internal.dispose();
    desktop.removeAll();
    desktop.repaint();
  }

  private void setNextImage() {
    contador++;
    cantidad++;
    anterior.setEnabled(true);
    guardarYLimpiar(rutaJL, tabla, page, pdf);
    Imagen imagen1 = goImagen(contador);
    try {
      desktop.add(internal);
      setTituloYRutaLabel(imagen1);
      setLabelPagina(pdf, imagen1);
      setCB.set(imagen1.getId());
      String ruta_temp = rutadeimagen.siguienteImagen(pdf, imagen1);
      imageDraw.cargarImage(ruta_temp, pdf, tif, jComboBox1);
      scrollImage.getViewport().add(imageDraw);
      internal.setVisible(true);
    } catch (Exception ex) {
      Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void setBackImage() {
    contador--;
    cantidad--;
    Imagen pr = backImagen(contador);
    guardarYLimpiar(rutaJL, tabla, page, pdf);
    siguiente.setEnabled(true);
    desktop.add(internal);
    internal.setVisible(true);
    setTituloYRutaLabel(pr);
    setLabelPagina(pdf, pr);
    setCB.set(pr.getId());
    String visualizacion = rutadeimagen.anteriorImagen(pdf, pr);
    imageDraw.cargarImage(visualizacion, pdf, tif, jComboBox1);
    scrollImage.getViewport().add(imageDraw);
  }

  private void setFinalizar() {
    save.guardar(traza, rutaJL.getText(), tabla, page, pdf);
    NumeroRechazo numeroRechazo = new NumeroRechazo(traza.getId());
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Reporte(traza.getId()).setVisible(true);
      }
    });
    dispose();
  }

  private int getSizeRamdom() {
    return traza.getListaTif().size();
  }
}
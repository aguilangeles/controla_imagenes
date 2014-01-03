/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PaneldeControl;

import Entidades.TiposDeControl;
import VentanaPrincipal.ListaControlesActivos;
import Helpers.InputVerifier;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import BasedeDatos.Conexion;
import Helpers.MensajeJoptionPane;
import Helpers.VersionEImageIcon;

/**
 *
 * @author MUTNPROD003
 */
public class VerificacionAlta extends javax.swing.JFrame {

  private Conexion conexion;
  private DefaultListModel modeloOrigen = new DefaultListModel();
  private DefaultListModel modeloDestino = new DefaultListModel();
  private DefaultTableModel abmModel;
  private JTable tabla;
  private List<Object> idTipoControl = new ArrayList<>();

  /**
   * Creates new form VerificacionAlta
   *
   * @param conexion
   * @param abmModel
   * @param tabla
   */
  public VerificacionAlta(Conexion conexion, DefaultTableModel abmModel, JTable tabla) {
    initComponents();
//    String rutaImagen = "Logos/nuevo logo sin letras UTN.png";
//    ImageIcon im = new ImageIcon(rutaImagen);
//    setIconImage(im.getImage());
    VersionEImageIcon vic = new VersionEImageIcon(this, "Alta Nueva Verificaci�n. ");
    vic.newColorFromPanel(jPanel1);
    nombreQs.setInputVerifier((new InputVerifier().inputVerifierT()));
    descripcionQs.setInputVerifier((new InputVerifier().inputVerifierT()));
    mensajeL.setText("<html>Seleccione un TdC y presione Agregar. "
            + "Para remover un elemento, seleccione desde el destino y presione Remover.</html>");
    this.conexion = conexion;
    this.abmModel = abmModel;
    this.tabla = tabla;
    origen.setModel(modeloOrigen);
    destino.setModel(modeloDestino);
    poblarLista();
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
    jLabel2 = new javax.swing.JLabel();
    nombreQs = new javax.swing.JTextField();
    mensajeL = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    origen = new javax.swing.JList();
    agregar = new javax.swing.JButton();
    remover = new javax.swing.JButton();
    aceptarSeleccion = new javax.swing.JButton();
    jScrollPane3 = new javax.swing.JScrollPane();
    destino = new javax.swing.JList();
    jLabel4 = new javax.swing.JLabel();
    descripcionQs = new javax.swing.JTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Creacion de Tipos de Verificacion");
    setResizable(false);

    jPanel1.setNextFocusableComponent(nombreQs);

    jLabel2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel2.setText("Nombre de Verificaci�n:");

    nombreQs.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    nombreQs.setToolTipText("");
    nombreQs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    nombreQs.setNextFocusableComponent(descripcionQs);

    mensajeL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    mensajeL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

    origen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    origen.setModel(new javax.swing.AbstractListModel() {
      String[] strings = { "Im�genes torcidas", "Im�genes con bordes Negros", "Im�genes en blanco", "Im�genes con mal contraste", "Im�genes mal rotadas", "Im�genes de alimentaci�n m�ltiple", "Im�genes con esquinas dobladas" };
      public int getSize() { return strings.length; }
      public Object getElementAt(int i) { return strings[i]; }
    });
    jScrollPane1.setViewportView(origen);

    agregar.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    agregar.setText("Agregar");
    agregar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        agregarActionPerformed(evt);
      }
    });

    remover.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    remover.setText("Remover");
    remover.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        removerActionPerformed(evt);
      }
    });

    aceptarSeleccion.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    aceptarSeleccion.setText("Finalizar");
    aceptarSeleccion.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        aceptarSeleccionActionPerformed(evt);
      }
    });

    destino.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jScrollPane3.setViewportView(destino);

    jLabel4.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel4.setText("Descripci�n:");

    descripcionQs.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    descripcionQs.setNextFocusableComponent(origen);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap(13, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(remover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(aceptarSeleccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(48, 48, 48)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(nombreQs, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
              .addComponent(descripcionQs))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addGap(22, 22, 22))
      .addComponent(mensajeL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(24, 24, 24)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(nombreQs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(descripcionQs, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
          .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(mensajeL, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(21, 21, 21)
            .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(30, 30, 30)
            .addComponent(remover, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(32, 32, 32)
            .addComponent(aceptarSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(22, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void aceptarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarSeleccionActionPerformed
      if (nombreQs.getText().equals("")) {
        JOptionPane.showMessageDialog(nombreQs, "Debe escribir un nombre", "Sin Nombre", JOptionPane.ERROR_MESSAGE);

      } else if (descripcionQs.getText().equals("")) {
        JOptionPane.showMessageDialog(descripcionQs, "Debe escribir una descripcion", "Sin Descripcion", JOptionPane.ERROR_MESSAGE);

      } else {
        if (modeloDestino.getSize() == 0) {
          JOptionPane.showMessageDialog(origen, "Debe seleccionar por lo menos un tipo de control", "Sin controles asignados al Qs", JOptionPane.ERROR_MESSAGE);
        } else if (modeloDestino.getSize() != 0) {
          List<Integer> id = new ArrayList<>();
          Verificacion_AltaNuevaVerificacion alta = new Verificacion_AltaNuevaVerificacion(nombreQs.getText(), descripcionQs.getText(), getIdTipoControl(), conexion, abmModel, tabla);
          if (alta.inserTipos_verificacion() && alta.insertarTipos_Control()) {
            alta.insertarModelo();
            dispose();
          } else {
            JOptionPane.showMessageDialog(aceptarSeleccion, "La Verificaci�n no pudo ser insertada", "Fall� Insert", JOptionPane.ERROR_MESSAGE);

          }
        }
      }
    }//GEN-LAST:event_aceptarSeleccionActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
      try {
        int index = origen.getSelectedIndex();
        Object o = origen.getSelectedValue();
        modeloDestino.addElement(o);
        modeloOrigen.remove(index);
        idTipoControl.add(o);
      } catch (ArrayIndexOutOfBoundsException e) {
        MensajeJoptionPane msg = new MensajeJoptionPane(this, JOptionPane.ERROR_MESSAGE);
        msg.getMessage("Debe seleccionar por lo menos un tipo de control", VerificacionAlta.class.getName());
      }
    }//GEN-LAST:event_agregarActionPerformed

    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
      if (destino.getModel().getSize() == 0) {
        JOptionPane.showMessageDialog(destino, "No hay elementos que remover", "Tabla receptora vacia", JOptionPane.ERROR_MESSAGE);
      } else {
        int index = destino.getSelectedIndex();
        Object o = destino.getSelectedValue();
        modeloOrigen.addElement(o);
        modeloDestino.remove(index);
        idTipoControl.remove(o);
      }
    }//GEN-LAST:event_removerActionPerformed

  private void poblarLista() {
    ListaControlesActivos lista = new ListaControlesActivos(conexion);
    List<TiposDeControl> tipos = lista.getLista();
    for (int i = 0; i < tipos.size(); i++) {
      modeloOrigen.addElement(tipos.get(i));
    }
  }

  public List<Object> getIdTipoControl() {
    return idTipoControl;
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
//            java.util.logging.Logger.getLogger(VerificacionAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VerificacionAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VerificacionAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VerificacionAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VerificacionAlta().setVisible(true);
//            }
//        });
//    }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton aceptarSeleccion;
  private javax.swing.JButton agregar;
  private javax.swing.JTextField descripcionQs;
  private javax.swing.JList destino;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JLabel mensajeL;
  private javax.swing.JTextField nombreQs;
  private javax.swing.JList origen;
  private javax.swing.JButton remover;
  // End of variables declaration//GEN-END:variables
}

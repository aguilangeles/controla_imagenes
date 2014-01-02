/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PaneldeControl;

import javax.swing.table.DefaultTableModel;
import BasedeDatos.Conexion;
import Helpers.VersionEImageIcon;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author MUTNPROD003
 */
public class VerificacionABM extends javax.swing.JFrame {

  private String evento;
  private Conexion conexion = new Conexion();
  private VerificacionDao verificacion;
  private DefaultTableModel modelo;
  private int ide;

  /**
   * Creates new form ABMRangos
   */
  public VerificacionABM() {
    initComponents();
    VersionEImageIcon vic = new VersionEImageIcon(this, "Alta y Baja de Verificación.");
    vic.newColorFromPanel(jPanel1);
    principalInternal.setBackground(vic.getColor());
    verificacion = new VerificacionDao(tablaV, conexion);
    principalInternal.setVisible(true);
    modelo = (DefaultTableModel) tablaV.getModel();
    agregar.setVisible(false);
    desactivar.setVisible(false);
    try
      {
      principalInternal.setMaximum(true);
      } catch (PropertyVetoException ex)
      {
      Logger.getLogger(VerificacionABM.class.getName()).log(Level.SEVERE, null, ex);
      }

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
    jPanel2 = new javax.swing.JPanel();
    ABM = new javax.swing.JButton();
    cerrar = new javax.swing.JButton();
    mensajeLabel = new javax.swing.JLabel();
    scroll = new javax.swing.JScrollPane();
    desk = new javax.swing.JDesktopPane();
    principalInternal = new javax.swing.JInternalFrame();
    desactivar = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    tablaV = new javax.swing.JTable();
    agregar = new javax.swing.JButton();
    jSeparator1 = new javax.swing.JSeparator();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Alta y Baja de Verificacion");
    setResizable(false);

    jPanel2.setBackground(new java.awt.Color(230, 252, 238));
    jPanel2.setOpaque(false);

    ABM.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    ABM.setText("Activar ABM");
    ABM.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ABMActionPerformed(evt);
      }
    });
    ABM.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        ABMKeyPressed(evt);
      }
    });

    cerrar.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    cerrar.setMnemonic('c');
    cerrar.setText("cerrar");
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

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(ABM, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
          .addComponent(cerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(20, 20, 20)
        .addComponent(mensajeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(33, 33, 33)
        .addComponent(ABM, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(mensajeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
        .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    principalInternal.setTitle("Para Editar los contenidos presione Activar ABM");
    principalInternal.setVisible(true);

    desactivar.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    desactivar.setText("Cambiar Estado");
    desactivar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        desactivarActionPerformed(evt);
      }
    });

    tablaV.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "id", "nombre", "descripcion", "controles", "Es"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(tablaV);

    agregar.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    agregar.setText("Agregar ");
    agregar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        agregarActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout principalInternalLayout = new javax.swing.GroupLayout(principalInternal.getContentPane());
    principalInternal.getContentPane().setLayout(principalInternalLayout);
    principalInternalLayout.setHorizontalGroup(
      principalInternalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jSeparator1)
      .addGroup(principalInternalLayout.createSequentialGroup()
        .addGap(23, 23, 23)
        .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(desactivar)
        .addGap(35, 35, 35))
      .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
    );
    principalInternalLayout.setVerticalGroup(
      principalInternalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(principalInternalLayout.createSequentialGroup()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(principalInternalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(agregar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
          .addComponent(desactivar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(20, 20, 20))
    );

    principalInternal.setBounds(0, 0, 550, 410);
    desk.add(principalInternal, javax.swing.JLayeredPane.DEFAULT_LAYER);

    scroll.setViewportView(desk);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(4, 4, 4)
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(scroll)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 1, Short.MAX_VALUE)))
        .addContainerGap())
    );

    getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
      java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
          new VerificacionAlta(conexion, modelo, tablaV).setVisible(true);
        }
      });

    }//GEN-LAST:event_agregarActionPerformed

    private void desactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desactivarActionPerformed
      getDesactivarBoton();

    }//GEN-LAST:event_desactivarActionPerformed

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
      dispose();
    }//GEN-LAST:event_cerrarActionPerformed

    private void ABMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ABMActionPerformed
      getABM();

    }//GEN-LAST:event_ABMActionPerformed

  private void ABMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ABMKeyPressed
    getABM();
  }//GEN-LAST:event_ABMKeyPressed

  private void cerrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cerrarKeyPressed
    dispose();
  }//GEN-LAST:event_cerrarKeyPressed
//
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
//            java.util.logging.Logger.getLogger(VerificacionABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VerificacionABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VerificacionABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VerificacionABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VerificacionABM().setVisible(true);
//            }
//        });
//    }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton ABM;
  private javax.swing.JButton agregar;
  private javax.swing.JButton cerrar;
  private javax.swing.JButton desactivar;
  private javax.swing.JDesktopPane desk;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JLabel mensajeLabel;
  private javax.swing.JInternalFrame principalInternal;
  private javax.swing.JScrollPane scroll;
  private javax.swing.JTable tablaV;
  // End of variables declaration//GEN-END:variables

  private void getABM() {
    principalInternal.setTitle("Módulo de Edición");
    ABM.setEnabled(false);
    agregar.setVisible(true);
    desactivar.setVisible(true);
  }

  private void getDesactivarBoton() {
    DesactivarBoton desactivarBoton = new DesactivarBoton(tablaV, conexion, modelo, "Tipos_verificacion", 4, mensajeLabel);
  }
}

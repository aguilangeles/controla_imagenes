/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelesABM;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Entidades.Conexion;
import static PanelesABM.ControlesABM.ROW_EMPTY;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTable;

/**
 *
 * @author MUTNPROD003
 */
public class UsuariosABM extends javax.swing.JFrame {

  private Conexion conexion = new Conexion();
  private DefaultTableModel modelo;
  private UsuariosDao usuario;
  private int ide;
  private String evento;

  /**
   * Creates new form ABMRangos
   */
  public UsuariosABM() {
    initComponents();
    String rutaImagen = "Logos/nuevo logo sin letras UTN.png";
    ImageIcon im = new ImageIcon(rutaImagen);
    setIconImage(im.getImage());
    setTitle("Alta, Baja y Modificacion de Usuarios");
    setResizable(false);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    usuario = new UsuariosDao(tablaUsuarios, conexion);
    principalInternal.setVisible(true);
    modelo = (DefaultTableModel) tablaUsuarios.getModel();
    salvar.setVisible(false);
    agregar.setVisible(false);
    editar.setVisible(false);
    desactivar.setVisible(false);
    try {
      principalInternal.setMaximum(true);
    } catch (PropertyVetoException ex) {
      Logger.getLogger(UsuariosABM.class.getName()).log(Level.SEVERE, null, ex);
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
    cerrar = new javax.swing.JButton();
    ABM = new javax.swing.JButton();
    mensajeLabel = new javax.swing.JLabel();
    scroll = new javax.swing.JScrollPane();
    desk = new javax.swing.JDesktopPane();
    principalInternal = new javax.swing.JInternalFrame();
    editar = new javax.swing.JButton();
    desactivar = new javax.swing.JButton();
    salvar = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    tablaUsuarios = new javax.swing.JTable();
    agregar = new javax.swing.JButton();
    jSeparator1 = new javax.swing.JSeparator();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBackground(new java.awt.Color(230, 252, 238));

    jPanel2.setOpaque(false);

    cerrar.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    cerrar.setText("cerrar");
    cerrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cerrarActionPerformed(evt);
      }
    });

    ABM.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    ABM.setText("Activar ABM");
    ABM.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ABMActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        .addGap(13, 13, 13)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(mensajeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(cerrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(ABM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(29, 29, 29)
        .addComponent(ABM, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(mensajeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(29, 29, 29))
    );

    principalInternal.setBackground(new java.awt.Color(230, 252, 238));
    principalInternal.setTitle("Para Editar los contenidos presione Activar ABM");
    principalInternal.setVisible(true);

    editar.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    editar.setText("Editar ");
    editar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        editarActionPerformed(evt);
      }
    });

    desactivar.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    desactivar.setText("Cambiar Estado");
    desactivar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        desactivarActionPerformed(evt);
      }
    });

    salvar.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    salvar.setText("Guardar ");
    salvar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        salvarActionPerformed(evt);
      }
    });

    tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "id", "nombre", "password", "tipo", "activo"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
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
    tablaUsuarios.setColumnSelectionAllowed(true);
    jScrollPane1.setViewportView(tablaUsuarios);
    tablaUsuarios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

    agregar.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    agregar.setText("Agregar");
    agregar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        agregarActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout principalInternalLayout = new javax.swing.GroupLayout(principalInternal.getContentPane());
    principalInternal.getContentPane().setLayout(principalInternalLayout);
    principalInternalLayout.setHorizontalGroup(
      principalInternalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(principalInternalLayout.createSequentialGroup()
        .addGap(22, 22, 22)
        .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(55, 55, 55)
        .addComponent(desactivar)
        .addGap(22, 22, 22))
      .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
      .addComponent(jSeparator1)
      .addGroup(principalInternalLayout.createSequentialGroup()
        .addGap(117, 117, 117)
        .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    principalInternalLayout.setVerticalGroup(
      principalInternalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(principalInternalLayout.createSequentialGroup()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(2, 2, 2)
        .addGroup(principalInternalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(agregar)
          .addComponent(editar)
          .addComponent(desactivar))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(salvar)
        .addContainerGap(16, Short.MAX_VALUE))
    );

    principalInternal.setBounds(0, 0, 530, 340);
    desk.add(principalInternal, javax.swing.JLayeredPane.DEFAULT_LAYER);

    scroll.setViewportView(desk);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
      usuario.setEditable(true);
      int idNew = getIde() + 1;
      Object[] ob = new Object[]{idNew,"ingrese nombre", "ingrese pasww",1,1};
      modelo.addRow(ob);
      tablaUsuarios.repaint();
      salvar.setVisible(true);
      evento = "Agregar";
    }//GEN-LAST:event_agregarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
      usuario.setEditable(true);
      salvar.setVisible(true);
      evento = "Editar";
    }//GEN-LAST:event_editarActionPerformed

    private void desactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desactivarActionPerformed
      usuario.setEditable(true);
      int idjtext = (tablaUsuarios.getSelectedRow());
      Desactivar desactivar1 = new Desactivar(conexion, modelo, "usuarios", idjtext, 4);
      if(desactivar1.modificarEstado()){
        mensajeLabel.setText("<html>Usuario<br>Modificado</html>");
      tablaUsuarios.repaint();
      }

    }//GEN-LAST:event_desactivarActionPerformed

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
      dispose();
    }//GEN-LAST:event_cerrarActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
      botonGuardar();
    }//GEN-LAST:event_salvarActionPerformed
  private void botonGuardar() {
    switch (evento) {
      case "Agregar":
        boolean insertad;
        try {
        tablaUsuarios.editCellAt(-1, -1);
          if (isRowEmpty(tablaUsuarios, getIde())) {
            insertad = usuario.getInsertar().insert_newUsuario(getIde());
            mensajeUpdate(insertad, "Usuario");
          }
        } catch (RuntimeException e) {
           mensajeLabel.setText("<html>usuario<br>Rechazado</html>");
          JOptionPane.showMessageDialog(null, e.getMessage(), "Rango vacia", JOptionPane.ERROR_MESSAGE);
        }
        break;
      case "Editar":
        boolean update;
        int row = tablaUsuarios.getSelectedRow();
        tablaUsuarios.editCellAt(-1, -1);
        int idjtext = (row);

        tablaUsuarios.repaint();
        try {
          if(isRowEmpty(tablaUsuarios, idjtext)){
            update=
        usuario.getEditar().usuarios_setRow(idjtext);
            mensajeUpdate(update, "Usuario");

          }
        } catch (RuntimeException e) {
          mensajeLabel.setText("<html>Usuario<br>Rechazado</html>");
          JOptionPane.showMessageDialog(null, e.getMessage(), "Edit  Usuario", JOptionPane.ERROR_MESSAGE);
        }
        break;
    }
  }
    private void ABMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ABMActionPerformed
      JOptionPane.showMessageDialog(tablaUsuarios, MensajeABM.INSTRUCCIONES);
      ABM.setEnabled(false);
      principalInternal.setTitle("M�dulo de Edici�n");
      agregar.setVisible(true);
      editar.setVisible(true);
      desactivar.setVisible(true);
    }//GEN-LAST:event_ABMActionPerformed

  public int getIde() {
    return usuario.getLastId();
  }

  public void setIde(int ide) {
    this.ide = ide;
  }

  private boolean isRowEmpty(JTable tablaContenido, int id) {
    boolean ret = true;
    for (int i = 0; i < tablaContenido.getColumnCount(); i++) {
      Object inspect = tablaContenido.getValueAt(id, i);
      if (inspect == null || inspect.equals("")) {
        ret = false;
        throw new RuntimeException(ROW_EMPTY);
      }
    }
    return ret;
  }

  private void mensajeUpdate(boolean insertado, String mensajeJl) {
    if (insertado) {
      mensajeLabel.setText("<html>" + mensajeJl + "<br>Aceptado</html>");
      tablaUsuarios.repaint();
      salvar.setVisible(false);
    } else {
      mensajeLabel.setText("<html>" + mensajeJl + "<br>Rechazado</html>");
      salvar.setVisible(true);
    }
  }
  /**
   * @param args the command line arguments
   */
//    public static void main(String args[]) {
////        /* Set the Nimbus look and feel */
////        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
////        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
////         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
////         */
////        try {
////            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
////                if ("Nimbus".equals(info.getName())) {
////                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
////                    break;
////                }
////            }
////        } catch (ClassNotFoundException ex) {
////            java.util.logging.Logger.getLogger(ABMRangos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (InstantiationException ex) {
////            java.util.logging.Logger.getLogger(ABMRangos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (IllegalAccessException ex) {
////            java.util.logging.Logger.getLogger(ABMRangos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
////            java.util.logging.Logger.getLogger(ABMRangos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        }
////        //</editor-fold>
////
////        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new UsuariosABM().setVisible(true);
//            }
//        });
//   }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton ABM;
  private javax.swing.JButton agregar;
  private javax.swing.JButton cerrar;
  private javax.swing.JButton desactivar;
  private javax.swing.JDesktopPane desk;
  private javax.swing.JButton editar;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JLabel mensajeLabel;
  private javax.swing.JInternalFrame principalInternal;
  private javax.swing.JButton salvar;
  private javax.swing.JScrollPane scroll;
  private javax.swing.JTable tablaUsuarios;
  // End of variables declaration//GEN-END:variables
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PaneldeControl;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import database.Conexion;
import helper.MensajeJoptionPane;
import helper.Minimo;
import helper.VersionEImageIcon;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import javax.swing.JTable;

/**
 *
 * @author MUTNPROD003
 */
public class RangosABM extends javax.swing.JFrame {

  private String classname = RangosABM.class.getName();
  private MensajeJoptionPane msg;
  public static final String ROW_EMPTY = "No pueden quedar filas vac�as";
  private Conexion conexion = new Conexion();
  private final RangosDao rangosDao;
  private DefaultTableModel modelo;
  private int ide;
  private String evento;
  private helper.Minimo minimo = new Minimo();

  /**
   * Creates new form RangosABM
   */
  public RangosABM() {
    initComponents();
    VersionEImageIcon versionEImageIcon = new VersionEImageIcon(this, "Alta, Baja y Modificaci�n Rangos");
    versionEImageIcon.newColorFromPanel(jPanel1);
    principalInternal.setBackground(versionEImageIcon.getColor());
    setResizable(true);
    rangosDao = new RangosDao(conexion, tablaContenido);
    principalInternal.setVisible(true);
    modelo = (DefaultTableModel) tablaContenido.getModel();
    salvar.setVisible(false);
    agregar.setVisible(false);
    editar.setVisible(false);
    desactivar.setVisible(false);
    try
      {
      principalInternal.setMaximum(true);
      } catch (PropertyVetoException ex)
      {
      msg = new MensajeJoptionPane(this, JOptionPane.ERROR_MESSAGE);
      msg.getMessage(ex.getMessage(), classname);
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
    tablaContenido = new javax.swing.JTable();
    agregar = new javax.swing.JButton();
    jSeparator1 = new javax.swing.JSeparator();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Alta, Baja y Modificacion de Rangos");
    setResizable(false);

    jPanel2.setOpaque(false);

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

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(mensajeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(ABM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(4, 4, 4))))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(30, 30, 30)
        .addComponent(ABM, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(mensajeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
        .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(29, 29, 29))
    );

    principalInternal.setTitle("Para Editar los contenidos presione Activar ABM");
    principalInternal.setVisible(true);

    editar.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    editar.setText("Editar");
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
    salvar.setText("Guardar");
    salvar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        salvarActionPerformed(evt);
      }
    });

    tablaContenido.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "id", "m�mino", "maximo", "muestra", "rechazo", "estado"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false, false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(tablaContenido);

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
      .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
      .addComponent(jScrollPane1)
      .addGroup(principalInternalLayout.createSequentialGroup()
        .addGroup(principalInternalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(principalInternalLayout.createSequentialGroup()
            .addGap(22, 22, 22)
            .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(31, 31, 31)
            .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(desactivar))
          .addGroup(principalInternalLayout.createSequentialGroup()
            .addGap(108, 108, 108)
            .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(11, Short.MAX_VALUE))
    );
    principalInternalLayout.setVerticalGroup(
      principalInternalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(principalInternalLayout.createSequentialGroup()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(principalInternalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(agregar)
          .addComponent(editar)
          .addComponent(desactivar))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(salvar)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    principalInternal.setBounds(10, 10, 480, 350);
    desk.add(principalInternal, javax.swing.JLayeredPane.DEFAULT_LAYER);

    scroll.setViewportView(desk);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(6, 6, 6)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGap(49, 49, 49))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
      getAgregar();
    }//GEN-LAST:event_agregarActionPerformed
    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
      getEditar();
    }//GEN-LAST:event_editarActionPerformed

    private void desactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desactivarActionPerformed
      getDesactivar();
    }//GEN-LAST:event_desactivarActionPerformed

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
      dispose();
    }//GEN-LAST:event_cerrarActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
      botonGuardar();
    }//GEN-LAST:event_salvarActionPerformed

    private void ABMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ABMActionPerformed
      activarABM();
    }//GEN-LAST:event_ABMActionPerformed

  private void ABMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ABMKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER)
      {
      activarABM();
      }
  }//GEN-LAST:event_ABMKeyPressed

  private void cerrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cerrarKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER)
      {
      dispose();
      }
  }//GEN-LAST:event_cerrarKeyPressed
  private void botonGuardar() {
    switch (evento)
      {
      case "Agregar":
        boolean insertado;
        tablaContenido.editCellAt(-1, -1);
        try
          {
          if (isRowEmpty(tablaContenido, getIde()))
            {
            insertado = rangosDao.getInsertar().nuevoRango(getIde());
            mensajeUpdate(insertado, "Rango");
            }
          } catch (RuntimeException e)
          {
          mensajeLabel.setText("<html>Rango<br>Rechazado</html>");
          msg.getMessage(e.getMessage(), classname);
          }
        break;
      case "Editar":
        boolean update;
        tablaContenido.editCellAt(-1, -1);
        int row = tablaContenido.getSelectedRow();
        int idjtext = (row);
        try
          {
          if (isRowEmpty(tablaContenido, idjtext))
            {
            update = rangosDao.getEditar().rangos_SetRow(idjtext);
            mensajeUpdate(update, "Rango");
            }
          } catch (RuntimeException e)
          {
          mensajeLabel.setText("<html>Rango<br>Rechazado</html>");
          msg.getMessage(e.getMessage(), classname);
          }
        break;
      }
  }

  public int getIde() {
    return rangosDao.getLastId();
  }

  public void setIde(int ide) {
    this.ide = ide;
  }

  private boolean isRowEmpty(JTable tablaContenido, int id) {
    boolean ret = true;
    for (int i = 0; i < tablaContenido.getColumnCount(); i++)
      {
      Object inspect = tablaContenido.getValueAt(id, i);
      if (inspect == null || inspect.equals(""))
        {
        ret = false;
        throw new RuntimeException(ROW_EMPTY);
        }
      }
    return ret;
  }

  private void mensajeUpdate(boolean insertado, String mensajeJl) {
    if (insertado)
      {
      mensajeLabel.setText("<html>" + mensajeJl + "<br>Aceptado</html>");
      tablaContenido.repaint();
      salvar.setVisible(false);
      } else
      {
      mensajeLabel.setText("<html>" + mensajeJl + "<br>Rechazado</html>");
      salvar.setVisible(true);
      }
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
//            java.util.logging.Logger.getLogger(RangosABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(RangosABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(RangosABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(RangosABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RangosABM().setVisible(true);
//            }
//        });
//    }
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
  private javax.swing.JTable tablaContenido;
  // End of variables declaration//GEN-END:variables

  private void getAgregar() {
    rangosDao.setEditable(true);
    int idNew = getIde() + 1;
    int nuevoMin = (minimo.minimoMasUno(getIde()));
    Object[] ob = new Object[]
      {
      idNew, nuevoMin, 0, 0, 0, 1
      };
    new AgregarBoton(modelo, tablaContenido, salvar, ob);
    evento = "Agregar";
  }

  private void getEditar() {
    rangosDao.setEditable(true);
    salvar.setVisible(true);
    evento = "Editar";
  }

  private void getDesactivar() {
    rangosDao.setEditable(true);
    DesactivarBoton desactivarBoton =
            new DesactivarBoton(tablaContenido, conexion, modelo,
            "rangos_qs", 5, mensajeLabel);
  }

  private void activarABM() {
    AltaBajaYModificacionBoton altaBajaYModificacionBoton =
            new AltaBajaYModificacionBoton(tablaContenido, ABM, agregar, editar, desactivar, principalInternal);
  }
}

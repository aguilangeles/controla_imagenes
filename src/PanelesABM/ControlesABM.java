/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelesABM;

import java.awt.Rectangle;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Entidades.Conexion;
import Helpers.VersionEImageIcon;
import java.awt.HeadlessException;
import java.beans.PropertyVetoException;
import javax.swing.JTable;

/**
 *
 * @author MUTNPROD003
 */
public class ControlesABM extends javax.swing.JFrame {

  public static final String ROW_EMPTY = "No deben quedar filas vac�as";
  private String evento;
  private ControlesDao controles;
  private Conexion conexion = new Conexion();
  private DefaultTableModel modelo;
  private int ide;
  private boolean apto;

  /**
   * Creates new form ControlesABM
   */
  public ControlesABM() {
    initComponents();
    new VersionEImageIcon().setImagenIcon(this);
    controles = new ControlesDao(tablaContenido, conexion);
    principalInternal.setVisible(true);
    modelo = (DefaultTableModel) tablaContenido.getModel();
    salvar.setVisible(false);
    agregar.setVisible(false);
    editar.setVisible(false);
    desactivar.setVisible(false);
    try {
      principalInternal.setMaximum(true);
    } catch (PropertyVetoException ex) {
      JOptionPane.showMessageDialog(principalInternal, ex.getMessage(), "Error ajuste JInternalFrame", JOptionPane.ERROR_MESSAGE);
//      Logger.getLogger(ControlesABM.class.getName()).log(Level.SEVERE, null, ex);
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
    mensajLab = new javax.swing.JLabel();
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
    setTitle("Alta, Baja y Modificacion de Controles");
    setResizable(false);

    jPanel1.setBackground(new java.awt.Color(230, 252, 238));

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

    mensajLab.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    mensajLab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(ABM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(mensajLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(30, 30, 30)
        .addComponent(ABM, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(41, 41, 41)
        .addComponent(mensajLab, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(32, 32, 32))
    );

    principalInternal.setBackground(new java.awt.Color(230, 252, 238));
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
    salvar.setText("Guardar ");
    salvar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        salvarActionPerformed(evt);
      }
    });

    tablaContenido.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "id", "nombre", "descripcion", "imagen", "Est"
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
    jScrollPane1.setViewportView(tablaContenido);
    tablaContenido.getColumnModel().getColumn(0).setResizable(false);
    tablaContenido.getColumnModel().getColumn(1).setResizable(false);
    tablaContenido.getColumnModel().getColumn(2).setResizable(false);
    tablaContenido.getColumnModel().getColumn(3).setResizable(false);
    tablaContenido.getColumnModel().getColumn(4).setResizable(false);

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
        .addGap(34, 34, 34)
        .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(110, 110, 110)
        .addComponent(desactivar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(30, 30, 30))
      .addGroup(principalInternalLayout.createSequentialGroup()
        .addGroup(principalInternalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(principalInternalLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(principalInternalLayout.createSequentialGroup()
            .addGap(166, 166, 166)
            .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    principalInternalLayout.setVerticalGroup(
      principalInternalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(principalInternalLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(11, 11, 11)
        .addGroup(principalInternalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(agregar)
          .addComponent(editar)
          .addComponent(desactivar))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(salvar)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    principalInternal.setBounds(0, 0, 760, 490);
    desk.add(principalInternal, javax.swing.JLayeredPane.DEFAULT_LAYER);

    scroll.setViewportView(desk);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        .addGap(0, 0, 0))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(scroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
      .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
      getAgregarBoton();

    }//GEN-LAST:event_agregarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
      controles.setEditable(true);
      salvar.setVisible(true);
      evento = "Editar";

    }//GEN-LAST:event_editarActionPerformed

    private void desactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desactivarActionPerformed
      getDesactivarBoton();

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
        boolean insertado;
        tablaContenido.editCellAt(-1, -1);
        try {
          if (isRowEmpty(tablaContenido, getIde())) {
            insertado = controles.getInsertar().insert_newControl(getIde());
            mensajeUpdate(insertado, "Control");
          }
        } catch (RuntimeException e) {
          mensajLab.setText("<html>Control<br>Rechazado</html>");
          JOptionPane.showMessageDialog(null, e.getMessage());
        }
        break;
      case "Editar":
        boolean update;
        tablaContenido.editCellAt(-1, -1);
        int row = tablaContenido.getSelectedRow();
        int idjtext = (row);
        try {
          if (isRowEmpty(tablaContenido, idjtext)) {
            update = controles.getEditar().controles_SetRow(idjtext);
            mensajeUpdate(update, "Control");
          }
        } catch (RuntimeException e) {
          mensajLab.setText("<html>Control<br>Rechazado</html>");
          JOptionPane.showMessageDialog(null, e.getMessage());
        }
        break;
    }
  }

    private void ABMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ABMActionPerformed
      getABM();
    }//GEN-LAST:event_ABMActionPerformed

  private void ABMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ABMKeyPressed
    getABM();
  }//GEN-LAST:event_ABMKeyPressed

  private void cerrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cerrarKeyPressed
    dispose();
  }//GEN-LAST:event_cerrarKeyPressed

  public int getIde() {
    return controles.getLastId();
  }

  public void setIde(int ide) {
    this.ide = ide;
  }
  /**
   * @param args the command line arguments
   */
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
  private javax.swing.JLabel mensajLab;
  private javax.swing.JInternalFrame principalInternal;
  private javax.swing.JButton salvar;
  private javax.swing.JScrollPane scroll;
  private javax.swing.JTable tablaContenido;
  // End of variables declaration//GEN-END:variables

//
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
      mensajLab.setText("<html>" + mensajeJl + "<br>Aceptado</html>");
      tablaContenido.repaint();
      salvar.setVisible(false);
    } else {
      mensajLab.setText("<html>" + mensajeJl + "<br>Rechazado</html>");
      salvar.setVisible(true);
    }
  }

  private void getABM() {
    AltaBajaYModificacionBoton altaBajaYModificacionBoton =
            new AltaBajaYModificacionBoton(tablaContenido, ABM, agregar, editar, desactivar, principalInternal);

  }

  private void getDesactivarBoton() {
    controles.setEditable(true);
    DesactivarBoton desactivarBoton =
            new DesactivarBoton(tablaContenido, conexion, modelo, "controles", 4, mensajLab);
  }

  private void getAgregarBoton() {
    controles.setEditable(true);
    int idTable = getIde() + 1;
    Object[] ob = new Object[]{idTable, "Ingrese nombre", "Ingrese descripci�n", "ejemplo.jpg", 1};
    new AgregarBoton().addWithRectangle(ob, modelo, tablaContenido, salvar);
    evento = "Agregar";
  }
}

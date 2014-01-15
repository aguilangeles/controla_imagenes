/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Helpers.InputVerifier;
import BasedeDatos.Conexion;
import archivoConfiguracion.ReadProperties;
import entidad.LogQualitys;
import Helpers.VersionEImageIcon;

/**
 *
 * @author MUTNPROD003
 */
public class IngresoBaseDeDatos extends javax.swing.JFrame {

  private Conexion validar = new Conexion();

  /**
   * Creates new form IngresoBaseDeDatos
   *
   * @param isAdministrador
   */
  public IngresoBaseDeDatos(boolean isAdministrador) {
    initComponents();
    VersionEImageIcon versionEImageIcon = new VersionEImageIcon();
    versionEImageIcon.newColorFromPanel(panel);
    setResizable(false);
    setInputVerifier();
    aceptar.setText("Test");
    if (isAdministrador)
      {
      setInputVerifier();
      usuarioEditable();
      } else
      {
      usuarioNoEditable();
      }
  }

  public IngresoBaseDeDatos() {
    initComponents();
    VersionEImageIcon versionEImageIcon = new VersionEImageIcon();
    versionEImageIcon.newColorFromPanel(panel);
    setInputVerifier();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    panel = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    usuario = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    password = new javax.swing.JTextField();
    aceptar = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    database = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    url = new javax.swing.JTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Conexion");

    jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("USUARIO");

    usuario.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N

    jLabel2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel2.setText("PASSWORD");

    password.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N

    aceptar.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    aceptar.setMnemonic('t');
    aceptar.setText("Aceptar");
    aceptar.setToolTipText("alt+t");
    aceptar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        aceptarActionPerformed(evt);
      }
    });
    aceptar.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        aceptarKeyPressed(evt);
      }
    });

    jLabel3.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel3.setText("DATABASE");

    database.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N

    jLabel4.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel4.setText("URL");

    url.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N

    javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
    panel.setLayout(panelLayout);
    panelLayout.setHorizontalGroup(
      panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelLayout.createSequentialGroup()
        .addGap(29, 29, 29)
        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(password)
          .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(usuario)
          .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(database)
          .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(url))
        .addGap(28, 28, 28))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
        .addContainerGap(65, Short.MAX_VALUE)
        .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(63, 63, 63))
    );
    panelLayout.setVerticalGroup(
      panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(database, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(19, 19, 19)
        .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
      botonActionPerformed(evt);
    }//GEN-LAST:event_aceptarActionPerformed

  private void aceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aceptarKeyPressed
    botonKeyPressed(evt);
  }//GEN-LAST:event_aceptarKeyPressed

  private void botonActionPerformed(java.awt.event.ActionEvent evt) {
    if ("Aceptar".equals(evt.getActionCommand()))
      {
      TestBaseDeDatos usuarioAceptar = new TestBaseDeDatos(url, database, usuario, password, validar, aceptar, false, this);
      }
    if ("Test".equals(evt.getActionCommand()))
      {
      TestBaseDeDatos usuarioAceptar = new TestBaseDeDatos(url, database, usuario, password, validar, aceptar, true, this);
      }
  }

  private void botonKeyPressed(java.awt.event.KeyEvent evt) {
    if ("Aceptar".equals(aceptar.getText()))
      {
      TestBaseDeDatos usuarioAceptar = new TestBaseDeDatos(url, database, usuario, password, validar, aceptar, false, this);
      }
    if ("Test".equals(aceptar.getText()))
      {
      TestBaseDeDatos usuarioAceptar = new TestBaseDeDatos(url, database, usuario, password, validar, aceptar, true, this);
      }
  }

  private void usuarioNoEditable() {
    LogQualitys us = new ReadProperties().getUser();
    url.setText(us.getUrl());
    database.setText(us.getBase());
    usuario.setText(us.getUsuario());
    password.setText(us.getPassword());
    url.setEditable(false);
    database.setEditable(false);
    usuario.setEditable(false);
    password.setEditable(false);
  }

  private LogQualitys usuarioEditable() {
    LogQualitys usuarioEdit = new ReadProperties().getUser();
    url.setText(usuarioEdit.getUrl());
    database.setText(usuarioEdit.getBase());
    usuario.setText(usuarioEdit.getUsuario());
    password.setText(usuarioEdit.getPassword());
    return usuarioEdit;
  }

  private void setInputVerifier() {
    url.setInputVerifier(new InputVerifier().inputVerifierT());
    database.setInputVerifier(new InputVerifier().inputVerifierT());
    usuario.setInputVerifier(new InputVerifier().inputVerifierT());
    password.setInputVerifier(new InputVerifier().inputVerifierT());
  }
  /**
   * @param args the command line arguments
   */
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton aceptar;
  private javax.swing.JTextField database;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JPanel panel;
  private javax.swing.JTextField password;
  private javax.swing.JTextField url;
  private javax.swing.JTextField usuario;
  // End of variables declaration//GEN-END:variables
}

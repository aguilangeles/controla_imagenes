/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import PaneldeControl.PanelControl;
import ArchivoConfig.SetConfigFile;
import Helpers.InputVerifier;
import javax.swing.JOptionPane;
import Entidades.Usuario;
import BasedeDatos.GetUsuarioyCategoriaQs;
import Helpers.VersionEImageIcon;

/**
 *
 * @author MUTNPROD003
 */
public class Login extends javax.swing.JFrame {

  private static final String USER_DEFAULT = "default";
  private static final String USER_INVALID = "<html>El Usuario o password "
          + "no existe en la base de datos, o no es un usuario activo</html>";
  private static Usuario usuario;

  /**
   * Creates new form Login
   */
  public Login() {
    initComponents();
    VersionEImageIcon versionEImageIcon = new VersionEImageIcon(this, "Ingreso de Usuario");
    setResizable(false);
    user.requestFocusInWindow();
    user.setInputVerifier(new InputVerifier().inputVerifierT());
    password.setInputVerifier(new InputVerifier().inputVerifierT());
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
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    user = new javax.swing.JTextField();
    password = new javax.swing.JPasswordField();
    entrar = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Ingreso de Usuario");

    jPanel1.setBackground(new java.awt.Color(230, 252, 238));

    jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Usuario");

    jLabel2.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel2.setText("Password");

    user.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    user.setNextFocusableComponent(password);

    password.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N

    entrar.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 14)); // NOI18N
    entrar.setMnemonic('e');
    entrar.setText("Saludos");
    entrar.setToolTipText("alt + t");
    entrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        entrarActionPerformed(evt);
      }
    });
    entrar.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        entrarKeyPressed(evt);
      }
    });

    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageicon/unt100_1.png"))); // NOI18N

    jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageicon/test_100_1.png"))); // NOI18N

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
            .addComponent(jLabel4)
            .addGap(21, 21, 21))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))))))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(16, 16, 16)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 41, Short.MAX_VALUE)
        .addComponent(jLabel3)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addComponent(entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel4))))
        .addGap(14, 14, 14))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void entrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_entrarKeyPressed
    setEntrar();
  }//GEN-LAST:event_entrarKeyPressed

  private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
    setEntrar();
  }//GEN-LAST:event_entrarActionPerformed
  private void setEntrar() {
    /*Define si se setea el archivo o permite el ingreso del usuario*/
    if (user.getText().trim().equalsIgnoreCase(USER_DEFAULT)
            && password.getText().trim().equalsIgnoreCase(USER_DEFAULT))
      {
      SetConfigFile setConfigFile = new SetConfigFile();
      } else
      {
      loginUsuario();
      }
  }

  private void loginUsuario() {
    /*si el usuario es apto, setea la fecha de ingreso*/
    if (isUsuarioValidado())
      {
      SetFechaDeIngreso setfecha = new SetFechaDeIngreso(getUsuario());
      java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
          new PanelControl().setVisible(true);
        }
      });
      dispose();
      } else
      {
      JOptionPane.showMessageDialog(entrar, USER_INVALID, "Error en el ingreso de datos", JOptionPane.ERROR_MESSAGE);
      user.setText("");
      password.setText("");
      }
  }

  private boolean isUsuarioValidado() {
    /*Identifica si es un usuario y qu� categoria posee*/
    GetUsuarioyCategoriaQs userCat = new GetUsuarioyCategoriaQs(user.getText(), password.getText());
    if (userCat.isUsuario())
      {
      usuario = userCat.getUsuarioValidado();
      return true;
      }
    return false;
  }

  /**
   * @return
   */
  public static Usuario getUsuario() {
    return usuario;
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton entrar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPasswordField password;
  private javax.swing.JTextField user;
  // End of variables declaration//GEN-END:variables
}

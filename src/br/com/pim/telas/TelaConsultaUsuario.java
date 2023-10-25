/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.pim.telas;
import java.sql.*;
import br.com.pim.dal.ModuloConexao;
import javax.swing.JOptionPane;

public class TelaConsultaUsuario extends javax.swing.JInternalFrame {
//Componentes da Classe ModuloConexao.java.
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
//Construtor da Classe TelaConsultaUsuario  
    public TelaConsultaUsuario() {
        //Componentes da Classe ModuloConexao.java.
        initComponents();
        conexao = ModuloConexao.conector();     
    }
//Metodo ConsultarUsuarios da Classe TelaConsultaUsuario
//Realizando um 'SELECT' na tabela tb_usuario
    private void consultar(){
        String sql = "select * from tbusuarios where iduser=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1, txtUsuId.getText());
            rs=pst.executeQuery();
            if (rs.next()) {
                txtUsuNome.setText(rs.getString(2));
                txtUsuLogin.setText(rs.getString(3));
                txtPasswordd.setText(rs.getString(4));
                cboUsuPerfil.setSelectedItem(rs.getString(5));            
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado.");
                limpar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }        
    }  
//Metodo alterar da Classe TelaConsultaUsuario
//Realizando um 'UPDATE' na tabela tb_Usuario    
    private void alterar(){
         String sql ="update tbusuarios set usuario=?, login=?, senha=?,perfil=? where iduser=?";
         try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1, txtUsuNome.getText());
            pst.setString(2,txtUsuLogin.getText());
            pst.setString(3,txtPasswordd.getText());
            pst.setString(4,cboUsuPerfil.getSelectedItem().toString());
            pst.setString(5,txtUsuId.getText());
              if ((txtUsuNome.getText().isEmpty()) || (txtUsuLogin.getText().isEmpty()) || (txtPasswordd.getText().isEmpty())){
                JOptionPane.showMessageDialog(null,"Preencha Todos os Campos Obrigatório !!");
            } else {           
            int add = pst.executeUpdate();
            if (add >0) {
                JOptionPane.showMessageDialog(null, "Dados Alterado com Sucesso");
                limpar();
                }
            }
            pst.executeUpdate();
            limpar();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
    } 
//Metodo Auxiliar para Realizar a Limpeza dos Campos Preenchidos 
    private void limpar(){
        txtUsuId.setText(null);
        txtUsuNome.setText(null);
        txtUsuLogin.setText(null);
        txtPasswordd.setText(null);
        cboUsuPerfil.setSelectedItem(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUsuId = new javax.swing.JTextField();
        txtUsuNome = new javax.swing.JTextField();
        txtUsuLogin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cboUsuPerfil = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnConfirmarUsu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnCancelarUsu = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnConsultarUsu = new javax.swing.JButton();
        txtPasswordd = new javax.swing.JPasswordField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Consultar ou Alterar Dados do Usuário");

        jLabel5.setText("*Perfil");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Consultar ou Alterar Dados do Usuário");

        jLabel7.setText("* Campos Obrigatórios");

        jLabel1.setText("ID");

        cboUsuPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Master", "Medio", "Primario" }));

        jLabel2.setText("*Nome");

        btnConfirmarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/1891021_approved_check_checkbox_checkmark_confirm_icon.png"))); // NOI18N
        btnConfirmarUsu.setToolTipText("Confirmar Alterações");
        btnConfirmarUsu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarUsuActionPerformed(evt);
            }
        });

        jLabel3.setText("*Login");

        btnCancelarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/clear_icon.png"))); // NOI18N
        btnCancelarUsu.setToolTipText("Limpar Campos Preenchidos");
        btnCancelarUsu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarUsuActionPerformed(evt);
            }
        });

        jLabel4.setText("*Senha");

        btnConsultarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/edit_icon.png"))); // NOI18N
        btnConsultarUsu.setToolTipText("Realizar Consulta");
        btnConsultarUsu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarUsuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtUsuNome, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtPasswordd, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtUsuLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cboUsuPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnConfirmarUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConsultarUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel6)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtUsuNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsuLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPasswordd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboUsuPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConsultarUsu)
                    .addComponent(btnCancelarUsu)
                    .addComponent(btnConfirmarUsu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        setBounds(0, 0, 813, 614);
    }// </editor-fold>//GEN-END:initComponents
//Eventos Relacionados aos Botoes utilizados   
    private void btnConsultarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarUsuActionPerformed
        consultar();
    }//GEN-LAST:event_btnConsultarUsuActionPerformed

    private void btnCancelarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarUsuActionPerformed
         limpar();
    }//GEN-LAST:event_btnCancelarUsuActionPerformed

    private void btnConfirmarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarUsuActionPerformed
         alterar();
    }//GEN-LAST:event_btnConfirmarUsuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarUsu;
    private javax.swing.JButton btnConfirmarUsu;
    private javax.swing.JButton btnConsultarUsu;
    private javax.swing.JComboBox<String> cboUsuPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField txtPasswordd;
    private javax.swing.JTextField txtUsuId;
    private javax.swing.JTextField txtUsuLogin;
    private javax.swing.JTextField txtUsuNome;
    // End of variables declaration//GEN-END:variables
}

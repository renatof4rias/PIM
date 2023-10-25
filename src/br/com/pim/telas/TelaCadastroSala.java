/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.pim.telas;
import java.sql.*;
import br.com.pim.dal.ModuloConexao;
import javax.swing.JOptionPane;

public class TelaCadastroSala extends javax.swing.JInternalFrame {
//Componentes da Classe ModuloConexao.java.
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
//Construtor da Classe TelaCadastrarCusos
    public TelaCadastroSala() {
//Componentes da Classe ModuloConexao.java.
    initComponents();
    conexao = ModuloConexao.conector();
    }
//Metodo CadastrarSala da Classe TelaCadastrarSala
//Realizando um 'INSERT' na tabela tb_Sala
    private void CadastroSala() {
        String sql = "insert into tbsala (capacidadesala, localizacaosala, disponibilidadesala) values(?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCapacidadeSala.getText());
            pst.setString(2, txtLocalizacaoSala.getText());
            pst.setString(3, txtDisponibilidadeSala.getText());         
            if ((txtCapacidadeSala.getText().isEmpty()) || (txtLocalizacaoSala.getText().isEmpty()) || (txtDisponibilidadeSala.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatório !!");
            } else {
                int add = pst.executeUpdate();
                if (add > 0) {
                    JOptionPane.showMessageDialog(null, "Sala Cadastrada com Sucesso");
                    limpar();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
//Metodo Auxiliar para Realizar a Limpeza dos Campos Preenchidos
    private void limpar() {
        txtCapacidadeSala.setText(null);
        txtLocalizacaoSala.setText(null);
        txtDisponibilidadeSala.setText(null);      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtLocalizacaoSala = new javax.swing.JTextField();
        txtDisponibilidadeSala = new javax.swing.JTextField();
        txtCapacidadeSala = new javax.swing.JTextField();
        btnConfirmarAluno = new javax.swing.JButton();
        bntLimpar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel2.setText("*Localização");

        jLabel3.setText("*Disponibilidade");

        jLabel4.setText("*Capacidade");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Cadastro de Salas ");

        btnConfirmarAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/1891021_approved_check_checkbox_checkmark_confirm_icon.png"))); // NOI18N
        btnConfirmarAluno.setToolTipText("Confirmar Cadastro");
        btnConfirmarAluno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarAlunoActionPerformed(evt);
            }
        });

        bntLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/clear_icon.png"))); // NOI18N
        bntLimpar.setToolTipText("Limpar Campos Preenchidos");
        bntLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLimparActionPerformed(evt);
            }
        });

        jLabel7.setText("* Campos Obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLocalizacaoSala)
                            .addComponent(txtCapacidadeSala, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                            .addComponent(txtDisponibilidadeSala))))
                .addGap(137, 137, 137))
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(btnConfirmarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(bntLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtLocalizacaoSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDisponibilidadeSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCapacidadeSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                        .addComponent(bntLimpar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConfirmarAluno)))
                .addGap(165, 165, 165)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        setBounds(0, 0, 814, 612);
    }// </editor-fold>//GEN-END:initComponents
//Eventos Relacionados aos Botoes utilizados
    private void btnConfirmarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarAlunoActionPerformed
       CadastroSala();
    }//GEN-LAST:event_btnConfirmarAlunoActionPerformed

    private void bntLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLimparActionPerformed
       limpar();
    }//GEN-LAST:event_bntLimparActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntLimpar;
    private javax.swing.JButton btnConfirmarAluno;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtCapacidadeSala;
    private javax.swing.JTextField txtDisponibilidadeSala;
    private javax.swing.JTextField txtLocalizacaoSala;
    // End of variables declaration//GEN-END:variables
}
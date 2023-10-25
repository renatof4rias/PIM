/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.pim.telas;

import java.sql.*;
import br.com.pim.dal.ModuloConexao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class TelaConsultaProfessor extends javax.swing.JInternalFrame {
//Componentes da Classe ModuloConexao.java.
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
//Construtor da Classe TelaConsultaProfessor  
    public TelaConsultaProfessor() {
//Componentes da Classe ModuloConexao.java.
        initComponents();
        conexao = ModuloConexao.conector();
    }
    private void pesquisar_professor() {
//Metodo PesquisarCurso da Classe TelaConsultaProfessor
//Realizando um 'SELECT' na tabela tb_professor
        String sql = "select idprof as Matrícula, nomeprofessor as Nome, cpfprofessor as CPF, rgprofessor as RG, funcional as Funcional, foneprofessor as Fone, emailprofessor as Email, cepprofessor as CEP, endprofessor as Endereço from tbprofessor where nomeprofessor like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeAlu.getText() + "%");
            rs = pst.executeQuery();
            tblAlunos.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
//Metodo auxiliar Responsavel por "CAPTURAR" dados da tabela tblprofessor e Retornar aos Campos relacionados
    private void setarCampos() {
        int setar = tblAlunos.getSelectedRow();
        txtNomeAluno.setText(tblAlunos.getModel().getValueAt(setar, 1).toString());
        txtCpfAluno.setText(tblAlunos.getModel().getValueAt(setar, 2).toString());
        txtRgAluno.setText(tblAlunos.getModel().getValueAt(setar, 3).toString());
        txtRgAluno1.setText(tblAlunos.getModel().getValueAt(setar, 4).toString());
        txtFoneAluno.setText(tblAlunos.getModel().getValueAt(setar, 5).toString());
        txtEmailAluno.setText(tblAlunos.getModel().getValueAt(setar, 6).toString());
        txtCepAluno.setText(tblAlunos.getModel().getValueAt(setar, 7).toString());
        txtEnderecoAluno.setText(tblAlunos.getModel().getValueAt(setar, 8).toString());
    }
//Metodo alterar_curso da Classe TelaConsultaProfessor
//Realizando um 'UPDATE' na tabela tb_professor
    private void alterarProfessor() {
        String sql = "update tbprofessor set nomeprofessor=?, rgprofessor=?,foneprofessor=?,emailprofessor=?,cepprofessor=?, endprofessor=? where cpfprofessor=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeAluno.getText());
            pst.setString(2, txtRgAluno.getText());
            pst.setString(3, txtRgAluno1.getText());
            pst.setString(4, txtFoneAluno.getText());
            pst.setString(5, txtEmailAluno.getText());
            pst.setString(6, txtCepAluno.getText());
            pst.setString(7, txtEnderecoAluno.getText());
            pst.setString(8, txtCpfAluno.getText());
            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Dados Alterado com Sucesso");
                limpar();
            }
            pst.executeUpdate();
            limpar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
//Metodo Auxiliar para Realizar a Limpeza dos Campos Preenchidos 
    private void limpar() {
        txtNomeAluno.setText(null);
        txtCpfAluno.setText(null);
        txtRgAluno.setText(null);
        txtFoneAluno.setText(null);
        txtEmailAluno.setText(null);
        txtCepAluno.setText(null);
        txtEnderecoAluno.setText(null);
        txtNomeAlu.setText(null);
        ((DefaultTableModel) tblAlunos.getModel()).setRowCount(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        txtRgAluno = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFoneAluno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNomeAluno = new javax.swing.JTextField();
        txtEmailAluno = new javax.swing.JTextField();
        txtCepAluno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnConfirmarAluno = new javax.swing.JButton();
        txtCpfAluno = new javax.swing.JTextField();
        bntLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlunos = new javax.swing.JTable();
        txtEnderecoAluno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNomeAlu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtRgAluno1 = new javax.swing.JTextField();

        jLabel5.setText("jLabel5");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel10.setText("Endereço");

        jLabel2.setText("CPF");

        jLabel8.setText("RG");

        jLabel3.setText("Fone");

        btnConfirmarAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/1891021_approved_check_checkbox_checkmark_confirm_icon.png"))); // NOI18N
        btnConfirmarAluno.setToolTipText("Confirmar Cadastro");
        btnConfirmarAluno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarAlunoActionPerformed(evt);
            }
        });

        txtCpfAluno.setEnabled(false);

        bntLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/clear_icon.png"))); // NOI18N
        bntLimpar.setToolTipText("Limpar Campos Preenchidos");
        bntLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLimparActionPerformed(evt);
            }
        });

        tblAlunos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Matrícula", "Nome", "CPF", "RG", "Fone", "Email", "CEP", "Endereço"
            }
        ));
        tblAlunos.setFocusable(false);
        tblAlunos.getTableHeader().setReorderingAllowed(false);
        tblAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlunosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAlunos);

        jLabel1.setText("Nome Completo");

        jLabel37.setText("Nome Completo");

        jLabel9.setText("E-mail");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Alterar dados de Professor");

        txtNomeAlu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeAluKeyReleased(evt);
            }
        });

        jLabel4.setText("CEP");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel38.setText("Consultar dados de Professor");

        jLabel11.setText("Funcional");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(btnConfirmarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(bntLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNomeAluno)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtCpfAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtCepAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                            .addComponent(jLabel11))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtRgAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtRgAluno1)
                                        .addComponent(txtEmailAluno)
                                        .addComponent(txtFoneAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(txtEnderecoAluno))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(18, 18, 18)
                                .addComponent(txtNomeAlu, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCpfAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtEmailAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtRgAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtFoneAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCepAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(txtRgAluno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtEnderecoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtNomeAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirmarAluno)
                    .addComponent(bntLimpar))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        setBounds(0, 0, 813, 613);
    }// </editor-fold>//GEN-END:initComponents
//Eventos Relacionados aos Botoes utilizados   
    private void btnConfirmarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarAlunoActionPerformed
        alterarProfessor();
    }//GEN-LAST:event_btnConfirmarAlunoActionPerformed

    private void bntLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLimparActionPerformed
        limpar();
    }//GEN-LAST:event_bntLimparActionPerformed

    private void tblAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlunosMouseClicked
        setarCampos();
    }//GEN-LAST:event_tblAlunosMouseClicked

    private void txtNomeAluKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeAluKeyReleased
        pesquisar_professor();
    }//GEN-LAST:event_txtNomeAluKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntLimpar;
    private javax.swing.JButton btnConfirmarAluno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAlunos;
    private javax.swing.JTextField txtCepAluno;
    private javax.swing.JTextField txtCpfAluno;
    private javax.swing.JTextField txtEmailAluno;
    private javax.swing.JTextField txtEnderecoAluno;
    private javax.swing.JTextField txtFoneAluno;
    private javax.swing.JTextField txtNomeAlu;
    private javax.swing.JTextField txtNomeAluno;
    private javax.swing.JTextField txtRgAluno;
    private javax.swing.JTextField txtRgAluno1;
    // End of variables declaration//GEN-END:variables
}

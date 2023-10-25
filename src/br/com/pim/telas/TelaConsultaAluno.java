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

public class TelaConsultaAluno extends javax.swing.JInternalFrame {
//Componentes da Classe ModuloConexao.java.
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
//Construtor da Classe TelaConsultaAluno
    public TelaConsultaAluno() {
//Componentes da Classe ModuloConexao.java.  
    initComponents();
    conexao = ModuloConexao.conector();
    }
//Metodo pesquisar_aluno da Classe TelaConsultaAluno
//Realizando um 'SELECT' na tabela tb_aluno
    private void pesquisar_aluno(){
        String sql = "select id as Matrícula, nomealuno as Nome, cpfaluno as CPF, rgaluno as RG, fonealuno as Fone, emailaluno as Email, cepaluno as CEP, endaluno as Endereço from tb_alunos where nomealuno like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,txtNomeAlu.getText() + "%");
            rs=pst.executeQuery();           
            tblAlunos.setModel(DbUtils.resultSetToTableModel(rs));           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }      
    }
//Metodo auxiliar Responsavel por "CAPTURAR" dados da tabela tbl_aluno e Retornar aos Campos relacionados
    private void setarCampos(){
        int setar = tblAlunos.getSelectedRow();
        txtNomeAluno.setText(tblAlunos.getModel().getValueAt(setar,1).toString());
        txtCpfAluno.setText(tblAlunos.getModel().getValueAt(setar,2).toString());
        txtRgAluno.setText(tblAlunos.getModel().getValueAt(setar,3).toString());  
        txtFoneAluno.setText(tblAlunos.getModel().getValueAt(setar,4).toString());  
        txtEmailAluno.setText(tblAlunos.getModel().getValueAt(setar,5).toString());  
        txtCepAluno.setText(tblAlunos.getModel().getValueAt(setar,6).toString()); 
        txtEnderecoAluno.setText(tblAlunos.getModel().getValueAt(setar,7).toString()); 
    }
//Metodo alterar_aluno da Classe TelaConsultaAluno
//Realizando um 'UPDATE' na tabela tb_aluno
    private void alterarAluno(){
        String sql ="update tb_alunos set nomealuno=?, rgaluno=?,fonealuno=?,emailaluno=?,cepaluno=?, endaluno=? where cpfaluno=?";
        try {
            pst=conexao.prepareStatement(sql);          
            pst.setString(1, txtNomeAluno.getText());        
            pst.setString(2, txtRgAluno.getText());
            pst.setString(3, txtFoneAluno.getText());
            pst.setString(4, txtEmailAluno.getText());
            pst.setString(5, txtCepAluno.getText());
            pst.setString(6, txtEnderecoAluno.getText()); 
            pst.setString(7, txtCpfAluno.getText());     
            int add = pst.executeUpdate();
            if (add >0) {
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
    private void limpar(){
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

        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtFoneAluno = new javax.swing.JTextField();
        txtNomeAluno = new javax.swing.JTextField();
        txtCepAluno = new javax.swing.JTextField();
        btnConfirmarAluno = new javax.swing.JButton();
        txtCpfAluno = new javax.swing.JTextField();
        bntLimpar = new javax.swing.JButton();
        txtEnderecoAluno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRgAluno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtEmailAluno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtEnderecoAluno1 = new javax.swing.JTextField();
        txtNomeAluno1 = new javax.swing.JTextField();
        txtCepAluno1 = new javax.swing.JTextField();
        btnConfirmarAluno1 = new javax.swing.JButton();
        txtCpfAluno1 = new javax.swing.JTextField();
        bntLimpar1 = new javax.swing.JButton();
        txtFoneAluno1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtRgAluno1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtEmailAluno1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtEnderecoAluno2 = new javax.swing.JTextField();
        txtNomeAluno2 = new javax.swing.JTextField();
        txtCepAluno2 = new javax.swing.JTextField();
        btnConfirmarAluno2 = new javax.swing.JButton();
        txtCpfAluno2 = new javax.swing.JTextField();
        bntLimpar2 = new javax.swing.JButton();
        txtFoneAluno2 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtRgAluno2 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtEmailAluno2 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtEnderecoAluno3 = new javax.swing.JTextField();
        txtNomeAluno3 = new javax.swing.JTextField();
        txtCepAluno3 = new javax.swing.JTextField();
        btnConfirmarAluno3 = new javax.swing.JButton();
        txtCpfAluno3 = new javax.swing.JTextField();
        bntLimpar3 = new javax.swing.JButton();
        txtFoneAluno3 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtRgAluno3 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtEmailAluno3 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlunos = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        txtNomeAlu = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel9.setText("E-mail");

        jLabel4.setText("CEP");

        jLabel10.setText("Endereço");

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

        jLabel1.setText("Nome Completo");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Alterar dados de Aluno");

        jLabel2.setText("CPF");

        jLabel8.setText("RG");

        jLabel3.setText("Fone");

        jLabel11.setText("* Campos Obrigatório");

        jLabel12.setText("*E-mail");

        jLabel5.setText("CEP");

        jLabel13.setText("Endereço");

        btnConfirmarAluno1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/1891021_approved_check_checkbox_checkmark_confirm_icon.png"))); // NOI18N
        btnConfirmarAluno1.setToolTipText("Confirmar Cadastro");
        btnConfirmarAluno1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmarAluno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarAluno1ActionPerformed(evt);
            }
        });

        bntLimpar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/clear_icon.png"))); // NOI18N
        bntLimpar1.setToolTipText("Limpar Campos Preenchidos");
        bntLimpar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntLimpar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLimpar1ActionPerformed(evt);
            }
        });

        jLabel14.setText("*Nome Completo");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setText("Consultar ou Alterar dados de Aluno");

        jLabel16.setText("*CPF");

        jLabel17.setText("*RG");

        jLabel18.setText("*Fone");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel5)
                            .addComponent(jLabel18)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtFoneAluno1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCpfAluno1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCepAluno1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmailAluno1)
                                    .addComponent(txtEnderecoAluno1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtRgAluno1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNomeAluno1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(btnConfirmarAluno1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bntLimpar1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(122, 122, 122))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(56, 56, 56)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(txtNomeAluno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpfAluno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(txtRgAluno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtFoneAluno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtEmailAluno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel13)
                    .addComponent(txtEnderecoAluno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCepAluno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirmarAluno1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bntLimpar1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(106, 106, 106)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        jLabel19.setText("* Campos Obrigatório");

        jLabel20.setText("*E-mail");

        jLabel21.setText("CEP");

        jLabel22.setText("Endereço");

        btnConfirmarAluno2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/1891021_approved_check_checkbox_checkmark_confirm_icon.png"))); // NOI18N
        btnConfirmarAluno2.setToolTipText("Confirmar Cadastro");
        btnConfirmarAluno2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmarAluno2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarAluno2ActionPerformed(evt);
            }
        });

        bntLimpar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/clear_icon.png"))); // NOI18N
        bntLimpar2.setToolTipText("Limpar Campos Preenchidos");
        bntLimpar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntLimpar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLimpar2ActionPerformed(evt);
            }
        });

        jLabel23.setText("*Nome Completo");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel24.setText("Consultar ou Alterar dados de Aluno");

        jLabel25.setText("*CPF");

        jLabel26.setText("*RG");

        jLabel27.setText("*Fone");

        jLabel28.setText("* Campos Obrigatório");

        jLabel29.setText("*E-mail");

        jLabel30.setText("CEP");

        jLabel31.setText("Endereço");

        btnConfirmarAluno3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/1891021_approved_check_checkbox_checkmark_confirm_icon.png"))); // NOI18N
        btnConfirmarAluno3.setToolTipText("Confirmar Cadastro");
        btnConfirmarAluno3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmarAluno3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarAluno3ActionPerformed(evt);
            }
        });

        bntLimpar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/clear_icon.png"))); // NOI18N
        bntLimpar3.setToolTipText("Limpar Campos Preenchidos");
        bntLimpar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntLimpar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLimpar3ActionPerformed(evt);
            }
        });

        jLabel32.setText("*Nome Completo");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel33.setText("Consultar ou Alterar dados de Aluno");

        jLabel34.setText("*CPF");

        jLabel35.setText("*RG");

        jLabel36.setText("*Fone");

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel28))
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel30)
                            .addComponent(jLabel36)
                            .addComponent(jLabel34))
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtFoneAluno3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCpfAluno3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCepAluno3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel31))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmailAluno3)
                                    .addComponent(txtEnderecoAluno3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtRgAluno3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNomeAluno3, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                .addComponent(btnConfirmarAluno3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bntLimpar3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel33)
                .addGap(122, 122, 122))
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addGap(56, 56, 56)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32)
                    .addComponent(txtNomeAluno3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpfAluno3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(txtRgAluno3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txtFoneAluno3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(txtEmailAluno3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(txtEnderecoAluno3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCepAluno3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirmarAluno3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bntLimpar3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(106, 106, 106)
                .addComponent(jLabel28)
                .addContainerGap())
        );

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel21)
                            .addComponent(jLabel27)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtFoneAluno2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCpfAluno2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCepAluno2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmailAluno2)
                                    .addComponent(txtEnderecoAluno2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtRgAluno2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNomeAluno2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addComponent(btnConfirmarAluno2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bntLimpar2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(122, 122, 122))
            .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addGap(56, 56, 56)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(txtNomeAluno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpfAluno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(txtRgAluno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtFoneAluno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txtEmailAluno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(txtEnderecoAluno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCepAluno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirmarAluno2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bntLimpar2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(106, 106, 106)
                .addComponent(jLabel19)
                .addContainerGap())
            .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tblAlunos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Matrícula", "Nome", "CPF", "RG", "Fone", "Email", "CEP", "Endereço", "Turma"
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

        jLabel37.setText("Nome Completo");

        txtNomeAlu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeAluKeyReleased(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel38.setText("Consultar dados de Aluno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirmarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addComponent(bntLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCepAluno, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                    .addComponent(txtRgAluno)
                                    .addComponent(txtCpfAluno))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtEmailAluno, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                    .addComponent(txtFoneAluno)))
                            .addComponent(txtNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEnderecoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jLabel38))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                                    .addComponent(txtNomeAlu))))))
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 401, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 401, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 401, Short.MAX_VALUE)
                    .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 401, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCpfAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtRgAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtCepAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtEmailAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtFoneAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtEnderecoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNomeAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConfirmarAluno)
                    .addComponent(bntLimpar))
                .addGap(28, 28, 28))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 288, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 289, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 288, Short.MAX_VALUE)
                    .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 289, Short.MAX_VALUE)))
        );

        setBounds(0, 0, 814, 613);
    }// </editor-fold>//GEN-END:initComponents
//Eventos Relacionados aos Botoes utilizados 
    private void btnConfirmarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarAlunoActionPerformed
      alterarAluno();
    }//GEN-LAST:event_btnConfirmarAlunoActionPerformed

    private void bntLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLimparActionPerformed
        limpar();
    }//GEN-LAST:event_bntLimparActionPerformed

    private void btnConfirmarAluno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarAluno1ActionPerformed
     
    }//GEN-LAST:event_btnConfirmarAluno1ActionPerformed

    private void bntLimpar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLimpar1ActionPerformed
     
    }//GEN-LAST:event_bntLimpar1ActionPerformed

    private void btnConfirmarAluno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarAluno2ActionPerformed
   
    }//GEN-LAST:event_btnConfirmarAluno2ActionPerformed

    private void bntLimpar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLimpar2ActionPerformed
  
    }//GEN-LAST:event_bntLimpar2ActionPerformed

    private void btnConfirmarAluno3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarAluno3ActionPerformed

    }//GEN-LAST:event_btnConfirmarAluno3ActionPerformed

    private void bntLimpar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLimpar3ActionPerformed
       
    }//GEN-LAST:event_bntLimpar3ActionPerformed

    private void txtNomeAluKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeAluKeyReleased
        pesquisar_aluno();
    }//GEN-LAST:event_txtNomeAluKeyReleased

    private void tblAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlunosMouseClicked
       setarCampos();
    }//GEN-LAST:event_tblAlunosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntLimpar;
    private javax.swing.JButton bntLimpar1;
    private javax.swing.JButton bntLimpar2;
    private javax.swing.JButton bntLimpar3;
    private javax.swing.JButton btnConfirmarAluno;
    private javax.swing.JButton btnConfirmarAluno1;
    private javax.swing.JButton btnConfirmarAluno2;
    private javax.swing.JButton btnConfirmarAluno3;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
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
    private javax.swing.JTextField txtCepAluno1;
    private javax.swing.JTextField txtCepAluno2;
    private javax.swing.JTextField txtCepAluno3;
    private javax.swing.JTextField txtCpfAluno;
    private javax.swing.JTextField txtCpfAluno1;
    private javax.swing.JTextField txtCpfAluno2;
    private javax.swing.JTextField txtCpfAluno3;
    private javax.swing.JTextField txtEmailAluno;
    private javax.swing.JTextField txtEmailAluno1;
    private javax.swing.JTextField txtEmailAluno2;
    private javax.swing.JTextField txtEmailAluno3;
    private javax.swing.JTextField txtEnderecoAluno;
    private javax.swing.JTextField txtEnderecoAluno1;
    private javax.swing.JTextField txtEnderecoAluno2;
    private javax.swing.JTextField txtEnderecoAluno3;
    private javax.swing.JTextField txtFoneAluno;
    private javax.swing.JTextField txtFoneAluno1;
    private javax.swing.JTextField txtFoneAluno2;
    private javax.swing.JTextField txtFoneAluno3;
    private javax.swing.JTextField txtNomeAlu;
    private javax.swing.JTextField txtNomeAluno;
    private javax.swing.JTextField txtNomeAluno1;
    private javax.swing.JTextField txtNomeAluno2;
    private javax.swing.JTextField txtNomeAluno3;
    private javax.swing.JTextField txtRgAluno;
    private javax.swing.JTextField txtRgAluno1;
    private javax.swing.JTextField txtRgAluno2;
    private javax.swing.JTextField txtRgAluno3;
    // End of variables declaration//GEN-END:variables
}

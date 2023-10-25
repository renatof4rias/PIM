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

public class TelaConsultaSala extends javax.swing.JInternalFrame {
//Componentes da Classe ModuloConexao.java.
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
//Construtor da Classe TelaConsultaSala 
    public TelaConsultaSala() {
//Componentes da Classe ModuloConexao.java.
    initComponents();
    conexao = ModuloConexao.conector();
    }
//Metodo PesquisarCurso da Classe TelaConsultaSala
//Realizando um 'SELECT' na tabela tb_sala
    private void ConsultarSala() {
        String sql = "select idsala as Codigo, capacidadesala as Capacidade, localizacaosala as Localizacao, disponibilidadesala as Disponibilidade from tbsala where localizacaosala like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtLocSala.getText() + "%");
            rs = pst.executeQuery();
            tblSalas.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }  
//Metodo auxiliar Responsavel por "CAPTURAR" dados da tabela tblSala e Retornar aos Campos relacionados
    private void setarCampos() {
        int setar = tblSalas.getSelectedRow();    
        txtLocalizacaoSala.setText(tblSalas.getModel().getValueAt(setar, 2).toString());
        txtDisponibilidadeSala.setText(tblSalas.getModel().getValueAt(setar, 3).toString());  
        txtCapacidadeSala.setText(tblSalas.getModel().getValueAt(setar, 1).toString());        
    }
//Metodo alterar_curso da Classe TelaConsultaSala
//Realizando um 'UPDATE' na tabela tb_sala
    private void alterarSala() {
        String sql = "update tbsala set capacidadesala=?, disponibilidadesala=? where localizacaosala=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCapacidadeSala.getText());
            pst.setString(2, txtDisponibilidadeSala.getText());
            pst.setString(3, txtLocalizacaoSala.getText());
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
        txtLocSala.setText(null);
        txtLocalizacaoSala.setText(null);
        txtDisponibilidadeSala.setText(null);
        txtCapacidadeSala.setText(null);  
        ((DefaultTableModel) tblSalas.getModel()).setRowCount(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        txtLocalizacaoSala = new javax.swing.JTextField();
        txtDisponibilidadeSala = new javax.swing.JTextField();
        txtCapacidadeSala = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bntLimpar = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSalas = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        txtLocSala = new javax.swing.JTextField();
        btnConfirmarAluno = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Alterar dados de Sala");

        txtLocalizacaoSala.setEnabled(false);

        jLabel2.setText("*Localização");

        jLabel3.setText("*Disponibilidade");

        jLabel4.setText("*Capacidade");

        bntLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/clear_icon.png"))); // NOI18N
        bntLimpar.setToolTipText("Limpar Campos Preenchidos");
        bntLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLimparActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel38.setText("Consultar Sala");

        tblSalas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblSalas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Localizacao", "Capacidade", "Disponibilidade"
            }
        ));
        tblSalas.setFocusable(false);
        tblSalas.getTableHeader().setReorderingAllowed(false);
        tblSalas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSalasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSalas);

        jLabel37.setText("Localização");

        txtLocSala.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLocSalaKeyReleased(evt);
            }
        });

        btnConfirmarAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/1891021_approved_check_checkbox_checkmark_confirm_icon.png"))); // NOI18N
        btnConfirmarAluno.setToolTipText("Confirmar Cadastro");
        btnConfirmarAluno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarAlunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(btnConfirmarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110)
                                .addComponent(bntLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(178, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCapacidadeSala, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDisponibilidadeSala))
                                .addGap(96, 96, 96))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel37)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(txtLocalizacaoSala, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(jLabel38))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLocSala, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(13, 13, 13)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bntLimpar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConfirmarAluno, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap(44, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLocSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        setBounds(0, 0, 814, 614);
    }// </editor-fold>//GEN-END:initComponents
//Eventos Relacionados aos Botoes utilizados
    private void bntLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLimparActionPerformed
        limpar();
    }//GEN-LAST:event_bntLimparActionPerformed

    private void tblSalasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSalasMouseClicked
        setarCampos();
    }//GEN-LAST:event_tblSalasMouseClicked

    private void txtLocSalaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocSalaKeyReleased
       ConsultarSala();
    }//GEN-LAST:event_txtLocSalaKeyReleased

    private void btnConfirmarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarAlunoActionPerformed
       alterarSala();
    }//GEN-LAST:event_btnConfirmarAlunoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntLimpar;
    private javax.swing.JButton btnConfirmarAluno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSalas;
    private javax.swing.JTextField txtCapacidadeSala;
    private javax.swing.JTextField txtDisponibilidadeSala;
    private javax.swing.JTextField txtLocSala;
    private javax.swing.JTextField txtLocalizacaoSala;
    // End of variables declaration//GEN-END:variables
}

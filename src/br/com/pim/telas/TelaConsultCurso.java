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

public class TelaConsultCurso extends javax.swing.JInternalFrame {
//Componentes da Classe ModuloConexao.java.
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
//Construtor da Classe TelaCadastrarCusos  
    public TelaConsultCurso() {
//Componentes da Classe ModuloConexao.java.
    initComponents();
    conexao = ModuloConexao.conector();
    }
//Metodo PesquisarCurso da Classe TelaConsultCurso
//Realizando um 'SELECT' na tabela tb_cursos
    private void pesquisar_Curso(){
        String sql = "select idcurso as Codigo, nomecurso as Nome, descricaocurso as Descricao from tb_curso where nomecurso like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,txtNomeCurs.getText() + "%");
            rs=pst.executeQuery();           
            tblCurso.setModel(DbUtils.resultSetToTableModel(rs));      
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }      
    }
//Metodo auxiliar Responsavel por "CAPTURAR" dados da tabela tblCurso e Retornar aos Campos relacionados
    private void setarCampos(){
        int setar = tblCurso.getSelectedRow();
        txtNomeCurso.setText(tblCurso.getModel().getValueAt(setar,1).toString());
        txtDescricao.setText(tblCurso.getModel().getValueAt(setar,2).toString());
    }
//Metodo alterar_curso da Classe TelaConsultCurso
//Realizando um 'UPDATE' na tabela tb_cursos
    private void alterar_Curso() {
        String sql = "update tb_curso set nomecurso=?, descricaocurso=?  where nomecurso=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeCurso.getText());
            pst.setString(2, txtDescricao.getText());
            pst.setString(3, txtNomeCurso.getText());
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
        txtNomeCurso.setText(null);
        txtDescricao.setText(null);
        txtNomeCurs.setText(null);    
        ((DefaultTableModel) tblCurso.getModel()).setRowCount(0);
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConfirmar = new javax.swing.JButton();
        bntLimpar = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNomeCurs = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCurso = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNomeCurso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/1891021_approved_check_checkbox_checkmark_confirm_icon.png"))); // NOI18N
        btnConfirmar.setToolTipText("Confirmar Cadastro");
        btnConfirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
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

        jLabel37.setText("Nome da Disciplina");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Alterar dados de Disciplina");

        txtNomeCurs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeCursKeyReleased(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel38.setText("Consulta de Disciplina");

        tblCurso = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Descrição"
            }
        ));
        tblCurso.setFocusable(false);
        tblCurso.getTableHeader().setReorderingAllowed(false);
        tblCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCursoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCurso);

        jLabel1.setText("Nome da Disciplina");

        txtNomeCurso.setEnabled(false);
        txtNomeCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeCursoActionPerformed(evt);
            }
        });

        jLabel2.setText("Descrição da Disciplina");

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane2.setViewportView(txtDescricao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(bntLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel38))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomeCurso)
                                    .addComponent(jScrollPane2)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNomeCurs)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE))))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtNomeCurs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirmar)
                    .addComponent(bntLimpar))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        setBounds(0, 0, 814, 616);
    }// </editor-fold>//GEN-END:initComponents
//Eventos Relacionados aos Botoes utilizados   
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        alterar_Curso();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void bntLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLimparActionPerformed
    limpar();
    }//GEN-LAST:event_bntLimparActionPerformed

    private void txtNomeCursKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeCursKeyReleased
      pesquisar_Curso();
    }//GEN-LAST:event_txtNomeCursKeyReleased

    private void tblCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCursoMouseClicked
       setarCampos();
    }//GEN-LAST:event_tblCursoMouseClicked

    private void txtNomeCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeCursoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntLimpar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCurso;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtNomeCurs;
    private javax.swing.JTextField txtNomeCurso;
    // End of variables declaration//GEN-END:variables
}

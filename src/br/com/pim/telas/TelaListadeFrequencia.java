/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.pim.telas;
import java.sql.*;
import br.com.pim.dal.ModuloConexao;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class TelaListadeFrequencia extends javax.swing.JInternalFrame {
//Componentes da Classe ModuloConexao.java.
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
 //Construtor da Classe TelaListadeNotas
    public TelaListadeFrequencia() {
 //Componentes da Classe ModuloConexao.java.
    initComponents();
    conexao = ModuloConexao.conector();  
    }
//Metodo pesquisarTurma da Classe TelaCadastrarAluno
//Realizando um 'Select' na tabela tb_Turma
    private void pesquisarTurma() {
        String sql = "select idturma as Codigo, nometurma as Nome, periodoturma as Periodo, turnoturma as Turno, nomecurso as Curso from tbturma where nometurma like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCodTurma.getText() + "%");
            rs = pst.executeQuery();
            tblTurmas.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
//Metodo setarCampos da Classe TelaCadastrarAluno
//Realizando um evento na Tabela tblTurmas para 'Resgatar os valores da Tabela'
    private void setarCampos() {
        int setar = tblTurmas.getSelectedRow();
       // txtCodiTurma.setText(tblTurmas.getModel().getValueAt(setar, 0).toString());
    }
    private void imprimirLista (){
        int confirma = JOptionPane.showConfirmDialog(null, "Confirmar a impressão deste Documento ?","Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            try {
                JasperPrint print = JasperFillManager.fillReport("C:\\Users\\Renato\\Desktop\\relatorios\\report1.jasper", null, conexao);   
                JasperViewer.viewReport(print,false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
 
//Metodo Auxiliar para Realizar a Limpeza dos Campos Preenchidos 
    private void limpar() {
       txtCodTurma.setText(null);    
       bntImprimir.setEnabled(false);
       ((DefaultTableModel) tblTurmas.getModel()).setRowCount(0);
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCodTurma = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTurmas = new javax.swing.JTable();
        bntImprimir = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        bntLimpar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        txtCodTurma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodTurmaKeyReleased(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel38.setText("Lista de Frequência");

        tblTurmas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblTurmas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código Turma", "Nome Turma", "Periodo", "Turno", "Curso"
            }
        ));
        tblTurmas.setFocusable(false);
        tblTurmas.getTableHeader().setReorderingAllowed(false);
        tblTurmas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTurmasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTurmas);

        bntImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/bx_printer_icon.png"))); // NOI18N
        bntImprimir.setToolTipText("Emitir Documento");
        bntImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntImprimir.setEnabled(false);
        bntImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntImprimirActionPerformed(evt);
            }
        });

        jLabel37.setText("Turma");

        bntLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/clear_icon.png"))); // NOI18N
        bntLimpar.setToolTipText("Limpar Campos Preenchidos");
        bntLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel38))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(bntLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(bntImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(64, Short.MAX_VALUE)
                        .addComponent(jLabel37)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel38)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtCodTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntLimpar)
                    .addComponent(bntImprimir))
                .addGap(140, 140, 140))
        );

        setBounds(0, 0, 812, 614);
    }// </editor-fold>//GEN-END:initComponents
    private void txtCodTurmaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodTurmaKeyReleased
        pesquisarTurma();
    }//GEN-LAST:event_txtCodTurmaKeyReleased
    private void tblTurmasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTurmasMouseClicked
      bntImprimir.setEnabled(true);
    }//GEN-LAST:event_tblTurmasMouseClicked
    private void bntImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntImprimirActionPerformed
        imprimirLista ();
    }//GEN-LAST:event_bntImprimirActionPerformed
    private void bntLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLimparActionPerformed
        limpar();
    }//GEN-LAST:event_bntLimparActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntImprimir;
    private javax.swing.JButton bntLimpar;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTurmas;
    private javax.swing.JTextField txtCodTurma;
    // End of variables declaration//GEN-END:variables
}

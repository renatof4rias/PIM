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

public class TelaGerenciarFrequencia extends javax.swing.JInternalFrame {
//Componentes da Classe ModuloConexao.java.
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
//Construtor da Classe TelaGerenciarFrequencia  
    public TelaGerenciarFrequencia() {
//Componentes da Classe ModuloConexao.java.
    initComponents();
    conexao = ModuloConexao.conector();
    }
//Metodo ConsultarAluno da Classe TelaGerenciarFrequencia
//Realizando um 'SELECT' na tabela tb_alunos
    private void ConsultarAluno() {
        String sql = "select id as Id, nomealuno as Nome, emailaluno as Email from tb_alunos where nomealuno like ? ";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeAlunno.getText() + "%");
            System.out.println(txtNomeAlunno.getText());
            rs = pst.executeQuery();
            tblConsultAluno.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
//Metodo auxiliar Responsavel por "CAPTURAR" dados da tabela tblalunos e Retornar aos Campos relacionados
    private void setarCampos() {
        int setar = tblConsultAluno.getSelectedRow();
        txtMatriculaAlu.setText(tblConsultAluno.getModel().getValueAt(setar, 0).toString());
        txtNOMEALU.setText(tblConsultAluno.getModel().getValueAt(setar, 1).toString());
    }
//Metodo ConsultarDisciplina da Classe TelaGerenciarFrequencia
//Realizando um 'SELECT' na tabela tb_disciplina
    private void ConsultarDisciplina() {
        String sql = "select idcurso as Codigo, nomecurso as Disciplina from tb_curso where nomecurso like ? ";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeDisciplina.getText() + "%");
            rs = pst.executeQuery();
            tblConsultDisciplina.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
//Metodo auxiliar Responsavel por "CAPTURAR" dados da tabela tblDisciplina e Retornar aos Campos relacionados
    private void setarCamposDisciplina() {
        int seta = tblConsultDisciplina.getSelectedRow();
        txtMatriculaDisciplina.setText(tblConsultDisciplina.getModel().getValueAt(seta, 0).toString());
    }
//Metodo cadastrarFrequencia da Classe TelaGerenciarFrequencia
//Realizando um 'INSERT' na tabela tb_frequencia
    private void cadastrarFrequencia() {
        String sql = "insert into tbfrequencia(aula1, aula2, aula3, aula4, aula5, aula6, aula7, aula8, aula9, aula10, id, idcurso) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtaula1.getText());
            pst.setString(2, txtaula2.getText());
            pst.setString(3, txtaula3.getText());
            pst.setString(4, txtaula4.getText());
            pst.setString(5, txtaula5.getText());
            pst.setString(6, txtaula6.getText());
            pst.setString(7, txtaula7.getText());
            pst.setString(8, txtaula8.getText());
            pst.setString(9, txtaula9.getText());
            pst.setString(10, txtaula10.getText());
            pst.setString(11, txtMatriculaAlu.getText());
            pst.setString(12, txtMatriculaDisciplina.getText());
            if ((txtNomeAlunno.getText().isEmpty()) || (txtNomeDisciplina.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatório !!");
            } else {
                int add = pst.executeUpdate();
                if (add > 0) {
                    JOptionPane.showMessageDialog(null, "Notas Cadastradas com Sucesso");
                    limpar();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
//Metodo ConsultarFrequencia da Classe TelaGerenciarFrequencia
//Realizando um 'SELECT' na tabela tb_frequencia
    private void ConsultarFrequencia() {
        String sql = "select * from tbfrequencia where id like ? and idcurso like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtMatriculaAlu.getText() + "%");
            pst.setString(2, txtMatriculaDisciplina.getText() + "%");
            rs = pst.executeQuery();
            if (rs.next()) {
                txtaula1.setText(rs.getString(2));
                txtaula2.setText(rs.getString(3));
                txtaula3.setText(rs.getString(4));
                txtaula4.setText(rs.getString(5));
                txtaula5.setText(rs.getString(6));
                txtaula6.setText(rs.getString(7));
                txtaula7.setText(rs.getString(8));
                txtaula8.setText(rs.getString(9));
                txtaula9.setText(rs.getString(10));
                txtaula10.setText(rs.getString(11));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
//Metodo AlterarFrequencia da Classe TelaGerenciarFrequencia
//Realizando um 'UPDATE' na tabela tb_frequencia
    private void AlterarFrequencia() {
        String sql = "update tbfrequencia set aula1=?,aula2=?,aula3=?,aula4=?,aula5=?,aula6=?,aula7=?,aula8=?,aula9=?,aula10=? where id=? and idcurso=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtaula1.getText());
            pst.setString(2, txtaula2.getText());
            pst.setString(3, txtaula3.getText());
            pst.setString(4, txtaula4.getText());
            pst.setString(5, txtaula5.getText());
            pst.setString(6, txtaula6.getText());
            pst.setString(7, txtaula7.getText());
            pst.setString(8, txtaula8.getText());
            pst.setString(9, txtaula9.getText());
            pst.setString(10, txtaula10.getText());
            pst.setString(11, txtMatriculaAlu.getText());
            pst.setString(12, txtMatriculaDisciplina.getText());
            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Dados Alterado com Sucesso");
            }
            pst.executeUpdate();
            limpar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
//Metodo Auxiliar para Realizar a Limpeza dos Campos Preenchidos 
    private void limpar() {
        txtNOMEALU.setText(null);
        txtMatriculaAlu.setText(null);
        txtaula1.setText(null);
        txtaula2.setText(null);
        txtaula3.setText(null);
        txtaula4.setText(null);
        txtaula5.setText(null);
        txtaula6.setText(null);
        txtaula7.setText(null);
        txtaula8.setText(null);
        txtaula9.setText(null);
        txtaula10.setText(null);
        txtNomeAlunno.setText(null);
        ((DefaultTableModel) tblConsultAluno.getModel()).setRowCount(0);
    }
//Metodo Auxiliar para Realizar a Limpeza dos Campos Preenchidos 
    private void limpar1() {
        txtNOMEALU.setText(null);
        txtNomeDisciplina.setText(null);
        txtMatriculaAlu.setText(null);
        txtMatriculaDisciplina.setText(null);
        txtaula1.setText(null);
        txtaula2.setText(null);
        txtaula3.setText(null);
        txtaula4.setText(null);
        txtaula5.setText(null);
        txtaula6.setText(null);
        txtaula7.setText(null);
        txtaula8.setText(null);
        txtaula9.setText(null);
        txtaula10.setText(null);
        txtNomeAlunno.setText(null);
        ((DefaultTableModel) tblConsultAluno.getModel()).setRowCount(0);
        ((DefaultTableModel) tblConsultDisciplina.getModel()).setRowCount(0);      
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTrabalho5 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNomeDisciplina = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtMatriculaDisciplina = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblConsultDisciplina = new javax.swing.JTable();
        btnConfirmarFrequencia = new javax.swing.JButton();
        bntLimpar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        bntConsultar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        bntUpdated = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtaula3 = new javax.swing.JTextField();
        txtaula2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultAluno = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtMatriculaAlu = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNomeAlunno = new javax.swing.JTextField();
        txtNOMEALU = new javax.swing.JTextField();
        txtaula1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtaula4 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtaula5 = new javax.swing.JTextField();
        txtaula6 = new javax.swing.JTextField();
        txtaula7 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtaula8 = new javax.swing.JTextField();
        txtaula10 = new javax.swing.JTextField();
        txtaula9 = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/asdf.png"))); // NOI18N

        txtNomeDisciplina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeDisciplinaKeyReleased(evt);
            }
        });

        jLabel14.setText("Codigo da Disciplina");

        txtMatriculaDisciplina.setEnabled(false);

        tblConsultDisciplina = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblConsultDisciplina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Nome Disciplina"
            }
        ));
        tblConsultDisciplina.setFocusable(false);
        tblConsultDisciplina.getTableHeader().setReorderingAllowed(false);
        tblConsultDisciplina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConsultDisciplinaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblConsultDisciplina);

        btnConfirmarFrequencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/1891021_approved_check_checkbox_checkmark_confirm_icon.png"))); // NOI18N
        btnConfirmarFrequencia.setToolTipText("Confirmar Cadastro");
        btnConfirmarFrequencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmarFrequencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarFrequenciaActionPerformed(evt);
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

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Dados do Aluno");

        bntConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/search_icon.png"))); // NOI18N
        bntConsultar.setToolTipText("Consultar Frenquencias");
        bntConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntConsultarActionPerformed(evt);
            }
        });

        jLabel5.setText("2ª");

        bntUpdated.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/326602_create_edit_pencil_write_icon.png"))); // NOI18N
        bntUpdated.setToolTipText("Atualizar Frequencias");
        bntUpdated.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntUpdated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntUpdatedActionPerformed(evt);
            }
        });

        jLabel9.setText("3ª");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/asdf.png"))); // NOI18N

        tblConsultAluno = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblConsultAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Matricula", "Nome", "Email"
            }
        ));
        tblConsultAluno.setFocusable(false);
        tblConsultAluno.getTableHeader().setReorderingAllowed(false);
        tblConsultAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConsultAlunoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblConsultAluno);

        jLabel10.setText("Matricula do Aluno");

        txtMatriculaAlu.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Consultar Aluno");

        jLabel1.setText("Nome do Aluno");

        jLabel2.setText("Nome");

        jLabel4.setText("1ª");

        txtNomeAlunno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeAlunnoKeyReleased(evt);
            }
        });

        txtNOMEALU.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Consultar Disciplina");

        jLabel12.setText("Nome da Disciplina");

        jLabel3.setText("4ª");

        jLabel15.setText("5ª");

        jLabel16.setText("6ª");

        jLabel17.setText("7ª");

        jLabel18.setText("8ª");

        jLabel19.setText("9ª");

        jLabel20.setText("10ª");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNomeAlunno, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)
                        .addGap(81, 81, 81)
                        .addComponent(txtNOMEALU, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(437, 437, 437)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtaula6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtaula7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtaula8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtaula9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtaula10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMatriculaDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11)
                            .addComponent(jLabel7)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel10)
                        .addGap(13, 13, 13)
                        .addComponent(txtMatriculaAlu, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtaula1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtaula2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtaula3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtaula4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtaula5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(93, 93, 93)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnConfirmarFrequencia, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(32, 32, 32)
                                    .addComponent(bntLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(33, 33, 33)
                                    .addComponent(bntConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(484, 484, 484)
                                    .addComponent(bntUpdated, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(jLabel6)))
                    .addContainerGap(93, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtNomeAlunno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(txtNomeDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNOMEALU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel10))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMatriculaAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txtaula1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtaula2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(txtaula3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtaula4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(txtaula5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMatriculaDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtaula6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(txtaula7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)
                        .addComponent(txtaula8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19)
                        .addComponent(txtaula9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)
                        .addComponent(txtaula10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)))
                .addContainerGap(154, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel6)
                    .addGap(436, 436, 436)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(bntConsultar)
                        .addComponent(bntLimpar)
                        .addComponent(bntUpdated)
                        .addComponent(btnConfirmarFrequencia))
                    .addContainerGap(41, Short.MAX_VALUE)))
        );

        setBounds(0, 0, 812, 614);
    }// </editor-fold>//GEN-END:initComponents
//Eventos Relacionados aos Botoes utilizados   
    private void txtNomeDisciplinaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeDisciplinaKeyReleased
        ConsultarDisciplina();
    }//GEN-LAST:event_txtNomeDisciplinaKeyReleased

    private void tblConsultDisciplinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblConsultDisciplinaMouseClicked
        setarCamposDisciplina();
    }//GEN-LAST:event_tblConsultDisciplinaMouseClicked

    private void btnConfirmarFrequenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarFrequenciaActionPerformed
        cadastrarFrequencia();
    }//GEN-LAST:event_btnConfirmarFrequenciaActionPerformed

    private void bntLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLimparActionPerformed
        limpar1();
    }//GEN-LAST:event_bntLimparActionPerformed

    private void bntConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntConsultarActionPerformed
        ConsultarFrequencia();
    }//GEN-LAST:event_bntConsultarActionPerformed

    private void bntUpdatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntUpdatedActionPerformed
        AlterarFrequencia();
    }//GEN-LAST:event_bntUpdatedActionPerformed

    private void tblConsultAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblConsultAlunoMouseClicked
        setarCampos();
    }//GEN-LAST:event_tblConsultAlunoMouseClicked

    private void txtNomeAlunnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeAlunnoKeyReleased
        ConsultarAluno();
    }//GEN-LAST:event_txtNomeAlunnoKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntConsultar;
    private javax.swing.JButton bntLimpar;
    private javax.swing.JButton bntUpdated;
    private javax.swing.JButton btnConfirmarFrequencia;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblConsultAluno;
    private javax.swing.JTable tblConsultDisciplina;
    private javax.swing.JTextField txtMatriculaAlu;
    private javax.swing.JTextField txtMatriculaDisciplina;
    private javax.swing.JTextField txtNOMEALU;
    private javax.swing.JTextField txtNomeAlunno;
    private javax.swing.JTextField txtNomeDisciplina;
    private javax.swing.JTextField txtTrabalho5;
    private javax.swing.JTextField txtaula1;
    private javax.swing.JTextField txtaula10;
    private javax.swing.JTextField txtaula2;
    private javax.swing.JTextField txtaula3;
    private javax.swing.JTextField txtaula4;
    private javax.swing.JTextField txtaula5;
    private javax.swing.JTextField txtaula6;
    private javax.swing.JTextField txtaula7;
    private javax.swing.JTextField txtaula8;
    private javax.swing.JTextField txtaula9;
    // End of variables declaration//GEN-END:variables
}

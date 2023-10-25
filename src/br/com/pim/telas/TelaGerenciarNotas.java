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

public class TelaGerenciarNotas extends javax.swing.JInternalFrame {
//Componentes da Classe ModuloConexao.java.
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
//Construtor da Classe TelaGerenciarNotas  
    public TelaGerenciarNotas() {
//Componentes da Classe ModuloConexao.java.   
        initComponents();
        conexao = ModuloConexao.conector();
    }
//Metodo ConsultarAluno da Classe TelaGerenciarNotas
//Realizando um 'SELECT' na tabela tb_alunos  
    private void ConsultarAluno(){
      String sql= "select id as Id, nomealuno as Nome, emailaluno as Email from tb_alunos where nomealuno like ? ";
        try {
            pst = conexao.prepareStatement(sql);
            pst .setString(1,txtNomeAlunno.getText()+ "%");
            System.out.println(txtNomeAlunno.getText());
            rs=pst.executeQuery();
            tblConsultAluno.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
//Metodo auxiliar Responsavel por "CAPTURAR" dados da tabela tblalunos e Retornar aos Campos relacionados
    private void setarCampos(){
        int setar =tblConsultAluno.getSelectedRow();
        txtMatriculaAlu.setText(tblConsultAluno.getModel().getValueAt(setar,0).toString());
        txtNOMEALU.setText(tblConsultAluno.getModel().getValueAt(setar,1).toString());
       // btnConfirmarNota.setEnabled(false);
    }
//Metodo ConsultarDisciplina da Classe TelaGerenciarNotas
//Realizando um 'SELECT' na tabela tb_disciplina  
    private void ConsultarDisciplina(){
      String sql= "select idcurso as Codigo, nomecurso as Disciplina from tb_curso where nomecurso like ? ";
        try {
            pst = conexao.prepareStatement(sql);
            pst .setString(1,txtNomeDisciplina.getText()+ "%");
            rs=pst.executeQuery();
            tblConsultDisciplina.setModel(DbUtils.resultSetToTableModel(rs));          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
//Metodo auxiliar Responsavel por "CAPTURAR" dados da tabela tblDisciplina e Retornar aos Campos relacionados 
    private void setarCamposDisciplina(){
        int seta =tblConsultDisciplina.getSelectedRow();
        txtMatriculaDisciplina.setText(tblConsultDisciplina.getModel().getValueAt(seta,0).toString());
    }   
//Metodo cadastrarNotas da Classe TelaGerenciarNotas
//Realizando um 'INSERT' na tabela tb_notas
    private void cadastrarNotas(){
        String sql = "insert into tbnotas(np1, np2, trabalho, id, idcurso) values(?, ?, ?, ?, ?)";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1, txtNP1.getText());
            pst.setString(2, txtNP2.getText());
            pst.setString(3, txtTrabalho.getText());
            pst.setString(4, txtMatriculaAlu.getText());
            pst.setString(5, txtMatriculaDisciplina.getText());
             if ((txtNomeAlunno.getText().isEmpty()) || (txtNomeDisciplina.getText().isEmpty())){
                JOptionPane.showMessageDialog(null,"Preencha Todos os Campos Obrigatório !!");
            } else {
            int add = pst.executeUpdate();
            if (add >0) {
                JOptionPane.showMessageDialog(null, "Notas Cadastradas com Sucesso"); 
                limpar();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
//Metodo ConsultarNotas da Classe TelaGerenciarNotas
//Realizando um 'SELECT' na tabela tb_notas 
    private void ConsultarNotas(){
        String sql = "select * from tbnotas where id like ? and idcurso like ?";     
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtMatriculaAlu.getText() + "%");
            pst.setString(2, txtMatriculaDisciplina.getText() + "%");
            rs=pst.executeQuery();  
            if (rs.next()) {
                txtNP1.setText(rs.getString(4));
                txtNP2.setText(rs.getString(5));
                txtTrabalho.setText(rs.getString(6));
            }             
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
        }
    }
//Metodo AlterarNota da Classe TelaGerenciarNotas
//Realizando um 'UPDATE' na tabela tb_notas     
    private void AlterarNota(){
        String sql = "update tbnotas set np1=?, np2=?, trabalho=? where id=? and idcurso=?";
        try {
            pst=conexao.prepareStatement(sql);
          pst.setString(1,txtNP1.getText());
          pst.setString(2,txtNP2.getText());
          pst.setString(3,txtTrabalho.getText());
          pst.setString(4, txtMatriculaAlu.getText());
          pst.setString(5,txtMatriculaDisciplina.getText());
          int add = pst.executeUpdate();
            if (add >0) {
                JOptionPane.showMessageDialog(null, "Dados Alterado com Sucesso");
            }           
            pst.executeUpdate();
            limpar();
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
        }
    }
//Metodo Auxiliar para Realizar a Limpeza dos Campos Preenchidos    
    private void limpar(){
        txtNOMEALU.setText(null);
        txtMatriculaAlu.setText(null);
      
        txtNP1.setText(null);
        txtNP2.setText(null);
        txtTrabalho.setText(null);
        txtNomeAlunno.setText(null);
        ((DefaultTableModel) tblConsultAluno.getModel()).setRowCount(0);
    }
    private void imprimirLista (){
        int confirma = JOptionPane.showConfirmDialog(null, "Confirmar a impressão deste Documento ?","Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            try {
                //JasperPrint print = JasperFillManager.fillReport("C:\\Users\\Renato\\Desktop\\relatorios\\report1.jasper", null, conexao);
                HashMap<String, Object> parametro = new HashMap<String, Object>();
                parametro.put("nomeAluno", txtNOMEALU.getText());
                JasperPrint print = JasperFillManager.fillReport("C:\\Users\\Renato\\Desktop\\relatorios\\report4.jasper", parametro, conexao);
                
                JasperViewer.viewReport(print,false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
   
//Metodo Auxiliar para Realizar a Limpeza dos Campos Preenchidos 
     private void limpar1(){
        bntImprimir.setEnabled(false);
        txtNOMEALU.setText(null);
        txtNomeDisciplina.setText(null);
        txtMatriculaAlu.setText(null);
        txtMatriculaDisciplina.setText(null);
        txtNP1.setText(null);
        txtNP2.setText(null);
        txtTrabalho.setText(null);
        txtNomeAlunno.setText(null);
        ((DefaultTableModel) tblConsultAluno.getModel()).setRowCount(0);
        ((DefaultTableModel) tblConsultDisciplina.getModel()).setRowCount(0); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNomeAlunno = new javax.swing.JTextField();
        txtNOMEALU = new javax.swing.JTextField();
        txtNP1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTrabalho = new javax.swing.JTextField();
        txtNP2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultAluno = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtMatriculaAlu = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNomeDisciplina = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtMatriculaDisciplina = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblConsultDisciplina = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        btnConfirmarNota = new javax.swing.JButton();
        bntLimpar = new javax.swing.JButton();
        bntConsultar = new javax.swing.JButton();
        bntUpdated = new javax.swing.JButton();
        bntImprimir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Consultar Aluno");

        jLabel1.setText("Nome do Aluno");

        jLabel2.setText("Nome");

        jLabel4.setText("NP1");

        txtNomeAlunno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeAlunnoKeyReleased(evt);
            }
        });

        txtNOMEALU.setEnabled(false);
        txtNOMEALU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNOMEALUActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Dados do Aluno");

        jLabel5.setText("NP2");

        jLabel9.setText("Trabalho");

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

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Consultar Disciplina");

        jLabel12.setText("Nome da Disciplina");

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

        btnConfirmarNota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/1891021_approved_check_checkbox_checkmark_confirm_icon.png"))); // NOI18N
        btnConfirmarNota.setToolTipText("Confirmar Cadastro");
        btnConfirmarNota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmarNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarNotaActionPerformed(evt);
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

        bntConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/search_icon.png"))); // NOI18N
        bntConsultar.setToolTipText("Consultar Notas");
        bntConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntConsultarActionPerformed(evt);
            }
        });

        bntUpdated.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/326602_create_edit_pencil_write_icon.png"))); // NOI18N
        bntUpdated.setToolTipText("Atualizar Notas");
        bntUpdated.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntUpdated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntUpdatedActionPerformed(evt);
            }
        });

        bntImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/bx_printer_icon.png"))); // NOI18N
        bntImprimir.setToolTipText("Emitir Documento");
        bntImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntImprimir.setEnabled(false);
        bntImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMatriculaAlu, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMatriculaDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNOMEALU, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNP1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNP2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                            .addComponent(txtTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(btnConfirmarNota, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(bntLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(bntConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(bntUpdated, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(bntImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 34, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(707, 707, 707)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtNomeAlunno, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNomeAlunno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(txtNomeDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNOMEALU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtMatriculaAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtMatriculaDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtNP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bntConsultar)
                            .addComponent(bntLimpar)
                            .addComponent(bntUpdated)
                            .addComponent(btnConfirmarNota)
                            .addComponent(bntImprimir))))
                .addGap(42, 42, 42))
        );

        setBounds(0, 0, 812, 616);
    }// </editor-fold>//GEN-END:initComponents
//Eventos Relacionados aos Botoes utilizados   
    private void txtNomeAlunnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeAlunnoKeyReleased
     ConsultarAluno();
    }//GEN-LAST:event_txtNomeAlunnoKeyReleased

    private void tblConsultAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblConsultAlunoMouseClicked
        setarCampos();
        bntImprimir.setEnabled(true);
    }//GEN-LAST:event_tblConsultAlunoMouseClicked

    private void txtNomeDisciplinaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeDisciplinaKeyReleased
      ConsultarDisciplina();
    }//GEN-LAST:event_txtNomeDisciplinaKeyReleased

    private void tblConsultDisciplinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblConsultDisciplinaMouseClicked
       setarCamposDisciplina();
    }//GEN-LAST:event_tblConsultDisciplinaMouseClicked

    private void btnConfirmarNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarNotaActionPerformed
       cadastrarNotas();
    }//GEN-LAST:event_btnConfirmarNotaActionPerformed

    private void bntLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLimparActionPerformed
        limpar1();
    }//GEN-LAST:event_bntLimparActionPerformed

    private void bntConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntConsultarActionPerformed
        ConsultarNotas();
    }//GEN-LAST:event_bntConsultarActionPerformed

    private void bntUpdatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntUpdatedActionPerformed
        AlterarNota();
    }//GEN-LAST:event_bntUpdatedActionPerformed

    private void bntImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntImprimirActionPerformed
        imprimirLista ();
    }//GEN-LAST:event_bntImprimirActionPerformed

    private void txtNOMEALUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNOMEALUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNOMEALUActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntConsultar;
    private javax.swing.JButton bntImprimir;
    private javax.swing.JButton bntLimpar;
    private javax.swing.JButton bntUpdated;
    private javax.swing.JButton btnConfirmarNota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblConsultAluno;
    private javax.swing.JTable tblConsultDisciplina;
    private javax.swing.JTextField txtMatriculaAlu;
    private javax.swing.JTextField txtMatriculaDisciplina;
    private javax.swing.JTextField txtNOMEALU;
    private javax.swing.JTextField txtNP1;
    private javax.swing.JTextField txtNP2;
    private javax.swing.JTextField txtNomeAlunno;
    private javax.swing.JTextField txtNomeDisciplina;
    private javax.swing.JTextField txtTrabalho;
    // End of variables declaration//GEN-END:variables
}

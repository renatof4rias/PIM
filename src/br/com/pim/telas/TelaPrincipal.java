/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package br.com.pim.telas;
import com.sun.java.swing.plaf.windows.resources.windows;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.*;
import br.com.pim.dal.ModuloConexao;

public class TelaPrincipal extends javax.swing.JFrame {  
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
//Construtor da Classe TelaPrincipal
    public TelaPrincipal() {
       initComponents();
       conexao = ModuloConexao.conector();  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jLabel1 = new javax.swing.JLabel();
        jMenuItem2 = new javax.swing.JMenuItem();
        desktop = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        menUsuario = new javax.swing.JMenu();
        menUsuCad = new javax.swing.JMenuItem();
        menUsuAlt = new javax.swing.JMenuItem();
        menUsuRem = new javax.swing.JMenuItem();
        menAlun = new javax.swing.JMenu();
        MenuCadastrarAluno = new javax.swing.JMenuItem();
        MenuConsultarAluno = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menAlunCadNotas = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menAlunFreq = new javax.swing.JMenuItem();
        menListaFrequencia = new javax.swing.JMenuItem();
        menProfessor = new javax.swing.JMenu();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenuItem34 = new javax.swing.JMenuItem();
        menSala = new javax.swing.JMenu();
        jMenuItem36 = new javax.swing.JMenuItem();
        jMenuItem38 = new javax.swing.JMenuItem();
        menCurso = new javax.swing.JMenu();
        jMenuItem40 = new javax.swing.JMenuItem();
        jMenuItem39 = new javax.swing.JMenuItem();
        menTurma = new javax.swing.JMenu();
        jMenuItem44 = new javax.swing.JMenuItem();
        jMenuItem41 = new javax.swing.JMenuItem();
        menAjuda = new javax.swing.JMenu();
        jMenuItem30 = new javax.swing.JMenuItem();
        menOpcoes = new javax.swing.JMenu();
        jMenuItem31 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/LogoStarkPequenoSemFundo.png"))); // NOI18N

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(new ImageIcon(getClass().getResource("/br/com/pim/icones/csharp.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 813, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/LogoStarkPequenoSemFundo.png"))); // NOI18N

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsuario.setText("Usuário");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Perfil:");

        menUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/8666609_user_icon.png"))); // NOI18N
        menUsuario.setText("Usuário");
        menUsuario.setEnabled(false);
        menUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menUsuarioActionPerformed(evt);
            }
        });

        menUsuCad.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menUsuCad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/newUser.png"))); // NOI18N
        menUsuCad.setText("Cadastrar");
        menUsuCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menUsuCadActionPerformed(evt);
            }
        });
        menUsuario.add(menUsuCad);

        menUsuAlt.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menUsuAlt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/edit.png"))); // NOI18N
        menUsuAlt.setText("Consultar / Alterar");
        menUsuAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menUsuAltActionPerformed(evt);
            }
        });
        menUsuario.add(menUsuAlt);

        menUsuRem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menUsuRem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/remove_icon.png"))); // NOI18N
        menUsuRem.setText("Remover");
        menUsuRem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menUsuRemActionPerformed(evt);
            }
        });
        menUsuario.add(menUsuRem);

        Menu.add(menUsuario);

        menAlun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/9023992_student_fill_icon (1).png"))); // NOI18N
        menAlun.setText("Aluno");
        menAlun.setEnabled(false);
        menAlun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menAlunActionPerformed(evt);
            }
        });

        MenuCadastrarAluno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        MenuCadastrarAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/newUser.png"))); // NOI18N
        MenuCadastrarAluno.setText("Cadastrar");
        MenuCadastrarAluno.setEnabled(false);
        MenuCadastrarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastrarAlunoActionPerformed(evt);
            }
        });
        menAlun.add(MenuCadastrarAluno);

        MenuConsultarAluno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        MenuConsultarAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/edit.png"))); // NOI18N
        MenuConsultarAluno.setText("Consultar / Alterar");
        MenuConsultarAluno.setEnabled(false);
        MenuConsultarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuConsultarAlunoActionPerformed(evt);
            }
        });
        menAlun.add(MenuConsultarAluno);
        menAlun.add(jSeparator1);

        menAlunCadNotas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menAlunCadNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/newUser.png"))); // NOI18N
        menAlunCadNotas.setText("Gerenciar Notas");
        menAlunCadNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menAlunCadNotasActionPerformed(evt);
            }
        });
        menAlun.add(menAlunCadNotas);
        menAlun.add(jSeparator2);

        menAlunFreq.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menAlunFreq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/newUser.png"))); // NOI18N
        menAlunFreq.setText("Gerenciar Frequências");
        menAlunFreq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menAlunFreqActionPerformed(evt);
            }
        });
        menAlun.add(menAlunFreq);

        menListaFrequencia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menListaFrequencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/print.png"))); // NOI18N
        menListaFrequencia.setText("Lista de Frequências");
        menListaFrequencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menListaFrequenciaActionPerformed(evt);
            }
        });
        menAlun.add(menListaFrequencia);

        Menu.add(menAlun);

        menProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/3289566_assistant_educator_professor_showing_teacher_icon.png"))); // NOI18N
        menProfessor.setText("Professor");
        menProfessor.setEnabled(false);
        menProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menProfessorActionPerformed(evt);
            }
        });

        jMenuItem32.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/newUser.png"))); // NOI18N
        jMenuItem32.setText("Cadastrar");
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
        menProfessor.add(jMenuItem32);

        jMenuItem34.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/asdf.png"))); // NOI18N
        jMenuItem34.setText("Consultar/Alterar");
        jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem34ActionPerformed(evt);
            }
        });
        menProfessor.add(jMenuItem34);

        Menu.add(menProfessor);

        menSala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/1564508_home_main_room_estate_property_icon.png"))); // NOI18N
        menSala.setText("Sala");
        menSala.setEnabled(false);

        jMenuItem36.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/newUser.png"))); // NOI18N
        jMenuItem36.setText("Cadastrar");
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        menSala.add(jMenuItem36);

        jMenuItem38.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/asdf.png"))); // NOI18N
        jMenuItem38.setText("Consultar / Alterar");
        jMenuItem38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem38ActionPerformed(evt);
            }
        });
        menSala.add(jMenuItem38);

        Menu.add(menSala);

        menCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/9055078_bxs_book_icon.png"))); // NOI18N
        menCurso.setText("Disciplina");
        menCurso.setEnabled(false);

        jMenuItem40.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/newUser.png"))); // NOI18N
        jMenuItem40.setText("Cadastrar");
        jMenuItem40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem40ActionPerformed(evt);
            }
        });
        menCurso.add(jMenuItem40);

        jMenuItem39.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/asdf.png"))); // NOI18N
        jMenuItem39.setText("Consultar / Alterar");
        jMenuItem39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem39ActionPerformed(evt);
            }
        });
        menCurso.add(jMenuItem39);

        Menu.add(menCurso);

        menTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/class10469869_business_presentation_presenter_instructor_speech_icon.png"))); // NOI18N
        menTurma.setText("Turma");
        menTurma.setEnabled(false);

        jMenuItem44.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/newUser.png"))); // NOI18N
        jMenuItem44.setText("Cadastrar");
        jMenuItem44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem44ActionPerformed(evt);
            }
        });
        menTurma.add(jMenuItem44);

        jMenuItem41.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/asdf.png"))); // NOI18N
        jMenuItem41.setText("Consultar / Alterar");
        jMenuItem41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem41ActionPerformed(evt);
            }
        });
        menTurma.add(jMenuItem41);

        Menu.add(menTurma);

        menAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/3017955_examination_inquiry_interrogation_investigation_poll_icon.png"))); // NOI18N
        menAjuda.setText("Ajuda");

        jMenuItem30.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/about.png"))); // NOI18N
        jMenuItem30.setText("Sobre");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        menAjuda.add(jMenuItem30);

        Menu.add(menAjuda);

        menOpcoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/3017931_categories_class_division_group_list_icon.png"))); // NOI18N
        menOpcoes.setText("Opções");

        jMenuItem31.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pim/icones/exit.png"))); // NOI18N
        jMenuItem31.setText("Sair");
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        menOpcoes.add(jMenuItem31);

        Menu.add(menOpcoes);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsuario)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 483, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktop)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1065, 678));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    }//GEN-LAST:event_formWindowActivated

//GEN-FIRST:event_jMenuItem31ActionPerformed
    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        
    }
//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        TelaSobre sobre = new TelaSobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem41ActionPerformed
        TelaConsultaTurma ConsultTurma = new TelaConsultaTurma();
        ConsultTurma.setVisible(true);
        desktop.add(ConsultTurma);
    }//GEN-LAST:event_jMenuItem41ActionPerformed

    private void jMenuItem44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem44ActionPerformed
        TelaCadastroTurma CadTurma = new TelaCadastroTurma();
        CadTurma.setVisible(true);
        desktop.add(CadTurma);
    }//GEN-LAST:event_jMenuItem44ActionPerformed

    private void jMenuItem39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem39ActionPerformed
        TelaConsultCurso ConsultCurso = new TelaConsultCurso();
        ConsultCurso.setVisible(true);
        desktop.add(ConsultCurso);
    }//GEN-LAST:event_jMenuItem39ActionPerformed

    private void jMenuItem40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem40ActionPerformed
        TelaCadastrarCurso CadastrarCurso = new TelaCadastrarCurso();
        CadastrarCurso.setVisible(true);
        desktop.add(CadastrarCurso);
    }//GEN-LAST:event_jMenuItem40ActionPerformed

    private void jMenuItem38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem38ActionPerformed
        TelaConsultaSala ConsultaSala = new TelaConsultaSala();
        ConsultaSala.setVisible(true);
        desktop.add(ConsultaSala);
    }//GEN-LAST:event_jMenuItem38ActionPerformed

    private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36ActionPerformed
        TelaCadastroSala CadastroSala = new TelaCadastroSala();
        CadastroSala.setVisible(true);
        desktop.add(CadastroSala);
    }//GEN-LAST:event_jMenuItem36ActionPerformed

    private void menProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menProfessorActionPerformed

    }//GEN-LAST:event_menProfessorActionPerformed

    private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem34ActionPerformed
        TelaConsultaProfessor cadastrProfessor = new TelaConsultaProfessor();
        cadastrProfessor.setVisible(true);
        desktop.add(cadastrProfessor);
    }//GEN-LAST:event_jMenuItem34ActionPerformed

    private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem32ActionPerformed
        TelaCadastroProfessor cadastroProfessor = new TelaCadastroProfessor();
        cadastroProfessor.setVisible(true);
        desktop.add(cadastroProfessor);
    }//GEN-LAST:event_jMenuItem32ActionPerformed

    private void menAlunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menAlunActionPerformed

    }//GEN-LAST:event_menAlunActionPerformed

    private void menAlunFreqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menAlunFreqActionPerformed
        TelaGerenciarFrequencia gerenciarFrequencia = new TelaGerenciarFrequencia();
        gerenciarFrequencia.setVisible(true);
        desktop.add(gerenciarFrequencia);
    }//GEN-LAST:event_menAlunFreqActionPerformed

    private void menAlunCadNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menAlunCadNotasActionPerformed
        TelaGerenciarNotas gerenciarNotas = new TelaGerenciarNotas();
        gerenciarNotas.setVisible(true);
        desktop.add(gerenciarNotas);
    }//GEN-LAST:event_menAlunCadNotasActionPerformed

    private void MenuConsultarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuConsultarAlunoActionPerformed
        TelaConsultaAluno consultarAluno = new TelaConsultaAluno();
        consultarAluno.setVisible(true);
        desktop.add(consultarAluno);
    }//GEN-LAST:event_MenuConsultarAlunoActionPerformed

    private void MenuCadastrarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastrarAlunoActionPerformed
        TelaCadastroAluno cadastroAluno = new TelaCadastroAluno();
        cadastroAluno.setVisible(true);
        desktop.add(cadastroAluno);
    }//GEN-LAST:event_MenuCadastrarAlunoActionPerformed

    private void menUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menUsuarioActionPerformed

    private void menUsuRemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menUsuRemActionPerformed
        TelaDeleteUsuario deleteUsuario = new TelaDeleteUsuario();
        deleteUsuario.setVisible(true);
        desktop.add(deleteUsuario);
    }//GEN-LAST:event_menUsuRemActionPerformed

    private void menUsuAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menUsuAltActionPerformed
        TelaConsultaUsuario consultUsuario = new TelaConsultaUsuario();
        consultUsuario.setVisible(true);
        desktop.add(consultUsuario);
    }//GEN-LAST:event_menUsuAltActionPerformed

    private void menUsuCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menUsuCadActionPerformed
        TelaUsuario usuario = new TelaUsuario();
        usuario.setVisible(true);
        desktop.add(usuario);
    }//GEN-LAST:event_menUsuCadActionPerformed

    private void menListaFrequenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menListaFrequenciaActionPerformed
        TelaListadeFrequencia ListFrequencia = new TelaListadeFrequencia();
        ListFrequencia.setVisible(true);
        desktop.add(ListFrequencia);
    }//GEN-LAST:event_menListaFrequenciaActionPerformed

//Metodo 'Main' responsavel por 'INICIAR'
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Menu;
    public static javax.swing.JMenuItem MenuCadastrarAluno;
    public static javax.swing.JMenuItem MenuConsultarAluno;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem41;
    private javax.swing.JMenuItem jMenuItem44;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu menAjuda;
    public static javax.swing.JMenu menAlun;
    private javax.swing.JMenuItem menAlunCadNotas;
    private javax.swing.JMenuItem menAlunFreq;
    public static javax.swing.JMenu menCurso;
    private javax.swing.JMenuItem menListaFrequencia;
    private javax.swing.JMenu menOpcoes;
    public static javax.swing.JMenu menProfessor;
    public static javax.swing.JMenu menSala;
    public static javax.swing.JMenu menTurma;
    private javax.swing.JMenuItem menUsuAlt;
    private javax.swing.JMenuItem menUsuCad;
    private javax.swing.JMenuItem menUsuRem;
    public static javax.swing.JMenu menUsuario;
    // End of variables declaration//GEN-END:variables
}

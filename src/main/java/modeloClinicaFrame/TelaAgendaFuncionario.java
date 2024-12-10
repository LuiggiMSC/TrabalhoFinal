/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package modeloClinicaFrame;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import modeloClinica.Agendamento;
import modeloClinica.Cliente;
import modeloClinica.Funcionario;
import modeloClinica.Servico;
import modeloClinica.dao.AgendaRepositorioJPA;
import modeloClinica.dao.PessoaRepositorioJPA;
import modeloClinica.dao.ServicoRepositorioJPA;

/**
 *
 * @author ggbra
 */

public class TelaAgendaFuncionario extends javax.swing.JDialog {

    private Funcionario funcionarioAgenda;
    AgendaRepositorioJPA jpa;
    PessoaRepositorioJPA pessoaRepository;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
    /**
     * Creates new form TelaAgendaFuncionario
     */
    public TelaAgendaFuncionario(java.awt.Frame parent, boolean modal, Funcionario funcionario) {
        super(parent, modal);
        initComponents();
        this.funcionarioAgenda = funcionario;
        jpa = new AgendaRepositorioJPA();
        this.carregarDadosNaTabela();
        pessoaRepository = new PessoaRepositorioJPA();
        this.popularServicosCadastrados();
        this.popularClientesCadastrados();
    }

    private TelaAgendaFuncionario(JFrame jFrame, boolean b) {
         jpa = new AgendaRepositorioJPA();
         this.carregarDadosNaTabela();
         pessoaRepository = new PessoaRepositorioJPA();
         this.popularServicosCadastrados();
         this.popularClientesCadastrados();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        lblTitulo1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAgenda = new javax.swing.JTable();
        pnlFuncionario = new javax.swing.JPanel();
        lblBuscaNome3 = new javax.swing.JLabel();
        cmbServico = new javax.swing.JComboBox<>();
        lblBuscaNome = new javax.swing.JLabel();
        areaListagem = new javax.swing.JPanel();
        cmbCliente = new javax.swing.JComboBox<>();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitulo1.setText(" Agenda Funcionario:");

        tblAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cliente", "Serviço", "Data", "Horário"
            }
        ));
        tblAgenda.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tblAgenda);

        javax.swing.GroupLayout pnlFuncionarioLayout = new javax.swing.GroupLayout(pnlFuncionario);
        pnlFuncionario.setLayout(pnlFuncionarioLayout);
        pnlFuncionarioLayout.setHorizontalGroup(
            pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        pnlFuncionarioLayout.setVerticalGroup(
            pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        lblBuscaNome3.setText("Serviço:");

        cmbServico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbServicoItemStateChanged(evt);
            }
        });

        lblBuscaNome.setText("Cliente:");

        javax.swing.GroupLayout areaListagemLayout = new javax.swing.GroupLayout(areaListagem);
        areaListagem.setLayout(areaListagemLayout);
        areaListagemLayout.setHorizontalGroup(
            areaListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        areaListagemLayout.setVerticalGroup(
            areaListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        cmbCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClienteItemStateChanged(evt);
            }
        });
        cmbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblBuscaNome)
                                            .addComponent(lblBuscaNome3))
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbServico, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(areaListagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(btnVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblTitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(areaListagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBuscaNome, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscaNome3))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVoltar)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbClienteActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void cmbServicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbServicoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            this.carregarDadosFiltro();
        }
    }//GEN-LAST:event_cmbServicoItemStateChanged

    private void cmbClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClienteItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            this.carregarDadosFiltro();
        }
    }//GEN-LAST:event_cmbClienteItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAgendaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAgendaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAgendaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAgendaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaAgendaFuncionario dialog = new TelaAgendaFuncionario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private void carregarDadosNaTabela() {
        List<Agendamento> agendamentos = jpa.getAllAgendamentosByAgenda(funcionarioAgenda.getAgenda());

        
        DefaultTableModel model = (DefaultTableModel) tblAgenda.getModel();

        model.setRowCount(0);

        for (Agendamento agendamento : agendamentos) {
            Object[] dadosVeiculo = {
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                dateFormat.format(agendamento.getData()),
                timeFormat.format(agendamento.getData()),};
            model.addRow(dadosVeiculo);
        }

        tblAgenda.setModel(model);

        this.setSize(600, 400);
        this.setVisible(true);
    }

    private void carregarDadosFiltro() {
        jpa.conexaoAberta();

        Cliente cliente = (Cliente) cmbCliente.getSelectedItem();
        Servico servico = (Servico) cmbServico.getSelectedItem();

        if (cliente == null && servico == null) {
            this.carregarDadosNaTabela();
        } else {
            List<Agendamento> agendamentos = jpa.getAgendaFuncionarioFiltros(cliente, servico, funcionarioAgenda.getAgenda());
            DefaultTableModel model = (DefaultTableModel) tblAgenda.getModel();

            model.setRowCount(0);

            for (Agendamento agendamento : agendamentos) {
            Object[] dadosVeiculo = {
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                dateFormat.format(agendamento.getData()),
                timeFormat.format(agendamento.getData()),};
            model.addRow(dadosVeiculo);
        }
            tblAgenda.repaint();
        }
        jpa.fecharConexao();
    }

   private void popularClientesCadastrados() {
    try {
        PessoaRepositorioJPA pessoaRepositorioJPA = new PessoaRepositorioJPA();
        List<Cliente> clientes = pessoaRepositorioJPA.getAllClientes();
            if (clientes == null || clientes.isEmpty()) {
                System.err.println("Nenhum cliente encontrado para popular o JComboBox.");
                return;
            }

            DefaultComboBoxModel<Cliente> model = new DefaultComboBoxModel<>();
            model.addElement(null);

            for (Cliente cliente : clientes) {
                model.addElement(cliente);
            }

            cmbCliente.setModel(model);
            cmbCliente.setSelectedItem(null);
            
            cmbCliente.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                
                if (value instanceof Cliente) {
                    Cliente cliente = (Cliente) value;
                    setText(cliente.getNome()); 
                } else if (value == null) {
                    setText("Selecione um cliente"); 
                }
                
                return this;
            }
        });
        } catch (Exception e) {
            Logger.getLogger(TelaAgendamento.class.getName()).log(Level.SEVERE, null, e);
        }
    } 
    
    private void popularServicosCadastrados() {
    try {
        ServicoRepositorioJPA servicoRepositoryJPA = new ServicoRepositorioJPA();
        List<Servico> servicos = servicoRepositoryJPA.getAllServicos();
        
        DefaultComboBoxModel<Servico> model = new DefaultComboBoxModel<>();
        model.addElement(null);
        for (Servico servico : servicos) {
            model.addElement(servico);
           
        }

        cmbServico.setModel(model);
        cmbServico.setSelectedItem(null);
        
        cmbServico.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                
                if (value instanceof Servico) {
                    Servico servico = (Servico) value;
                    setText(servico.getDescricao()); 
                } else if (value == null) {
                    setText("Selecione um serviço"); 
                }
                
                return this;
            }
        });
    } catch (Exception e) {
        Logger.getLogger(TelaAgendamento.class.getName()).log(Level.SEVERE, null, e);
    }
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaListagem;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<Cliente> cmbCliente;
    private javax.swing.JComboBox<Servico> cmbServico;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBuscaNome;
    private javax.swing.JLabel lblBuscaNome3;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JPanel pnlFuncionario;
    private javax.swing.JTable tblAgenda;
    // End of variables declaration//GEN-END:variables

    public Funcionario getFuncionarioAgenda() {
        return funcionarioAgenda;
    }

    public void setFuncionarioAgenda(Funcionario funcionarioAgenda) {
        this.funcionarioAgenda = funcionarioAgenda;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package modeloClinicaFrame;


import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import modeloClinica.Agenda;
import modeloClinica.Agendamento;
import modeloClinica.Cliente;
import modeloClinica.Servico;
import modeloClinica.dao.AgendaRepositorioJPA;
import modeloClinica.dao.PessoaRepositorioJPA;
import modeloClinica.dao.ServicoRepositorioJPA;


public class TelaCadastroAgendamento extends javax.swing.JDialog {
    private Agendamento a;
    AgendaRepositorioJPA jpa;
    PessoaRepositorioJPA pessoaRepositorioJPA;
    ServicoRepositorioJPA servicoRepositoryJPA;
    List<Cliente> clientes;
    List<Servico> servicos;
    List<Agenda> agendas;
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    /**
     * Creates new form TelaCadastroPessoa
     * @param parent
     * @param modal
     */
    public TelaCadastroAgendamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jpa = new AgendaRepositorioJPA();
        pessoaRepositorioJPA = new PessoaRepositorioJPA();
        servicoRepositoryJPA = new ServicoRepositorioJPA();
        clientes = new ArrayList<>();
        servicos = new ArrayList<>();
        agendas = new ArrayList<>();
        this.popularClientesCadastrados();
        this.popularAgendasFuncionarios();
        this.popularServicosCadastrados();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlFuncionario = new javax.swing.JPanel();
        lblCliente = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();
        lblServico = new javax.swing.JLabel();
        cmbServico = new javax.swing.JComboBox<>();
        lblData = new javax.swing.JLabel();
        jftData = new javax.swing.JFormattedTextField();
        lblData1 = new javax.swing.JLabel();
        cmbAgenda = new javax.swing.JComboBox<>();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("SAIR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblCliente.setText("Cliente: ");

        cmbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteActionPerformed(evt);
            }
        });

        lblServico.setText("Descrição:");

        lblData.setText("dd/MM/yyyy , hh:mm:ss");

        javax.swing.GroupLayout pnlFuncionarioLayout = new javax.swing.GroupLayout(pnlFuncionario);
        pnlFuncionario.setLayout(pnlFuncionarioLayout);
        pnlFuncionarioLayout.setHorizontalGroup(
            pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlFuncionarioLayout.createSequentialGroup()
                        .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(cmbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlFuncionarioLayout.createSequentialGroup()
                        .addComponent(lblData)
                        .addGap(18, 18, 18)
                        .addComponent(jftData, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFuncionarioLayout.createSequentialGroup()
                        .addComponent(lblServico, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbServico, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pnlFuncionarioLayout.setVerticalGroup(
            pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblServico)
                    .addComponent(cmbServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData)
                    .addComponent(jftData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblData1.setText("Atendimento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblData1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData1)
                    .addComponent(cmbAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

       if(a == null){
           a = new Agendamento();
       }   
       
       a.setCliente((Cliente) cmbCliente.getModel().getSelectedItem());
       
       Date data;
        try {
            data = dateFormat.parse(jftData.getText());
            a.setData(data);
        } catch (ParseException ex) {
            Logger.getLogger(TelaCadastroAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       a.setServico((Servico) cmbServico.getModel().getSelectedItem());
       a.setAgenda((Agenda) cmbAgenda.getModel().getSelectedItem());
           
       jpa.conexaoAberta();
       
        try {
            jpa.persist(a);
            
        } catch (Exception ex) {
            Logger.getLogger(TelaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        jpa.fecharConexao();
       
       dispose();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbClienteActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCadastroAgendamento dialog = new TelaCadastroAgendamento(new javax.swing.JFrame(), true);
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

    private void popularAgendasFuncionarios(){
        try {
            
        agendas = jpa.getAllAgenda();
   
        DefaultComboBoxModel<Agenda> model = new DefaultComboBoxModel<>();
        model.addElement(null);

            
        for (Agenda a : agendas){
             model.addElement(a);
        }
        
        cmbAgenda.setModel(model);
        cmbAgenda.setSelectedItem(null);
            
          cmbAgenda.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                
                if (value instanceof Agenda) {
                    Agenda agenda = (Agenda) value;
                    setText(agenda.getFuncionario().getNome()); 
                } else if (value == null) {
                    setText("Selecione uma agenda"); 
                }
                
                return this;
            }
        });   
            
    } catch (Exception e) {
        Logger.getLogger(TelaAgendamento.class.getName()).log(Level.SEVERE, null, e);
    }
        
    }
    private void popularClientesCadastrados() {
    try {
        clientes = pessoaRepositorioJPA.getAllClientes();
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
        servicos = servicoRepositoryJPA.getAllServicos();
        
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Agenda> cmbAgenda;
    private javax.swing.JComboBox<Cliente> cmbCliente;
    private javax.swing.JComboBox<Servico> cmbServico;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jftData;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblData1;
    private javax.swing.JLabel lblServico;
    private javax.swing.JPanel pnlFuncionario;
    // End of variables declaration//GEN-END:variables

    public Agendamento getA() {
        return a;
    }

    public void setA(Agendamento a) {
        this.a = a;
        
        cmbAgenda.setSelectedItem(a.getAgenda());
        cmbCliente.setSelectedItem(a.getCliente());
        cmbServico.setSelectedItem(a.getServico());
        
        jftData.setValue(a.getData());
    }
}

package br.com.view;

import br.com.jdbc.CrudClientes;
import br.com.model.Cliente;
import javax.swing.JOptionPane;

public class AlterandoTipoPlano extends javax.swing.JFrame {

    CrudClientes crudClientes;
    Cliente cliente;
    
    public AlterandoTipoPlano(int ID,String nome,String tipoPlano) {
        this.cliente = new Cliente();
        this.crudClientes = new CrudClientes();
        cliente.setId(ID);
        cliente.setNome(nome);
        cliente.setTipo_plano(tipoPlano);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxPlano = new javax.swing.JComboBox<>();

        setTitle("Alterando plano");
        setResizable(false);

        jButton1.setText("Alterar plano");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel1.setText("Alterando plano ("+cliente.getTipo_plano()+") de "+cliente.getNome()+" para:");

        jComboBoxPlano.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "mensal", "bimestral", "semestral", "anual" }));
        jComboBoxPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPlanoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBoxPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jComboBoxPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(31, 31, 31))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPlanoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPlanoActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       
        if(crudClientes.alterarTipoPlano(cliente.getId(), jComboBoxPlano.getSelectedItem().toString()) == true){
            JOptionPane.showConfirmDialog(null, cliente.getNome()+" teve o plano alterado com sucesso!!");
            this.dispose();
        }else{
             JOptionPane.showConfirmDialog(null, "Erro ao alterar plano de "+cliente.getNome());
        }
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public javax.swing.JComboBox<String> jComboBoxPlano;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

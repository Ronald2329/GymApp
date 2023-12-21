package br.com.view;

import br.com.jdbc.CrudClientes;
import br.com.model.Cliente;
import javax.swing.JOptionPane;

public class AlterandoMatricula extends javax.swing.JFrame {
    
    CrudClientes crudClientes;
    Cliente cliente;
    
    public AlterandoMatricula(int ID,String nome,String matricula) {
        this.cliente = new Cliente();
        this.crudClientes = new CrudClientes();
        cliente.setId(ID);
        cliente.setNome(nome);
        cliente.setMatricula(matricula);
         initComponents();
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxMatricula = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setTitle("Alterando matrícula");
        setResizable(false);

        jLabel1.setText("Alterando a matrícula("+cliente.getMatricula()+") de "+cliente.getNome());

        jComboBoxMatricula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "matriculado", "desmatriculado", "trancado" }));

        jButton1.setText("Alterar matrícula");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxMatricula, 0, 272, Short.MAX_VALUE))
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jComboBoxMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
         if(crudClientes.alterarStatusMatricula(cliente.getId(), jComboBoxMatricula.getSelectedItem().toString()) == true){
            JOptionPane.showConfirmDialog(null, cliente.getNome()+" teve o status da matrícula alterada com sucesso!!");
            this.dispose();
        }else{
             JOptionPane.showConfirmDialog(null, "Erro ao alterar o status de matrícula de "+cliente.getNome());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxMatricula;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

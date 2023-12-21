package br.com.view;

import br.com.jdbc.CrudClientes;
import br.com.jdbc.CrudTreinos;
import br.com.model.Cliente;
import br.com.model.Treino;
import javax.swing.JOptionPane;

public class AdicionandoTreino extends javax.swing.JFrame {

    CrudTreinos crudTreinos;
    CrudClientes crudClientes;
    Cliente cliente;
    Treino treino;
    
    public AdicionandoTreino(int id_cliente,String dia) {
        this.crudTreinos = new CrudTreinos();
        this.cliente = new Cliente();
        this.treino = new Treino();
        this.crudClientes = new CrudClientes();
        
        treino.setDia(dia);
        cliente.setId(id_cliente);
        cliente.setNome(crudClientes.descobrirNomeDeCliente(id_cliente));
        
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNomeExercicio = new javax.swing.JTextField();
        jTextFieldSeries = new javax.swing.JTextField();
        jTextFieldRepeticoes = new javax.swing.JTextField();
        jTextFieldDescanso = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        setTitle("Adicionando um novo exercício em "+treino.getDia()+" para "+cliente.getNome());
        setResizable(false);

        jLabel1.setText("Nome do exercício:");

        jLabel2.setText("Quantidade de séries:");

        jLabel3.setText("Quantidade de repetições por série:");

        jLabel4.setText("Tempo de descanso(em segundos):");

        jButton1.setText("Adicionar novo exercício para "+cliente.getNome());
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
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDescanso, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSeries, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldRepeticoes, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNomeExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldSeries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldRepeticoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldDescanso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(34, 34, 34))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String nomeExercício = jTextFieldNomeExercicio.getText();
        
        if(nomeExercício.length() > 0){
            try{
                int series = Integer.parseInt(jTextFieldSeries.getText());
               
                try{
                     int repeticoes = Integer.parseInt(jTextFieldRepeticoes.getText());
                    
                        try{
                             int descanso = Integer.parseInt(jTextFieldDescanso.getText());
                             
                             if(crudTreinos.adicionarNovoTreino(treino.getDia(), cliente.getId(), nomeExercício, series, repeticoes, descanso) == true){
                                 JOptionPane.showConfirmDialog(null, "O exercício foi adicionado com sucesso!!");
                             }else{
                                 JOptionPane.showConfirmDialog(null, "Erro ao tenrar adicionar o exercício!!");
                             }
                             
                        }catch(Exception e){
                            JOptionPane.showConfirmDialog(null,"Formato de descanso é apenas números!!");
                        }
                }catch(Exception e){
                    JOptionPane.showConfirmDialog(null, "Formato de repetições é apenas números!!");
                }
            }catch(Exception e){
                JOptionPane.showConfirmDialog(null, "Formato de séries é apenas números!!");
            }
        }else{
            JOptionPane.showConfirmDialog(null, "O nome do exercício não pode ficar vazio!!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextFieldDescanso;
    private javax.swing.JTextField jTextFieldNomeExercicio;
    private javax.swing.JTextField jTextFieldRepeticoes;
    private javax.swing.JTextField jTextFieldSeries;
    // End of variables declaration//GEN-END:variables
}

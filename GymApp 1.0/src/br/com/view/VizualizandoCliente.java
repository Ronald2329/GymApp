package br.com.view;

import br.com.jdbc.CrudClientes;
import br.com.jdbc.CrudPagamentos;
import br.com.jdbc.CrudTreinos;
import br.com.model.Cliente;
import br.com.model.Pagamento;
import br.com.model.Treino;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VizualizandoCliente extends javax.swing.JFrame {
    
    Cliente cliente;
    CrudClientes crudClientes;
    CrudPagamentos crudPagamentos;
    CrudTreinos crudTreinos;
    Treino treino;
    
    void carregandoTreinosDomingo(){
            List<Treino> treinos = crudTreinos.consultarTreinoDiaExpecifico("domingo", cliente.getId());

            DefaultTableModel model = (DefaultTableModel) jTableDomingo.getModel();

            // Limpar todas as linhas da tabela
            model.setRowCount(0);

            for (Treino treino : treinos) {

                model.addRow(new Object[]{
                        treino.getId_treino(),
                        treino.getNomeExercicio(),
                        treino.getQuantidadeSeries(),
                        treino.getRepeticoes(),
                        treino.getTempoDescanso(),
                });
        }
    }
    
    void carregandoTreinosSegunda(){
        List<Treino> treinos = crudTreinos.consultarTreinoDiaExpecifico("segunda", cliente.getId());

            DefaultTableModel model = (DefaultTableModel) jTableSegunda.getModel();

            // Limpar todas as linhas da tabela
            model.setRowCount(0);

            for (Treino treino : treinos) {

                model.addRow(new Object[]{
                        treino.getId_treino(),
                        treino.getNomeExercicio(),
                        treino.getQuantidadeSeries(),
                        treino.getRepeticoes(),
                        treino.getTempoDescanso(),
                });
        }
    }
    
    void carregandoTreinosTerca(){
        List<Treino> treinos = crudTreinos.consultarTreinoDiaExpecifico("terca", cliente.getId());

            DefaultTableModel model = (DefaultTableModel) jTableTerca.getModel();

            // Limpar todas as linhas da tabela
            model.setRowCount(0);

            for (Treino treino : treinos) {

                model.addRow(new Object[]{
                        treino.getId_treino(),
                        treino.getNomeExercicio(),
                        treino.getQuantidadeSeries(),
                        treino.getRepeticoes(),
                        treino.getTempoDescanso(),
                });
        }
    }
    
    void carregandoTreinosQuarta(){
        List<Treino> treinos = crudTreinos.consultarTreinoDiaExpecifico("quarta", cliente.getId());

            DefaultTableModel model = (DefaultTableModel) jTableQuarta.getModel();

            // Limpar todas as linhas da tabela
            model.setRowCount(0);

            for (Treino treino : treinos) {

                model.addRow(new Object[]{
                        treino.getId_treino(),
                        treino.getNomeExercicio(),
                        treino.getQuantidadeSeries(),
                        treino.getRepeticoes(),
                        treino.getTempoDescanso(),
                });
        }
    }
    
    void carregandoTreinosQuinta(){
        List<Treino> treinos = crudTreinos.consultarTreinoDiaExpecifico("quinta", cliente.getId());

            DefaultTableModel model = (DefaultTableModel) jTableQuinta.getModel();

            // Limpar todas as linhas da tabela
            model.setRowCount(0);

            for (Treino treino : treinos) {

                model.addRow(new Object[]{
                        treino.getId_treino(),
                        treino.getNomeExercicio(),
                        treino.getQuantidadeSeries(),
                        treino.getRepeticoes(),
                        treino.getTempoDescanso(),
                });
        }
    }
    
    void carregandoTreinosSexta(){
        List<Treino> treinos = crudTreinos.consultarTreinoDiaExpecifico("sexta", cliente.getId());

            DefaultTableModel model = (DefaultTableModel) jTableSexta.getModel();

            // Limpar todas as linhas da tabela
            model.setRowCount(0);

            for (Treino treino : treinos) {

                model.addRow(new Object[]{
                        treino.getId_treino(),
                        treino.getNomeExercicio(),
                        treino.getQuantidadeSeries(),
                        treino.getRepeticoes(),
                        treino.getTempoDescanso(),
                });
        }
    }
    
    void carregandoTreinosSabado(){
        List<Treino> treinos = crudTreinos.consultarTreinoDiaExpecifico("Sabado", cliente.getId());

            DefaultTableModel model = (DefaultTableModel) jTableSabado.getModel();

            // Limpar todas as linhas da tabela
            model.setRowCount(0);

            for (Treino treino : treinos) {

                model.addRow(new Object[]{
                        treino.getId_treino(),
                        treino.getNomeExercicio(),
                        treino.getQuantidadeSeries(),
                        treino.getRepeticoes(),
                        treino.getTempoDescanso(),
                });
        }
    }         
        
    public VizualizandoCliente(int ID) {     
      
       this.crudClientes = new CrudClientes();
       this.cliente = new Cliente();
       cliente.setId(ID);
       this.crudPagamentos = new CrudPagamentos();
       this.crudTreinos = new CrudTreinos();
       this.treino = new Treino();
       cliente.setNome(crudClientes.descobrirNomeDeCliente(ID));//Setando nome do cliente para aparecer no título da aba
       
        initComponents();
        
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Chama os dados do cliente e de seus respectivos pagamentos
             scheduler.scheduleAtFixedRate(() -> {
             carregarDadosCliente();
             carregarPagamentosCliente(cliente.getId());
             carregandoTreinosDomingo();
                carregandoTreinosSegunda();
                carregandoTreinosTerca();
                carregandoTreinosQuarta();
                carregandoTreinosQuinta();
                carregandoTreinosSexta();
                carregandoTreinosSabado();
        }, 0, 2, TimeUnit.SECONDS);
        
       
    }
    
 private void carregarDadosCliente() {
        // Obtém os dados específicos do cliente
        List<Cliente> clientes = crudClientes.consultarClienteExpecifico(cliente.getId());

        // Cria um modelo de lista
        DefaultListModel<String> listModel = new DefaultListModel<>();

        // Adiciona os dados do cliente ao modelo de lista
        for (Cliente c : clientes) {
            
            listModel.addElement("ID " + c.getId());
            listModel.addElement("Nome: " + c.getNome());
            listModel.addElement("Idade: " + c.getIdade());
            listModel.addElement("Email: " + c.getEmail());
            listModel.addElement("Telefone: " + c.getTelefone());
            listModel.addElement("Tipo de Plano: " + c.getTipo_plano());
            listModel.addElement("Primeira Matrícula: " + c.getUltima_alteracao());
            listModel.addElement("Sexo: " + c.getSexo());
            listModel.addElement("Matrícula Status: " + c.getMatricula());
            
            //Setando os dados em memória:
            cliente.setNome(c.getNome());
            cliente.setIdade(c.getIdade());
            cliente.setEmail(c.getEmail());
            cliente.setTelefone(c.getTelefone());
            cliente.setTipo_plano(c.getTipo_plano());   
            cliente.setSexo(c.getSexo());
            cliente.setMatricula(c.getMatricula());
        }

        // Define o modelo de lista na JList
        jListDadosCliente.setModel(listModel);
    }
 
 void carregarPagamentosCliente(int id_cliente){
   List<Pagamento> pagamentos = crudPagamentos.consultarTodosOsPagamentosDoCliente(id_cliente);

         DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
     
        // Limpar todas as linhas da tabela
        model.setRowCount(0);

         for (Pagamento pagamento : pagamentos){
             
       
             model.addRow(new Object[]{
                     pagamento.getIdPagamento(),
                     pagamento.getData(),
                     pagamento.getValor(),
             });
         }   
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListDadosCliente = new javax.swing.JList<>();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDomingo = new javax.swing.JTable();
        jButtonDomingo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableSegunda = new javax.swing.JTable();
        jButtonSegunda = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableTerca = new javax.swing.JTable();
        jButtonTerca = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButtonQuarta = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTableQuarta = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableQuinta = new javax.swing.JTable();
        jButtonQuinta = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTableSexta = new javax.swing.JTable();
        jButtonSexta = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTableSabado = new javax.swing.JTable();
        jButtonSabado = new javax.swing.JButton();

        setTitle("Vizualizando "+cliente.getNome());
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID de pagamento", "Data ", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton1.setText("Adicionar pagamento");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(431, 431, 431))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Histórico de pagamentos", jPanel3);

        jListDadosCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListDadosClienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jListDadosCliente);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        jTabbedPane1.addTab("Informações pessoais", jPanel4);

        jTableDomingo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do exercício", "Séries", "Repetições", "Descanso(segundos)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableDomingo);

        jButtonDomingo.setText("Adicionar exercícios para Domingo");
        jButtonDomingo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDomingoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(460, 460, 460)
                .addComponent(jButtonDomingo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(424, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButtonDomingo)
                .addGap(17, 17, 17))
        );

        jTabbedPane2.addTab("Domingo", jPanel1);

        jTableSegunda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do exercício", "Séries", "Repetições", "Descanso(segundos)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTableSegunda);

        jButtonSegunda.setText("Adicionar exercícios para Segunda-feira");
        jButtonSegunda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSegundaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1111, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(460, 460, 460)
                .addComponent(jButtonSegunda, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButtonSegunda)
                .addGap(17, 17, 17))
        );

        jTabbedPane2.addTab("Segunda-feira", jPanel2);

        jTableTerca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do exercício", "Séries", "Repetições", "Descanso(segundos)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTableTerca);

        jButtonTerca.setText("Adicionar exercícios para Terça-feira");
        jButtonTerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTercaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(460, 460, 460)
                .addComponent(jButtonTerca, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(424, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButtonTerca)
                .addGap(17, 17, 17))
        );

        jTabbedPane2.addTab("Terça-feira", jPanel5);

        jButtonQuarta.setText("Adicionar exercícios para Quarta-feira");
        jButtonQuarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuartaActionPerformed(evt);
            }
        });

        jTableQuarta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do exercício", "Séries", "Repetições", "Descanso(segundos)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(jTableQuarta);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(460, 460, 460)
                .addComponent(jButtonQuarta, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(424, Short.MAX_VALUE))
            .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButtonQuarta)
                .addGap(17, 17, 17))
        );

        jTabbedPane2.addTab("Quarta-feira", jPanel6);

        jTableQuinta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do exercício", "Séries", "Repetições", "Descanso(segundos)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(jTableQuinta);

        jButtonQuinta.setText("Adicionar exercícios para Quinta-feira");
        jButtonQuinta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuintaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(460, 460, 460)
                .addComponent(jButtonQuinta, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(424, Short.MAX_VALUE))
            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButtonQuinta)
                .addGap(17, 17, 17))
        );

        jTabbedPane2.addTab("Quinta-feira", jPanel7);

        jTableSexta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do exercício", "Séries", "Repetições", "Descanso(segundos)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(jTableSexta);

        jButtonSexta.setText("Adicionar exercícios para Sexta-feira");
        jButtonSexta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSextaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(460, 460, 460)
                .addComponent(jButtonSexta, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(424, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButtonSexta)
                .addGap(17, 17, 17))
        );

        jTabbedPane2.addTab("Sexta-feira", jPanel8);

        jTableSabado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do exercício", "Séries", "Repetições", "Descanso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(jTableSabado);

        jButtonSabado.setText("Adicionar exercícios para Sábado");
        jButtonSabado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSabadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(460, 460, 460)
                .addComponent(jButtonSabado, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(424, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButtonSabado)
                .addGap(17, 17, 17))
        );

        jTabbedPane2.addTab("Sábado", jPanel9);

        jTabbedPane1.addTab("Treinos", jTabbedPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jListDadosClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListDadosClienteMouseClicked
     int selectedIndex = jListDadosCliente.getSelectedIndex();

// Verifica se o clique não foi no ID (índice 0) e na primeira matrícula (índice 6)
if (selectedIndex != 0 && selectedIndex != 6) {
    // Redireciona para o JFrame correspondente com base no índice clicado
    switch (selectedIndex) {
        case 1:
           
            String novoNome = JOptionPane.showInputDialog(null, "Altere o nome de (" + cliente.getNome() + ") para:\n");
            
            while(novoNome.length() == 0){
                 novoNome = JOptionPane.showInputDialog(null, "Altere o nome de (" + cliente.getNome() + ") para:\n");
            }
            
            if(crudClientes.alterarNome(cliente.getId(), novoNome) == true){
                JOptionPane.showConfirmDialog(null, cliente.getNome()+" teve o nome alterado com sucesso!!"); 
                
            }else{
                 JOptionPane.showConfirmDialog(null, "erro ao ao alterar nome de "+cliente.getNome());
            }
            
            break;
        case 2:
            String novaIdade = JOptionPane.showInputDialog(null, "Altere a idade (" + cliente.getIdade() + ") de " + cliente.getNome() + " para:\n");
           
            while(novaIdade.length() == 0){
                 novaIdade = JOptionPane.showInputDialog(null, "Altere o nome de (" + cliente.getNome() + ") para:\n");
            }
            
            try{
                             
                if(crudClientes.alterarIdade(cliente.getId(),  Integer.parseInt(novaIdade)) == true){
                    JOptionPane.showConfirmDialog(null, cliente.getNome()+" teve o nome alterado com sucesso!!"); 
                   
                }else{
                     JOptionPane.showConfirmDialog(null, "erro ao ao alterar idade de "+cliente.getNome());
                }
            }catch(Exception e){
                JOptionPane.showConfirmDialog(null, "Idade inválida!!\nPor favor digite apenas números");
            }
            
            break;
        case 3:
            String novoEmail = JOptionPane.showInputDialog(null, "Altere o email (" + cliente.getEmail() + ") de " + cliente.getNome() + " para:\n");
           
             while(novoEmail.length() == 0){
                 novoEmail = JOptionPane.showInputDialog(null, "Altere o email (" + cliente.getEmail() + ") de " + cliente.getNome() + " para:\n");
            }
            
            if(crudClientes.alterarEmail(cliente.getId(), novoEmail) == true){
                JOptionPane.showConfirmDialog(null, cliente.getNome()+" teve o email alterado com sucesso!!"); 
               
            }else{
                 JOptionPane.showConfirmDialog(null, "Erro ao ao alterar email de "+cliente.getNome());
            }
            break;
        case 4:
            String novoTelefone = JOptionPane.showInputDialog(null, "Altere o telefone (" + cliente.getTelefone() + ") de " + cliente.getNome() + " para:\n");
            
            while(novoTelefone.length() == 0){
                 novoTelefone = JOptionPane.showInputDialog(null, "Altere o nome de (" + cliente.getNome() + ") para:\n");
            }
            
            try{
                             
                if(crudClientes.alterarTelefone(cliente.getId(),  Integer.parseInt(novoTelefone)) == true){
                    JOptionPane.showConfirmDialog(null, cliente.getNome()+" teve o telefone alterado com sucesso!!"); 
                   
                }else{
                     JOptionPane.showConfirmDialog(null, "Erro ao ao alterar telefone de "+cliente.getNome());
                }
            }catch(Exception e){
                JOptionPane.showConfirmDialog(null, "Idade inválida!!\nPor favor digite apenas números");
            }
            
            break;
        case 5:
            new AlterandoTipoPlano(cliente.getId(),cliente.getNome(),cliente.getTipo_plano()).setVisible(true);
            break;
        case 7:
            new AlterandoSexo(cliente.getId(),cliente.getNome(),cliente.getSexo()).setVisible(true);
            break;
        case 8:
            new AlterandoMatricula(cliente.getId(),cliente.getNome(),cliente.getMatricula()).setVisible(true);
            break;
    }
}
    }//GEN-LAST:event_jListDadosClienteMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new AdicionandoPagamento(cliente.getId()).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonSegundaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSegundaActionPerformed
        // TODO add your handling code here:
        new AdicionandoTreino(cliente.getId(), "segunda").setVisible(true);
    }//GEN-LAST:event_jButtonSegundaActionPerformed

    private void jButtonDomingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDomingoActionPerformed
        // TODO add your handling code here:
         new AdicionandoTreino(cliente.getId(), "domingo").setVisible(true);
    }//GEN-LAST:event_jButtonDomingoActionPerformed

    private void jButtonTercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTercaActionPerformed
        // TODO add your handling code here:
         new AdicionandoTreino(cliente.getId(), "terca").setVisible(true);
    }//GEN-LAST:event_jButtonTercaActionPerformed

    private void jButtonQuartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuartaActionPerformed
        // TODO add your handling code here:
         new AdicionandoTreino(cliente.getId(), "quarta").setVisible(true);
    }//GEN-LAST:event_jButtonQuartaActionPerformed

    private void jButtonQuintaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuintaActionPerformed
        // TODO add your handling code here:
         new AdicionandoTreino(cliente.getId(), "quinta").setVisible(true);
    }//GEN-LAST:event_jButtonQuintaActionPerformed

    private void jButtonSextaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSextaActionPerformed
        // TODO add your handling code here:
         new AdicionandoTreino(cliente.getId(), "sexta").setVisible(true);
    }//GEN-LAST:event_jButtonSextaActionPerformed

    private void jButtonSabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSabadoActionPerformed
        // TODO add your handling code here:
         new AdicionandoTreino(cliente.getId(), "sabado").setVisible(true);
    }//GEN-LAST:event_jButtonSabadoActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonDomingo;
    private javax.swing.JButton jButtonQuarta;
    private javax.swing.JButton jButtonQuinta;
    private javax.swing.JButton jButtonSabado;
    private javax.swing.JButton jButtonSegunda;
    private javax.swing.JButton jButtonSexta;
    private javax.swing.JButton jButtonTerca;
    private javax.swing.JList<String> jListDadosCliente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableDomingo;
    private javax.swing.JTable jTableQuarta;
    private javax.swing.JTable jTableQuinta;
    private javax.swing.JTable jTableSabado;
    private javax.swing.JTable jTableSegunda;
    private javax.swing.JTable jTableSexta;
    private javax.swing.JTable jTableTerca;
    // End of variables declaration//GEN-END:variables
}

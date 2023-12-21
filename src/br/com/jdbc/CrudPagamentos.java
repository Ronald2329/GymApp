package br.com.jdbc;

import br.com.dal.Conexao;
import br.com.model.Pagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrudPagamentos extends Conexao{
     
    Conexao conexao;
    Connection crud;
    Pagamento pagamento;
      
    public CrudPagamentos(){
       this.conexao = new Conexao();
         this.pagamento = new Pagamento();
    }

    public List<Pagamento> consultarTodosOsPagamentos() {
        List<Pagamento> pagamentos = new ArrayList<>();
            try (Connection c = conexao.obterConexao()) {
                this.crud = c;
                 String consultaSQL = "SELECT * FROM pagamentos";
                    try (PreparedStatement declaracao = crud.prepareStatement(consultaSQL)) {
                            try (ResultSet resultado = declaracao.executeQuery()) {
                            while (resultado.next()) {
                                Pagamento pagamento = new Pagamento();
                                    pagamento.setIdPagamento(Integer.parseInt(resultado.getString("id_pagamento")));
                                    pagamento.setIdCliente(Integer.parseInt(resultado.getString("id_cliente")));
                                    pagamento.setValor(Float.parseFloat(resultado.getString("valor")));
                                    pagamento.setData(resultado.getString("data_pagamento"));
                                    pagamentos.add(pagamento);
                                }
                            }
                        }
                    } catch (SQLException e) {
                        System.out.println("Erro ao consultar pagamentos: " + e.getMessage());
                    }
                return pagamentos;
        }
   
      public List<Pagamento> consultarTodosOsPagamentosDoCliente(int id_cliente) {
        List<Pagamento> pagamentos = new ArrayList<>();
            try (Connection c = conexao.obterConexao()) {
                this.crud = c;
                 String consultaSQL = "SELECT * FROM pagamentos WHERE id_cliente="+id_cliente;
                    try (PreparedStatement declaracao = crud.prepareStatement(consultaSQL)) {
                            try (ResultSet resultado = declaracao.executeQuery()) {
                            while (resultado.next()) {
                                Pagamento pagamento = new Pagamento();
                                    pagamento.setIdPagamento(Integer.parseInt(resultado.getString("id_pagamento")));
                                    pagamento.setValor(Float.parseFloat(resultado.getString("valor")));
                                    pagamento.setData(resultado.getString("data_pagamento"));
                                    pagamentos.add(pagamento);
                                }
                            }
                        }
                    } catch (SQLException e) {
                        System.out.println("Erro ao consultar pagamentos: " + e.getMessage());
                    }
                return pagamentos;
        }
   
    
    public boolean adicionarNovoPagamento(int id_cliente, int valor, String dataPagamento) {
    try (Connection c = conexao.obterConexao()) {
        this.crud = c;

        String consultaSQL = "INSERT INTO pagamentos (id_cliente,valor,data_pagamento) " +
                             "VALUES (?, ?, ?)";

        try (PreparedStatement declaracao = crud.prepareStatement(consultaSQL)) {
            declaracao.setInt(1, id_cliente);
            declaracao.setInt(2, valor);
            declaracao.setString(3,dataPagamento);
            
            int linhasAfetadas = declaracao.executeUpdate();

            return linhasAfetadas > 0 ? true : false;
        }
    } catch (SQLException e) {
        System.out.println("Erro ao adicionar novo pagamento: " + e.getMessage());
    }

    return false;
}
}

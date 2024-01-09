package br.com.jdbc;

import br.com.dal.Conexao;
import br.com.model.Pagamento;
import br.com.model.Treino;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrudTreinos extends Conexao{

    Treino treino;
    Connection crud;
    Conexao conexao;
    
    public CrudTreinos() {
        this.treino = new Treino();
        this.conexao = new Conexao();
    }
     
    public boolean adicionarNovoTreino(String diaSemana,int id_cliente,String nomeExercicio,int quantidadeSeries,int repeticoes,int tempoDescanso) {
    try (Connection c = conexao.obterConexao()) {
        this.crud = c;

        String consultaSQL = "INSERT INTO treinos (dia,id_cliente,nome_exercicio, quantidade_series, repeticoes,tempo_descanso) " +
                             "VALUES (?, ?, ?, ?, ?, ?)";
  
        try (PreparedStatement declaracao = crud.prepareStatement(consultaSQL)) {
            declaracao.setString(1, diaSemana);
            declaracao.setInt(2, id_cliente);
            declaracao.setString(3, nomeExercicio);
            declaracao.setInt(4, quantidadeSeries);
            declaracao.setInt(5, repeticoes);
            declaracao.setInt(6, tempoDescanso);
                      
            int linhasAfetadas = declaracao.executeUpdate();

            return linhasAfetadas > 0 ? true : false;
        }
    } catch (SQLException e) {
        System.out.println("Erro ao adicionar novo treino para cliente: " + e.getMessage());
    }

    return false;
    }
    
    public List<Treino> consultarTreinoDiaExpecifico(String dia,int id_cliente) {
        List<Treino> treinos = new ArrayList<>();
            try (Connection c = conexao.obterConexao()) {
                this.crud = c;
                 String consultaSQL = "SELECT * FROM treinos WHERE dia='"+dia+"' AND id_cliente="+id_cliente;
                    try (PreparedStatement declaracao = crud.prepareStatement(consultaSQL)) {
                            try (ResultSet resultado = declaracao.executeQuery()) {
                            while (resultado.next()) {
                                Treino treino = new Treino();
                                    treino.setId_treino(Integer.parseInt(resultado.getString("id_treino")));
                                    treino.setNomeExercicio((resultado.getString("nome_exercicio")));
                                    treino.setQuantidadeSeries(Integer.parseInt(resultado.getString("quantidade_series")));
                                    treino.setRepeticoes(Integer.parseInt(resultado.getString("repeticoes")));
                                    treino.setTempoDescanso(Integer.parseInt(resultado.getString("tempo_descanso")));
                                    
                                    treinos.add(treino);
                                }
                            }
                        }
                    } catch (SQLException e) {
                        System.out.println("Erro ao consultar  treino: " + e.getMessage());
                    }
        return treinos;
                
        }
    
}

package br.com.jdbc;

import java.sql.Timestamp;
import br.com.model.Cliente;
import br.com.dal.Conexao;
import br.com.dal.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CrudClientes extends Conexao{
    Conexao conexao;
    Connection crud;
    Cliente cliente;
    
    public CrudClientes(){   
        this.conexao = new Conexao();  
        this.cliente = new Cliente();
    }
    
    public boolean descobrindoSeClienteExiste(String email, int telefone) {
    try (Connection c = conexao.obterConexao()) {
        this.crud = c;

        String consultaSQL = "SELECT * FROM clientes WHERE email=? OR telefone=?";

        try (PreparedStatement declaracao = crud.prepareStatement(consultaSQL)) {
            declaracao.setString(1, email);
            declaracao.setInt(2, telefone);

            int resultado = declaracao.executeUpdate();
                return resultado > 0 ? true : false;
        }
    } catch (SQLException e) {
        System.out.println("Erro ao consultar clientes: " + e.getMessage());
        return false;
    }
}

  public boolean alterarNome(int id,String nome){
      try (Connection c = conexao.obterConexao()) {
        this.crud = c;

        String consultaSQL = "UPDATE clientes SET nome='"+nome+"' WHERE id="+id;

        try (PreparedStatement declaracao = crud.prepareStatement(consultaSQL)) {
            
            int linhasAfetadas = declaracao.executeUpdate();

            return linhasAfetadas > 0 ? true : false;
        }
    } catch (SQLException e) {
        System.out.println("Erro ao alterar nome do cliente: " + e.getMessage());
    }

    return false;
  }
  
   public boolean alterarIdade(int id,int idade){
      try (Connection c = conexao.obterConexao()) {
        this.crud = c;

        String consultaSQL = "UPDATE clientes SET idade='"+idade+"' WHERE id="+id;

        try (PreparedStatement declaracao = crud.prepareStatement(consultaSQL)) {
            
            int linhasAfetadas = declaracao.executeUpdate();

            return linhasAfetadas > 0 ? true : false;
        }
    } catch (SQLException e) {
        System.out.println("Erro ao alterar idade do cliente: " + e.getMessage());
    }

    return false;
  }
  
  
  public boolean alterarEmail(int id,String email){
      try (Connection c = conexao.obterConexao()) {
        this.crud = c;

        String consultaSQL = "UPDATE clientes SET email='"+email+"' WHERE id="+id;

        try (PreparedStatement declaracao = crud.prepareStatement(consultaSQL)) {
            
            int linhasAfetadas = declaracao.executeUpdate();

            return linhasAfetadas > 0 ? true : false;
        }
    } catch (SQLException e) {
        System.out.println("Erro ao alterar email do cliente: " + e.getMessage());
    }

    return false;
  }
 
   public boolean alterarTelefone(int id,int telefone){
      try (Connection c = conexao.obterConexao()) {
        this.crud = c;

        String consultaSQL = "UPDATE clientes SET  telefone='"+telefone+"' WHERE id="+id;

        try (PreparedStatement declaracao = crud.prepareStatement(consultaSQL)) {
            
            int linhasAfetadas = declaracao.executeUpdate();

            return linhasAfetadas > 0 ? true : false;
        }
    } catch (SQLException e) {
        System.out.println("Erro ao alterar telefone do cliente: " + e.getMessage());
    }

    return false;
  }
   
    public boolean alterarTipoPlano(int id,String tipoPlano){
      try (Connection c = conexao.obterConexao()) {
        this.crud = c;

        String consultaSQL = "UPDATE clientes SET tipo_plano='"+tipoPlano+"' WHERE id="+id;

        try (PreparedStatement declaracao = crud.prepareStatement(consultaSQL)) {
            
            int linhasAfetadas = declaracao.executeUpdate();

            return linhasAfetadas > 0 ? true : false;
        }
    } catch (SQLException e) {
        System.out.println("Erro ao alterar tipo de plano do cliente: " + e.getMessage());
    }

    return false;
  }
    
  public boolean alterarSexo(int id,String sexo){
      try (Connection c = conexao.obterConexao()) {
        this.crud = c;

        String consultaSQL = "UPDATE clientes SET sexo='"+sexo+"' WHERE id="+id;

        try (PreparedStatement declaracao = crud.prepareStatement(consultaSQL)) {
            
            int linhasAfetadas = declaracao.executeUpdate();

            return linhasAfetadas > 0 ? true : false;
        }
    } catch (SQLException e) {
        System.out.println("Erro ao alterar sexo do cliente: " + e.getMessage());
    }

    return false;
  }
  
   public boolean alterarStatusMatricula(int id,String matriculaStatus){
      try (Connection c = conexao.obterConexao()) {
        this.crud = c;

        String consultaSQL = "UPDATE clientes SET matricula_status='"+matriculaStatus+"' WHERE id="+id;

        try (PreparedStatement declaracao = crud.prepareStatement(consultaSQL)) {
            
            int linhasAfetadas = declaracao.executeUpdate();

            return linhasAfetadas > 0 ? true : false;
        }
    } catch (SQLException e) {
        System.out.println("Erro ao alterar status da matrícula do cliente: " + e.getMessage());
    }

    return false;
  }
    
  public boolean adicionarNovoCliente(String nome, int idade, String email, int telefone, String tipo_plano, String sexo) {
    try (Connection c = conexao.obterConexao()) {
        this.crud = c;

        String consultaSQL = "INSERT INTO clientes (nome, idade, email, telefone, tipo_plano,ultima_alteracao, sexo, matricula_status) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement declaracao = crud.prepareStatement(consultaSQL)) {
            declaracao.setString(1, nome);
            declaracao.setInt(2, idade);
            declaracao.setString(3, email);
            declaracao.setInt(4, telefone);
            declaracao.setString(5, tipo_plano);
            declaracao.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            declaracao.setString(7, sexo);
            declaracao.setString(8,"matriculado"); 
            
            int linhasAfetadas = declaracao.executeUpdate();

            return linhasAfetadas > 0 ? true : false;
        }
    } catch (SQLException e) {
        System.out.println("Erro ao adicionar novo cliente: " + e.getMessage());
    }

    return false;
}
  
 
  public List<Cliente> consultarClienteExpecifico(int ID) {
    List<Cliente> clientes = new ArrayList<>();

    try (Connection c = conexao.obterConexao()) {
        this.crud = c;

        String consultaSQL = "SELECT * FROM clientes WHERE id="+ID;

        try(PreparedStatement declaracao = crud.prepareStatement(consultaSQL)) {
            try (ResultSet resultado = declaracao.executeQuery()) {
                while (resultado.next()) {
                    cliente.setId(Integer.parseInt(resultado.getString("id")));
                    cliente.setNome(resultado.getString("nome"));
                    cliente.setIdade(Integer.parseInt(resultado.getString("idade")));
                    cliente.setEmail(resultado.getString("email"));
                    cliente.setTelefone(Integer.parseInt(resultado.getString("telefone")));
                    cliente.setTipo_plano(resultado.getString("tipo_plano"));
                    cliente.setUltima_alteracao(resultado.getString("ultima_alteracao"));
                    cliente.setSexo(resultado.getString("sexo"));
                    cliente.setMatricula(resultado.getString("matricula_status"));

                    clientes.add(cliente);
                }
            }
        }
    } catch (SQLException e) {
        System.out.println("Erro ao consultar clientes: " + e.getMessage());
    }

    return clientes;
}
  
    public List<Cliente> consultarClientes() {
    List<Cliente> clientes = new ArrayList<>();

    try (Connection c = conexao.obterConexao()) {
        this.crud = c;

        String consultaSQL = "SELECT * FROM clientes";

        try (PreparedStatement declaracao = crud.prepareStatement(consultaSQL)) {
            try (ResultSet resultado = declaracao.executeQuery()) {
                while (resultado.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(Integer.parseInt(resultado.getString("id")));
                    cliente.setNome(resultado.getString("nome"));
                    cliente.setIdade(Integer.parseInt(resultado.getString("idade")));
                    cliente.setEmail(resultado.getString("email"));
                    cliente.setTelefone(Integer.parseInt(resultado.getString("telefone")));
                    cliente.setTipo_plano(resultado.getString("tipo_plano"));
                    cliente.setUltima_alteracao(resultado.getString("ultima_alteracao"));
                    cliente.setSexo(resultado.getString("sexo"));
                    cliente.setMatricula(resultado.getString("matricula_status"));

                    clientes.add(cliente);
                }
            }
        }
    } catch (SQLException e) {
        System.out.println("Erro ao consultar clientes: " + e.getMessage());
    }

    return clientes;
}

    public String descobrirNomeDeCliente(int id) {
        try (Connection c = conexao.obterConexao()){
             
            this.crud = c;  
            
            String consultaSQL = "SELECT * FROM clientes WHERE id=" + id;        
             try (PreparedStatement declaracao = crud.prepareStatement(consultaSQL)) {
                try (ResultSet resultado = declaracao.executeQuery()) {
                    while(resultado.next()){
                        return resultado.getString("nome");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar clientes: " + e.getMessage());
        }
      return null;

    }
    
}

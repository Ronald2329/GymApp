package br.com.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private String url = "jdbc:mysql://localhost:3306/gymapp";
    private String usuario = "root";
    private String senha = "t2986xQ.8CkeF@]w";
    
    public Connection obterConexao() {
        // Tentativa de conexão
        try {
            return DriverManager.getConnection(this.url, this.usuario, this.senha);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            throw new RuntimeException("Erro ao obter conexão com o banco de dados", e);
        }
    }
}

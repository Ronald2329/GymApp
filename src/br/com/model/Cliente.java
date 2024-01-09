package br.com.model;

import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente{
    
    private int id; 
    private String nome; 
    private int idade;
    private String email;
    private int telefone;
    private String tipo_plano;
    private String ultima_alteracao;
    private String sexo;
    private String matricula;  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    static String exibirDataHora(String dataHora) {
        try {
            // Formato original: "AA-MM-DD H:M:S"
            SimpleDateFormat formatoOriginal = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            
            // Formato desejado: "DD-MM-AA H:M:S"
            SimpleDateFormat formatoDesejado = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
            
            // Parse da string para Date usando o formato original
            Date data = formatoOriginal.parse(dataHora);
            
            // Formatação da data usando o formato desejado
            return formatoDesejado.format(data);
        } catch (ParseException e) {
            e.printStackTrace();
            return "Erro na conversão de data e hora.";
        }
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getTipo_plano() {
        return tipo_plano;
    }

    public void setTipo_plano(String tipo_plano) {
        this.tipo_plano = tipo_plano;
    }

    public String getUltima_alteracao() {
        return exibirDataHora(ultima_alteracao);
    }

    public void setUltima_alteracao(String ultima_alteracao) {
        this.ultima_alteracao = ultima_alteracao;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

      @Override
    public String toString() {
        return   "Nome: " + nome+
                 "Idade: "+idade+"\n"+
                 "Email: "+ email + "\n"+
                 "Telefone: " + telefone + "\n"+
                 "Tipo de plano: "+ tipo_plano+ "\n"+
                 "Primeira matrícula: " + ultima_alteracao+ "\n"+
                 "Sexo+" + sexo + "\n"+
                 "Matrícula: " + matricula;
    }
    
  
}

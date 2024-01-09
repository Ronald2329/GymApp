package br.com.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pagamento {
    
    int idPagamento;
    int idCliente;
    float valor;
    String data;

static String exibirData(String dataHora) {
        try {
            // Formato original: "AA-MM-DD H:M:S"
            SimpleDateFormat formatoOriginal = new SimpleDateFormat("yy-MM-dd");
            
            // Formato desejado: "DD-MM-AA H:M:S"
            SimpleDateFormat formatoDesejado = new SimpleDateFormat("dd-MM-yy");
            
            // Parse da string para Date usando o formato original
            Date data = formatoOriginal.parse(dataHora);
            
            // Formatação da data usando o formato desejado
            return formatoDesejado.format(data);
        } catch (ParseException e) {
            e.printStackTrace();
            return "Erro na conversão de data e hora.";
        }
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
 
    public int getidCliente() {
        return idCliente;
    }

    public void setidCliente(int idPagamento) {
        this.idCliente = idPagamento;
    }
    
    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getData() {
        return exibirData(data);
    }

    public void setData(String data) {
        this.data = data;
    }
 
}

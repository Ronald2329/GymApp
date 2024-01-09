package br.com.model;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Email{

    String apiUrl = "https://api.brevo.com/v3/smtp/email";
    String apiKey = "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"; // GymApp_TEST
    String htmlContent;
    String to;
    String email;
    String subject;
    String body;

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Email(String to,String email,String subject, String body){
        
        setTo(to);
        setEmail(email);
        setSubject(subject);
        setBody(body);
        
        setHtmlContent(
            "<html>\n" +
            " <head>\n" +
            "          <style>\n" +
            "            body {\n" +
            "              background-color: #f8f9fa;\n" +
            "              color: #f8f9fa;\n" +
            "            }\n" +
            "\n" +
            "            .logo {\n" +
            "              text-align: center;\n" +
            "              margin: 10px;\n" +
            "              margin-top: -60px;\n" +
            "            }\n" +
            "\n" +
            "            .logo-text {\n" +
            "              font-size: 75px;\n" +
            "              color: #f8f5f5;\n" +
            "            }\n" +
            "\n" +
            "            .logo-highlight {\n" +
            "              color: gold;\n" +
            "            }\n" +
            "\n" +
            "            .Header {\n" +
            "              background-color: black;\n" +
            "            }\n" +
            "          </style>\n" +
            "        </head>\n" +
            "        <body>\n" +
            "          <div class=\"Header\"> \n" +
            "            <div class=\"logo\">\n" +
            "              <h1 class=\"logo-text\">Gym<span class=\"logo-highlight\">App</span></h1>\n" +
            "            </div>\n" +
            "          </div>\n" +
            "          " +getBody() + "\n" +
            "        </body>\n" +
            "      </html>\n");
        
    }
    
    public void SendEmail() {
       
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurar a conexão
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("api-key", apiKey);
            connection.setDoOutput(true);

            // Construir os dados a serem enviados
            String jsonData = String.format("{\"sender\":{\"name\":\"GymApp\",\"email\":\"%s\"},\"to\":[{\"email\":\"%s\",\"name\":\"%s\"}],\"subject\":\"%s\",\"htmlContent\":\"%s\"}",
                    email, email, to, subject, body);

            // Enviar os dados
            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.writeBytes(jsonData);
                wr.flush();
            }

            // Obter a resposta
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                // Fazer algo com a resposta, por exemplo, imprimir na tela
                System.out.println(response.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package Classes;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import po23s.http.ClienteHttp;


/**
 *
 * @author baby
 */
public class ProjectPOO {
    private static final String API_URL = "https://www.googleapis.com/books/v1/volumes";
    
    public List<Books> searchBooks(String query, int maxResults, int startIndex) {
        ClienteHttp cliente = new ClienteHttp();
        String url = buildUrl(query, maxResults, startIndex);
        String resposta = cliente.buscaDados(url);
        return parseBook(resposta);
    }

    
    private List<Books> parseBook(String resposta){
        List<Books> parseBook = new ArrayList<>();
        JSONObject object = new JSONObject(resposta);
        JSONArray items = object.getJSONArray("items");
        
        for (int i = 0; i < items.length(); i++) {
            JSONObject item = items.getJSONObject(i);
            JSONObject volumeInfo = item.getJSONObject("volumeInfo");
            String titulo = volumeInfo.getString("title");
            ArrayList<String> autores = new ArrayList<>();
            if (volumeInfo.has("authors")) {
                JSONArray autoresArray = volumeInfo.getJSONArray("authors");
                for (int j = 0; j < autoresArray.length(); j++) {
                    autores.add(autoresArray.getString(j));
                }
            }
            String editora = volumeInfo.has("publisher") ? volumeInfo.getString("publisher") : "Editora Desconhecida";
            Boolean disponivelPdf = volumeInfo.has("pdf") && volumeInfo.getJSONObject("pdf").getBoolean("Esta Disponivel");
            double preco = 0.0;
            if (item.has("saleInfo")) {
                JSONObject saleInfo = item.getJSONObject("saleInfo");
                if (saleInfo.has("retailPrice")) {
                    JSONObject retailPrice = saleInfo.getJSONObject("retailPrice");
                    if (retailPrice.has("amount")) {
                        preco = retailPrice.getDouble("amount");
                    }
                }
            }

            parseBook.add(new Books(titulo, autores, editora, disponivelPdf, preco));
        }
        return parseBook;
    }
    
    private String buildUrl(String query, int maxResults, int startIndex){
       StringBuilder url = new StringBuilder(API_URL);
    
        url.append("?q=").append(URLEncoder.encode(query, StandardCharsets.UTF_8));
        if (maxResults > 0 && maxResults <= 40) {
            url.append("&maxResults=").append(maxResults);
        }
        if (startIndex >= 0) {
            url.append("&startIndex=").append(startIndex);
        }
        return url.toString();
    }
}


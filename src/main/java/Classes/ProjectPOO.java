package Classes;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import po23s.http.ClienteHttp;


/**
 *
 * @author baby
 */
public class ProjectPOO {
    private static final String API_URL = "https://www.googleapis.com/books/v1/volumes";
    
    public List<Book> searchBooks(String query, int maxResults, int startIndex) {
        ParseBooks parseBook = new ParseBooks();
        ClienteHttp cliente = new ClienteHttp();
        String url = buildUrl(query, maxResults, startIndex);
        String resposta = cliente.buscaDados(url);
        return parseBook.parseBook(resposta);
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


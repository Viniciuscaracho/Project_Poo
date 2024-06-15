/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



import java.awt.print.Book;
import java.net.URI;
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
        Books livros = new Books;
        List<Books> parseBook = new ArrayList<>();
        JSONObject object = new JSONObject(resposta);
        JSONArray items = JSONObject.getJSONArray("items");
        
        for (int i = 0; i < items.length(); i++) {
            JSONObject volumeInfo = items.get("volumeInfo");
            String titulo = volumeInfo.getString("title");
            ArrayList<String> autores = volumeInfo.has("authors") ? Books.getAutores(volumeInfo.getJSONArray("authors")) : new ArrayList<>();
            String editora = volumeInfo.has("publisher") ? volumeInfo.getString("publisher") : "Editora Desconhecida";
            Boolean disponivelPdf = volumeInfo.has("pdf") && volumeInfo.getJSONObject("pdf").getBoolean("Esta Disponivel");
            double preco = volumeInfo.has("saleInfo") && volumeInfo.getJSONObject("saleInfo").getJSONObject("retailPrice").has("amount") ?
            volumeInfo.getJSONObject("saleInfo").getJSONObject("retailPrice").getDouble("amount") : 0.0;
            
            parseBook.add(new Book(titulo,autores,editora,disponivelPdf,preco));
        }
        return parseBook;
    }
    
    private String buildUrl(String query, int maxResults, int startIndex){
       StringBuilder url = new StringBuilder(API_URL);
    
        url.append("?q=").append(URI.create(query).toString());
        if (maxResults > 0 && maxResults <= 40) {
            url.append("&maxResults=").append(maxResults);
        }
        if (startIndex > 0) {
            url.append("&startIndex=").append(startIndex);
        }
        return url.toString();
    }


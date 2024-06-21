/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author pedro
 */
public class ParseBooks {
    public List<Book> parseBook(String resposta){
        List<Book> parseBook = new ArrayList<>();
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
            else{
                autores.add("Autores Desconhecidos");
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
            String smallThumbnail = "https://drive.usercontent.google.com/download?id=15tzOCQdSRGg_wcwa-3TnpS2zt2hTHaMI&authuser=0&confirm=t&uuid=e7d297b8-bf30-49d6-bd25-c0cbdbc140bf&at=APZUnTWC7Q_RZ5u--BGCMZLVqgup:1718315906981";
            if(volumeInfo.has("imageLinks")){
                JSONObject imageLinks = volumeInfo.getJSONObject("imageLinks");
                if(imageLinks.has("smallThumbnail")){
                    smallThumbnail = imageLinks.getString("smallThumbnail");
                }
            }

            parseBook.add(new Book(titulo, autores, editora, disponivelPdf, preco,smallThumbnail));
        }
        return parseBook;
    }
    
}


import java.util.List;

import Classes.Books;
import Classes.ProjectPOO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pedro
 */
public class main {
    public static void main(String[] args) {
        ProjectPOO googleBooksApi = new ProjectPOO();
        String query = "Java"; // Consulta de exemplo
        List<Books> books = googleBooksApi.searchBooks(query, 10, 0);

        
        for (Books book : books) {
            System.out.println(book);
        }
             
    }
}

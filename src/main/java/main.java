
import po23s.http.ClienteHttp;

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
        ClienteHttp cliente = new ClienteHttp();
        System.out.println(cliente.buscaDados("https://www.googleapis.com/books/v1/volumes?q=java"));
             
    }
}

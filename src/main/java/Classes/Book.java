package Classes;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/**
 *
 * @author pedro
 */
public class Book {
    private String titulo;
    private ArrayList<String> autores;
    private String editora;
    private Boolean disponivelPdf;
    private double preco;

    public Book(String titulo, ArrayList<String> autores, String editora, Boolean disponivelPdf, double preco) {
        this.titulo = titulo;
        this.autores = autores;
        this.editora = editora;
        this.disponivelPdf = disponivelPdf;
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public String getEditora() {
        return editora;
    }

    public boolean isDisponivelPdf() {
        return disponivelPdf;
    }

    public double getPreco() {
        return preco;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutores(List<String> autores) {
        this.autores = (ArrayList<String>) autores;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setDisponivelPdf(Boolean disponivelPdf) {
        this.disponivelPdf = disponivelPdf;
    }
    
    public void setPreco(double preco){
        this.preco = preco;
    }
    
    @Override
    public String toString() {
        return "Classes.Books{" + "titulo=" + titulo + ", autores=" + autores + ", editora=" + editora + ", disponivelPdf=" + disponivelPdf + ", preco=" + preco + '}';
    }
    
    
    
}

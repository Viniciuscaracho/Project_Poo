/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.List;
/**
 *
 * @author pedro
 */
public class Books {
    private String Titulo;
    private List<String> Autores;
    private String Editora;
    private boolean disponivelPdf;
    private double preco;

    public Books(String Titulo, List<String> Autores, String Editora, boolean disponivelPdf, double preco) {
        this.Titulo = Titulo;
        this.Autores = Autores;
        this.Editora = Editora;
        this.disponivelPdf = disponivelPdf;
        this.preco = preco;
    }

    public String getTitulo() {
        return Titulo;
    }

    public List<String> getAutores() {
        return Autores;
    }

    public String getEditora() {
        return Editora;
    }

    public boolean isDisponivelPdf() {
        return disponivelPdf;
    }

    public double getPreco() {
        return preco;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public void setAutores(List<String> Autores) {
        this.Autores = Autores;
    }

    public void setEditora(String Editora) {
        this.Editora = Editora;
    }

    public void setDisponivelPdf(boolean disponivelPdf) {
        this.disponivelPdf = disponivelPdf;
    }
    
    private void setPreco(double preco){
        this.preco = preco;
    }
    
    @Override
    public String toString() {
        return "Books{" + "Titulo=" + Titulo + ", Autores=" + Autores + ", Editora=" + Editora + ", disponivelPdf=" + disponivelPdf + ", preco=" + preco + '}';
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ezequiel
 */
 
public class Libro {
 
    private int id;
    private String titulo;
    private String autor;
    private String categoria;
    private String editorial;
    private int stock;
 
    public Libro() {
    }
 
    // Para libros nuevos -> todavia no tienen id, lo genera MySQL al insertar
    public Libro(String titulo, String autor, String categoria, String editorial, int stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.editorial = editorial;
        this.stock = stock;
    }
 
    // Para libros leidos desde la base de datos -> ya tienen id
    public Libro(int id, String titulo, String autor, String categoria, String editorial, int stock) {
        this(titulo, autor, categoria, editorial, stock);
        this.id = id;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getTitulo() {
        return titulo;
    }
 
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
 
    public String getAutor() {
        return autor;
    }
 
    public void setAutor(String autor) {
        this.autor = autor;
    }
 
    public String getCategoria() {
        return categoria;
    }
 
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
 
    public String getEditorial() {
        return editorial;
    }
 
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
 
    public int getStock() {
        return stock;
    }
 
    public void setStock(int stock) {
        this.stock = stock;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.LibroDAO;
import modelo.Libro;
 
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author ezequiel
 */


public class ControladorLibro {
 
    private final LibroDAO libroDAO;
 
    public ControladorLibro() {
        libroDAO = new LibroDAO();
    }
 
    // Listo todos los libros
    public List<Libro> listar() throws SQLException {
        return libroDAO.listar();
    }
 
    // Busco libros por titulo
    public List<Libro> buscarPorTitulo(String titulo)
            throws SQLException {
 
        validarBusqueda(titulo);
 
        return libroDAO.buscarPorTitulo(titulo.trim());
    }
 
    // Busco libros por autor
    public List<Libro> buscarPorAutor(String autor)
            throws SQLException {
 
        validarBusqueda(autor);
 
        return libroDAO.buscarPorAutor(autor.trim());
    }
 
    // Guardo un libro nuevo
    public boolean guardar(String titulo,
            String autor,
            String categoria,
            String editorial,
            String stock) throws SQLException {
 
        validarLibro(titulo, autor, categoria, editorial);
        int stockNumero = convertirStock(stock);
 
        Libro libro = new Libro(
                titulo.trim(),
                autor.trim(),
                categoria.trim(),
                editorial.trim(),
                stockNumero
        );
 
        return libroDAO.insertar(libro);
    }
 
    // Modifico un libro existente
    public boolean modificar(int id,
            String titulo,
            String autor,
            String categoria,
            String editorial,
            String stock) throws SQLException {
 
        validarId(id);
        validarLibro(titulo, autor, categoria, editorial);
        int stockNumero = convertirStock(stock);
 
        Libro libro = new Libro(
                id,
                titulo.trim(),
                autor.trim(),
                categoria.trim(),
                editorial.trim(),
                stockNumero
        );
 
        return libroDAO.modificar(libro);
    }
 
    // Elimino un libro
    public boolean eliminar(int id) throws SQLException {
        validarId(id);
 
        return libroDAO.eliminar(id);
    }
 
    // Valido que haya un libro seleccionado
    private void validarId(int id) {
 
        if (id <= 0) {
            throw new IllegalArgumentException(
                    "Debe seleccionar un libro de la tabla."
            );
        }
    }
 
    // Valido los textos del libro
    private void validarLibro(String titulo,
            String autor,
            String categoria,
            String editorial) {
 
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException(
                    "El titulo es obligatorio."
            );
        }
 
        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException(
                    "El autor es obligatorio."
            );
        }
 
        if (categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException(
                    "La categoria es obligatoria."
            );
        }
 
        if (editorial == null || editorial.isBlank()) {
            throw new IllegalArgumentException(
                    "La editorial es obligatoria."
            );
        }
    }
 
    // Valido el stock y lo convierto a numero entero
    private int convertirStock(String stock) {
 
        if (stock == null || stock.isBlank()) {
            throw new IllegalArgumentException(
                    "El stock es obligatorio."
            );
        }
 
        int numero;
 
        try {
            numero = Integer.parseInt(stock.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "El stock debe ser un numero entero."
            );
        }
 
        if (numero < 0) {
            throw new IllegalArgumentException(
                    "El stock no puede ser negativo."
            );
        }
 
        return numero;
    }
 
    // Valido el texto de la busqueda
    private void validarBusqueda(String texto) {
 
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException(
                    "Escriba un texto para buscar."
            );
        }
    }
}
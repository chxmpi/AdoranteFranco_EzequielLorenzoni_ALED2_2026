/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author ezequiel
 */

import conexion.Conexion;
import modelo.Libro;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
public class LibroDAO {
 
    // Listo todos los libros de la base
    public List<Libro> listar() throws SQLException {
 
        List<Libro> lista = new ArrayList<>();
 
        String sql = "SELECT id, titulo, autor, categoria, editorial, stock "
                + "FROM libros ORDER BY id";
 
        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
 
            while (rs.next()) {
 
                Libro l = new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("categoria"),
                        rs.getString("editorial"),
                        rs.getInt("stock")
                );
 
                lista.add(l);
            }
        }
 
        return lista;
    }
 
    // Inserto un libro nuevo
    public boolean insertar(Libro l) throws SQLException {
 
        String sql = "INSERT INTO libros "
                + "(titulo, autor, categoria, editorial, stock) "
                + "VALUES (?, ?, ?, ?, ?)";
 
        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
 
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setString(3, l.getCategoria());
            ps.setString(4, l.getEditorial());
            ps.setInt(5, l.getStock());
 
            return ps.executeUpdate() == 1;
        }
    }
 
    // Modifico un libro existente
    public boolean modificar(Libro l) throws SQLException {
 
        String sql = "UPDATE libros "
                + "SET titulo = ?, autor = ?, categoria = ?, "
                + "editorial = ?, stock = ? "
                + "WHERE id = ?";
 
        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
 
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setString(3, l.getCategoria());
            ps.setString(4, l.getEditorial());
            ps.setInt(5, l.getStock());
            ps.setInt(6, l.getId());
 
            return ps.executeUpdate() == 1;
        }
    }
 
    // Elimino un libro
    public boolean eliminar(int id) throws SQLException {
 
        String sql = "DELETE FROM libros "
                + "WHERE id = ?";
 
        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
 
            ps.setInt(1, id);
 
            return ps.executeUpdate() == 1;
        }
    }
 
    // Busco libros por titulo
    public List<Libro> buscarPorTitulo(String titulo)
            throws SQLException {
 
        List<Libro> lista = new ArrayList<>();
 
        String sql = "SELECT id, titulo, autor, categoria, editorial, stock "
                + "FROM libros "
                + "WHERE titulo LIKE ? "
                + "ORDER BY titulo";
 
        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
 
            ps.setString(1, "%" + titulo + "%");
 
            try (ResultSet rs = ps.executeQuery()) {
 
                while (rs.next()) {
 
                    Libro l = new Libro(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getString("categoria"),
                            rs.getString("editorial"),
                            rs.getInt("stock")
                    );
 
                    lista.add(l);
                }
            }
        }
 
        return lista;
    }
 
    // Busco libros por autor
    public List<Libro> buscarPorAutor(String autor)
            throws SQLException {
 
        List<Libro> lista = new ArrayList<>();
 
        String sql = "SELECT id, titulo, autor, categoria, editorial, stock "
                + "FROM libros "
                + "WHERE autor LIKE ? "
                + "ORDER BY autor, titulo";
 
        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
 
            ps.setString(1, "%" + autor + "%");
 
            try (ResultSet rs = ps.executeQuery()) {
 
                while (rs.next()) {
 
                    Libro l = new Libro(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getString("categoria"),
                            rs.getString("editorial"),
                            rs.getInt("stock")
                    );
 
                    lista.add(l);
                }
            }
        }
 
        return lista;
    }
}
 

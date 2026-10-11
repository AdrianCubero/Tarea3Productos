/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.webapp.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import my.webapp.database.Database;

public class ProductDAO {

    public void addProduct(Product product) throws SQLException {

        Database db = new Database();

        Connection conn = db.getConnection();

        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO productos(nombre, precio, stock) VALUES (?, ?, ?)"
        );

        ps.setString(1, product.getNombre());
        ps.setDouble(2, product.getPrecio());
        ps.setInt(3, product.getStock());

        ps.executeUpdate();
    }

    public List<Product> getProducts() throws SQLException {

        List<Product> products = new ArrayList<>();

        Database db = new Database();

        Connection conn = db.getConnection();

        PreparedStatement ps =
                conn.prepareStatement("SELECT * FROM productos");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Product product = new Product(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getDouble("precio"),
                    rs.getInt("stock")
            );

            products.add(product);
        }
        
        return products;
    }

}
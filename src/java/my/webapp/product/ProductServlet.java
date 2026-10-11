/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.webapp.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            ProductDAO dao = new ProductDAO();

            List<Product> products =
                    dao.getProducts();

            request.setAttribute(
                    "productList",
                    products);

            request.getRequestDispatcher(
                    "productos.jsp")
                    .forward(request, response);

        } catch (SQLException ex) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String nombre =
                    request.getParameter("nombre");

            double precio =
                    Double.parseDouble(
                    request.getParameter("precio"));

            int stock =
                    Integer.parseInt(
                    request.getParameter("stock"));

            Product product =
                    new Product(
                            0,
                            nombre,
                            precio,
                            stock);

            ProductDAO dao =
                    new ProductDAO();

            dao.addProduct(product);

            response.sendRedirect(
                    "ProductServlet");

        } catch (SQLException ex) {
        }
    }
}
<%@page import="java.util.List"%>
<%@page import="my.webapp.product.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
    <title>Lista de Productos</title>
</head>

<body>

<h2>Lista de Productos</h2>

<table border="1">

<tr>
    <th>ID</th>
    <th>Nombre</th>
    <th>Precio</th>
    <th>Stock</th>
</tr>

<%
List<Product> productList =
(List<Product>)request.getAttribute("productList");

if(productList != null){

    for(Product p : productList){
%>

<tr>
    <td><%=p.getId()%></td>
    <td><%=p.getNombre()%></td>
    <td><%=p.getPrecio()%></td>
    <td><%=p.getStock()%></td>
</tr>

<%
    }
}
%>

</table>

</body>
</html>

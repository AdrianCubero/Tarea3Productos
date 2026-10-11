<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Producto</title>
</head>
<body>

    <h2>Registrar Producto</h2>

    <form action="ProductServlet" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>

        <br><br>

        <label for="precio">Precio:</label>
        <input type="number" id="precio" name="precio"
               min="0" step="0.01" required>

        <br><br>

        <label for="stock">Stock:</label>
        <input type="number" id="stock" name="stock"
               min="0" step="1" required>

        <br><br>

        <input type="submit" value="Guardar">
    </form>

</body>
</html>

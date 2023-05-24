<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Productos"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <b>
            <center><textarea name="nombre" rows="4" cols="35" readonly="readonly">
    SEGUNDO PARCIAL TEM-742
    Nombre: Nilsa Emily Tola Tola
    Carnet: 13734079 LP </textarea>
        <div>
            <h1>Gestion de Productos</h1>
            <a href="Controlador?accion=add">Nuevo Producto</a>
            <table border="1" cellspacing = "1" >
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>DESCRIPCION</th>
                        <th>CANTIDAD</th>
                        <th>PRECIO</th>
                        <th>CATEGORIA</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <%
                    ProductoDAO dao = new ProductoDAO();
                    List<Productos> list = dao.listar();
                    Iterator<Productos> iter = list.iterator();
                    Productos pro = null;
                    while (iter.hasNext()) {
                        pro = iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td><%= pro.getId()%></td>
                        <td><%= pro.getDescripcion()%></td>
                        <td><%= pro.getCantidad()%></td>
                        <td><%= pro.getPrecio()%></td>
                        <td><%= pro.getCategoria()%></td>
                        
                        <td>
                            <a href="Controlador?accion=editar&id=<%= pro.getId()%>">Editar</a>
                            <a href="Controlador?accion=eliminar&id=<%= pro.getId()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>

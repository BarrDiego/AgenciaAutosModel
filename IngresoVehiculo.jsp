<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agencia Autos Model</title>
</head>
<body>
<h1>Ingrese el Vehiculo</h1>
<hr>
<%
	if(request.getAttribute("mensaje")!=null){
		out.println(request.getAttribute("mensaje"));
	}
%>
<form action="VehiculoServlet" method="post">
	Marca:<input type="text" name="marca" /><br>
	Modelo:<input type="text" name="modelo"/><br>
	Año:<input type="text" name="año"/><br>
	Precio: <input type="text" name="precio" />$<br>
	<input type="submit" value="Ingresar">
	

</form>


</body>
</html>
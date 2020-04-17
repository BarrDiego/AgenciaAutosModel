<%@page import="com.agencia.AutoVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agencia Autos Model</title>
</head>
<body>
<h1>Busque su modelo</h1>
<hr>
<%
	if(request.getAttribute("mensaje")!=null){
		out.println(request.getAttribute("mensaje"));
}
%>
<form action="SolicitudServlet" method="post">
Marca: <input type="text" name="marca"><br>
Modelo: <input type="text" name="modelo"><br>
<input type="button" value="Busqueda">

<%
if(request.getAttribute("vehiculo")!=null){
	AutoVO au=(AutoVO) request.getAttribute("vehiculo");
	out.println("se encontro el vehiculo: "+au);
}

%>



</form>


</body>
</html>
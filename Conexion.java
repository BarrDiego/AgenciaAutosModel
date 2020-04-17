package com.agencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexion {
	static Connection con=null;
	static String db="autos";
	static String url="jdbc:mysql://localhost/"+db;
	static String login="root";
	static String password="";
	
	


	
	public Conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url, login, password);
			if(con==null) {
			System.out.println("no se logro conexion a "+db);
			}else {
			System.out.println("Bienvenido a "+db);
			}
			}catch (SQLException e){
			e.printStackTrace();
			e.getMessage();
			
			
			}catch (ClassNotFoundException e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}
		}
	
	
	public Connection obtenerConexion() {
	return con;
	}
	
	public void desconectar() {
		if (con!=null) {
			System.out.println("Ud a cerrado sesion con "+db);
		}
		
	}
}
		
			
	
		
		
		
		
		
	



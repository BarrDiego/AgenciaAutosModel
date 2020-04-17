package com.agencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutoDAO {
	
	public static void inserta(AutoVO auto) throws SQLException {
		
		Conexion cn =new Conexion();
		Connection con=cn.obtenerConexion();
		
		
	
		PreparedStatement st=con.prepareStatement("INSERT INTO autos(marca,modelo,año,precio)VALUES(?,?,?,?)");
		st.setString(1, auto.getMarca());
		st.setString(2, auto.getModelo());
		st.setInt(3, auto.getAño());
		st.setInt(4, auto.getPrecio());
		st.execute();
		System.out.println("se inserto en BD ");
		st.close();
		con.close();
		cn.desconectar();
	}
	
	public static void elimina(int id) {
		Conexion cn =new Conexion();
		Connection con=cn.obtenerConexion();
		try {
		if(traerId(id)==null) {
			System.out.println("el vehiculo no existe");
		}
		PreparedStatement st=con.prepareStatement("DELETE FROM autos WHERE id=?");
		st.setInt(1,id);
		st.execute();
		System.out.println("se ha eliminado un vehiculo id: "+id);
		st.close();
		}catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}finally {
			try {
			con.close();
			cn.desconectar();
			}catch (SQLException e) {
				e.printStackTrace();
				e.getMessage();
			}
			
		}
			
		
		
	}
	public static void modifica( AutoVO au) {
		Conexion cn =new Conexion();
		Connection con=cn.obtenerConexion();
		try {
			if(traerId(au.getId())==null) {
				System.out.println("el vehiculo no existe");
				}
			PreparedStatement st=con.prepareStatement("UPDATE autos set marca=?, modelo=?, año=?, precio=? WHERE id=?");
			st.setString(1, au.getMarca());
			st.setString(2, au.getModelo());
			st.setInt(3, au.getAño());
			st.setInt(4, au.getPrecio());
			st.setInt(5,au.getId());
			st.execute();
			System.out.println("se modifico vehiculo:"+au);
			st.close();
		}catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}finally {
			try {
				cn.desconectar();
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
				e.getMessage();
			}
		}
		
	}
	
	public static AutoVO traerId(int id) {
		Conexion cn =new Conexion();
		Connection con=cn.obtenerConexion();
		AutoVO au=null;
		ResultSet rs=null;
		
		try {
			PreparedStatement st=con.prepareStatement("SELECT * FROM autos WHERE id=?");
			st.setInt(1, id);
			rs=st.executeQuery();
			if(rs.next()) {
				int ids= rs.getInt("id");
				String marc= rs.getString("marca");
				String mod= rs.getString("modelo");
				int anio= rs.getInt("año");
				int prec=rs.getInt("precio");
				au=new AutoVO();
				au.setId(ids);
				au.setMarca(marc);
				au.setModelo(mod);
				au.setAño(anio);
				au.setPrecio(prec);
			}else {
				System.out.println("El vehiculo no existe");
			}
			st.close();
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}finally {
			try {
			rs.close();
			cn.desconectar();
			}catch (Exception e) {
				e.printStackTrace();
				e.getMessage();
			}
			
			
		}
		return au;
		
		
	}
	
	public static AutoVO traerMM(String marca, String modelo) {
		Conexion cn =new Conexion();
		Connection con=cn.obtenerConexion();
		AutoVO au=null;
		ResultSet rs=null;
		
		try {
			PreparedStatement st=con.prepareStatement("SELECT * FROM autos WHERE marca=?||modelo=?");
			st.setString(1, marca);
			st.setString(2, modelo);			
			rs=st.executeQuery();
			if(rs.next()) {
				int ids= rs.getInt("id");
				String marc= rs.getString("marca");
				String mod= rs.getString("modelo");
				int anio= rs.getInt("año");
				int prec=rs.getInt("precio");
				au=new AutoVO();
				au.setId(ids);
				au.setMarca(marc);
				au.setModelo(mod);
				au.setAño(anio);
				au.setPrecio(prec);
			}else {
				System.out.println("El vehiculo no existe");
			}
			st.close();
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}finally {
			try {
			rs.close();
			cn.desconectar();
			}catch (Exception e) {
				e.printStackTrace();
				e.getMessage();
			}
			
			
		}
		return au;
		
	}
	
	public static List <AutoVO> traerAutos(){
		ArrayList<AutoVO> vehiculos=new ArrayList<AutoVO>();
		Conexion cn =new Conexion();
		Connection con=cn.obtenerConexion();
		ResultSet rs=null;
		try{
			PreparedStatement st=con.prepareStatement("SELECT * FROM autos");
			rs=st.executeQuery();
			while(rs.next()) {
				AutoVO au=new AutoVO();
				au.setId(rs.getInt("id"));
				au.setMarca(rs.getString("marca"));
				au.setModelo(rs.getString("modelo"));
				au.setAño(rs.getInt("año"));
				au.setPrecio(rs.getInt("precio"));
				vehiculos.add(au);
			}
			st.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
			e.getCause();
			e.getMessage();
		}finally {
			try {
				rs.close();
				cn.desconectar();
				con.close();
			}catch (SQLException e) {
				e.printStackTrace();
				e.getMessage();
			}
		}
		return vehiculos;
	}

}

package com.agencia;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VehiculoServlet
 */
@WebServlet("/VehiculoServlet")
public class VehiculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehiculoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String marca= request.getParameter("marca");
		String modelo= request.getParameter("modelo");
		int año= Integer.valueOf(request.getParameter("año"));
		int precio=Integer.valueOf(request.getParameter("precio"));
		
		AutoVO au=new AutoVO(marca,modelo,año,precio);
		
		try {
			AutoDAO.inserta(au);
			request.setAttribute("mensaje", "El Vehiculo se inserto correctamente!");
		} catch (SQLException e) {
			request.setAttribute("mensaje", e.getCause());
			request.setAttribute("mensaje", e.getMessage());
			e.printStackTrace();
			
		}
		
		request.getRequestDispatcher("IngresoVehiculo.jsp").forward(request,response);
		
		
		
		doGet(request, response);
	}

}

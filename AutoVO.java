package com.agencia;

public class AutoVO {
	private int id;
	private String marca;
	private String modelo;
	private int año;
	private int precio;
	
	public AutoVO() {
		
	}
	
	
	public AutoVO( String marca, String modelo, int año, int precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
		this.precio = precio;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public int getAño() {
		return año;
	}


	public void setAño(int año) {
		this.año = año;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "AutoVO [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", año=" + año + ", precio=" + precio
				+ "]";
	}







}

package com.agencia;

public class AutoVO {
	private int id;
	private String marca;
	private String modelo;
	private int a�o;
	private int precio;
	
	public AutoVO() {
		
	}
	
	
	public AutoVO( String marca, String modelo, int a�o, int precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.a�o = a�o;
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


	public int getA�o() {
		return a�o;
	}


	public void setA�o(int a�o) {
		this.a�o = a�o;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "AutoVO [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", a�o=" + a�o + ", precio=" + precio
				+ "]";
	}







}

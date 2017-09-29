package com.belatrix.springboot.mariano.model;

import java.util.Date;

public class Vehiculo {
	private long id;
	private String marca;

	public Vehiculo() {

	}

	public Vehiculo(String marca, String modelo) {
		this.id = (new Date()).getTime();
		this.marca = marca;
		this.modelo = modelo;
	}

	private String modelo;

	public long getId() {
		return id;
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

	@Override
	public String toString() {
		return "Vehiculo{" + "id=" + id + ", marca='" + marca + '\'' + ", modelo='" + modelo + '\'' + '}';
	}
}

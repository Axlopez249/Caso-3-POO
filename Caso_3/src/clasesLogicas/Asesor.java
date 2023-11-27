package clasesLogicas;

import java.util.Date;

public class Asesor {
	private String nombre;
	private int idAsesor;
	private String zona;
	private String correo;
	private double rating;
	private int experiencia;
	private int cantidadCasos;
	private Date fechaIngreso;
	
	
	public Asesor(String nombre, int idAsesor, String zona, String correo, double rating, int experiencia, int cantidadCasos, Date fechaIngreso) {
		this.nombre = nombre;
		this.idAsesor = idAsesor;
		this.zona = zona;
		this.correo = correo;
		this.rating = rating;
		this.experiencia = experiencia;
		this.cantidadCasos = cantidadCasos;
		this.fechaIngreso = fechaIngreso;
	}


	public int getId() {
		return idAsesor;
	}


	public String getNombre() {
		return nombre;
	}


	public String getZona() {
		return zona;
	}


	public String getCorreo() {
		return correo;
	}


	public double getRating() {
		return rating;
	}


	public int getExperiencia() {
		return experiencia;
	}


	public int getCantidadCasos() {
		return cantidadCasos;
	}


	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	
	
	
	
	
}

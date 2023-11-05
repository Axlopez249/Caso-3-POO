package clasesLogicas;

import java.util.Date;

public class Asesor {
	private String nombre;
	private String lugar;
	private String correo;
	private double rating;
	private int experiencia;
	private int cantCasos;
	private Date fechaIngreso;
	
	
	public Asesor(String nombre, String lugar, String correo, double rating, int experiencia, int cantCasos, Date fechaIngreso) {
		this.nombre = nombre;
		this.lugar = lugar;
		this.correo = correo;
		this.rating = rating;
		this.experiencia = experiencia;
		this.cantCasos = cantCasos;
		this.fechaIngreso = fechaIngreso;
	}


	public String getNombre() {
		return nombre;
	}


	public String getLugar() {
		return lugar;
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


	public int getCantCasos() {
		return cantCasos;
	}


	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	
	
	
	
	
}

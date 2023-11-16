package ControllersGUI;

import java.util.Date;

import interfacesGraficas.AsesorUI;

public class ControllerAsesor {
	private String nombre;
	private int id;
	private String lugar;
	private String correo;
	private int experiencia;
	private int cantidadCasos;
	private Date fechaIngreso;
	private AsesorUI tableAsesores;
	private double rating;
	
	public ControllerAsesor(String nombre, double rating, int id, String lugar, String correo, int experiencia, int cantidadCasos, Date fechaIngreso, AsesorUI tablaAsesores) {
		this.nombre = nombre;
		this.id = id;
		this.lugar = lugar;
		this.correo = correo;
		this.experiencia = experiencia;
		this.cantidadCasos = cantidadCasos;
		this.fechaIngreso = fechaIngreso;
		this.tableAsesores = tablaAsesores;
		this.rating = rating;
	}
	
	public void actualizarTablaAsesores() {
		tableAsesores.pintarTable( nombre,rating, id,  lugar,  correo,  experiencia,  cantidadCasos,  fechaIngreso);
	}
	
	public boolean verificarDatos() {
		boolean verificado = true;
		
		//Aquí tengo que validar el contenido de cada variable para ver si corresponde y no se haya metido algo incorrecto
		
		return verificado;
	}

	public String getNombre() {
		return nombre;
	}

	public int getId() {
		return id;
	}

	public String getLugar() {
		return lugar;
	}

	public String getCorreo() {
		return correo;
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

	public AsesorUI getTableAsesores() {
		return tableAsesores;
	}
	
	public double getRating() {
		return rating;
	}
	
	
	
	
}

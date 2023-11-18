package ControllersGUI;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

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
		// Obtener el modelo de la tabla
	    DefaultTableModel model = (DefaultTableModel) tableAsesores.getTable().getModel();
	    SimpleDateFormat dateOnly = new SimpleDateFormat("yyyy/MM/dd");
	    
	    // Agregar una nueva fila con la información proporcionada
	    model.addRow(new Object[]{nombre, id, lugar, correo, experiencia, rating, cantidadCasos, dateOnly.format(fechaIngreso.getTime())});
	    
	    // Refrescar la tabla
	    tableAsesores.getTable().repaint();
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

package ControllersGUI;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import clasesLogicas.Asesor;
import interfacesGraficas.AsesorUI;
import strapi.Main;

public class ControllerAsesor {
	private Asesor asesor;
	private AsesorUI tableAsesores;
	
	public ControllerAsesor(String nombre, double rating, int id, String zona, String correo, int experiencia, int cantidadCasos, Date fechaIngreso, AsesorUI tablaAsesores) {
		asesor = new Asesor(nombre, id, zona, correo, rating, experiencia, cantidadCasos, fechaIngreso);
		this.tableAsesores = tablaAsesores;
		Main.asesoresRegistrados.add(asesor);
	}
	
	public void actualizarTablaAsesores() {
		// Obtener el modelo de la tabla
	    DefaultTableModel model = (DefaultTableModel) tableAsesores.getTable().getModel();
	    SimpleDateFormat dateOnly = new SimpleDateFormat("yyyy/MM/dd");
	    
	    // Agregar una nueva fila con la información proporcionada
	    model.addRow(new Object[]{asesor.getNombre(), asesor.getId(), asesor.getZona(), asesor.getCorreo(), asesor.getExperiencia(), asesor.getRating(), 
	    						  asesor.getCantidadCasos(), dateOnly.format(asesor.getFechaIngreso().getTime())});
	    
	    // Refrescar la tabla
	    tableAsesores.getTable().repaint();
	}
	
	public boolean verificarDatos() {
		boolean verificado = true;
		
		//Aquí tengo que validar el contenido de cada variable para ver si corresponde y no se haya metido algo incorrecto
		
		return verificado;
	}

	public AsesorUI getTableAsesores() {
		return tableAsesores;
	}
	
	
	
	
}

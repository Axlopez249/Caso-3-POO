package ControllersGUI;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import clasesLogicas.Paso;
import interfacesGraficas.AgregarPlanEconomicoUI;

public class ControllerPaso {
	private Paso paso;
	private AgregarPlanEconomicoUI tablePasos;
	
	public ControllerPaso(String accion, String descripcion, int mes, int ingreso, String tipoIngreso, String estado, AgregarPlanEconomicoUI tablePasos) {
		this.paso = new Paso(accion, descripcion, mes, ingreso, tipoIngreso, estado);
		this.tablePasos = tablePasos;
	}
	
	public void actualizarTablaPasos() {
		// Obtener el modelo de la tabla
	    DefaultTableModel model = (DefaultTableModel) tablePasos.getTable().getModel();
	    String ingreso = "+";
	    if(paso.getTipoIngreso().equals("Negativo")) {
	    	ingreso = "-";
	    }
	    
	    ingreso += Integer.toString(paso.getIngreso());
	    
	    // Agregar una nueva fila con la información proporcionada
	    model.addRow(new Object[]{paso.getAccion(), paso.getDescripcion(), paso.getMes(), ingreso, paso.getEstado()});
	    
	    // Refrescar la tabla
	    tablePasos.getTable().repaint();
	}
	
	public boolean verificarDatos() {
		boolean verificado = true;
		
		//Aquí tengo que validar el contenido de cada variable para ver si corresponde y no se haya metido algo incorrecto
		
		return verificado;
	}

	public AgregarPlanEconomicoUI getTableAsesores() {
		return tablePasos;
	}

	public Paso getPaso() {
		return paso;
	}
	
	
}

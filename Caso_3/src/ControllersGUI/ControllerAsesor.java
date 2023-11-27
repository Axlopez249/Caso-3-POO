package ControllersGUI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import clasesLogicas.Asesor;
import strapi.Main;

public class ControllerAsesor {
	
	public void actualizarTablaAsesores(JTable table) {
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		// Limpia la tabla actual.
		model.setRowCount(0);
		
	    SimpleDateFormat dateOnly = new SimpleDateFormat("yyyy/MM/dd");
	    
	    // Agregar la información actual de asesores
	    ArrayList<Asesor> asesores = Main.getAsesores();
		if(asesores != null) {
			for(Asesor asesor: asesores) {
				model.addRow(new Object[]{asesor.getNombre(), asesor.getId(), asesor.getZona(), asesor.getCorreo(), asesor.getExperiencia(), asesor.getRating(), 
			    						  asesor.getCantidadCasos(), dateOnly.format(asesor.getFechaIngreso().getTime())});
		    }
	    }
	    // Refrescar la tabla
		table.repaint();
	}
	
	public void añadirAsesor(JTextField txtNombre, JTextField txtId, JTextField txtCorreo, JTextField txtExperiencia, String zona) {
		
		if(txtNombre.getText().isBlank() || txtId.getText().isBlank() || txtCorreo.getText().isBlank() || txtExperiencia.getText().isBlank()) {

		    JOptionPane.showMessageDialog(null, "Por favor complete todos los espacios.");
		}else {
			
			Calendar cal = Calendar.getInstance();
			Asesor asesor = new Asesor(txtNombre.getText(), Integer.parseInt(txtId.getText()), zona, txtCorreo.getText(), 0,  Integer.parseInt(txtExperiencia.getText()), 0, cal.getTime());
			boolean encontrado = false;
		    ArrayList<Asesor> asesores = Main.getAsesores();
			for(Asesor asesorAlmacenado: asesores) {
				if(asesorAlmacenado.getId() == Integer.parseInt(txtId.getText())) {
					encontrado = true;
				}
			}
			if(!encontrado) {
				Main.getAsesores().add(asesor);
			}else {
				JOptionPane.showMessageDialog(null, "El asesor ya está registrado en el sistema, no se puede volver a registrar.");
			}
		}
	}
	
}

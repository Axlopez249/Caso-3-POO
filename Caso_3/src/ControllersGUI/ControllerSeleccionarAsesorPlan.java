package ControllersGUI;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import clasesLogicas.Asesor;
import clasesLogicas.Caso;
import strapi.Main;

public class ControllerSeleccionarAsesorPlan {
	
	public void getComboBoxSelection(JComboBox<String> comboBox_casos, JComboBox<String> comboBox_asesores) {

		comboBox_asesores.removeAllItems();
		comboBox_casos.removeAllItems();
	    for (Asesor asesor : Main.getAsesores()) {
	        comboBox_asesores.addItem(Integer.toString(asesor.getId()));
	    }
	    comboBox_asesores.revalidate();
	    comboBox_asesores.repaint();
	    if(comboBox_asesores.getItemCount() == 0) {
	    	comboBox_asesores.addItem(".");
	    }
	    
	    for (Caso caso : Main.getCasos()) {
	    	comboBox_casos.addItem(Integer.toString(caso.getIdCaso()));
	    }
	    comboBox_casos.revalidate();
	    comboBox_casos.repaint();
	    if(comboBox_casos.getItemCount() == 0) {
	    	comboBox_casos.addItem(".");
	    }
	}
	
	public boolean seleccionarAsesor(JComboBox<String> comboBox_casos, JComboBox<String> comboBox_asesores) {
		if (comboBox_asesores.getSelectedItem().toString()!= ".") {

			int IDAsesor = Integer.parseInt(comboBox_asesores.getSelectedItem().toString());
			int IDCaso = Integer.parseInt(comboBox_casos.getSelectedItem().toString());
			
			Asesor asesor = null;
			for(Asesor asesorAlmacenado : Main.getAsesores()) {
				if(asesorAlmacenado.getId() == IDAsesor) {
					asesor = asesorAlmacenado;
					break;
				}
			}
			Caso caso = null;
			for(Caso casoAlmacenado: Main.getCasos()) {
				if(casoAlmacenado.getIdCaso() == IDCaso) {
					caso = casoAlmacenado;
				}
			}
			
			if(caso.getZona().equals(asesor.getZona())) {
				Main.agregarPlanUI.setVisible(true);
				Main.agregarPlanUI.setNombreAsesor(asesor.getNombre());
				Main.agregarPlanUI.setIDCaso(IDCaso);
				return true;
			}else {
				JOptionPane.showMessageDialog(null, "El asesor debe operar en la misma zona del caso.");
				return false;
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "No se ha seleccionado Asesor o Caso.");
			return false;
		}
	}
}

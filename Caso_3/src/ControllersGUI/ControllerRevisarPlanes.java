package ControllersGUI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clasesLogicas.Asesor;
import clasesLogicas.Caso;
import strapi.Main;

public class ControllerRevisarPlanes {
	Caso caso;
	
	public boolean buscarPlan(int IDCaso) {
		caso = null;
		for(Caso casoAlmacenado: Main.getCasos()) {
			if(casoAlmacenado.getIdCaso() == IDCaso) {
				caso = casoAlmacenado;
				break;
			}
		}
		
		if(caso == null || caso.getEstado().equals("No asignado")) {

			JOptionPane.showMessageDialog(null, "Este caso no posee un plan asignado.");
			return false;
		}
		
		actualizarTabla(Main.revisarPlanesUI.getTable());
		return true;
	}
	
	public void actualizarTabla(JTable table) {

		DefaultTableModel model = (DefaultTableModel)table.getModel();
		// Limpia la tabla actual.
		model.setRowCount(0);
	    
		model.addRow(new Object[]{caso.getAsesor().getNombre(), caso.getZona(), caso.getAsesor().getCorreo()});
	    // Refrescar la tabla
		table.repaint();
	}
	
	public int getIDCaso(){
		return caso.getIdCaso();
	}
}


package ControllersGUI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import clasesLogicas.Agricultor;
import clasesLogicas.Asesor;
import clasesLogicas.Caso;
import clasesLogicas.InfoTemporal;
import clasesLogicas.PlanEconomico;
import clasesLogicas.Producto;
import clasesLogicas.Terreno;
import strapi.Main;

public class ControllerCaso {
	
	
	public void actualizarTablaAsesores(JTable table1, JTable table2) {
		
		// Obtener el modelo de la tabla
		DefaultTableModel model1 = (DefaultTableModel)table1.getModel();
		// Limpia la tabla actual.
		model1.setRowCount(0);

		DefaultTableModel model2 = (DefaultTableModel)table2.getModel();
		model2.setRowCount(0);
			    
		// Agregar la información actual de asesores
		ArrayList<Caso> casos = Main.getCasos();
		if(casos != null) {
			for(Caso caso: casos) {
				model1.addRow(new Object[]{caso.getAgricultor().getNombre(), caso.getIdCaso(), caso.getTelefonoAgricultor(), caso.getAgricultor().getTerreno().getHectareas(), 
										  caso.getAgricultor().getTerreno().getTipoSuelo(), caso.getZona(), caso.getAgricultor().getDeuda(), caso.getAgricultor().getDinero(), 
										  caso.getOrganiRepresentante(), caso.getEstado()});
				model2.addRow(new Object[]{caso.getAgricultor().getId(), caso.getAgricultor().getTerreno().getHectareas(), caso.getAgricultor().getTerreno().isSiembra(),
										   caso.getAgricultor().getProducto(), caso.getAgricultor().getDeuda(), caso.getAgricultor().getDinero(),
										   caso.getAgricultor().getIngresosActuales(), caso.getAgricultor().getGananciasAñoPasado()});
			}
		}
		// Refrescar la tabla
		table1.repaint();
	}
	
	public void añadirCaso(JTextField agricultorT, JTextField telefonoAT, JTextField terrenoDisponibleT, JTextField cantidadActualT, JTextField dineroDisponibleT, 
						  JTextField ingresosActualesT, JTextField gananciaAnoPasadoT, JTextField organizacionT, JTextField deudaT, ButtonGroup bgTipoSuelo, ButtonGroup bgTieneSiembra, String zona) {
		
		Random random = new Random();
		int IDAgricultor = random.nextInt(9000) + 1000;
				
		Date currentDate = new Date();
		// Crear un objeto Calendar y establecer la fecha actual
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		// Incrementar la fecha en 30 días
		calendar.add(Calendar.DAY_OF_MONTH, 30);

		String terrainType = bgTipoSuelo.getSelection().getActionCommand();
		boolean tieneSiembra = false;

		if(bgTieneSiembra.getSelection().getActionCommand().equals("Si")) {
			tieneSiembra = true;
		}
		        
		Asesor asesor = new Asesor("Null", 0, "Null","Null", 1.1, 1, 1, calendar.getTime());
		Producto producto = new Producto("Papa", false, calendar.getTime(), Integer.parseInt(cantidadActualT.getText()), agricultorT.getText());
				
		Terreno terreno = new Terreno(terrainType, tieneSiembra, Integer.parseInt(terrenoDisponibleT.getText()), agricultorT.getText());
													
		Agricultor agricultor = new Agricultor(agricultorT.getText(), IDAgricultor, Double.parseDouble(dineroDisponibleT.getText()), 
				Double.parseDouble(deudaT.getText()), Integer.parseInt(telefonoAT.getText()), 
				Double.parseDouble(ingresosActualesT.getText()), Double.parseDouble(gananciaAnoPasadoT.getText()), terreno, producto);
		
		boolean encontrado = false;
		int IDCaso;

		do {
			IDCaso = random.nextInt(9000) + 1000;
			for(Caso casoAlmacenado: Main.getCasos()) {
				if(casoAlmacenado.getIdCaso() == IDCaso) {
					encontrado = true;
					break;
				}
				encontrado = false;
			}
		}while(encontrado);

		Caso caso = new Caso(IDCaso, agricultor, Integer.parseInt(telefonoAT.getText()), asesor, zona, 00000000, organizacionT.getText(), calendar.getTime(), "No asignado");
		Main.getCasos().add(caso);
		
		PlanEconomico plan = null;
			
		InfoTemporal infoTemporal = new InfoTemporal(agricultor.getNombre(), Integer.parseInt(telefonoAT.getText()), 
														 Integer.parseInt(terrenoDisponibleT.getText()), terrainType, zona,
														 Double.parseDouble(deudaT.getText()), Double.parseDouble(dineroDisponibleT.getText()), organizacionT.getText(), plan);
		 
		Main.infoTemporalessinasignar.add(infoTemporal);
		
	}
	
}

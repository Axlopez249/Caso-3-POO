package ControllersGUI;

import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import clasesLogicas.InfoTemporal;
import strapi.Main;

public class ActualizadorTablaPlan {

	
	public ActualizadorTablaPlan() { 
	}

	public void actualizarTable(JTable table) {
		JTable tableCaso = Main.CasoUI.getTable();
		

		// Obtiene el modelo de la tabla
        TableModel model = tableCaso.getModel();

        // Obtiene el número de filas en la tabla
        int rowCount = model.getRowCount();

        // Itera a través de cada fila
        for (int i = 0; i < rowCount; i++) {
            // Obtén los datos de cada columna en la fila actual
            String nameAgricultor = model.getValueAt(i, 0).toString(); // Datos de la columna 0
            int telefonoAgricultor = Integer.parseInt(model.getValueAt(i, 1).toString()); // Datos de la columna 1
            double terrenoDisponible = Double.parseDouble(model.getValueAt(i, 2).toString()); 
            String tipoTerreno = model.getValueAt(i, 3).toString();
            String provincia = model.getValueAt(i, 4).toString();
            double deuda = Double.parseDouble(model.getValueAt(i, 5).toString());
            double dineroDisponible = Double.parseDouble(model.getValueAt(i, 6).toString());
            String organizacion = model.getValueAt(i, 7).toString();
            String estado = model.getValueAt(i, 8).toString();
            
            //Si de la fila que tengo el estado es no asignado entonces la pinto en mi tabla
            if (estado.equals("no asignado")) {
            	// Obtener el modelo de la tabla
        	    DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
        	    
        	    // Agregar una nueva fila con la información proporcionada
        	    modelTable.addRow(new Object[]{nameAgricultor, telefonoAgricultor, terrenoDisponible, tipoTerreno, provincia, deuda, dineroDisponible, organizacion});
			}   
        }
        table.repaint();
	}
	
	public InfoTemporal extraerDatos(int filaSeleccionada, JTable table) {
            // Obtener los datos de la fila seleccionada
            String nombre = table.getValueAt(filaSeleccionada, 0).toString();
            int telefonoAgricultor = Integer.parseInt(table.getValueAt(filaSeleccionada, 1).toString());
            double terrenoDisponible = Double.parseDouble(table.getValueAt(filaSeleccionada, 2).toString());
            String tipoTerreno = table.getValueAt(filaSeleccionada, 3).toString();
            String provincia = table.getValueAt(filaSeleccionada, 4).toString();
            double deuda = Double.parseDouble(table.getValueAt(filaSeleccionada, 5).toString());
            double dineroDisponible = Double.parseDouble(table.getValueAt(filaSeleccionada, 6).toString());
            String organizacion = table.getValueAt(filaSeleccionada, 7).toString();
            
            InfoTemporal infoTemporal = new InfoTemporal(nombre, telefonoAgricultor, terrenoDisponible, tipoTerreno, provincia, deuda, dineroDisponible, organizacion, null);
            return infoTemporal;
	}
	
}	


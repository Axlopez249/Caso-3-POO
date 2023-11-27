package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import ControllersGUI.ActualizadorTablaPlan;
import clasesLogicas.InfoTemporal;
import strapi.Main;

//Los estados pueden ser asignado con plan asignado
//O sin asignar

public class PlanEconomicoUI extends JFrame{
	private JTable table;
	private ActualizadorTablaPlan actualizador = new ActualizadorTablaPlan();
	private InfoTemporal infoTemporal;

	public PlanEconomicoUI(CasoUI caso){
		
		//Lo primero es pintar este table con los casos no asignados
		//Entonces lo que puedo hacer es mandar todo el table y recorrer aquellos como estado no asignado
		//Y guardarlo en este table
		
		setTitle("Asesores en Agricultura");
		setSize(1350, 725);
	    
	    getContentPane().setLayout(null);
	    
	    DefaultTableModel model = new DefaultTableModel();
	    model.addColumn("Agricultor");
	    model.addColumn("ID Caso");
	    model.addColumn("Teléfono agricultor");
	    model.addColumn("Terreno disponible");
	    model.addColumn("Tipo de terreno");
	    model.addColumn("Provincia");
	    model.addColumn("Deuda");
	    model.addColumn("Dinero disponible");
	    model.addColumn("Organización representante");
	    
	    table = new JTable(model);
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Modo de selección de una sola fila
	
	    table.setBounds(10, 10, 200, 200);
	    
	    
	    JButton crearPlan = new JButton("Crear plan economico");
	    
	    crearPlan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Ademas de llamar a la ventana tengo que seleccionar el caso 
				//Obtener los datos de ese caso para ponerlo como asignado luego
				
				//Activo para preguntar por los asesores
				
				//Luego se abre la ventana
				Main.seleccionarAsesor.setVisible(true);
				Main.seleccionarAsesor.crearSeleccion();
				//Cuando la ventana se cierra 
				dispose();
			}
	    });
	    
	    JButton asignarPlan = new JButton("Asignar plan economico");
	    asignarPlan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Ademas de llamar a la ventana tengo que seleccionar el caso 
				//Obtener los datos de ese caso para ponerlo como asignado luego
				int filaSeleccionada = table.getSelectedRow();
				if (filaSeleccionada != -1) {
					int entero = (Integer) table.getValueAt(filaSeleccionada, 1);
					infoTemporal = actualizador.extraerDatos(filaSeleccionada, table);
					Main.planDisponible.setVisible(true);
					Main.planDisponible.pintarTable(entero);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Selecciona una fila primero.");
				}
				
			
			}
	    });
	    
	    JButton botonSalir = new JButton("Salir");
	    botonSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.Ventana.setVisible(true);
				dispose();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
			}
	    });
	    
	    crearPlan.setBounds(200, 550, 200, 100);
	    botonSalir.setBounds(875, 550, 200, 100);
	    asignarPlan.setBounds(500, 550, 200, 100);
	    
	    getContentPane().setLayout(new BorderLayout());
	    JScrollPane panelDesplazamiento = new JScrollPane(table);
	    
	    getContentPane().add(crearPlan);
	    getContentPane().add(botonSalir);
	    getContentPane().add(asignarPlan);
	    getContentPane().add(panelDesplazamiento);
	    setLocationRelativeTo(null);
	    
	    
	    
	}
	
	public void pintarTable() {
		actualizador.actualizarTable(table);
	}
	
	public InfoTemporal getInfo() {
		return infoTemporal;
	}

}
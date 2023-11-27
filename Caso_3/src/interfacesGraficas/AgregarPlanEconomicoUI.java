package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import ControllersGUI.ControllerAgregarPlan;
import ControllersGUI.ControllerPlanEconomico;
import clasesLogicas.Paso;
import strapi.Main;

public class AgregarPlanEconomicoUI extends JFrame{
	private JTable table;
	private ControllerPlanEconomico controller = new ControllerPlanEconomico();
	private ControllerAgregarPlan controllerAgregarPlan;
	private String nombreAsesor;
	private int IDCaso;
	
	public AgregarPlanEconomicoUI() {
		
		setTitle("Asesores");
        setSize(780, 750); // Set the desired size
        setResizable(false); // Disable frame resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(50, 60);
        getContentPane().setLayout(null);
        
		DefaultTableModel model = new DefaultTableModel();
		String[] columnas = {"Acción", "Descripción", "Mes de ejecución", "Ingreso", "Estado"};
	    
		for(String columna : columnas) {
			model.addColumn(columna);
	    }
	    
	    table = new JTable(model);
	    table.setDefaultEditor(Object.class, null);
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Modo de selección de una sola fila

        table.setBounds(10, 10, 600, 600);
        
        table.setRowHeight(30);table.setRowHeight(30);


        TableColumnModel columnModel = table.getColumnModel();
	    columnModel.getColumn(2).setPreferredWidth(50);
	    
	    table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	controller.setIndexSelected(table.getSelectedRow());
	        }
	    });

        JButton agregarPaso = new JButton("Agregar paso");
        JButton aceptar = new JButton("Crear caso");
        JButton cancelar = new JButton("Cancelar");
        
        aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Aqui es donde yo ya tengo el objeto PlanEconomico por medio del controller
				ArrayList<Paso> pasos = new ArrayList<Paso>();
				
				for(int rows = 0; rows < table.getRowCount(); rows++) {
					String ingreso = table.getValueAt(rows, 3).toString();
					
					String tipoIngreso = "Negativo";
					if(ingreso.charAt(0) == '+') {
						tipoIngreso = "Positivo";
					}
					ingreso = ingreso.substring(0);
					
					Paso paso = new Paso(table.getValueAt(rows, 0).toString(), table.getValueAt(rows, 1).toString(), Integer.parseInt(table.getValueAt(rows, 2).toString()),
										 Integer.parseInt(ingreso), tipoIngreso ,table.getValueAt(rows, 4).toString());
					pasos.add(paso);
				}
				
				controllerAgregarPlan = new ControllerAgregarPlan(nombreAsesor, IDCaso, pasos);   
				// ----------------------------------------------------------
				//Tengo que liberar las listas usadas
				//Y el string nombre del asesor
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.setRowCount(0);
				nombreAsesor = "";
				Main.planesEconomicosUI.setVisible(true);
				dispose();
			}
        });
        

        agregarPaso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.agregarPasoUI.setVisible(true);
				//Aqui tengo que pintar la tabla de APasoUI
				dispose();
			}
        });
        
        cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.setRowCount(0);
				Main.planesEconomicosUI.setVisible(true);
				dispose();
			}
        });
        
        agregarPaso.setBounds(10, 520, 200, 50);
        aceptar.setBounds(10, 590, 200, 100);
        cancelar.setBounds(555, 640, 200, 50);

        JScrollPane panelDesplazamiento = new JScrollPane(table);
        panelDesplazamiento.setBounds(10, 10, 745, 500);
	    
        getContentPane().add(agregarPaso);
        getContentPane().add(aceptar);
	    getContentPane().add(cancelar);
	    getContentPane().add(panelDesplazamiento);

        setLocationRelativeTo(null);
	}
	
	public JTable getTable() {
		return table;
	}
	
	public void setNombreAsesor(String nombre) {
		nombreAsesor = nombre;
	}

	public void setIDCaso(int iDCaso) {
		IDCaso = iDCaso;
	}
	
}

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

public class ModificarPlanEconomicoUI extends JFrame{
	private JTable table;
	private ControllerPlanEconomico controller = new ControllerPlanEconomico();
	private ControllerAgregarPlan controllerAgregarPlan;
	private String nombreAsesor;
	private int IDCaso;
	private ArrayList<Paso> pasos = new ArrayList<Paso>();
	
	public ModificarPlanEconomicoUI() {
		
		setTitle("Asesores");
        setSize(780, 750); // Set the desired size
        setResizable(false); // Disable frame resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pasos.clear();
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
        JButton marcarPaso = new JButton("Marcar paso");
        JButton DeseleccionarPaso = new JButton("Deseleccionar paso");
        JButton aceptar = new JButton("Aceptar");
	    
        ButtonGroup bgEstado = new ButtonGroup();
        
        JRadioButton rbPlaneado = controller.crearRadioButton("Planeado", 250, 520, 100, 30);
        JRadioButton rbPendiente = controller.crearRadioButton("Pendiente", 380, 520, 100, 30);
        JRadioButton rbEjecución = controller.crearRadioButton("Ejecución", 250, 560, 100, 30);
        JRadioButton rbCancelado = controller.crearRadioButton("Cancelado", 380, 560, 100, 30);
        JRadioButton rbCompletado = controller.crearRadioButton("Completado", 250, 600, 100, 30);
        JRadioButton rbIncompleto = controller.crearRadioButton("Imcompleto", 380, 600, 100, 30);
        
        
        aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Aqui es donde yo ya tengo el objeto PlanEconomico por medio del controller
				controllerAgregarPlan = new ControllerAgregarPlan(nombreAsesor, IDCaso, pasos);   // ----------------------------------------------------------
				//Tengo que liberar las listas usadas
				//Y el string nombre del asesor
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.setRowCount(0);
				pasos.clear();
				System.out.println(pasos.size());
				nombreAsesor = "";
				Main.planesEconomicosUI.setVisible(true);
				dispose();
			}
        });
        

        agregarPaso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bgEstado.clearSelection();
				Main.agregarPasoUI.setVisible(true);
				//Aqui tengo que pintar la tabla de APasoUI
				dispose();
			}
        });
        
        marcarPaso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bgEstado.getSelection() != null) {
					controller.CambiarEstado(table, bgEstado.getSelection().getActionCommand());
				}else {
					JOptionPane.showMessageDialog(null, "Por favor seleccione un estado");
				}
			}
        });
        
        DeseleccionarPaso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bgEstado.clearSelection();
				table.clearSelection();
			}
        });
        
        agregarPaso.setBounds(10, 520, 200, 50);
        marcarPaso.setBounds(10, 580, 200, 50);
        DeseleccionarPaso.setBounds(10, 640, 200, 50);
        aceptar.setBounds(535, 590, 220, 100);

        JScrollPane panelDesplazamiento = new JScrollPane(table);
        panelDesplazamiento.setBounds(10, 10, 745, 500);
	    
        getContentPane().add(agregarPaso);
        getContentPane().add(marcarPaso);
        getContentPane().add(DeseleccionarPaso);
        getContentPane().add(aceptar);
	    getContentPane().add(panelDesplazamiento);
        
        getContentPane().add(rbPlaneado);
        getContentPane().add(rbPendiente);
        getContentPane().add(rbEjecución);
        getContentPane().add(rbCancelado);
        getContentPane().add(rbCompletado);
        getContentPane().add(rbIncompleto);
        
        bgEstado.add(rbPlaneado);
        bgEstado.add(rbPendiente);
        bgEstado.add(rbEjecución);
        bgEstado.add(rbCancelado);
        bgEstado.add(rbCompletado);
        bgEstado.add(rbIncompleto);

        setLocationRelativeTo(null);
	}
	
	public JTable getTable() {
		return table;
	}
	
	public void setNombreAsesor(String nombre) {
		nombreAsesor = nombre;
	}

	public void actualizarListaPasos(Paso paso) {
		pasos.add(paso);
	}

	public void setIDCaso(int iDCaso) {
		IDCaso = iDCaso;
	}
	
}

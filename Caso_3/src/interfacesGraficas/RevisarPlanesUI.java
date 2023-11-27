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
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import ControllersGUI.ControllerRevisarPlanes;
import strapi.Main;
//Saldrian los casos ya asignados con un plan
public class RevisarPlanesUI extends JFrame {
    JTable table;
	
	private ControllerRevisarPlanes controller = new ControllerRevisarPlanes();
	
	public RevisarPlanesUI() {
		setTitle("Asesores en Agricultura");
		setSize(1350, 725);
        
        getContentPane().setLayout(null);
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Asesor a cargo");
        model.addColumn("Provincia");
        model.addColumn("Correo electrónico");
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Modo de selección de una sola fila

        table.setBounds(10, 10, 200, 200);
        
        JButton seleccionarPlan = new JButton("Seleccionar plan");
        JButton botonCancelar = new JButton("Cancelar");
        
        seleccionarPlan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {int filaSeleccionada = table.getSelectedRow();
			if (filaSeleccionada != -1) {
				
				Main.modificarPlanUI.setVisible(true);
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Selecciona una fila primero.");
			}
			}
        });
        
        botonCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.casoUI.setVisible(true);
				dispose();
			}
        });
        
        
        seleccionarPlan.setBounds(425, 550, 200, 100);
        botonCancelar.setBounds(675, 550, 200, 100);
        
        JScrollPane panelDesplazamiento = new JScrollPane(table);
        panelDesplazamiento.setBounds(10, 10, 1315, 500);
        
        getContentPane().add(seleccionarPlan);
        getContentPane().add(botonCancelar);
        getContentPane().add(panelDesplazamiento);

        setLocationRelativeTo(null);
	}
	
	public JTable getTable() {
		return table;
	}
	
	public ControllerRevisarPlanes getController() {
		return controller;
	}
}
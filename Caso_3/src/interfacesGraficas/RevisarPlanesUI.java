package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import strapi.Main;
//Saldrian los casos ya asignados con un plan
public class RevisarPlanesUI extends JFrame {
	public RevisarPlanesUI() {
		setTitle("Asesores en Agricultura");
		setSize(1350, 725);
        
        getContentPane().setLayout(null);
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Asesor a cargo");
        model.addColumn("Provincia");
        model.addColumn("Dinero generado");
        model.addColumn("Tiempo total");
        model.addColumn("Cantida de pasos");
        model.addColumn("Teléfono de asesor");
        model.addColumn("Correo electrónico");
        
        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Modo de selección de una sola fila

        table.setBounds(10, 10, 200, 200);
        
        JButton seleccionarPlan = new JButton("Seleccionar plan");
        JButton botonCancelar = new JButton("Cancelar");
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
	
}
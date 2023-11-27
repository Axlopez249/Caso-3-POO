package interfacesGraficas;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import strapi.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FurtherInformationUI extends JFrame {
	
	private JTable table = new JTable();
	
    public FurtherInformationUI() {
		setTitle("Ver más");
		setSize(1350, 725);
        
        getContentPane().setLayout(null);
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Agricultor");
        model.addColumn("Terreno disponible");
        model.addColumn("Productos sembrados");
        model.addColumn("Cantidad (kg)");
        model.addColumn("Deuda");
        model.addColumn("Dinero disponible");
        model.addColumn("Ingresos actuales");
        model.addColumn("Ganancia (año pasado)");
        
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Modo de selección de una sola fila

        table.setBounds(10, 10, 200, 200);
        
        JButton botonSalir = new JButton("Salir");
        
        botonSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.casoUI.setVisible(true);
				dispose();
			}
        });
        
        botonSalir.setBounds(475, 550, 400, 100);
        
        JScrollPane panelDesplazamiento = new JScrollPane(table);
        panelDesplazamiento.setBounds(10, 10, 1315, 500);

        getContentPane().add(botonSalir);
        getContentPane().add(panelDesplazamiento);

        JButton seleccionarButton = new JButton("Seleccionar Fila");
        seleccionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = table.getSelectedRow();
                if (filaSeleccionada != -1) {
                    int numeroF = (int) table.getValueAt(filaSeleccionada, 0);
                    int ID = (int) table.getValueAt(filaSeleccionada, 1);
                    String falla = (String) table.getValueAt(filaSeleccionada, 3);
                    ((DefaultTableModel) table.getModel()).removeRow(filaSeleccionada);
                } else {
                	
                }
            }
        });

        setLocationRelativeTo(null);

    }

	public JTable getTable() {
		return table;
	}
}
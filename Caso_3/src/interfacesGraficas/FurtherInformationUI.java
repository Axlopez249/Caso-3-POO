package interfacesGraficas;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import strapi.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FurtherInformationUI extends JFrame {
    public FurtherInformationUI() {
		setTitle("Ver más");
		setSize(1350, 725);
        
        getContentPane().setLayout(null);
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Agricultor");
//        model.addColumn("Teléfono agricultor");
        model.addColumn("Terreno disponible");
//        model.addColumn("Tipo de terreno");
//        model.addColumn("Provincia");
        model.addColumn("Productos sembrados");
        model.addColumn("Cantidad (kg)");
        model.addColumn("Deuda");
        model.addColumn("Dinero disponible");
        model.addColumn("Ingresos actuales");
        model.addColumn("Ganancia (año pasado)");
//        model.addColumn("Organización representante");
//        model.addColumn("Fecha de ingreso de caso");
/*
        model.addColumn("Asesor");
        model.addColumn("Provincia");
        model.addColumn("Teléfono asesor");
        model.addColumn("Correo del asesor");
*/
//        model.addColumn("Estado");
        
        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Modo de selección de una sola fila

        table.setBounds(10, 10, 200, 200);
        
        JButton botonSalir = new JButton("Salir");
        
        botonSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.CasoUI.setVisible(true);
				dispose();
			}
        });
        
        botonSalir.setBounds(475, 550, 400, 100);
        
        getContentPane().setLayout(new BorderLayout());
        JScrollPane panelDesplazamiento = new JScrollPane(table);

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

}
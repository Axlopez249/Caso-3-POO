package interfacesGraficas;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import ControllersGUI.ControllerCaso;
import strapi.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CasoUI extends JFrame {

	private ControllerCaso controller = new ControllerCaso();
	private JTable table;
	
    public CasoUI() {
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
//        model.addColumn("Productos sembrados");
//        model.addColumn("Cantidad (kg)");
        model.addColumn("Deuda");
        model.addColumn("Dinero disponible");
//        model.addColumn("Ingresos actuales");
//        model.addColumn("Ganancia (año pasado)");
        model.addColumn("Organización representante");
//        model.addColumn("Fecha de ingreso de caso");
/*
        model.addColumn("Asesor");
        model.addColumn("Provincia");
        model.addColumn("Teléfono asesor");
        model.addColumn("Correo del asesor");
*/
        model.addColumn("Estado");
        
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Modo de selección de una sola fila

        table.setBounds(10, 10, 200, 200);
        
        JButton verInformacion = new JButton("Ver más");
        verInformacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.verMasUI.setVisible(true);
				dispose();
			}
        });
        
        JButton agregarCaso = new JButton("Agregar caso");
        
        agregarCaso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.agregarCasoUI.setVisible(true);
				dispose();
			}
        });
        
        JButton planesXCaso = new JButton("Revisar planes por caso");
        
        planesXCaso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = table.getSelectedRow();
				if (filaSeleccionada != -1) {
					int entero = (Integer) table.getValueAt(filaSeleccionada, 1);
					
					if(Main.revisarPlanesUI.getController().buscarPlan(entero)) {
						Main.revisarPlanesUI.setVisible(true);
						dispose();
					}
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
			}
        });
        
        agregarCaso.setBounds(200, 550, 200, 100);
        verInformacion.setBounds(425, 550, 200, 100);
        planesXCaso.setBounds(650, 550, 200, 100);
        botonSalir.setBounds(875, 550, 200, 100);
        
        JScrollPane panelDesplazamiento = new JScrollPane(table);
        panelDesplazamiento.setBounds(10, 10, 1315, 500);
        
        getContentPane().add(verInformacion);
        getContentPane().add(agregarCaso);
        getContentPane().add(planesXCaso);
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
	
	public ControllerCaso getController() {
		return controller;
	}

}


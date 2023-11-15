package interfacesGraficas;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CasoUI extends JFrame {
	JTable table;
	DefaultTableModel model;
	public static CasoUI instance;
	public CasoUI() {
		setTitle("Asesores en Agricultura");
		setSize(1350, 725);
        
        getContentPane().setLayout(null);
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Agricultor");
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
        model.addColumn("Fecha de ingreso de caso");
/*
        model.addColumn("Asesor");
        model.addColumn("Provincia");
        model.addColumn("Teléfono asesor");
        model.addColumn("Correo del asesor");
*/
        model.addColumn("Estado");
        
        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Modo de selección de una sola fila

        table.setBounds(10, 10, 200, 200);
        
        JButton verInformacion = new JButton("Ver más");
        
        verInformacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FurtherInformation();
			}
        });
        
        JButton agregarCaso = new JButton("Agregar caso");
        
        agregarCaso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarCaso();
			}
        });
        
        JButton planesXCaso = new JButton("Revisar planes por caso");
        
        planesXCaso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				revisarPlanes();
			}
        });
        
        JButton botonSalir = new JButton("Salir");
        
        botonSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
        });
        agregarCaso.setBounds(200, 550, 200, 100);
        verInformacion.setBounds(425, 550, 200, 100);
        planesXCaso.setBounds(650, 550, 200, 100);
        botonSalir.setBounds(875, 550, 200, 100);
        
        getContentPane().setLayout(new BorderLayout());
        JScrollPane panelDesplazamiento = new JScrollPane(table);
        
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

    }
    
    
    public void revisarPlanes() {
    	RevisarPlanesUI.main(null);
    }
    
    public void agregarCaso() {
    	AgregarCasoUI.main(null);
    }
    
    public JTable getTable() {
    	return table;
    }
    
    public void rellenarJTable(String pName, int pTelefono, String pTerreno, int pTerrenoDisponible, String pProvincia, boolean pProductosSembrados, int pCantidadSembrada, int pDeuda, int pDineroDisponible, int pIngresosActuales, int pGananciaAnoPasado, String pOrganizacion) {
		model.addRow(new Object[]{pName, pTelefono, pTerreno, pTerrenoDisponible, pProvincia, pProductosSembrados, pCantidadSembrada, pDeuda, pDineroDisponible, pIngresosActuales, pGananciaAnoPasado, pOrganizacion});
        table = new JTable(model);
    }
    
    public void FurtherInformation() {
    	FurtherInformation.main(null);
    }
    
    public static CasoUI getInstanceCasoUI() {
    	if(instance == null) {
    		instance = new CasoUI();
    	}
		return instance;
    }
    
	public static void main(String args[]) {
		
		SwingUtilities.invokeLater(() -> {
			//Crea una instancia de la clase UI que será usada para mostrar los elementos
			CasoUI frame = CasoUI.getInstanceCasoUI();
			//Establece que cuando se corra el java application se va a mostrar la ventana recién creada, si no se agregara 
	        frame.setVisible(true);
	    });
	}

}
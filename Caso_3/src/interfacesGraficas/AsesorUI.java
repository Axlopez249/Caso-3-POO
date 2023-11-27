package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import ControllersGUI.ControllerAsesor;
import strapi.Main;

public class AsesorUI extends JFrame{
	
	private ControllerAsesor controller = new ControllerAsesor();
	private JTable table;
	
	public AsesorUI() {
		
		setTitle("Asesores");
        setSize(780, 750); // Set the desired size
        setResizable(false); // Disable frame resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(50, 60);
        getContentPane().setLayout(null);
        
		DefaultTableModel model = new DefaultTableModel();
		String[] columnas = {"Nombre", "ID", "Lugar", "Correo Electrónico", "Experiencia", "Rating", "Casos", "Ingreso"};
	    
		for(String columna : columnas) {
			model.addColumn(columna);
	    }
	    
	    table = new JTable(model);
	    table.setDefaultEditor(Object.class, null);
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Modo de selección de una sola fila

        table.setBounds(10, 10, 600, 600);
        
        table.setRowHeight(30);

        int[] anchoColumnas = {160, 70, 80, 180, 70, 50, 50};
        
        TableColumnModel columnModel = table.getColumnModel();
        for(int i = 0; i < anchoColumnas.length; i++) {
    	    columnModel.getColumn(i).setPreferredWidth(anchoColumnas[i]);
        }
        
        JButton agregarAsesor = new JButton("Agregar Asesor");
        JButton volver = new JButton("Volver");
        
        volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.Ventana.setVisible(true);
				dispose();
			}
        });

        agregarAsesor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.agregarAsesorUI.setVisible(true);
				dispose();
			}
        });
        
        agregarAsesor.setBounds(200, 550, 200, 100);
        volver.setBounds(425, 550, 200, 100);

        JScrollPane panelDesplazamiento = new JScrollPane(table);
        panelDesplazamiento.setBounds(10, 10, 745, 500);
	    
        getContentPane().add(agregarAsesor);
        getContentPane().add(volver);
	    getContentPane().add(panelDesplazamiento);
	    
	    controller.actualizarTablaAsesores(table);

        setLocationRelativeTo(null);
	}

	public JTable getTable() {
		return table;
	}
	
	
}

package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import strapi.Main;

public class AsesorUI extends JFrame{
	private JTable table;
	
	public AsesorUI() {
		
		setTitle("Asesores");
        setSize(780, 750); // Set the desired size
        setResizable(false); // Disable frame resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(50, 60);
        getContentPane().setLayout(null);
        
		DefaultTableModel model = new DefaultTableModel();
	    model.addColumn("Nombre");
	    model.addColumn("ID");
	    model.addColumn("Lugar");
	    model.addColumn("Correo Electrónico");
	    model.addColumn("Años de Experiencia");
	    model.addColumn("Rating");
	    model.addColumn("Casos completados");
	    model.addColumn("Fecha de ingreso");
	    
	    table = new JTable(model);
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Modo de selección de una sola fila

        table.setBounds(10, 10, 600, 600);

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
				Main.AAsesorUI.setVisible(true);
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

        setLocationRelativeTo(null);
	}

	public JTable getTable() {
		return table;
	}
	
	public void pintarTable(String nombre,double rating,  int id, String lugar, String correo, int experiencia, int cantidadCasos, Date fechaIngreso) {
		// Obtener el modelo de la tabla
	    DefaultTableModel model = (DefaultTableModel) table.getModel();

	    // Agregar una nueva fila con la información proporcionada
	    model.addRow(new Object[]{nombre, id, lugar, correo, experiencia, rating, cantidadCasos, fechaIngreso});

	    // Refrescar la tabla
	    table.repaint();
	}
}

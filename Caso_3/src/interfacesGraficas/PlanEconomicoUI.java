package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import strapi.Main;

public class PlanEconomicoUI extends JFrame{
	
	public PlanEconomicoUI() {
		
		setTitle("Asesores");
        setSize(780, 750); // Set the desired size
        setResizable(false); // Disable frame resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(50, 60);
        getContentPane().setLayout(null);
        
		DefaultTableModel model = new DefaultTableModel();
	    model.addColumn("Acción");
	    model.addColumn("Descripción");
	    model.addColumn("Mes de ejecución");
	    model.addColumn("Ingreso o salida");
	    model.addColumn("Dinero");
	    model.addColumn("Estado");
	    
	    JTable table = new JTable(model);
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Modo de selección de una sola fila

        table.setBounds(10, 10, 600, 600);

        JButton agregarPaso = new JButton("Agregar paso");
        JButton marcarPaso = new JButton("Marcar paso");
        JButton volver = new JButton("Volver");
        
        volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.Ventana.setVisible(true);
				dispose();
			}
        });
        

        agregarPaso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.APasoUI.setVisible(true);
				dispose();
			}
        });
        
        agregarPaso.setBounds(150, 540, 200, 50);
        marcarPaso.setBounds(150, 600, 200, 50);
        volver.setBounds(400, 545, 220, 100);

        JScrollPane panelDesplazamiento = new JScrollPane(table);
        panelDesplazamiento.setBounds(10, 10, 745, 500);
	    
        getContentPane().add(agregarPaso);
        getContentPane().add(marcarPaso);
        getContentPane().add(volver);
	    getContentPane().add(panelDesplazamiento);

        setLocationRelativeTo(null);
	}
	
}

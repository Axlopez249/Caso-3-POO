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
				dispose();
			}
        });
        
        
        seleccionarPlan.setBounds(425, 550, 200, 100);
        botonCancelar.setBounds(675, 550, 200, 100);
        
        getContentPane().setLayout(new BorderLayout());
        JScrollPane panelDesplazamiento = new JScrollPane(table);
        
        getContentPane().add(seleccionarPlan);
        getContentPane().add(botonCancelar);
        getContentPane().add(panelDesplazamiento);

	}
	
	
	public static void main(String args[]) {
		
		SwingUtilities.invokeLater(() -> {
			//Crea una instancia de la clase UI que será usada para mostrar los elementos
			RevisarPlanesUI frame = new RevisarPlanesUI();
			//Establece que cuando se corra el java application se va a mostrar la ventana recién creada, si no se agregara 
	        frame.setVisible(true);
	    });
	}
	
}
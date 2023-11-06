package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class PruebaJTable extends JFrame {
	public PruebaJTable() {
		
		setTitle("Asesores en Agricultura");
		setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(50, 60);
        getContentPane().setLayout(null);
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Agricultor");
        model.addColumn("Teléfono agricultor");
        model.addColumn("Terreno disponible");
        model.addColumn("Tipo de terreno");
        model.addColumn("Provincia");
        model.addColumn("Productos sembrados");
        model.addColumn("Cantidad (kg)");
        model.addColumn("Deuda");
        model.addColumn("Dinero disponible");
        model.addColumn("Ingresos actuales");
        model.addColumn("Ganancia (año pasado)");
        model.addColumn("Organización representante");
        model.addColumn("Fecha de ingreso de caso");
        model.addColumn("Asesor");
        model.addColumn("Provincia");
        model.addColumn("Teléfono asesor");
        model.addColumn("Correo del asesor");
        model.addColumn("Estado");
        
        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Modo de selección de una sola fila

        table.setBounds(10, 10, 700, 700);
        
        JButton boton = new JButton("Botón");
        boton.setBounds(200, 200, 125, 50);
        
        getContentPane().setLayout(new BorderLayout());
        JScrollPane panelDesplazamiento = new JScrollPane(table);
        
        getContentPane().add(boton);
        getContentPane().add(panelDesplazamiento);

	}
	
	
	public static void main(String args[]) {
		
		SwingUtilities.invokeLater(() -> {
			//Crea una instancia de la clase UI que será usada para mostrar los elementos
			PruebaJTable frame = new PruebaJTable();
			//Establece que cuando se corra el java application se va a mostrar la ventana recién creada, si no se agregara 
	        frame.setVisible(true);
	    });
	}
	
}

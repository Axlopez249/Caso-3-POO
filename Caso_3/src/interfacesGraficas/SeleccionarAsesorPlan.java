package interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import clasesLogicas.Asesor;
import clasesLogicas.Caso;
import strapi.Main;

public class SeleccionarAsesorPlan extends JFrame{
	private JComboBox<String> comboBox_asesores;
	private JComboBox<String> comboBox_casos;
	
	public SeleccionarAsesorPlan() {

		setTitle("Seleccion de asesores");
        setSize(780, 550); // Set the desired size
        setResizable(false); // Disable frame resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(50, 60);
        getContentPane().setLayout(null);
        
        // Agregar otro comboBox que tenga los ID de los casos

        JButton seleccionarAsesor = new JButton("Seleccionar Asesor");
        seleccionarAsesor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombreAsesor = comboBox_asesores.getSelectedItem().toString();
				int IDCaso = Integer.parseInt(comboBox_casos.getSelectedItem().toString());
				if (comboBox_asesores.getSelectedItem().toString()!= ".") {
					Main.plan.setVisible(true);
					Main.plan.setNombreAsesor(nombreAsesor);
					Main.plan.setIDCaso(IDCaso);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "No hay asesores o debe seleccionar uno válido");
				}
			}
        });
        
        JButton volver = new JButton("Salir");
        volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.planesEconomicos.setVisible(true);
				dispose();
			}
        });
        
        comboBox_asesores = new JComboBox<>();
        comboBox_asesores.addItem(".");
        
        comboBox_casos = new JComboBox<>();
        comboBox_casos.addItem(".");
        
        seleccionarAsesor.setBounds(150, 350, 200, 100);
        volver.setBounds(450, 350, 200, 100);
        comboBox_casos.setBounds(190, 200, 200, 100);
        comboBox_asesores.setBounds(410, 200, 200, 100);
        
        getContentPane().add(seleccionarAsesor);
        getContentPane().add(volver);
        getContentPane().add(comboBox_casos);
        getContentPane().add(comboBox_asesores);

        setLocationRelativeTo(null);
	}
	
	public void crearSeleccion() {
		// Agrego las opciones después de la creación
		comboBox_asesores.removeAllItems();
		comboBox_casos.removeAllItems();
	    for (Asesor asesor : Main.asesoresRegistrados) {
	        comboBox_asesores.addItem(asesor.getNombre());
	        System.out.println(asesor.getNombre());
	        System.out.println(Main.casos.size());
	    }
	    comboBox_asesores.revalidate();
	    comboBox_asesores.repaint();
	    for (Caso caso : Main.casos) {
	    	comboBox_casos.addItem(Integer.toString(caso.getIdCaso()));
	    	System.out.println(caso.getIdCaso());
	    }
	    comboBox_casos.revalidate();
	    comboBox_casos.repaint();
	    
	}
	
	public static void main(String[]args) {
		SeleccionarAsesorPlan x = new SeleccionarAsesorPlan();
		x.setVisible(true);
	}
}

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
import strapi.Main;

public class SeleccionarAsesorPlan extends JFrame{
	private JComboBox<String> comboBox_asesores;
	
	public SeleccionarAsesorPlan() {

		setTitle("Seleccion de asesores");
        setSize(780, 750); // Set the desired size
        setResizable(false); // Disable frame resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(50, 60);
        getContentPane().setLayout(null);
        
        
        

        JButton seleccionarAsesor = new JButton("Seleccionar Asesor");
        seleccionarAsesor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombreAsesor = comboBox_asesores.getSelectedItem().toString();
				if (comboBox_asesores.getSelectedItem().toString()!= ".") {
					Main.plan.setVisible(true);
					Main.plan.setNombreAsesor(nombreAsesor);
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
        
        seleccionarAsesor.setBounds(150, 550, 200, 100);
        volver.setBounds(450, 550, 200, 100);
        comboBox_asesores.setBounds(300, 300, 200, 100);
        
        
        getContentPane().add(seleccionarAsesor);
        getContentPane().add(volver);
        getContentPane().add(comboBox_asesores);

        setLocationRelativeTo(null);
	}
	
	public void crearSeleccion() {
		// Agrego las opciones después de la creación
		
	    for (Asesor asesor : Main.asesoresRegistrados) {
	        comboBox_asesores.addItem(asesor.getNombre());
	        System.out.println(asesor.getNombre());
	    }
	    comboBox_asesores.revalidate();
	    comboBox_asesores.repaint();
	}
	
	public static void main(String[]args) {
		SeleccionarAsesorPlan x = new SeleccionarAsesorPlan();
		x.setVisible(true);
	}
}

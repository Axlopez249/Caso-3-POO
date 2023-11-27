package interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ControllersGUI.ControllerSeleccionarAsesorPlan;
import clasesLogicas.Asesor;
import clasesLogicas.Caso;
import strapi.Main;

public class SeleccionarAsesorPlan extends JFrame{
	
	private ControllerSeleccionarAsesorPlan controller = new ControllerSeleccionarAsesorPlan();
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
			
			try {
			    if(controller.seleccionarAsesor(comboBox_casos, comboBox_asesores)) {
					dispose();
			    }
			}catch(Exception er) {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error: \n" + er);
			}
			
			}
        });
        
        JButton volver = new JButton("Salir");
        volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.planesEconomicosUI.setVisible(true);
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

	    controller.getComboBoxSelection(comboBox_casos, comboBox_asesores);
	    
	}
	
	public static void main(String[]args) {
		SeleccionarAsesorPlan x = new SeleccionarAsesorPlan();
		x.setVisible(true);
	}
}

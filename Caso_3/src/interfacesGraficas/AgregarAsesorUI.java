package interfacesGraficas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import ControllersGUI.ControllerAgregarAsesor;
import ControllersGUI.ControllerAsesor;
import ControllersGUI.ControllerZonas;
import strapi.Main;

public class AgregarAsesorUI extends JFrame {
	
	private ControllerAgregarAsesor controller;
	
	public AgregarAsesorUI(AsesorUI tablaAsesores) {
		
		setTitle("Agregar Asesor");
		setSize(380, 390); // Set the desired size
        setResizable(false); // Disable frame resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(50, 60);
        getContentPane().setLayout(null);

        JLabel lblNombre = new JLabel("Nombre: ");
        lblNombre.setBounds(20, 20, 330, 40);
        getContentPane().add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(140, 30, 200, 30);
        getContentPane().add(txtNombre);

        JLabel lblId = new JLabel("Identificación: ");
        lblId.setBounds(20, 70, 330, 40);
        getContentPane().add(lblId);

        JTextField txtId = new JTextField();
        txtId.setBounds(140, 80, 200, 30);
        getContentPane().add(txtId);

        JLabel lblZona = new JLabel("Zona de operación: ");
        lblZona.setBounds(20, 120, 330, 40);
        getContentPane().add(lblZona);

        ControllerZonas getZonas = new ControllerZonas();
        
        JComboBox<String> cmbZona = getZonas.getCmb();
        cmbZona.setBounds(140, 130, 200, 30);
        
        
        getContentPane().add(cmbZona);

        JLabel lblCorreo = new JLabel("Correo electrónico: ");
        lblCorreo.setBounds(20, 170, 330, 40);
        getContentPane().add(lblCorreo);

        JTextField txtCorreo = new JTextField();
        txtCorreo.setBounds(140, 180, 200, 30);
        getContentPane().add(txtCorreo);

        JLabel lblExperiencia = new JLabel("Años experiencia: ");
        lblExperiencia.setBounds(20, 220, 330, 40);
        getContentPane().add(lblExperiencia);

        JTextField txtExperiencia = new JTextField();
        txtExperiencia.setBounds(140, 230, 200, 30);
        getContentPane().add(txtExperiencia);
        
        JButton btnAgregarAsesor = new JButton("Guardar Asesor");
        JButton btnCancelar = new JButton("Cancelar");

        btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.AsesorUI.setVisible(true);
				dispose();
			}
        });

        btnAgregarAsesor.setBounds(60, 280, 130, 50);
        
        btnAgregarAsesor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Tienene que haber un tipo de seguridad a la hora de tomar los datos
				//puede ser en el mismo controller de esta clase

				//Primero saco la info de cata jtxt
				try {
					String nombre = txtNombre.getText();
					int id = Integer.parseInt(txtId.getText());
					String zona = (String) cmbZona.getSelectedItem();
					String correo = txtCorreo.getText();
					int experiencia = Integer.parseInt(txtExperiencia.getText());
					
					Calendar cal = Calendar.getInstance();
					
					ControllerAsesor controller = new ControllerAsesor(nombre, 0 , id, zona, correo, experiencia, 0, cal.getTime(), tablaAsesores);
					controller.actualizarTablaAsesores();
				} catch (Exception e1) {
				    // Captura la excepción si hay un error al convertir a int o double
				    JOptionPane.showMessageDialog(null, "Uno de los contenidos no corresponde");
				}
				txtNombre.setText("");
				txtId.setText("");
				
				txtCorreo.setText("");
				txtExperiencia.setText("");

				Main.AsesorUI.setVisible(true);
				dispose();
			}
        });
        
        btnCancelar.setBounds(210, 280, 130, 50);
        getContentPane().add(btnAgregarAsesor);
        getContentPane().add(btnCancelar);

        setLocationRelativeTo(null);
		
	}

}

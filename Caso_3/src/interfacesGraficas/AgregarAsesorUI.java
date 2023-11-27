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
import javax.swing.table.DefaultTableModel;

import ControllersGUI.ControllerAsesor;
import ControllersGUI.ControllerZonas;
import strapi.Main;

public class AgregarAsesorUI extends JFrame {
	
	private ControllerAsesor controller = new ControllerAsesor();
	private JTextField txtNombre = new JTextField();
	private JTextField txtId = new JTextField();
	private JTextField txtCorreo = new JTextField();
	private JTextField txtExperiencia = new JTextField();
	
	public AgregarAsesorUI() {
		
		setTitle("Agregar Asesor");
		setSize(380, 390); // Set the desired size
        setResizable(false); // Disable frame resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(50, 60);
        getContentPane().setLayout(null);
        
		
		
        JLabel lblNombre = new JLabel("Nombre: ");
        lblNombre.setBounds(20, 20, 330, 40);
        getContentPane().add(lblNombre);

        txtNombre.setBounds(140, 30, 200, 30);
        getContentPane().add(txtNombre);

        JLabel lblId = new JLabel("Identificación: ");
        lblId.setBounds(20, 70, 330, 40);
        getContentPane().add(lblId);

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

        txtCorreo.setBounds(140, 180, 200, 30);
        getContentPane().add(txtCorreo);

        JLabel lblExperiencia = new JLabel("Años experiencia: ");
        lblExperiencia.setBounds(20, 220, 330, 40);
        getContentPane().add(lblExperiencia);

        txtExperiencia.setBounds(140, 230, 200, 30);
        getContentPane().add(txtExperiencia);
        
        JButton btnAgregarAsesor = new JButton("Guardar Asesor");
        JButton btnCancelar = new JButton("Cancelar");

        btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Salir();
			}
        });

        btnAgregarAsesor.setBounds(60, 280, 130, 50);
        
        btnAgregarAsesor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					if(txtNombre.getText().isBlank() || txtId.getText().isBlank() || txtCorreo.getText().isBlank() || txtExperiencia.getText().isBlank()) {

					    JOptionPane.showMessageDialog(null, "Por favor complete todos los espacios.");
					}else {
						controller.añadirAsesor(txtNombre, txtId, txtCorreo, txtExperiencia, (String) cmbZona.getSelectedItem());
						controller.actualizarTablaAsesores(Main.asesorUI.getTable());
						Salir();
					}
				} catch (Exception e1) {
				    JOptionPane.showMessageDialog(null, "Ha ocurrido un error: \n" + e1);
				}
			}
        });
        
        btnCancelar.setBounds(210, 280, 130, 50);
        getContentPane().add(btnAgregarAsesor);
        getContentPane().add(btnCancelar);

        setLocationRelativeTo(null);
		
	}
	
	public void Salir() {

		txtNombre.setText("");
		txtId.setText("");
		txtCorreo.setText("");
		txtExperiencia.setText("");

		Main.asesorUI.setVisible(true);
		dispose();
	}
}

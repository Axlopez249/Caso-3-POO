package interfacesGraficas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AgregarAsesorUI extends JFrame {
	AgregarAsesorUI() {
		
		setTitle("Agregar Asesor");
        setSize(380, 560); // Set the desired size
        setResizable(false); // Disable frame resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainUI.setDefaultLookAndFeelDecorated(rootPaneCheckingEnabled);

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

        JLabel lblLugar = new JLabel("Lugar: ");
        lblLugar.setBounds(20, 120, 330, 40);
        getContentPane().add(lblLugar);

        JTextField txtLugar = new JTextField();
        txtLugar.setBounds(140, 130, 200, 30);
        getContentPane().add(txtLugar);

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

        JLabel lblRating = new JLabel("Rating: ");
        lblRating.setBounds(20, 270, 330, 40);
        getContentPane().add(lblRating);

        JTextField txtRating = new JTextField();
        txtRating.setBounds(140, 280, 200, 30);
        getContentPane().add(txtRating);

        JLabel lblCasos = new JLabel("Casos completados: ");
        lblCasos.setBounds(20, 320, 330, 40);
        getContentPane().add(lblCasos);

        JTextField txtCasos = new JTextField();
        txtCasos.setBounds(140, 330, 200, 30);
        getContentPane().add(txtCasos);

        JLabel lblFecha = new JLabel("Fecha de ingreso: ");
        lblFecha.setBounds(20, 370, 330, 40);
        getContentPane().add(lblFecha);

        JTextField txtFecha = new JTextField();
        txtFecha.setBounds(140, 380, 200, 30);
        getContentPane().add(txtFecha);
        
        JButton btnAgregarAsesor = new JButton("Guardar Asesor");
        JButton btnCancelar = new JButton("Cancelar");

        btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				AsesorUI.main(null);
			}
        });

        btnAgregarAsesor.setBounds(30, 440, 130, 50);
        btnCancelar.setBounds(180, 440, 130, 50);
        
        getContentPane().add(btnAgregarAsesor);
        getContentPane().add(btnCancelar);

        setLocationRelativeTo(null);
		
	}
	
	public static void main(String args[]) {
		
		SwingUtilities.invokeLater(() -> {
			AgregarAsesorUI frame = new AgregarAsesorUI();
			frame.setVisible(true);
	    });
	}

}

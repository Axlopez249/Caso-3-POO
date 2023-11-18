package interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import strapi.Main;

public class AgregarPasoUI extends JFrame{
	public AgregarPasoUI() {
		
		setTitle("Agregar paso plan económico");
        setSize(380, 420); // Set the desired size
        setResizable(false); // Disable frame resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(50, 60);
        getContentPane().setLayout(null);
        
        JLabel lblTipoAccion = new JLabel("Tipo de acción: ");
        lblTipoAccion.setBounds(30, 50, 330, 20);
        getContentPane().add(lblTipoAccion);
        
        ButtonGroup bgTipoAccion = new ButtonGroup();

        JRadioButton rbFinanzas = new JRadioButton("Finanzas");
        JRadioButton rbComercial = new JRadioButton("Comercial");
        JRadioButton rbAgricultura = new JRadioButton("Agricultura");
        
        rbFinanzas.setBounds(130, 20, 100, 20);
        rbComercial.setBounds(130, 50, 100, 20);
        rbAgricultura.setBounds(130, 80, 100, 20);
        
        rbFinanzas.setFocusable(false);
        rbComercial.setFocusable(false);
        rbAgricultura.setFocusable(false);

        getContentPane().add(rbFinanzas);
        getContentPane().add(rbComercial);
        getContentPane().add(rbAgricultura);
        
        bgTipoAccion.add(rbFinanzas);
        bgTipoAccion.add(rbComercial);
        bgTipoAccion.add(rbAgricultura);

        JLabel lblDescripción = new JLabel("Descripción: ");
        lblDescripción.setBounds(30, 110, 330, 40);
        getContentPane().add(lblDescripción);

        JTextField txtDescripcion = new JTextField();
        txtDescripcion.setBounds(140, 120, 200, 30);
        getContentPane().add(txtDescripcion);

        JLabel lblMesEjecucion = new JLabel("Mes de Ejecución: ");
        lblMesEjecucion.setBounds(30, 160, 330, 40);
        getContentPane().add(lblMesEjecucion);

        JTextField txtMesEjecucion = new JTextField();
        txtMesEjecucion.setBounds(140, 170, 200, 30);
        getContentPane().add(txtMesEjecucion);

        JLabel lblIngreso = new JLabel("Ingreso: ");
        lblIngreso.setBounds(30, 220, 330, 40);
        getContentPane().add(lblIngreso);

        JTextField txtIngreso = new JTextField();
        txtIngreso.setBounds(140, 220, 200, 30);
        getContentPane().add(txtIngreso);

        JLabel lblTipoIngreso = new JLabel("Tipo ingreso: ");
        lblTipoIngreso.setBounds(30, 260, 330, 40);
        getContentPane().add(lblTipoIngreso);
        
        ButtonGroup bgTipoIngreso = new ButtonGroup();

        JRadioButton rbPositivo = new JRadioButton("Positivo");
        JRadioButton rbNegativo = new JRadioButton("Negativo");
        
        rbPositivo.setBounds(135, 265, 100, 30);
        rbNegativo.setBounds(260, 265, 100, 30);
        
        rbPositivo.setFocusable(false);
        rbNegativo.setFocusable(false);

        getContentPane().add(rbPositivo);
        getContentPane().add(rbNegativo);
        
        bgTipoIngreso.add(rbPositivo);
        bgTipoIngreso.add(rbNegativo);
        
        JButton btnAgregarPaso = new JButton("Guardar paso");
        JButton btnCancelar = new JButton("Cancelar");

        btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.PlanEconomicoUI.setVisible(true);
				dispose();
			}
        });

        btnAgregarPaso.setBounds(60, 310, 130, 50);
        btnCancelar.setBounds(210, 310, 130, 50);
        
        getContentPane().add(btnAgregarPaso);
        getContentPane().add(btnCancelar);

        setLocationRelativeTo(null);
	}
}

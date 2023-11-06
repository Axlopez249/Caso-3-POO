package interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AgregarPasoUI extends JFrame{
	public AgregarPasoUI() {
		
		setTitle("Agregar paso plan económico");
        setSize(380, 480); // Set the desired size
        setResizable(false); // Disable frame resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainUI.setDefaultLookAndFeelDecorated(rootPaneCheckingEnabled);

        setLocation(50, 60);
        getContentPane().setLayout(null);
        
        JLabel lblTipoAccion = new JLabel("Tipo de acción: ");
        lblTipoAccion.setBounds(30, 50, 330, 20);
        getContentPane().add(lblTipoAccion);

        JCheckBox checkBoxFinanzas = new JCheckBox("Finanzas");
        JCheckBox checkBoxComercial = new JCheckBox("Comercial");
        JCheckBox checkBoxAgricultura = new JCheckBox("Agricultura");
        
        checkBoxFinanzas.setBounds(130, 20, 100, 20);
        checkBoxComercial.setBounds(130, 50, 100, 20);
        checkBoxAgricultura.setBounds(130, 80, 100, 20);

        getContentPane().add(checkBoxFinanzas);
        getContentPane().add(checkBoxComercial);
        getContentPane().add(checkBoxAgricultura);

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

        JLabel lblIngresoSalida = new JLabel("Ingreso o salida: ");
        lblIngresoSalida.setBounds(30, 210, 330, 40);
        getContentPane().add(lblIngresoSalida);

        JTextField txtIngresoSalida = new JTextField();
        txtIngresoSalida.setBounds(140, 220, 200, 30);
        getContentPane().add(txtIngresoSalida);

        JLabel lblDinero = new JLabel("Dinero: ");
        lblDinero.setBounds(30, 260, 330, 40);
        getContentPane().add(lblDinero);

        JTextField txtDinero = new JTextField();
        txtDinero.setBounds(140, 270, 200, 30);
        getContentPane().add(txtDinero);

        JLabel lblEstado = new JLabel("Estado: ");
        lblEstado.setBounds(30, 310, 330, 40);
        getContentPane().add(lblEstado);

        JTextField txtEstado = new JTextField();
        txtEstado.setBounds(140, 320, 200, 30);
        getContentPane().add(txtEstado);
        
        JButton btnAgregarPaso = new JButton("Guardar paso");
        JButton btnCancelar = new JButton("Cancelar");

        btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				PlanEconomicoUI.main(null);
			}
        });

        btnAgregarPaso.setBounds(30, 370, 130, 50);
        btnCancelar.setBounds(180, 370, 130, 50);
        
        getContentPane().add(btnAgregarPaso);
        getContentPane().add(btnCancelar);

        setLocationRelativeTo(null);
	}
	
	
	
	public static void main(String args[]) {

		SwingUtilities.invokeLater(() -> {
			AgregarPasoUI frame = new AgregarPasoUI();
			frame.setVisible(true);
	    });
	}
}

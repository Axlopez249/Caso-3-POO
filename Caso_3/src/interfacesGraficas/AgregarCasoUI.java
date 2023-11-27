package interfacesGraficas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ControllersGUI.ControllerCaso;
import ControllersGUI.ControllerZonas;
import clasesLogicas.Agricultor;
import clasesLogicas.Asesor;
import clasesLogicas.Producto;
import clasesLogicas.Terreno;
import strapi.*;

public class AgregarCasoUI extends JFrame {
	
	private ControllerCaso controller = new ControllerCaso();
	
    private JTextField agricultorT = new JTextField();
    private JTextField telefonoAT = new JTextField();
    private JTextField terrenoDisponibleT = new JTextField();
    private JTextField cantidadActualT = new JTextField();
    private JTextField deudaT = new JTextField();
    private JTextField dineroDisponibleT = new JTextField();
    private JTextField ingresosActualesT = new JTextField();
    private JTextField gananciaAnoPasadoT = new JTextField();
    private JTextField organizacionT = new JTextField();
    private ButtonGroup bgTipoSuelo = new ButtonGroup();
    private ButtonGroup bgTieneSiembra = new ButtonGroup();
    
	public AgregarCasoUI(CasoUI casoUI) {
		setTitle("Asesores en Agricultura");
		setSize(1150, 725);
		setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel agricultor = new JLabel("Agricultor");
        JLabel telefonoA = new JLabel("Teléfono agricultor");
        JLabel tipoTerreno = new JLabel("Tipo de terreno");
        JLabel terrenoDisponible = new JLabel("Terreno disponible");
        JLabel zona = new JLabel("Zona de Operación");
        
        ControllerZonas getZonas = new ControllerZonas();
        
        JComboBox<String> zonaT = getZonas.getCmb();
        
        JLabel boolSembrado = new JLabel("Productos sembrados");
        JLabel cantidadActual = new JLabel("Cantidad (kg)");
        JLabel deuda = new JLabel("Deuda");
        JLabel dineroDisponible = new JLabel("Dinero disponible");
        JLabel ingresosActuales = new JLabel("Ingresos actuales");
        JLabel gananciaAnoPasado = new JLabel("Ganancia (año pasado)");
        JLabel organizacion = new JLabel("Organización representante");
        
        agricultor.setFont(new Font("Arial", Font.BOLD, 20));
        telefonoA.setFont(new Font("Arial", Font.BOLD, 20));
        tipoTerreno.setFont(new Font("Arial", Font.BOLD, 20));
        terrenoDisponible.setFont(new Font("Arial", Font.BOLD, 20));
        zona.setFont(new Font("Arial", Font.BOLD, 20));
        boolSembrado.setFont(new Font("Arial", Font.BOLD, 20));
        cantidadActual.setFont(new Font("Arial", Font.BOLD, 20));
        deuda.setFont(new Font("Arial", Font.BOLD, 20));
        dineroDisponible.setFont(new Font("Arial", Font.BOLD, 20));
        ingresosActuales.setFont(new Font("Arial", Font.BOLD, 20));
        gananciaAnoPasado.setFont(new Font("Arial", Font.BOLD, 20));
        organizacion.setFont(new Font("Arial", Font.BOLD, 20));
        
        agricultor.setBounds(60, 60, 330, 40);
        telefonoA.setBounds(60, 140, 330, 40);
        tipoTerreno.setBounds(60, 220, 330, 40);
        terrenoDisponible.setBounds(60, 300, 330, 40);
        zona.setBounds(60, 380, 330, 40);
        boolSembrado.setBounds(60, 460, 330, 40);
        cantidadActual.setBounds(740, 60, 330, 40);
        deuda.setBounds(800, 140, 330, 40);
        dineroDisponible.setBounds(700, 220, 330, 40);
        ingresosActuales.setBounds(700, 300, 330, 40);
        gananciaAnoPasado.setBounds(650, 380, 330, 40);
        organizacion.setBounds(600, 460, 330, 40);
        
        agricultorT.setBounds(300, 60, 200, 30);
        telefonoAT.setBounds(300, 140, 200, 30);
        terrenoDisponibleT.setBounds(300, 300, 200, 30);
        zonaT.setBounds(300, 380, 200, 30);
        cantidadActualT.setBounds(885, 60, 200, 30);
        deudaT.setBounds(885, 140, 200, 30);
        dineroDisponibleT.setBounds(885, 220, 200, 30);
        ingresosActualesT.setBounds(885, 300, 200, 30);
        gananciaAnoPasadoT.setBounds(885, 380, 200, 30);
        organizacionT.setBounds(885, 460, 200, 30);
        
        JRadioButton rbArido = new JRadioButton("Árido");
        JRadioButton rbHumedo = new JRadioButton("Húmedo");
        
        rbArido.setActionCommand("Árido");
        rbHumedo.setActionCommand("Húmedo");
        
        rbArido.setBounds(300, 215, 80, 20);
        rbHumedo.setBounds(300, 245, 80, 20);
        
        rbArido.setFocusable(false);
        rbHumedo.setFocusable(false);

        getContentPane().add(rbArido);
        getContentPane().add(rbHumedo);
        
        bgTipoSuelo.add(rbArido);
        bgTipoSuelo.add(rbHumedo);

        JRadioButton rbSi = new JRadioButton("Si");
        JRadioButton rbNo = new JRadioButton("No");
        
        rbSi.setActionCommand("Árido");
        rbNo.setActionCommand("Húmedo");

        rbSi.setBounds(300, 455, 80, 20);
        rbNo.setBounds(300, 485, 80, 20);
        
        rbSi.setFocusable(false);
        rbNo.setFocusable(false);

        getContentPane().add(rbSi);
        getContentPane().add(rbNo);
        
        bgTieneSiembra.add(rbSi);
        bgTieneSiembra.add(rbNo);
        
        JButton botonConfirmar = new JButton("Confirmar caso");
        
        botonConfirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Tienene que haber un tipo de seguridad a la hora de tomar los datos
				//puede ser en el mismo controller de esta clase

				//Primero saco la info del JTextBox
				try {

					if(bgTipoSuelo.getSelection() == null || bgTieneSiembra.getSelection() == null) {
					    JOptionPane.showMessageDialog(null, "Por favor no deje opciones sin seleccionar.");
					}else if(agricultorT.getText().isEmpty() || telefonoAT.getText().isEmpty() || terrenoDisponibleT.getText().isEmpty() || cantidadActualT.getText().isEmpty() || dineroDisponibleT.getText().isEmpty()
							|| ingresosActualesT.getText().isEmpty() || gananciaAnoPasadoT.getText().isEmpty() || organizacionT.getText().isEmpty() || deudaT.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Por favor complete todos los espacios");
					}else {
						controller.añadirCaso(agricultorT, telefonoAT, terrenoDisponibleT, cantidadActualT, dineroDisponibleT, 
											  ingresosActualesT, gananciaAnoPasadoT, organizacionT, deudaT, bgTipoSuelo, 
											  bgTieneSiembra, (String) zonaT.getSelectedItem());
						controller.actualizarTablaAsesores(Main.casoUI.getTable(), Main.verMasUI.getTable());
						Salir();
					}
					
				} catch (NumberFormatException e1) {
				    JOptionPane.showMessageDialog(null, "Por favor coloque valores númericos en los espacios en los que se le indica.");
				} catch (Exception e2) {
				    JOptionPane.showMessageDialog(null, "Ha ocurrido un error: \n" + e2.getMessage());
				}
				
			}
        });

        
        JButton botonCancelar = new JButton("Cancelar");
        
        botonCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Salir();
			}
        });
        
        botonConfirmar.setBounds(350, 560, 200, 100);
        botonCancelar.setBounds(600, 560, 200, 100);
        
        
        //La siguiente instrucción se divide en 2 partes, la primera getContentPane() es usada para "llamar" a la ventana, esto para poder aplicarle setLayout(null) que lo que significa es que los elementos (botones, label etc) serán agregados de manera normal y no de manera automática
        getContentPane().setLayout(null);
        
        getContentPane().add(agricultor);
        getContentPane().add(agricultorT);
        getContentPane().add(telefonoA);
        getContentPane().add(telefonoAT);
        getContentPane().add(tipoTerreno);
        getContentPane().add(terrenoDisponible);
        getContentPane().add(terrenoDisponibleT);
        getContentPane().add(zona);
        getContentPane().add(zonaT);
        getContentPane().add(boolSembrado);
        getContentPane().add(cantidadActual);
        getContentPane().add(cantidadActualT);
        getContentPane().add(deuda);
        getContentPane().add(deudaT);
        getContentPane().add(dineroDisponible);
        getContentPane().add(dineroDisponibleT);
        getContentPane().add(ingresosActuales);
        getContentPane().add(ingresosActualesT);
        getContentPane().add(gananciaAnoPasado);
        getContentPane().add(gananciaAnoPasadoT);
        getContentPane().add(organizacion);
        getContentPane().add(organizacionT);
        getContentPane().add(botonConfirmar);
        getContentPane().add(botonCancelar);
        getContentPane().add(rbArido);
        getContentPane().add(rbHumedo);
        getContentPane().add(rbSi);
        getContentPane().add(rbNo);

        setLocationRelativeTo(null);
	}
	
	public void Salir() {

		agricultorT.setText("");
		telefonoAT.setText("");
		terrenoDisponibleT.setText("");
		cantidadActualT.setText("");
		dineroDisponibleT.setText("");
		ingresosActualesT.setText("");
		gananciaAnoPasadoT.setText("");
		organizacionT.setText("");
		deudaT.setText("");
		bgTipoSuelo.clearSelection();
		bgTieneSiembra.clearSelection();
		Main.casoUI.setVisible(true);
		dispose();
	}
}

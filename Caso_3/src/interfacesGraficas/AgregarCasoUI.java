package interfacesGraficas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import ControllersGUI.ControllerAsesor;
import ControllersGUI.ControllerCaso;
import ControllersGUI.ControllerZonas;
import strapi.*;

public class AgregarCasoUI extends JFrame {
	public AgregarCasoUI(CasoUI casoUI) {
		setTitle("Asesores en Agricultura");
		setSize(1150, 725);
		setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel agricultor = new JLabel("Agricultor");
//        JComboBox<String> agricultorT = new JComboBox<>();
        JTextField agricultorT = new JTextField();
        JLabel telefonoA = new JLabel("Teléfono agricultor");
        JTextField telefonoAT = new JTextField();
        JLabel tipoTerreno = new JLabel("Tipo de terreno");
//        JTextField tipoTerrenoT = new JTextField();
        JLabel terrenoDisponible = new JLabel("Terreno disponible");
        JTextField terrenoDisponibleT = new JTextField();
        JLabel provincia = new JLabel("Provincia");
//        JTextField provinciaT = new JTextField();
        ControllerZonas getZonas = new ControllerZonas();
        JComboBox<String> provinciaT = getZonas.getCmb();

        
        JLabel boolSembrado = new JLabel("Productos sembrados");
//        JTextField boolSembradoT = new JTextField();
        JLabel cantidadActual = new JLabel("Cantidad (kg)");
        JTextField cantidadActualT = new JTextField();
        JLabel deuda = new JLabel("Deuda");
        JTextField deudaT = new JTextField();
        JLabel dineroDisponible = new JLabel("Dinero disponible");
        JTextField dineroDisponibleT = new JTextField();
        JLabel ingresosActuales = new JLabel("Ingresos actuales");
        JTextField ingresosActualesT = new JTextField();
        JLabel gananciaAnoPasado = new JLabel("Ganancia (año pasado)");
        JTextField gananciaAnoPasadoT = new JTextField();
        JLabel organizacion = new JLabel("Organización representante");
        JTextField organizacionT = new JTextField();
        
        agricultor.setFont(new Font("Arial", Font.BOLD, 20));
        telefonoA.setFont(new Font("Arial", Font.BOLD, 20));
        tipoTerreno.setFont(new Font("Arial", Font.BOLD, 20));
        terrenoDisponible.setFont(new Font("Arial", Font.BOLD, 20));
        provincia.setFont(new Font("Arial", Font.BOLD, 20));
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
        provincia.setBounds(60, 380, 330, 40);
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
        provinciaT.setBounds(300, 380, 200, 30);
        cantidadActualT.setBounds(885, 60, 200, 30);
        deudaT.setBounds(885, 140, 200, 30);
        dineroDisponibleT.setBounds(885, 220, 200, 30);
        ingresosActualesT.setBounds(885, 300, 200, 30);
        gananciaAnoPasadoT.setBounds(885, 380, 200, 30);
        organizacionT.setBounds(885, 460, 200, 30);
        
        JCheckBox checkBoxArido = new JCheckBox("Arido");
        JCheckBox checkBoxHumedo = new JCheckBox("Húmedo");
        
        checkBoxArido.setBounds(300, 215, 80, 20);
        checkBoxHumedo.setBounds(300, 245, 80, 20);
        
        JCheckBox checkBoxSi = new JCheckBox("Sí");
        JCheckBox checkBoxNo = new JCheckBox("No");
        
        checkBoxSi.setBounds(300, 455, 80, 20);
        checkBoxNo.setBounds(300, 485, 80, 20);
        
        
        JButton botonConfirmar = new JButton("Confirmar caso");
        
        botonConfirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Tienene que haber un tipo de seguridad a la hora de tomar los datos
				//puede ser en el mismo controller de esta clase

				//Primero saco la info de cata jtxt
				
				try {
					String nombre = (String) agricultorT.getText();
					int telefono = Integer.parseInt(telefonoAT.getText());
					int terrenoDisponible = Integer.parseInt(terrenoDisponibleT.getText());
					String provincia = (String) provinciaT.getSelectedItem();
					int deuda = Integer.parseInt(deudaT.getText());
					int dineroDisponible = Integer.parseInt(dineroDisponibleT.getText());
					int ingresosActuales = Integer.parseInt(ingresosActualesT.getText());
					int pastYearGain = Integer.parseInt(gananciaAnoPasadoT.getText());
					String organizacionA = (String) organizacionT.getText();
					int cantidadActual = 0;
					String terrainType = "Humedo";
					
					if(checkBoxSi.isSelected()) {
						cantidadActual = Integer.parseInt(cantidadActualT.getText());
					}
					if(checkBoxArido.isSelected()) {
						terrainType = "Arido";
					}
					
					ControllerCaso controller = new ControllerCaso(nombre, telefono, terrainType, terrenoDisponible, provincia, 
																   checkBoxSi.isSelected(), cantidadActual, deuda, dineroDisponible, 
																   ingresosActuales, pastYearGain, organizacionA,casoUI);
					controller.actualizarTablaAsesores();
					
				} catch (NumberFormatException e1) {
				    JOptionPane.showMessageDialog(null, "Error al convertir a número: " + e1.getMessage());
				} catch (Exception e2) {
				    JOptionPane.showMessageDialog(null, "Otro error: " + e2.getMessage());
				}
				Main.CasoUI.setVisible(true);
				dispose();
			}
        });
//String pName, int pTelefono, Terreno pTerreno, int pTerrenoDisponible, String pProvincia, boolean pProductosSembrados, int pCantidadSembrada, int pDeuda, int pDineroDisponible, int pIngresosActuales, int pGananciaAnoPasado, String pOrganizacion
        
        JButton botonCancelar = new JButton("Cancelar");
        
        botonCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.CasoUI.setVisible(true);
				dispose();
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
//        getContentPane().add(tipoTerrenoT);
        getContentPane().add(terrenoDisponible);
        getContentPane().add(terrenoDisponibleT);
        getContentPane().add(provincia);
        getContentPane().add(provinciaT);
        getContentPane().add(boolSembrado);
//        getContentPane().add(boolSembradoT);
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
        getContentPane().add(checkBoxArido);
        getContentPane().add(checkBoxHumedo);
        getContentPane().add(checkBoxSi);
        getContentPane().add(checkBoxNo);

        setLocationRelativeTo(null);
	}
	
//	public void generarCaso(String pName, int pTelefono, Terreno pTerreno, int pTerrenoDisponible, String pProvincia, boolean pProductosSembrados, int pCantidadSembrada, int pDeuda, int pDineroDisponible, int pIngresosActuales, int pGananciaAnoPasado, String pOrganizacion) {
//		Caso caso = new Caso(pName, pTelefono, pTerreno, pTerrenoDisponible, pProvincia, pProductosSembrados, pCantidadSembrada, pDeuda, pDineroDisponible, pIngresosActuales, pGananciaAnoPasado, pOrganizacion);
//	}

}
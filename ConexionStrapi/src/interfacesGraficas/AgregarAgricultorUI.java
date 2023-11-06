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

public class AgregarAgricultorUI extends JFrame {
	public AgregarAgricultorUI() {
		setTitle("Asesores en Agricultura");
		setSize(1150, 725);
		setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        JLabel agricultor = new JLabel("Agricultor");
        JTextField agricultorT = new JTextField();
        JLabel ID = new JLabel("Número de ID");
        JTextField IDT = new JTextField();
        JLabel dinero = new JLabel("Dinero");
        JTextField dineroT = new JTextField();
        JLabel deuda = new JLabel("Deuda");
        JTextField deudaT = new JTextField();
        
        JTextField tipoTerrenoT = new JTextField();
        JCheckBox checkBoxArido = new JCheckBox("Arido");
        JCheckBox checkBoxHumedo = new JCheckBox("Húmedo");
        JLabel boolSembrado = new JLabel("Productos sembrados");
        JCheckBox checkBoxSi = new JCheckBox("Sí");
        JCheckBox checkBoxNo = new JCheckBox("No");
        JLabel boolPlaga = new JLabel("Plaga");
        JCheckBox checkBoxSiP = new JCheckBox("Sí");
        JCheckBox checkBoxNoP = new JCheckBox("No");
        JLabel boolAbonado = new JLabel("Plaga");
        JCheckBox checkBoxSiA = new JCheckBox("Sí");
        JCheckBox checkBoxNoA = new JCheckBox("No");
        JLabel cantidadHectareas = new JLabel("Cantidad de hectareas");
        JTextField cantidadHectareasT = new JTextField();
        
  
        JLabel provincia = new JLabel("Provincia");
        JTextField provinciaT = new JTextField();

        JTextField boolSembradoT = new JTextField();
        JLabel cantidadActual = new JLabel("Cantidad (kg)");
        JTextField cantidadActualT = new JTextField();

        JLabel dineroDisponible = new JLabel("Dinero disponible");
        JTextField dineroDisponibleT = new JTextField();
        JLabel ingresosActuales = new JLabel("Ingresos actuales");
        JTextField ingresosActualesT = new JTextField();
        JLabel gananciaAnoPasado = new JLabel("Ganancia (año pasado)");
        JTextField gananciaAnoPasadoT = new JTextField();
        JLabel organizacion = new JLabel("Organización representante");
        JTextField organizacionT = new JTextField();
        
        agricultor.setFont(new Font("Arial", Font.BOLD, 20));
        provincia.setFont(new Font("Arial", Font.BOLD, 20));
        boolSembrado.setFont(new Font("Arial", Font.BOLD, 20));
        cantidadActual.setFont(new Font("Arial", Font.BOLD, 20));
        deuda.setFont(new Font("Arial", Font.BOLD, 20));
        dineroDisponible.setFont(new Font("Arial", Font.BOLD, 20));
        ingresosActuales.setFont(new Font("Arial", Font.BOLD, 20));
        gananciaAnoPasado.setFont(new Font("Arial", Font.BOLD, 20));
        organizacion.setFont(new Font("Arial", Font.BOLD, 20));
        
        agricultor.setBounds(60, 60, 330, 40);
        provincia.setBounds(60, 380, 330, 40);
        boolSembrado.setBounds(60, 460, 330, 40);
        cantidadActual.setBounds(740, 60, 330, 40);
        deuda.setBounds(800, 140, 330, 40);
        dineroDisponible.setBounds(700, 220, 330, 40);
        ingresosActuales.setBounds(700, 300, 330, 40);
        gananciaAnoPasado.setBounds(650, 380, 330, 40);
        organizacion.setBounds(600, 460, 330, 40);
        
        agricultorT.setBounds(300, 60, 200, 30);
        provinciaT.setBounds(300, 380, 200, 30);
        cantidadActualT.setBounds(885, 60, 200, 30);
        deudaT.setBounds(885, 140, 200, 30);
        dineroDisponibleT.setBounds(885, 220, 200, 30);
        ingresosActualesT.setBounds(885, 300, 200, 30);
        gananciaAnoPasadoT.setBounds(885, 380, 200, 30);
        organizacionT.setBounds(885, 460, 200, 30);
        
        JButton botonConfirmar = new JButton("Confirmar caso");
        
        botonConfirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				agregarCaso(agricultorT.getText(), ;
			}
        });
        
//String pName, int pTelefono, Terreno pTerreno, int pTerrenoDisponible, String pProvincia, boolean pProductosSembrados, int pCantidadSembrada, int pDeuda, int pDineroDisponible, int pIngresosActuales, int pGananciaAnoPasado, String pOrganizacion
        
        JButton botonCancelar = new JButton("Cancelar");
        
        botonCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
        });
        
        botonConfirmar.setBounds(350, 560, 200, 100);
        botonCancelar.setBounds(600, 560, 200, 100);
        
        checkBoxArido.setBounds(300, 215, 80, 20);
        checkBoxHumedo.setBounds(300, 245, 80, 20);
        
        checkBoxSi.setBounds(300, 455, 80, 20);
        checkBoxNo.setBounds(300, 485, 80, 20);
        
        
        //La siguiente instrucción se divide en 2 partes, la primera getContentPane() es usada para "llamar" a la ventana, esto para poder aplicarle setLayout(null) que lo que significa es que los elementos (botones, label etc) serán agregados de manera normal y no de manera automática
        getContentPane().setLayout(null);
        
        getContentPane().add(agricultor);
        getContentPane().add(agricultorT);
        getContentPane().add(provincia);
        getContentPane().add(provinciaT);
        getContentPane().add(boolSembrado);
        getContentPane().add(boolSembradoT);
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

	}
	
//	public void generarCaso(String pName, int pTelefono, Terreno pTerreno, int pTerrenoDisponible, String pProvincia, boolean pProductosSembrados, int pCantidadSembrada, int pDeuda, int pDineroDisponible, int pIngresosActuales, int pGananciaAnoPasado, String pOrganizacion) {
//		Caso caso = new Caso(pName, pTelefono, pTerreno, pTerrenoDisponible, pProvincia, pProductosSembrados, pCantidadSembrada, pDeuda, pDineroDisponible, pIngresosActuales, pGananciaAnoPasado, pOrganizacion);
//	}

	public static void main(String args[]) {
		
		SwingUtilities.invokeLater(() -> {
			//Crea una instancia de la clase UI que será usada para mostrar los elementos
			AgregarCasoUI frame = new AgregarCasoUI();
			//Establece que cuando se corra el java application se va a mostrar la ventana recién creada, si no se agregara 
	        frame.setVisible(true);
	    });
	}

}

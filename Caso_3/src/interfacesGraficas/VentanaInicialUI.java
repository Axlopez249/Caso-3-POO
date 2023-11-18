package interfacesGraficas;

import javax.swing.*;
import javax.swing.border.*;

import strapi.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Calendar;

public class VentanaInicialUI extends JFrame {
	public VentanaInicialUI() {
		
		//Establecer título de la ventana
		setTitle("Asesores en Agricultura");
		//Establecer tamaño de la ventana inicial
		setSize(575, 400);
		//Para establecer si se puede modificar o no el tamaño de la ventana se usa setResizable(false/true);, en este caso no deseo que sea modificable
		setResizable(false);
		//Cerrará el programa para no dejar operaciones en segundo plano
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Establece donde se abrirá la ventana cuando se corra el programa
        setLocation(50, 60);
        
        SimpleDateFormat dateOnly = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
                
        //Crea un label
        JLabel label = new JLabel("Fecha actual: " + dateOnly.format(cal.getTime()));
        //Le establece una fuente, en este caso el primer parámetro equivale a la fuente, el segundo al tipo de letra (BOLD = negrita, PLAIN = normal, ITALIC = cursiva) y por último el tamaño de la fuente
        label.setFont(new Font("Arial", Font.BOLD, 20));
        //Se ubica el label dentro de la ventana, en este caso, e primer parámetro equivale a la ubicación en x, el segundo parámetro a la ubicación en y, el tercer parámetro a la anchura del label y el último a la altura
        label.setBounds(250, 10, 330, 40);
        
        //La siguiente instrucción se divide en 2 partes, la primera getContentPane() es usada para "llamar" a la ventana, esto para poder aplicarle setLayout(null) que lo que significa es que los elementos (botones, label etc) serán agregados de manera normal y no de manera automática
        getContentPane().setLayout(null);
        
        
        JButton botonAsesor = new JButton("Buscar Asesor");
        
        botonAsesor.setBounds(70, 140, 180, 75);
        
        botonAsesor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.AsesorUI.setVisible(true);
				dispose();
//				verFallas();
//				visitarFinca(objeto);	; Aquí  debería ir la llamada de un método
/*
	private void verHistorial() {
		try {
			HistorialUI.main(null);
		} catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Todavía no existe historial por mostrar.");
		}
	}
 */
			}
        });
        
        
        JButton botonCaso = new JButton("Consultar casos");
        
        botonCaso.setBounds(70, 240, 180, 75);
        
        botonCaso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.CasoUI.setVisible(true);
				dispose();
			}
        });
        
        JButton botonPlanes = new JButton("Consultar planes");
        
        botonPlanes.setBounds(270, 190, 180, 75);
        
        botonPlanes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.PlanEconomicoUI.setVisible(true);
				dispose();
			}
        });
        
        
        //Se vuelve a "llamar" a la ventana para agregarle el label
        getContentPane().add(label);
        getContentPane().add(botonAsesor);
        getContentPane().add(botonCaso);
        getContentPane().add(botonPlanes);

        setLocationRelativeTo(null);
	}
	
	private void verHistorial() {
		try {

		} catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Todavía no existe historial por mostrar.");
		}
	}
	
	private void visitarFinca(Object pObjeto) {

    }
}
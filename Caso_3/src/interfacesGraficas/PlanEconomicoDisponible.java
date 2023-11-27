package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import ControllersGUI.ActualizadorPlanDisponible;
import clasesLogicas.PlanEconomico;
import strapi.Main;

public class PlanEconomicoDisponible extends JFrame{
	//Aqui tengo que hacer que plan economico me pinte esta tabla
	private JTable table;
	private ActualizadorPlanDisponible actualizador = new ActualizadorPlanDisponible();
	
	public PlanEconomicoDisponible() {
		
		setTitle("Planes Economicos Disponibles");
		setSize(1350, 725);
	    
	    getContentPane().setLayout(null);
	    
	    
		DefaultTableModel model = new DefaultTableModel();
	    model.addColumn("Nombre Asesor");
	    model.addColumn("Cantidad de pasos");
	    
	    table = new JTable(model);
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Modo de selección de una sola fila
	
	    table.setBounds(10, 10, 200, 125);
	    
	    getContentPane().setLayout(new BorderLayout());
	    JScrollPane panelDesplazamiento = new JScrollPane(table);
	    
	    JButton aceptar = new JButton("Aceptar");
	    aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = table.getSelectedRow();
				if (filaSeleccionada != -1) {
					Main.planesEconomicos.setVisible(true);
					dispose();
					actualizador.asignarPlan(table, filaSeleccionada);
				}else {
					JOptionPane.showMessageDialog(null, "Selecciona una fila primero.");
				}
			}
	    });
	    
        JButton salir = new JButton("Salir");
        salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.planesEconomicos.setVisible(true);
				dispose();
			}
        });
        
        salir.setBounds(633, 600, 100, 50);
        
        getContentPane().add(salir);
        
	    getContentPane().add(panelDesplazamiento);
	    
	    setLocationRelativeTo(null);
	}
	public void pintarTable(int IDCaso) {
		 actualizador.actualizarTable(IDCaso, table);
	}
	
	public static void main(String []args) {
		PlanEconomicoDisponible disponible = new PlanEconomicoDisponible();
		disponible.setVisible(true);
	}

}

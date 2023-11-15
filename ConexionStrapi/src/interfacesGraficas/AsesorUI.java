package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class AsesorUI extends JFrame{
	
	public AsesorUI() {
		
		setTitle("Asesores");
        setSize(780, 750); // Set the desired size
        setResizable(false); // Disable frame resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainUI.setDefaultLookAndFeelDecorated(rootPaneCheckingEnabled);

        setLocation(50, 60);
        getContentPane().setLayout(null);
        
		DefaultTableModel model = new DefaultTableModel();
	    model.addColumn("Nombre");
	    model.addColumn("ID");
	    model.addColumn("Lugar");
	    model.addColumn("Correo Electrónico");
	    model.addColumn("Años de Experiencia");
	    model.addColumn("Rating");
	    model.addColumn("Casos completados");
	    model.addColumn("Fecha de ingreso");
	    
	    JTable table = new JTable(model);
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Modo de selección de una sola fila

        table.setBounds(10, 10, 600, 600);

        JButton agregarAsesor = new JButton("Agregar Asesor");
        JButton volver = new JButton("Volver");
        
        volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
        });

        agregarAsesor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//dispose();
				AgregarAsesorUI agregarAsesor = new AgregarAsesorUI();
				agregarAsesor.setVisible(true);
			}
        });
        
        agregarAsesor.setBounds(200, 550, 200, 100);
        volver.setBounds(425, 550, 200, 100);

        JScrollPane panelDesplazamiento = new JScrollPane(table);
        panelDesplazamiento.setBounds(10, 10, 745, 500);
	    
        getContentPane().add(agregarAsesor);
        getContentPane().add(volver);
	    getContentPane().add(panelDesplazamiento);

        setLocationRelativeTo(null);
	}
	
	
	
	public static void main(String args[]) {

		SwingUtilities.invokeLater(() -> {
			AsesorUI frame = new AsesorUI();
			frame.setVisible(true);
	    });
	}
}

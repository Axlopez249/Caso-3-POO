package ControllersGUI;

import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControllerPlanEconomico {

	private int indexSelected;

	public int getIndexSelected() {
		return indexSelected;
	}

	public void setIndexSelected(int indexSelected) {
		this.indexSelected = indexSelected;
	}
	
	public JRadioButton crearRadioButton(String nombre, int x, int y, int w, int h) {
		JRadioButton boton = new JRadioButton(nombre);
		boton.setActionCommand(nombre);
		boton.setFocusable(false);
		boton.setBounds(x, y, w, h);
		return boton;
	}
	
	public void CambiarEstado(JTable tabla, String value) {
		tabla.getModel().setValueAt(value, indexSelected, 4);
		tabla.repaint();
	}
}

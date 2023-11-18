package ControllersGUI;

import java.util.ArrayList;

import javax.swing.JComboBox;

public class ControllerZonas {
	
	public JComboBox<String> getCmb() {
		
		ArrayList<String>  zonas = new ArrayList<String>();

		// get zonas de strapi
		zonas.add("Limón");
		zonas.add("Guanacaste");
		zonas.add("Cartago");
		zonas.add("San José");
        zonas.add("Alajuela");
        zonas.add("Puntarenas");
        zonas.add("Heredia");
		
		JComboBox<String> cmb = new JComboBox<String>();
		
		if(zonas.size() != 0) {
			for(int i = 0; i < zonas.size(); i++) {
				cmb.addItem(zonas.get(i));
			}
		}
		
		return cmb;
	}
}

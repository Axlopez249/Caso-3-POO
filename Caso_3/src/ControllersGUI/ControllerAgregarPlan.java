package ControllersGUI;

import interfacesGraficas.*;
import strapi.Main;
import clasesLogicas.*;
import java.util.*;

public class ControllerAgregarPlan {
	public ControllerAgregarPlan(String nombreAsesor, ArrayList<Paso> pasos) {
		PlanEconomico plan = new PlanEconomico(nombreAsesor, pasos);
		Main.planesRegistrados.add(plan);
	}
}

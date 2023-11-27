package ControllersGUI;

import interfacesGraficas.*;
import strapi.Main;
import clasesLogicas.*;
import java.util.*;

public class ControllerAgregarPlan {
	public ControllerAgregarPlan(String nombreAsesor, int IDCaso, ArrayList<Paso> pasos) {   // public ControllerAgregarPlan(String nombreAsesor, int IDCaso, ArrayList<Paso> pasos) {
		PlanEconomico plan = new PlanEconomico(nombreAsesor, IDCaso, pasos);             // 		PlanEconomico plan = new PlanEconomico(nombreAsesor, IDCaso, pasos);
		Main.planesRegistrados.add(plan);
	}
}

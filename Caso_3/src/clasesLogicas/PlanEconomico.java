package clasesLogicas;

import java.util.ArrayList;

import strapi.Main;

public class PlanEconomico {
	private ArrayList<Paso> pasos;
	private String nombreAsesor;
	
	public PlanEconomico(String nombreAsesor, ArrayList<Paso> pasos) {
		this.nombreAsesor = nombreAsesor;
		this.pasos = pasos;
	}

	public ArrayList<Paso> getPasos() {
		return pasos;
	}

	public String getNombreAsesor() {
		return nombreAsesor;
	}
	
	
	
	
}
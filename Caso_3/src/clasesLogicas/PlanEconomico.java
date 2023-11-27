package clasesLogicas;

import java.util.ArrayList;

import strapi.Main;

public class PlanEconomico {
	private ArrayList<Paso> pasos;
	private String nombreAsesor;
	private int IDcaso;
	
	public PlanEconomico(String nombreAsesor, int IDCaso, ArrayList<Paso> pasos) {
		this.nombreAsesor = nombreAsesor;
		this.pasos = pasos;
		this.IDcaso = IDCaso;
	}

	public ArrayList<Paso> getPasos() {
		return pasos;
	}

	public String getNombreAsesor() {
		return nombreAsesor;
	}

	public int getIDCaso() {
		return IDcaso;
	}
	
}
package clasesLogicas;

import java.util.Date;

public class InfoTemporal {
	private String agricultor;
	private int telefonoAgricultor;
	private double terrenoDisponible;
	private String tipoTerreno;
	private double deuda;
	private String provincia;
	private double dineroDisponible;
	private String organiRepresentante;
	private PlanEconomico plan;


	public InfoTemporal(String agricultor, int telefonoAgricultor, double terrenoDisponible,String tipoTerreno, String provincia,
		double deuda, double dineroDisponible, String organiRepresentante, PlanEconomico plan) {
		
		this.agricultor = agricultor;
		this.telefonoAgricultor = telefonoAgricultor;
		this.terrenoDisponible = terrenoDisponible;
		this.tipoTerreno = tipoTerreno;
		this.provincia = provincia;
		this.deuda = deuda;
		this.dineroDisponible = dineroDisponible;
		this.organiRepresentante = organiRepresentante;
		this.plan = plan;
	}


	public String getAgricultor() {
		return agricultor;
	}


	public int getTelefonoAgricultor() {
		return telefonoAgricultor;
	}


	public double getTerrenoDisponible() {
		return terrenoDisponible;
	}


	public String getTipoTerreno() {
		return tipoTerreno;
	}


	public double getDeuda() {
		return deuda;
	}


	public String getProvincia() {
		return provincia;
	}


	public double getDineroDisponible() {
		return dineroDisponible;
	}


	public String getOrganiRepresentante() {
		return organiRepresentante;
	}

	public void setPlan(PlanEconomico plan) {
		this.plan = plan;
	}

	
		
	
}

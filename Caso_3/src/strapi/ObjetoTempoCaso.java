package strapi;

import java.util.Date;

import clasesLogicas.Agricultor;
import clasesLogicas.Asesor;

public class ObjetoTempoCaso {
	private int idCaso;
	private int telefonoAgricultor;
	private String zona;
	private int telefonoAsesor;
	private String organiRepresentante;
	private Date fechaIngreso;
	private String estado;
	
	
	public ObjetoTempoCaso(int idCaso, int telefonoAgricultor, String provincia,
			int telefonoAsesor, String organiRepresentante, Date fechaIngreso, String estado) {
		this.idCaso = idCaso;
		this.telefonoAgricultor = telefonoAgricultor;
		this.zona = provincia;
		this.telefonoAsesor = telefonoAsesor;
		this.organiRepresentante = organiRepresentante;
		this.fechaIngreso = fechaIngreso;
		this.estado = estado;
	}


	public int getIdCaso() {
		return idCaso;
	}

	public int getTelefonoAgricultor() {
		return telefonoAgricultor;
	}

	public String getProvincia() {
		return zona;
	}


	public int getTelefonoAsesor() {
		return telefonoAsesor;
	}


	public String getOrganiRepresentante() {
		return organiRepresentante;
	}


	public Date getFechaIngreso() {
		return fechaIngreso;
	}


	public String getEstado() {
		return estado;
	}
	
	
	
}
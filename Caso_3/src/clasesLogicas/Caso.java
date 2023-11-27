package clasesLogicas;

import java.util.ArrayList;
import java.util.Date;

public class Caso {
	private int idCaso;
	private Agricultor agricultor;
	private int telefonoAgricultor;
	private Asesor asesor;
	private String zona;
	private int telefonoAsesor;
	private String organiRepresentante;
	private Date fechaIngreso;
	private String estado;
	
	
	public Caso(int idCaso, Agricultor agricultor, int telefonoAgricultor, Asesor asesor, String zona,
			int telefonoAsesor, String organiRepresentante, Date fechaIngreso, String estado) {
		this.idCaso = idCaso;
		this.agricultor = agricultor;
		this.telefonoAgricultor = telefonoAgricultor;
		this.asesor = asesor;
		this.zona = zona;
		this.telefonoAsesor = telefonoAsesor;
		this.organiRepresentante = organiRepresentante;
		this.fechaIngreso = fechaIngreso;
		this.estado = estado;
	}


	public int getIdCaso() {
		return idCaso;
	}


	public Agricultor getAgricultor() {
		return agricultor;
	}


	public int getTelefonoAgricultor() {
		return telefonoAgricultor;
	}


	public Asesor getAsesor() {
		return asesor;
	}


	public String getZona() {
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
	
	
	public void setAsesor(Asesor asesor) {
		this.asesor = asesor;
	}
	
}

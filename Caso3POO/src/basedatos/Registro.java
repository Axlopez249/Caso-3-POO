package basedatos;

import java.sql.Date;

public class Registro {
	
	private int idAgricultor;
	private int idAsesor;
	private String Asesor; 
	private Date fecha;
	private String descripCaso;

	public Registro(int pidAgricultor, int pidAsesor, String pAsesor, Date pfecha, String pdescripCaso) {
		this.idAgricultor = pidAgricultor;
		this.Asesor = pAsesor;
		this.descripCaso = pdescripCaso;
		this.fecha = pfecha;
		this.idAsesor = pidAsesor;
	}
	
	public void saveInfo() {
		
		
	}
}

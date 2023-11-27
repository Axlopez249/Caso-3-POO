package clasesLogicas;

		
public class Terreno {
	private String tipoSuelo;
	private boolean siembra;
	private double hectareas;
	private String dueno;
	
	public Terreno(String tipoSuelo, boolean siembra, double hectareas, String dueno) {
		this.tipoSuelo = tipoSuelo;
		this.siembra = siembra;
		this.hectareas = hectareas;
		this.dueno = dueno;
	}

	public String getTipoSuelo() {
		return tipoSuelo;
	}

	public String isSiembra() {
		if(siembra) {
			return "Si";
		}
		return "No";
	}

	public double getHectareas() {
		return hectareas;
	}

	public String getDueno() {
		return dueno;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

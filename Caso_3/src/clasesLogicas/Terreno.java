package clasesLogicas;

		
public class Terreno {
	private String tipoSuelo;
	private boolean siembra;
	private boolean plaga;
	private boolean abonado;
	private double hectareas;
	private String dueno;
	
	public Terreno(String tipoSuelo, boolean siembra, boolean plaga, boolean abonado, double hectareas, String dueno) {
		this.tipoSuelo = tipoSuelo;
		this.siembra = siembra;
		this.plaga = plaga;
		this.abonado = abonado;
		this.hectareas = hectareas;
		this.dueno = dueno;
	}

	public String getTipoSuelo() {
		return tipoSuelo;
	}

	public boolean isSiembra() {
		return siembra;
	}

	public boolean isPlaga() {
		return plaga;
	}

	public boolean isAbonado() {
		return abonado;
	}

	public double getHectareas() {
		return hectareas;
	}

	public String getDueno() {
		return dueno;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

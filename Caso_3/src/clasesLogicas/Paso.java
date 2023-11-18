package clasesLogicas;

public class Paso {
	
	String accion;
	String descripcion;
	int mes;
	int ingreso;
	String tipoIngreso;
	String estado;
	
	public Paso(String accion, String descripcion, int mes, int ingreso, String tipoIngreso, String estado) {
		this.accion = accion;
		this.descripcion = descripcion;
		this.mes = mes;
		this.ingreso = ingreso;
		this.tipoIngreso = tipoIngreso;
		this.estado = estado;
	}
	
	public String getAccion() {
		return accion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public int getMes() {
		return mes;
	}
	public int getIngreso() {
		return ingreso;
	}
	public String getTipoIngreso() {
		return tipoIngreso;
	}
	public String getEstado() {
		return estado;
	}
	
	
}

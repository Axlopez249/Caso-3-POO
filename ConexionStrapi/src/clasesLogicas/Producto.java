package clasesLogicas;

import java.util.Date;

public class Producto {

	private String nombre;
	private boolean abonado;
	private Date caducidad;
	private int cantidad;
	private String productor;
	
	public Producto(String pnombre, boolean pabonado, Date pcaducidad, int pcantidad, String pproductor) {
		this.abonado = pabonado;
		this.caducidad = pcaducidad;
		this.cantidad = pcantidad;
		this.nombre = pnombre;
		this.productor = pproductor;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean isAbonado() {
		return abonado;
	}

	public Date getCaducidad() {
		return caducidad;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	public String getProductor() {
		return productor;
	}
	
}

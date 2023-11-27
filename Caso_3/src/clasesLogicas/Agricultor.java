package clasesLogicas;

import java.util.ArrayList;

public class Agricultor {
	private String nombre;
	private int idAgricultor;
	private double dinero;
	private double deuda;
	private int telefono;
	private double ingresosActuales;
	private double gananciasAnoPasado;
	private Terreno terreno;
	private Producto producto;
	
	public Agricultor(String nombre, int idAgricultor, double dinero, double deuda, int telefono, double ingregosActuales, double gananciasAnoPasado, Terreno terreno, Producto producto) {
		this.nombre = nombre;
		this.idAgricultor = idAgricultor;
		this.dinero = dinero;
		this.telefono = telefono;
		this.ingresosActuales = ingregosActuales;
		this.gananciasAnoPasado = gananciasAnoPasado;
		this.deuda = deuda;
		this.terreno = terreno;
		this.producto = producto;
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getIdAgricultor() {
		return idAgricultor;
	}

	public double getGananciasAñoPasado() {
		return gananciasAnoPasado;
	}

	public double getIngresosActuales() {
		return ingresosActuales;
	}
	
	public int getTelefono() {
		return telefono;
	}

	public int getId() {
		return idAgricultor;
	}

	public double getDinero() {
		return dinero;
	}

	public double getDeuda() {
		return deuda;
	}

	public Terreno getTerreno() {
		return terreno;
	}

	public Producto getProducto() {
		return producto;
	}
	
	
	
	
	
	
}

package clasesLogicas;

import java.util.ArrayList;

public class Agricultor {
	private String nombre;
	private int idAgricultor;
	private double dinero;
	private double deuda;
	private int telefono;
	private int ingresosActuales;
	private int gananciasAñoPasado;
	private Terreno terreno;
	private ArrayList<Producto> productos;
	
	public Agricultor(String nombre, int idAgricultor, double dinero, double deuda, int telefono, int ingregosActuales, int gananciasAñoPasado, Terreno terreno, ArrayList<Producto> productos) {
		this.nombre = nombre;
		this.idAgricultor = idAgricultor;
		this.dinero = dinero;
		this.telefono = telefono;
		this.ingresosActuales = ingregosActuales;
		this.gananciasAñoPasado = gananciasAñoPasado;
		this.deuda = deuda;
		this.terreno = terreno;
		this.productos = productos;
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getIdAgricultor() {
		return idAgricultor;
	}

	public int getGananciasAñoPasado() {
		return gananciasAñoPasado;
	}

	public int getIngresosActuales() {
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

	public ArrayList<Producto> getProductos() {
		return productos;
	}
	
	
	
	
	
	
}

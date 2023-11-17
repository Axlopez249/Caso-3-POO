package clasesLogicas;

import java.util.ArrayList;

public class Agricultor {
	private String nombre;
	private int idAgricultor;
	private double dinero;
	private double deuda;
	private ArrayList<Terreno> terrenos;
	private ArrayList<Producto> productos;
	
	public Agricultor(String nombre, int idAgricultor, double dinero, double deuda, ArrayList<Terreno> terrenos, ArrayList<Producto> productos) {
		this.nombre = nombre;
		this.idAgricultor = idAgricultor;
		this.dinero = dinero;
		this.deuda = deuda;
		this.terrenos = terrenos;
		this.productos = productos;
	}

	public String getNombre() {
		return nombre;
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

	public ArrayList<Terreno> getTerrenos() {
		return terrenos;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}
	
	
	
	
	
	
}

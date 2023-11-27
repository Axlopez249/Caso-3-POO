package strapi;

import java.util.ArrayList;

import clasesLogicas.Producto;
import clasesLogicas.Terreno;

public class ObjetoTempoAgri {
	private String nombre;
	private int idAgricultor;
	private double dinero;
	private double deuda;
	private int telefono;
	private double ingresosActuales;
	private double gananciasAnoPasado;

	
	public ObjetoTempoAgri(String nombre, int idAgricultor, double dinero, double deuda, int telefono, double ingregosActuales, double gananciasAnoPasado ) {
		this.nombre = nombre;
		this.idAgricultor = idAgricultor;
		this.dinero = dinero;
		this.deuda = deuda;
		this.telefono = telefono;
		this.gananciasAnoPasado = gananciasAnoPasado;
		this.ingresosActuales = ingresosActuales;
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

}
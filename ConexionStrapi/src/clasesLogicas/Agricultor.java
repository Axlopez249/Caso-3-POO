package clasesLogicas;


public class Agricultor {
	private String nombre;
	private int id;
	private double dinero;
	private double deuda;
	private Terreno terreno;
	private Producto producto;
	
	public Agricultor(String nombre, int id, double dinero, double deuda, Terreno terreno, Producto producto) {
		this.nombre = nombre;
		this.id = id;
		this.dinero = dinero;
		this.deuda = deuda;
		this.terreno = terreno;
		this.producto = producto;
	}

	public String getNombre() {
		return nombre;
	}

	public int getId() {
		return id;
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

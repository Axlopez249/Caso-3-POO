package ControllersGUI;

import java.util.Date;

import interfacesGraficas.CasoUI;

public class ControllerCaso {
	private String name;
	private int cellphoneNumber;
	private int availableLand;
	private String landType;
	private String provincia;
	private boolean sembrado;
	private int actualQuantity;
	private int debt;
	private int availableMoney;
	private int actualIncome;
	private int lastYearIncome;
	private String organization;
	private Date fechaIngreso;
	private CasoUI instanciaCaso;
	
	public ControllerCaso(String nombre, int numeroTelefono, String tipoDeTerreno, int terrenoDisponible, String provincia, boolean sembrado, int cantidadActual, 
			int deuda, int dineroDisponible, int ingresosActuales, int ingresosAnoPasado, String organizacion, CasoUI casoUI) {
		this.name = nombre;
		this.cellphoneNumber = numeroTelefono;
		this.landType = tipoDeTerreno;
		this.availableLand = terrenoDisponible;
		this.provincia = provincia;
		this.sembrado = sembrado;
		this.actualQuantity = cantidadActual;
		this.debt = deuda;
		this.availableMoney = dineroDisponible;
		this.actualIncome = ingresosActuales;
		this.lastYearIncome = ingresosAnoPasado;
		this.organization = organizacion;
		this.instanciaCaso = casoUI;
	}
	
	public void actualizarTablaAsesores() {
		instanciaCaso.pintarTable(name, cellphoneNumber, availableLand, landType, provincia, debt, availableMoney, organization);
	}
	
	public boolean verificarDatos() {
		boolean verificado = true;
		
		//Aquí tengo que validar el contenido de cada variable para ver si corresponde y no se haya metido algo incorrecto
		
		return verificado;
	}

	public String getName() {
		return name;
	}

	public int getCellphoneNumber() {
		return cellphoneNumber;
	}

	public int getAvailableLand() {
		return availableLand;
	}

	public String getLandType() {
		return landType;
	}

	public String getProvincia() {
		return provincia;
	}

	public boolean isSembrado() {
		return sembrado;
	}

	public int getActualQuantity() {
		return actualQuantity;
	}

	public int getDebt() {
		return debt;
	}

	public int getAvailableMoney() {
		return availableMoney;
	}

	public int getActualIncome() {
		return actualIncome;
	}

	public int getLastYearIncome() {
		return lastYearIncome;
	}

	public String getOrganization() {
		return organization;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public CasoUI getTableAsesores() {
		return instanciaCaso;
	}

}

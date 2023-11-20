
package ControllersGUI;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import clasesLogicas.Agricultor;
import clasesLogicas.Asesor;
import clasesLogicas.Caso2;
import clasesLogicas.InfoTemporal;
import clasesLogicas.PlanEconomico;
import interfacesGraficas.AsesorUI;
import interfacesGraficas.CasoUI;
import interfacesGraficas.CasoUI3;
import strapi.Main;

public class ControllerCaso {
	private Caso2 caso2;
	private CasoUI tableCaso2;
	private double deuda;
	private double terrenoDisponible;
	private String tipoDeTerreno;
	private double dineroDisponible;
	private int numeroTelefono;
	
	public ControllerCaso(int IDCaso, Agricultor agricultor, int numeroTelefono, Asesor asesor, String provincia, int telefonoAsesor, String organizacion, Date fechaIngresoCaso, String estado, CasoUI casoUI, double deuda, double availableLand, String terrainType, double dineroDisponible) {
		this.caso2 = new Caso2(IDCaso, agricultor, numeroTelefono, asesor, provincia, telefonoAsesor, organizacion, fechaIngresoCaso, estado);
		Main.casos.add(caso2);
		this.tableCaso2 = casoUI;
		this.deuda = deuda;
		this.terrenoDisponible = availableLand;
		this.tipoDeTerreno = terrainType;
		this.dineroDisponible = dineroDisponible;
		this.numeroTelefono = numeroTelefono;
		PlanEconomico plan = null;
		
		
		InfoTemporal infoTemporal = new InfoTemporal(agricultor.getNombre(), numeroTelefono, availableLand, terrainType, provincia,
				deuda, dineroDisponible, organizacion, plan);
		
		Main.infoTemporalessinasignar.add(infoTemporal);
	}
	
	
	public void actualizarTablaAsesores() {
		// Obtener el modelo de la tabla
	    DefaultTableModel model = (DefaultTableModel) tableCaso2.getTable().getModel();
//	    SimpleDateFormat dateOnly = new SimpleDateFormat("yyyy/MM/dd");
	    
	    Agricultor agricultor = caso2.getAgricultor();
	    
	    model.addRow(new Object[]{agricultor.getNombre(), numeroTelefono, terrenoDisponible, tipoDeTerreno, caso2.getProvincia(), deuda, dineroDisponible, caso2.getOrganiRepresentante(), "no asignado"});

	    // Agregar una nueva fila con la información proporcionada
//	    model.addRow(new Object[]{asesor.getNombre(), asesor.getId(), asesor.getZona(), asesor.getCorreo(), asesor.getExperiencia(), asesor.getRating(), 
//	    						  asesor.getCantidadCasos(), dateOnly.format(asesor.getFechaIngreso().getTime())});
	    
	    // Refrescar la tabla
	    tableCaso2.getTable().repaint();
	}
	
	public boolean verificarDatos() {
		boolean verificado = true;
		
		//Aquí tengo que validar el contenido de cada variable para ver si corresponde y no se haya metido algo incorrecto
		
		return verificado;
	}

	public CasoUI getTableCaso() {
		return tableCaso2;
	}


	public Caso2 getCaso2() {
		return caso2;
	}


	public CasoUI getTableCaso2() {
		return tableCaso2;
	}


	public double getDeuda() {
		return deuda;
	}


	public double getTerrenoDisponible() {
		return terrenoDisponible;
	}


	public String getTipoDeTerreno() {
		return tipoDeTerreno;
	}


	public double getDineroDisponible() {
		return dineroDisponible;
	}
	
/*
	private String name;
	private int cellphoneNumber;
	private double availableLand;
	private String landType;
	private String provincia;
	private boolean sembrado;
	private int actualQuantity;
	private double debt;
	private double availableMoney;
	private int actualIncome;
	private int lastYearIncome;
	private String organization;
	private Date fechaIngreso;
	private CasoUI instanciaCaso;
	
	public ControllerCaso2(String nombre, int numeroTelefono, String tipoDeTerreno, double terrenoDisponible, String provincia, boolean sembrado, int cantidadActual, 
			double deuda, double dineroDisponible, int ingresosActuales, int ingresosAnoPasado, String organizacion, CasoUI casoUI) {
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

	public double getAvailableLand() {
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

	public double getDebt() {
		return debt;
	}

	public double getAvailableMoney() {
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
*/
}


package ControllersGUI;

import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clasesLogicas.InfoTemporal;
import clasesLogicas.PlanEconomico;
import interfacesGraficas.CasoUI;
import interfacesGraficas.CasoUI3;
import strapi.Main;

public class ControllerCaso3 {
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
	
	public ControllerCaso3(String nombre, int numeroTelefono, String tipoDeTerreno, double terrenoDisponible, String provincia, boolean sembrado, int cantidadActual, 
			double deuda, double dineroDisponible, int ingresosActuales, int ingresosAnoPasado, String organizacion, CasoUI casoUI) {
		
		//Creo un objeto tipo infoTemporal por mientras
		//Pero se deberia de crear un objeto caso
		
		
		
		
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
		PlanEconomico plan = null;
		
		
		InfoTemporal infoTemporal = new InfoTemporal(name, cellphoneNumber, availableLand, landType, provincia,
				debt, availableMoney, organization, plan);
		
		Main.infoTemporalessinasignar.add(infoTemporal);
	}
	
	public void actualizarTablaAsesores() {
		
		JTable tablaCasos = Main.CasoUI.getTable();
		// Obtener el modelo de la tabla
	    DefaultTableModel model = (DefaultTableModel) tablaCasos.getModel();

	    // Agregar una nueva fila con la información proporcionada
	    model.addRow(new Object[]{name, cellphoneNumber, availableLand, landType, provincia, debt, availableMoney, organization, "no asignado"});

	    // Refrescar la tabla
	    tablaCasos.repaint();
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

}

package ControllersGUI;

import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import clasesLogicas.*;

import strapi.Main;

public class ActualizadorPlanDisponible {
	public ActualizadorPlanDisponible() {
		
	}
	
	public void actualizarTable(JTable tablaPlanesDisponibles) {
		for (PlanEconomico plan : Main.planesRegistrados) {
			// Obtener el modelo de la tabla
    	    DefaultTableModel modelTable = (DefaultTableModel) tablaPlanesDisponibles.getModel();
    	    // Agregar una nueva fila con la información proporcionada
    	    modelTable.addRow(new Object[]{plan.getNombreAsesor(), plan.getPasos().size()});
		}
		tablaPlanesDisponibles.repaint();
	}
	
	public void asignarPlan(JTable tablaPlanesDisponibles, int filaSeleccionada) {
		
		String nombre = tablaPlanesDisponibles.getValueAt(filaSeleccionada, 0).toString();
        int cantidadCasos = Integer.parseInt(tablaPlanesDisponibles.getValueAt(filaSeleccionada, 1).toString());
        //Ahora tengo que actualizar todo
        //Actualizar en el array de planes disponibles y quitar el que se utilizó
        //Actualizar en el array de infoTemporales que simula los casos
        
        //Ya tengo el nombre del asesor y la cantidad de pasos de un plan
        //Busco entre los planes que tengo
        for (PlanEconomico plan : Main.planesRegistrados) {
			if (plan.getNombreAsesor() == nombre && plan.getPasos().size() == cantidadCasos) {
				//Ya tengo el plan economico, ahora traigo el objeto infoTemporal 
				InfoTemporal infoTemporal = Main.planesEconomicos.getInfo();
				
				//le asigno su plan
				infoTemporal.setPlan(plan);
				
				//Lo elimino porque ese plan ya no va a estar disponible más tiempo
				int indicePlan = Main.planesRegistrados.indexOf(plan);
				Main.planesRegistrados.remove(indicePlan);
				
				//Ahora lo busco en la lista para quitarlos de sin asignados
				for (InfoTemporal info : Main.infoTemporalessinasignar) {
					if (info.getAgricultor() == infoTemporal.getAgricultor() && info.getDeuda() == infoTemporal.getDeuda() && info.getDineroDisponible() == infoTemporal.getDineroDisponible()) {
						int indice = Main.infoTemporalessinasignar.indexOf(info);
						Main.infoTemporalessinasignar.remove(indice);
						
						//Ahora aquí mismo me toca buscar aquel caso que coincida con el objeto que tengo para asignarle el asesor
						
						//Busco el asesor con el nombre en la lista de asesores registrados
						for (Asesor asesorx : Main.asesoresRegistrados) {
							if (asesorx.getNombre() == nombre) {
								Asesor asesor = asesorx;
								//Ahora busco en los casos
								for (Caso2 caso : Main.casos) {
									if (caso.getAgricultor().getNombre() == infoTemporal.getAgricultor() && caso.getTelefonoAgricultor() == infoTemporal.getTelefonoAgricultor()) {
										caso.setAsesor(asesor);
										break;
									}
								}
								break;
							}
						}
					}
				}
			}
		}
     //Explicacion
        /*
         * Yo tengo que en la ventana de CasoUI sale informacion cuando yo creo un caso
         * Entonces lo que hice para poder ir pasando la informacion entre ventanas mas facilmente fue crear a InfoTemporal
         * InfoTemporal tiene la informacion necesaria para usarla como caso y asignarle un plan
         * Entonces en tienen 4 listas (asesores, casos, planes e infoTemporales)
         * En asesores guardo cuando creo un asesor
         * En casos cuando se crea un caso completamente con el objeto Asesor nulo (Aqui se termina de llenar cuando se asigna el plan)
         * En planes, lo que guarda son planes economicos que tiene el nombre de un asesor y su lista de planes por objeto
         * 
         * Entonces primero cuando voy a ver en mis planes aquellos casos no asignados, uso la lista de infoTemporal para pintarla
         * Cuando voy a crear un plan, se crea y se mete en la lista de planes
         * Cuando voy a asignar un plan, entonces veo la lista de planes creados para pintar la pantalla y que se pueda elegir uno
         * Como yo tengo solo el nombre del asesor y la cantidad de pasos del plan (porque no puedo pintar los pasos digamos de entrada)
         * entonces lo que hago es que cuando se asigna un asesor con su plan, se busca en las listas para completar la informacion
         * 
         * Por lo tanto, aquí se toma el nombre del asesor y se busca en los registrados, para inicializar el objeto y asignarlo al caso
         * además, quito de la lista de InfoTemporales el que se acaba de seleccionar porque pasa de no asignado a asignado
         * Esto se va a ver reflejado en la tabla de casoUI que lo mejor sería que se pintara con esa misma lista para que se actualice
         * 
         * Ahora el problema que falta resolver nuevamente es cómo puedo guardar los pasos o mas bien un plan asignado a caso,
         * ya que inicialmente se tiene sin nada asignado
         * */
       
	}
}

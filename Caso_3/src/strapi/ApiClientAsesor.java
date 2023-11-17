package strapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.google.gson.Gson;

import clasesLogicas.*;

public class ApiClientAsesor{

	private static ApiClientAsesor instanceAsesor = new ApiClientAsesor();
	private static String apiUrl;
	private ArrayList<Asesor> asesores= new ArrayList<>();
	
	private ApiClientAsesor() {
		apiUrl = "http://localhost:1337/api/asesors";
	}
	
	public static ApiClientAsesor getInstance() {
		return instanceAsesor;
	}
	
	public void enviarPOST(Asesor asesor) {
		
		String postData = null;
		try {
		    Gson gson = new Gson();
		    DataWrapper<Asesor> terrenoWrapper = new DataWrapper<>(asesor);
		    String jsonData = gson.toJson(terrenoWrapper);

		    // Si deseas imprimir el JSON resultante
		    System.out.println("JSON resultante: " + jsonData);

		    postData = jsonData;
		} catch (Exception e) {
		    e.printStackTrace();
		}

        StringBuilder response = new StringBuilder();
        CuerpoPost cuerpo = new CuerpoPost(response, postData, apiUrl);
    }
	
	public void getObject() {
		ArrayList<Asesor> asesores = new ArrayList<>();
	    try {
	        // Construye la URL con el nombre buscado como parámetro de consulta
	        String apiUrl = "http://localhost:1337/api/asesors";
	        URL url = new URL(apiUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("GET");

	        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        StringBuilder response = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            response.append(line);
	        }
	        reader.close();

	        connection.disconnect();

	        // Parsea la respuesta JSON utilizando las librerías javax.json
	        try (JsonReader jsonReader = Json.createReader(new java.io.StringReader(response.toString()))) {
	            JsonObject jsonObject = jsonReader.readObject();
	            JsonArray dataArray = jsonObject.getJsonArray("data");

	            // Si hay al menos un objeto en el array 'data'
	            for (int i = 0; i < dataArray.size(); i++) {
	                JsonObject currentObject = dataArray.getJsonObject(i);
	                JsonObject attributesObject = currentObject.getJsonObject("attributes");

	                String fechaStr = attributesObject.getString("fechaIngreso");
	                String name = attributesObject.getString("nombre");
		             // Limpiar la cadena eliminando el "?" y cualquier espacio adicional
		             fechaStr = fechaStr.replace("?", "").trim();

		             // Patrón que coincide con el formato proporcionado
		             SimpleDateFormat formatoFecha = new SimpleDateFormat("MMM dd, yyyy, HH:mm:ss", Locale.ENGLISH);
		             Date fecha = null;
		             try {
		                 // Parsear la cadena de fecha a un objeto Date
		                 fecha = formatoFecha.parse(fechaStr);

		                 // Imprimir la fecha para verificar
		                 //System.out.println("Fecha parseada: " + fecha);
		             } catch (ParseException e) {
		                 e.printStackTrace();
		             }


	                // Crea un nuevo objeto Agricultor con los datos obtenidos
	                Asesor asesor = new Asesor(name, attributesObject.getString("lugar"), attributesObject.getString("correo"), attributesObject.getJsonNumber("rating").doubleValue(),
	                		Integer.parseInt(attributesObject.getString("experiencia")), Integer.parseInt(attributesObject.getString("cantCasos")), fecha);
	                asesores.add(asesor);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    this.asesores = asesores;
	}
	
	
	
	public Asesor extraerTerrenoEspecifico(String asesorName) {
		Asesor currentAsesor = null;
		
		//Aqui se va a retornar una lista de terrenos que pertenecen a un dueño inclusive siendo solo uno
		for (Asesor asesor : asesores) {
			if (asesorName.equals(asesor.getNombre())) {
				currentAsesor = asesor;
			}
		}
		return currentAsesor;
	}

	public ArrayList<Asesor> getTerrenos() {
		return asesores;
	}
}



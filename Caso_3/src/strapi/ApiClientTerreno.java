package strapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import com.google.gson.Gson;

import clasesLogicas.*;

public class ApiClientTerreno {

	private static ApiClientTerreno instanceTerreno = new ApiClientTerreno();
	private static String apiUrl;
	private ArrayList<Terreno> terrenos;
	
	private ApiClientTerreno() {
		apiUrl = "http://localhost:1337/api/terrenos";
	}
	
	public static ApiClientTerreno getInstance() {
		return instanceTerreno;
	}
	

	public void enviarPOST(Terreno terreno) {
		String postData = null;
		try {
		    Gson gson = new Gson();
		    DataWrapper<Terreno> terrenoWrapper = new DataWrapper<>(terreno);
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
	
	public void getObjects() {
	    ArrayList<Terreno> terrenos = new ArrayList<>();
	    try {
	        // Construye la URL con el nombre buscado como parámetro de consulta
	        String apiUrl = "http://localhost:1337/api/terrenos";
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

	                // Obtiene los valores de los campos necesarios del objeto JSON

	                // Crea un nuevo objeto Terreno con los datos obtenidos
	                Terreno terreno = new Terreno(attributesObject.getString("tipoSuelo"), attributesObject.getBoolean("siembra"), 
	                		attributesObject.getJsonNumber("hectareas").doubleValue(), attributesObject.getString("dueno"));
	                terrenos.add(terreno);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    this.terrenos = terrenos;
	}
	
	public Terreno getExtraerTerrenoEspecifico(String dueno) {
		
		//Aqui se va a retornar una lista de terrenos que pertenecen a un dueño inclusive siendo solo uno
		for (Terreno terreno : terrenos) {
			if (dueno.equals(terreno.getDueno())) {
				return terreno;
			}
		}
		return null;
	}

	public ArrayList<Terreno> getTerrenos() {
		return terrenos;
	}

	
	
	
}


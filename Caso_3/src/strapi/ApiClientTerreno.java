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

import clasesLogicas.*;

public class ApiClientTerreno {

	private static ApiClientTerreno instanceTerreno = new ApiClientTerreno();
	private static String apiUrl;
	
	private ApiClientTerreno() {
		apiUrl = "http://localhost:1337/api/terrenos";
	}
	
	public static ApiClientTerreno getInstance() {
		return instanceTerreno;
	}
	

	public static String enviarPOST(Terreno terreno) {
		
		//Aqui se estaria guardando el registro correspondiente en la coleccion de agricultores
		String postData = "{\"data\":{\"tipoSuelo\":\"" + terreno.getTipoSuelo() + "\",\"dueno\":\"" +
		terreno.getDueno() + "\",\"abonado\":" + terreno.isAbonado() + ",\"siembra\":" +
		terreno.isSiembra() + ",\"plagas\":" + terreno.isPlaga() + ",\"hectareas\":" +
		terreno.getHectareas() + "}}";



        StringBuilder response = new StringBuilder();
        try {
        	
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            OutputStream os = connection.getOutputStream();
            os.write(postData.getBytes());
            os.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.toString();
    }
	
	public Terreno getObject(String nombreDueno) {
	    Terreno terreno = null;
	    try {
	        // Construye la URL con el nombre buscado como parámetro de consulta
	        String apiUrl = "http://localhost:1337/api/terrenos?dueno=" + URLEncoder.encode(nombreDueno, "UTF-8");
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
	            if (dataArray.size() > 0) {
	                JsonObject firstObject = dataArray.getJsonObject(0);
	                JsonObject attributesObject = firstObject.getJsonObject("attributes");
	                
	                
	                // Obtiene los valores de los campos necesarios del objeto JSON
	                boolean abonado = attributesObject.getBoolean("abonado");
	                boolean siembra = attributesObject.getBoolean("siembra");
	                boolean plaga = attributesObject.getBoolean("plagas");
	                double hectareas = attributesObject.getJsonNumber("hectareas").doubleValue();
	                String tipoSuelo = attributesObject.getString("tipoSuelo");

	                // Crea un nuevo objeto Agricultor con los datos obtenidos
	                terreno = new Terreno(tipoSuelo, siembra, plaga, abonado, hectareas, nombreDueno);
	            } else {
	                System.out.println("No se encontraron datos para el dueno buscado: " + nombreDueno);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return terreno;
	}

	
	
	public ArrayList<Pago> getListObject() {
		//Logica para crear el objeto con la informacion
		ArrayList<Pago> listaPagos = new ArrayList<>();
		return listaPagos;
	}
}


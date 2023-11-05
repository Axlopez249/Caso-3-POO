package strapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import clasesLogicas.*;

public class ApiClientAsesor{

	private static ApiClientAsesor instanceAsesor = new ApiClientAsesor();
	private static String apiUrl;
	
	private ApiClientAsesor() {
		apiUrl = "http://localhost:1337/api/asesors";
	}
	
	public static ApiClientAsesor getInstance() {
		return instanceAsesor;
	}
	
	public static String enviarPOST(Asesor asesor) {
		
		//Aqui se estaria guardando el registro correspondiente en la coleccion de agricultores
		String postData = "{\"data\":{\"nombre\":\"" + asesor.getNombre() + "\",\"lugar\":\"" +
				asesor.getLugar() + "\",\"correo\":\"" + asesor.getCorreo() + "\",\"experiencia\":" +
				asesor.getExperiencia() + ",\"cantCasos\":" + asesor.getCantCasos() + ",\"fechaIngreso\":\"" +
		        getFecha(asesor.getFechaIngreso()) + "\",\"rating\":" + asesor.getRating() + "}}";

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
	
	public Asesor getObject(String asesorName) {
	    Asesor asesor = null;
	    try {
	        // Construye la URL con el nombre buscado como parámetro de consulta
	        String apiUrl = "http://localhost:1337/api/asesors?nombre=" + URLEncoder.encode(asesorName, "UTF-8");
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
	                String lugar = attributesObject.getString("lugar");
	                int experiencia = Integer.parseInt(attributesObject.getString("experiencia"));
	                int cantCasos = Integer.parseInt(attributesObject.getString("cantCasos"));
	                double rating = attributesObject.getJsonNumber("rating").doubleValue();
	                Date fechaIngreso = new Date(attributesObject.getString("fechaIngreso"));
	                String correo = attributesObject.getString("correo");

	                // Crea un nuevo objeto Agricultor con los datos obtenidos
	                asesor = new Asesor(asesorName, lugar, correo, rating, experiencia, cantCasos, fechaIngreso);
	            } else {
	                System.out.println("No se encontraron datos para el dueno buscado: " + asesorName);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return asesor;
	}
	
	
	
	public static String getFecha(Date fecha) {
			
		Date fechaActual = new Date();

        // Define el formato de fecha que deseas
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        // Convierte la fecha a un String en el formato deseado
        String fechaFormateada = formato.format(fechaActual);

        // Imprime la fecha formateada
        
        return fechaFormateada;
	}
}



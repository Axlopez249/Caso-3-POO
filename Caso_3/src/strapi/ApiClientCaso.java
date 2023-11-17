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

import com.google.gson.Gson;

import clasesLogicas.*;

public class ApiClientCaso {

	private static ApiClientCaso instanceCaso = new ApiClientCaso();
	private static String apiUrl;
	private ArrayList<Caso> casos;
	
	private ApiClientCaso() {
		apiUrl = "http://localhost:1337/api/casos";
	}
	
	public static ApiClientCaso getInstance() {
		return instanceCaso;
	}
	

	public void enviarPOST(Caso caso) {
		ObjetoTempoCaso temp = new ObjetoTempoCaso(caso.getIdCaso(), caso.getTelefonoAgricultor(),
				caso.getProvincia(), caso.getTelefonoAsesor(), caso.getOrganiRepresentante(), caso.getFechaIngreso(), caso.getEstado());
		
		String postData = null;
		try {
		    Gson gson = new Gson();
		    DataWrapper<ObjetoTempoCaso> terrenoWrapper = new DataWrapper<>(temp);
		    String jsonData = gson.toJson(terrenoWrapper);

		    // Si deseas imprimir el JSON resultante
		    System.out.println("JSON resultante: " + jsonData);

		    postData = jsonData;
		} catch (Exception e) {
		    e.printStackTrace();
		}

        StringBuilder response = new StringBuilder();
        CuerpoPost cuerpo = new CuerpoPost(response, postData, apiUrl);
        
        ApiClientAsesor asesorInstance = ApiClientAsesor.getInstance();
        asesorInstance.enviarPOST(caso.getAsesor());
        
        ApiClientAgricultor agriInstance = ApiClientAgricultor.getInstance();
        agriInstance.enviarPOST(caso.getAgricultor());
        
        
    }
	
	public void getObject() {
		ArrayList<Caso> casos = new ArrayList<>();
	    try {
	        // Construye la URL con el nombre buscado como parámetro de consulta
	        String apiUrl = "http://localhost:1337/api/casos";
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
	                String provincia = attributesObject.getString("Provincia");
	                String orga = attributesObject.getString("organizacionRepresentante");
	                String estado = attributesObject.getString("Estado");
	                Date fechaIngreso = new Date(attributesObject.getString("fechaIngreso"));
	                int teleAsesor = Integer.parseInt(attributesObject.getString("telefonoAsesor"));
	                int teleAgri = Integer.parseInt(attributesObject.getString("telefonoAgricultor"));
	                String agricultor = attributesObject.getString("agricultor");
	                String asesor = attributesObject.getString("Asesor");
	                int idCaso = Integer.parseInt(attributesObject.getString("idCaso"));
	                
	                // Crea un nuevo objeto Agricultor con los datos obtenidos
	                ApiClientAgricultor instanceAgricultor = ApiClientAgricultor.getInstance();
	                instanceAgricultor.getObject();
	                
	                ApiClientAsesor instanceAsesor = ApiClientAsesor.getInstance();
	                instanceAsesor.getObject();
	                
	                Caso caso = new Caso(idCaso, instanceAgricultor.getAgricultorespecifico(agricultor), teleAgri,
	                		instanceAsesor.extraerTerrenoEspecifico(asesor), provincia,
	                teleAsesor, orga, fechaIngreso, estado);
	                
	                casos.add(caso);
	          
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    this.casos = casos;
	}
	
	public ArrayList<Caso> getCasos() {
		return casos;
	}
		

	public Caso getCasoEspecifico(int code){
		Caso currentCaso = null;

		for (Caso caso : casos) {
			if (code == caso.getIdCaso()) {
				currentCaso = caso;
			}
		}
		return currentCaso;
		
	}
	
}



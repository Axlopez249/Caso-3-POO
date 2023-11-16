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

public class ApiClientCaso {

	private static ApiClientCaso instanceCaso = new ApiClientCaso();
	private static String apiUrl;
	
	private ApiClientCaso() {
		apiUrl = "http://localhost:1337/api/casos";
	}
	
	public static ApiClientCaso getInstance() {
		return instanceCaso;
	}
	

	public String enviarPOST(Caso caso) {
		
		//Aqui se estaria guardando el registro correspondiente en la coleccion de agricultores
		String postData = "{\"data\":{\"telefonoAgricultor\":" + caso.getTelefonoAgricultor() +
                ",\"Provincia\":\"" + caso.getProvincia() + "\",\"telefonoAsesor\":" +
                caso.getTelefonoAsesor() + ",\"organizacionRepresentante\":\"" +
                caso.getOrganiRepresentante() + "\",\"fechaIngreso\":\"" +
                getFecha(caso.getFechaIngreso()) + "\",\"Estado\":\"" + caso.getEstado() + "\",\"idCaso\":" + caso.getIdCaso() +
                ",\"agricultor\":\"" + caso.getAgricultor().getNombre() + "\",\"Asesor\":\"" + caso.getAsesor().getNombre() + "\"}}";

		ApiClientAgricultor agricultorStrapi = ApiClientAgricultor.getInstance();
        agricultorStrapi.enviarPOST(caso.getAgricultor());
        
        ApiClientAsesor asesorStrapi = ApiClientAsesor.getInstance();
        asesorStrapi.enviarPOST(caso.getAsesor());
		
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
	
	public Caso getObject(int codigo) {
		Caso caso = null;
	    try {
	        // Construye la URL con el nombre buscado como parámetro de consulta
	        String apiUrl = "http://localhost:1337/api/casos?idCaso" + URLEncoder.encode(String.valueOf(codigo), "UTF-8");
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
	                Agricultor agricultorObject = instanceAgricultor.getObject(agricultor);
	                
	                ApiClientAsesor instanceAsesor = ApiClientAsesor.getInstance();
	                Asesor asesorObject = instanceAsesor.getObject(asesor);
	                
	                caso = new Caso(idCaso, agricultorObject, teleAgri, asesorObject, provincia,
	                teleAsesor, orga, fechaIngreso, estado);
	          
	            } else {
	                System.out.println("No se encontraron datos para el codigo buscado: " + codigo);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return caso;
	}
	
	
	public ArrayList<Pago> getListObject() {
		//Logica para crear el objeto con la informacion
		ArrayList<Pago> listaPagos = new ArrayList<>();
		return listaPagos;
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



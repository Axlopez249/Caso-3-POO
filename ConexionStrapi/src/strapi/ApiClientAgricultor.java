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

public class ApiClientAgricultor {
	private static ApiClientAgricultor instanceAgricultor = new ApiClientAgricultor();
	private static String apiUrl;
	
	private ApiClientAgricultor() {
		apiUrl = "http://localhost:1337/api/agricultors";
	}
	
	public static ApiClientAgricultor getInstance() {
		return instanceAgricultor;
	}
	

	public static String enviarPOST(Agricultor agricultor) {
		
		//Aqui se estaria guardando el registro correspondiente en la coleccion de agricultores
		String postData = "{\"data\":{\"nombre\":\"" + agricultor.getNombre() + "\",\"idAgricultor\":" + 
		agricultor.getId() + ",\"deuda\":" + agricultor.getDeuda() + ",\"dinero\":" + agricultor.getDinero() +"}}";
		
		//Como esa clase tiene mas informacion a guardar lo hacemos en otras colecciones utilizando otras instancias
		//unicas para realizar el almacenamiento
		ApiClientProducto instanceProduct = ApiClientProducto.getInstance();
		instanceProduct.enviarPOST(agricultor.getProducto());
		
		ApiClientTerreno instanceTerreno = ApiClientTerreno.getInstance();
		instanceTerreno.enviarPOST(agricultor.getTerreno());
		
		
		
		
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
	
	public Agricultor getObject(String nombreBuscado) {
        Agricultor agricultor = null;
        try {
            // Construye la URL con el nombre buscado como parámetro de consulta
            String apiUrl = "http://localhost:1337/api/agricultors?nombre=" + URLEncoder.encode(nombreBuscado, "UTF-8");
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
                    String nombre = attributesObject.getString("nombre");
                    double deuda = attributesObject.getJsonNumber("deuda").doubleValue();
                    double dinero = attributesObject.getJsonNumber("dinero").doubleValue();
                    int idAgricultor = Integer.parseInt(attributesObject.getString("idAgricultor"));

                    ApiClientTerreno instanceTerreno = ApiClientTerreno.getInstance();
                    Terreno terreno = instanceTerreno.getObject(nombre);
                    ApiClientProducto instanceProducto = ApiClientProducto.getInstance();
                    Producto producto = instanceProducto.getObject(nombre);
                    
                    agricultor = new Agricultor(nombre, idAgricultor, dinero, deuda, terreno, producto)
;
                } else {
                    System.out.println("No se encontraron datos para el nombre buscado: " + nombreBuscado);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return agricultor;
    }
		

	
	
	public ArrayList<Pago> getListObject() {
		//Logica para crear el objeto con la informacion
		ArrayList<Pago> listaPagos = new ArrayList<>();
		return listaPagos;
	}
}

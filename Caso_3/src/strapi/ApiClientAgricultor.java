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

public class ApiClientAgricultor {
	private static ApiClientAgricultor instanceAgricultor = new ApiClientAgricultor();
	private static String apiUrl;
	private ArrayList<Agricultor> agricultores = new ArrayList<>();
	
	
	private ApiClientAgricultor() {
		apiUrl = "http://localhost:1337/api/agricultors";
	}
	
	public static ApiClientAgricultor getInstance() {
		return instanceAgricultor;
	}
	

	public void enviarPOST(Agricultor agricultor) {
		ObjetoTempoAgri temp = new ObjetoTempoAgri(agricultor.getNombre(),agricultor.getId(), agricultor.getDinero(), agricultor.getDeuda(), agricultor.getTelefono(), agricultor.getIngresosActuales(), agricultor.getGananciasAñoPasado());
		
		String postData = null;
		try {
		    Gson gson = new Gson();
		    DataWrapper<ObjetoTempoAgri> agriWrapper = new DataWrapper<>(temp);
		    String jsonData = gson.toJson(agriWrapper);

		    // Si deseas imprimir el JSON resultante
		    System.out.println("JSON resultante: " + jsonData);

		    postData = jsonData;
		} catch (Exception e) {
		    e.printStackTrace();
		}

        StringBuilder response = new StringBuilder();
        CuerpoPost cuerpo = new CuerpoPost(response, postData, apiUrl);
        
        ApiClientTerreno terre = ApiClientTerreno.getInstance();
        ApiClientProducto pro = ApiClientProducto.getInstance();
        
        
        terre.enviarPOST(agricultor.getTerreno());
        
        pro.enviarPOST(agricultor.getProducto());
        
        
    }
	
	public void getObject() {
		ArrayList<Agricultor> agricultores = new ArrayList<>();
        try {
            // Construye la URL con el nombre buscado como parámetro de consulta
            String apiUrl = "http://localhost:1337/api/agricultors";
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
                    String nombre = attributesObject.getString("nombre");
                    double deuda = attributesObject.getJsonNumber("deuda").doubleValue();
                    double dinero = attributesObject.getJsonNumber("dinero").doubleValue();
                    int telefono = Integer.parseInt(attributesObject.getString("telefono"));
                    double ingresosActuales =  attributesObject.getJsonNumber("ingresosActuales").doubleValue();             
                    double gananciasAnoPasado = attributesObject.getJsonNumber("gananciasAnoPasado").doubleValue(); 
                    int idAgricultor = Integer.parseInt(attributesObject.getString("idAgricultor"));
                    

                    ApiClientTerreno instanceTerreno = ApiClientTerreno.getInstance();
                    instanceTerreno.getObjects();
                    
                    ApiClientProducto instanceProducto = ApiClientProducto.getInstance();
                    instanceProducto.getObjects();

                    Agricultor agricultor = new Agricultor(nombre, idAgricultor, dinero, deuda, telefono, ingresosActuales, gananciasAnoPasado, instanceTerreno.getExtraerTerrenoEspecifico(nombre),
                    		instanceProducto.getExtraerProductoEspecifico(nombre));
                    
                    agricultores.add(agricultor);
                } 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.agricultores = agricultores;
    }

	public ArrayList<Agricultor> getAgricultores() {
		return agricultores;
	}
		

	public Agricultor getAgricultorespecifico(String nombre){
		Agricultor currentAgricultor = null;

		for (Agricultor agricultor : agricultores) {
			if (nombre.equals(agricultor.getNombre())) {
				currentAgricultor = agricultor; 
			}
		}
		return currentAgricultor;
		
	}
	

}
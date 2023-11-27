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

public class ApiClientProducto {

	private static ApiClientProducto instanceProducto = new ApiClientProducto();
	private static String apiUrl;
	private ArrayList<Producto> productos;
	
	private ApiClientProducto() {
		apiUrl = "http://localhost:1337/api/productos";
	}
	
	public static ApiClientProducto getInstance() {
		return instanceProducto;
	}
	

	public void enviarPOST(Producto producto) {
		
		String postData = null;
		try {
		    Gson gson = new Gson();
		    DataWrapper<Producto> terrenoWrapper = new DataWrapper<>(producto);
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
	    ArrayList<Producto> productos = new ArrayList<>();
	    try {
	        // Construye la URL con el nombre buscado como parámetro de consulta
	        String apiUrl = "http://localhost:1337/api/productos";
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
	                String fechaStr = attributesObject.getString("caducidad");
	                String nombre = attributesObject.getString("nombre");
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

	                // Crea un nuevo objeto Producto con los datos obtenidos
	                Producto producto = new Producto(attributesObject.getString("nombre"), attributesObject.getBoolean("abonado"), fecha, Integer.parseInt(attributesObject.getString("cantidad")), nombre);
	                productos.add(producto);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    this.productos = productos;
	}

	
	public Producto getExtraerProductoEspecifico(String productor) {

		//Aqui se va a retornar una lista de terrenos que pertenecen a un dueño inclusive siendo solo uno
		for (Producto producto : productos) {
			if (productor.equals(producto.getProductor())) {
				return producto;
			}
		}
		return null;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}
}

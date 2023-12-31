package strapi;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import clasesLogicas.*;

public class ApiClientPayment {
	
	private ApiClientPayment instancePayment = new ApiClientPayment();
	String apiUrl;
	
	private ApiClientPayment() {
		apiUrl = "http://localhost:1337/api/pruebas";
	}
	
	public ApiClientPayment getInstance() {
		return instancePayment;
	}
	
	public void postObject(Pago pago) {
		
	}
	
	public Pago getObject() {
		
		StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

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
		
		//Logica para crear el objeto con la informacion
		Pago pago = new Pago();
		return pago;
	}
	
	public ArrayList<Pago> getListObject() {
		//Logica para crear el objeto con la informacion
		ArrayList<Pago> listaPagos = new ArrayList<>();
		return listaPagos;
	}
}

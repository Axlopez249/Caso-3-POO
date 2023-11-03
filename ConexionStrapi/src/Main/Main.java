package Main;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        // URL de la API de Strapi
        String apiUrl = "http://localhost:1337/api/pruebas";
        /*
        // Realizar una solicitud GET para obtener datos
        String getResponse = enviarGET(apiUrl);
        System.out.println("Datos obtenidos de Strapi (GET):");
        System.out.println(getResponse);
*/
        // Realizar una solicitud POST para agregar una nueva entrada
        
        
        //A la hora de formar el json tambien lo podemos hacer dentro de la funcion para solo 
        //llamar a la funcion con los datos a guardar
        
        String jsonData = "{\"data\":{\"Name\":\"nuevoNombre2\",\"Code\":67863}}";
        String postResponse = enviarPOST(apiUrl, jsonData);
        System.out.println("Respuesta del servidor (POST):");
        System.out.println(postResponse);
        
    }

    public static String enviarGET(String apiUrl) {
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
        return response.toString();
    }

    public static String enviarPOST(String apiUrl, String postData) {
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
}
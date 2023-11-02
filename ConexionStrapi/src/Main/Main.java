package Main;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Main {
	

    public static void main(String[] args) {
	
    	Observar("http://localhost:1337/api/casos");
    	Agregar(1234, "tsolano@gmail.com");
    	Observar("http://localhost:1337/api/casos");
    }
    
    public static void Observar(String url) {
        OkHttpClient cliente = new OkHttpClient();

        Request solicitud = new Request.Builder()
            .url(url)
            .get()
            .build();

        try {
            Response respuesta = cliente.newCall(solicitud).execute();
            
            if (respuesta.isSuccessful()) {
                ResponseBody cuerpo = respuesta.body();
                String datos = cuerpo.string();
                System.out.println("Datos obtenidos de Strapi: ");
                System.out.println(datos);
            } else {
                System.out.println("La solicitud a Strapi falló");
            }

            respuesta.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void Agregar(int SecretCode, String Email) {
    	OkHttpClient cliente = new OkHttpClient();

        // URL de la colección "Casos" en Strapi
        String url = "http://localhost:1337/casos/auth/local/register"; // Asegúrate de que esta sea la URL correcta de tu colección

        // Datos para la nueva entrada
        String jsonBody = "{\"secretCode\": \"eosa\", \"Email\": \"correo@ejemplo.com\"}";

        // Establecer el tipo de contenido JSON
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody cuerpo = RequestBody.create(jsonBody, JSON);

        // Token de acceso
        String token = "cb104ff5c93e2ae92c2d17acf48f6a4653c19844a20871d8f0f74e6a57616aa10089362f92de8b1cdc5e29ff136cbe0973ec37daa700dcec17c79d4acd82d6ccb4d6ce8cb1b4c89399af66246ea8a2fb2f97df6b3cce59efa211edf07df3f6978e1122be37c7f1d707217a577bc4e4a237af9c477044cf5be7cc6ead1233617a";

        // Crear la solicitud POST con el encabezado de autorización
        Request solicitud = new Request.Builder()
            .url(url)
            .post(cuerpo)
            .header("Authorization", "Bearer " + token)
            .build();

        try {
            Response respuesta = cliente.newCall(solicitud).execute();

            if (respuesta.isSuccessful()) {
                System.out.println("Nueva entrada creada exitosamente.");
            } else {
                System.out.println("La solicitud para crear una nueva entrada en Strapi ha fallado.");
                System.out.println("Código de respuesta: " + respuesta.code());
                System.out.println("Mensaje de error: " + respuesta.message());
                System.out.println("Cuerpo de respuesta: " + respuesta.body().string());
            }

            // Cierra la respuesta
            respuesta.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
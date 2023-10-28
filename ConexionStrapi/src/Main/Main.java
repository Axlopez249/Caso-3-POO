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
    	Agregar(1234, "Don Ramon", "Francisco", 50000);
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
    
    public static void Agregar(int identificacionAgricultor, String nombreAgricultor, String nombreAsesor, double deuda) {
    	OkHttpClient cliente = new OkHttpClient();

        // URL de la colección "Casos" en Strapi
        String url = "http://localhost:1337/api/casos"; // Asegúrate de que esta sea la URL correcta de tu colección

        // Crear un objeto JSON con los datos
        String jsonDatos = "{\"IdentificacionAgricultor\":\"" + identificacionAgricultor + "\", \"NombreAgricultor\":\"" + nombreAgricultor + "\", \"NombreAsesor\":\"" + nombreAsesor + "\", \"Deuda\":" + deuda + "}";


        // Establecer el tipo de contenido JSON
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody cuerpo = RequestBody.create(jsonDatos, JSON);

        // Crear la solicitud POST
        Request solicitud = new Request.Builder()
            .url(url)
            .post(cuerpo)
            .build();

        try {
            Response respuesta = cliente.newCall(solicitud).execute();

            if (respuesta.isSuccessful()) {
                System.out.println("Nueva entrada creada en Strapi con éxito.");
            } else {
                System.out.println("La solicitud a Strapi para crear una nueva entrada falló.");
            }

            // Cierra la respuesta
            respuesta.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
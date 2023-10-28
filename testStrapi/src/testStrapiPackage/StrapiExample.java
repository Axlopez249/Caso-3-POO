package testStrapiPackage;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class StrapiExample {
    public static void main(String[] args) {
    	
    	//Si lee esto, no pude hacer los imports, ya que mi compañero me pasó el código para que lo suba
    	//pero mi computadora no permite por algún motivo hacer build path desde un jar externo.

        realizarSolicitudGet();

        realizarSolicitudPost();
    }

    public static void realizarSolicitudGet() {
        OkHttpClient cliente = new OkHttpClient();
        
        String url = "http://localhost:1337/admin/plugins/content-type-builder/content-types/api::restaurant.restaurant";
        
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
                System.out.println("La solicitud GET a Strapi falló");
            }

            // Cierra la respuesta
            respuesta.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void realizarSolicitudPost() {
        OkHttpClient cliente = new OkHttpClient();
        
        // URL del endpoint de Strapi para la creación de contenido
        String url = "http://localhost:1337/admin/plugins/content-type-builder/content-types/create-content-type";
        
        // Los datos no serán definidos actualmente
        String json = "{ \"campo1\": \"Valor1\", \"campo2\": \"Valor2\" }";
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody cuerpo = RequestBody.create(mediaType, json);
        
        Request solicitud = new Request.Builder()
            .url(url)
            .post(cuerpo)
            .addHeader("Content-Type", "application/json")
            .build();

        try {
            Response respuesta = cliente.newCall(solicitud).execute();
            
            if (respuesta.isSuccessful()) {
                ResponseBody responseBody = respuesta.body();
                String datos = responseBody.string();
                System.out.println("Datos agregados exitosamente en Strapi: ");
                System.out.println(datos);
            } else {
                System.out.println("La solicitud para agregar datos en Strapi falló");
            }

            // Cierra la respuesta
            respuesta.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
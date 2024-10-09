package com.alura.screenmatch.principal;

import com.alura.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.alura.screenmatch.modelos.TitulboOmd;
import com.alura.screenmatch.modelos.Titulo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in); // Inicializa el scanner para la entrada del usuario.
        List<Titulo> titulos = new ArrayList<>(); // Crea una lista para almacenar objetos de tipo Titulo.

        // Configura Gson para manejar la conversión de objetos Java a JSON y viceversa.
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE) // Establece la política de nomenclatura de los campos.
                .setPrettyPrinting() // Habilita la impresión bonita de JSON.
                .create();

        while (true) {
            System.out.println("Escriba el nombre de la peli: "); // Solicita al usuario que ingrese el nombre de una película.
            var busqueda = lectura.nextLine(); // Lee la entrada del usuario.

            if (busqueda.equalsIgnoreCase("salir")) { // Verifica si el usuario quiere salir del ciclo.
                break; // Sale del ciclo si se ingresa "salir".
            }

            // Construye la dirección URL para la API OMDB.
            String direccion = "https://www.omdbapi.com/?t=" +
                    busqueda.replace(" ", "+") + // Reemplaza espacios por "+" en el nombre de la película.
                    "&apikey=e213ac13"; // Agrega la clave API.

            try {
                // Crea un cliente HTTP.
                HttpClient client = HttpClient.newHttpClient();
                // Crea una solicitud HTTP para la dirección construida.
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion)) // Establece la URI de la solicitud.
                        .build();

                // Envía la solicitud y recibe la respuesta.
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body(); // Obtiene el cuerpo de la respuesta como una cadena JSON.
                System.out.println(json); // Imprime la respuesta JSON.

                // Convierte la cadena JSON en un objeto TitulboOmd.
                TitulboOmd miTituloOmbd = gson.fromJson(json, TitulboOmd.class);
                System.out.println(miTituloOmbd); // Imprime el objeto convertido.

                // Convierte el objeto TitulboOmd en un objeto Titulo.
                Titulo miTitulo = new Titulo(miTituloOmbd);
                System.out.println("Título convertido: " + miTitulo); // Imprime el título convertido.

                // Agrega el título a la lista.
                titulos.add(miTitulo);

            } catch (NumberFormatException e) { // Manejo de excepciones.
                System.out.println("Error: ");
                System.out.println(e.getMessage()); // Imprime el mensaje de error.
            } catch (IllegalArgumentException e) {
                System.out.println("Error en URI! Verifique la dirección"); // Maneja errores de URI.
            } catch (ErrorEnConversionDeDuracionException e) {
                System.out.println(e.getMensaje()); // Maneja errores en la conversión de duración.
            }
        }

        System.out.println(titulos); // Imprime la lista de títulos.

        // Escribe la lista de títulos en un archivo JSON.
        FileWriter escritura = new FileWriter("titulos.json");
        escritura.write(gson.toJson(titulos)); // Convierte la lista de títulos a JSON y la escribe en el archivo.
        escritura.close(); // Cierra el escritor de archivos.

        System.out.println("Finalizó la ejecución"); // Mensaje de finalización de la ejecución.
    }
}

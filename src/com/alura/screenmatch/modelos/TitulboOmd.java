package com.alura.screenmatch.modelos;


// La clase TitulboOmd es un registro que representa un título con sus atributos básicos.
// Los registros son una forma concisa de definir clases que solo contienen datos.

public record TitulboOmd(String title, String year, String runtime) {


    // El registro TitulboOmd contiene tres atributos:
    // title: el título de la película o serie.
    // year: el año de lanzamiento de la película o serie.
    // runtime: la duración de la película o serie en formato de cadena.
}

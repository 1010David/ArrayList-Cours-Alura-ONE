package com.alura.screenmatch.excepcion;

// La clase ErrorEnConversionDeDuracionException es una excepción personalizada que se lanza
// cuando hay un error en la conversión de la duración de un título.
public class ErrorEnConversionDeDuracionException extends RuntimeException {

    // Atributo que almacena el mensaje de error.
    private String mensaje;

    // Constructor que recibe un mensaje y lo asigna al atributo.
    public ErrorEnConversionDeDuracionException(String mensaje) {
        this.mensaje = mensaje;
    }

    // Método que devuelve el mensaje de error.
    public String getMensaje() {
        return this.mensaje;
    }
}

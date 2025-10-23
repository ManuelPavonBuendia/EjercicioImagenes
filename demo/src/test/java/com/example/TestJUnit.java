package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Conversion.Conversor;

import java.io.File;
import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;

public class TestJUnit {
    private Conversor conversor;
    @BeforeEach
    public void setup(){
        conversor = new Conversor();

    }

    @Test
void testIntegridadImagenConvertida() throws IOException, InterruptedException {
    String imagenentrada = "src/main/java/com/example/IconoJava.png";
    String imagensalida = "src/main/java/com/example/IconoJava.jpg";

    File archivoSalida = new File(imagensalida);
    if (archivoSalida.exists()) archivoSalida.delete();

    conversor.convertirImagen(imagenentrada, imagensalida);

    assertAll("Verificación de imagen convertida",
        () -> assertTrue(archivoSalida.exists(), "La imagen convertida no fue creada"),
        () -> assertEquals("IconoJava.jpg", archivoSalida.getName(), "El nombre del archivo no es el esperado")
    );
}


@Test
void testFormatoNoValido() {
    String imagenentrada = "src/main/java/com/example/IconoJava.png";
    String imagensalida = "salida.md"; 

    IOException e = assertThrows(IOException.class, () -> {
        conversor.convertirImagen(imagenentrada, imagensalida);
    });

    assertTrue(e.getMessage().toLowerCase().contains("formato no válido"));
}


@Test
void testArchivoNoExiste() {
    String imagenentrada = "src/main/java/com/example/NoExiste.png";
    String imagensalida = "src/main/java/com/example/NoExiste.jpg";

    // Solo comprobamos que se lance IOException
    assertThrows(IOException.class, () -> {
        conversor.convertirImagen(imagenentrada, imagensalida);
    });
}

}


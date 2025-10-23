package com.example.Conversion;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Conversor implements IConversor {

    @Override
    public void convertirImagen(String imagenentrada, String imagensalida) throws IOException, InterruptedException {
        List<String> formatosValidos = List.of("jpg", "png", "gif", "bmp");
        String formatonovalido;
        String archivonoencontrado;
        String extension = imagensalida.substring(imagensalida.lastIndexOf('.') + 1).toLowerCase();


        if (!formatosValidos.contains(extension)) {
            formatonovalido="Formato no válido: " + extension +
                    ". Formatos permitidos: " + String.join(", ", formatosValidos);

            throw new IOException(formatonovalido);
        }

        File archivoEntrada = new File(imagenentrada);
        if (!archivoEntrada.exists()) {
            archivonoencontrado="Archivo de entrada no encontrado: " + imagenentrada;

            throw new IOException(archivonoencontrado);
        }

        String[] comando = { "convert", imagenentrada, imagensalida };

        try {
            Process proceso = Runtime.getRuntime().exec(comando);
            proceso.waitFor();
        } catch (IOException | InterruptedException e) {
            throw new IOException(e.getMessage());
        }
    }
}

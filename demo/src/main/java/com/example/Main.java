package com.example;

import java.io.IOException;

import com.example.Conversion.Conversor;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Conversor conversor = new Conversor();
        String usoformato = "Uso: java com.example.Programa <imagen_entrada> <imagen_salida>";
        if (args.length != 2) {
            throw new IOException(usoformato);
        }
        String imagenentrada = args[0];
        String formatoSalida = args[1];
        try {
        conversor.convertirImagen(imagenentrada, formatoSalida);
         } catch (IOException | InterruptedException e) {
            throw new IOException(e.getMessage());
        }
    }
}
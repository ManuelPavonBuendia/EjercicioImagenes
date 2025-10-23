package com.example.Conversion;

import java.io.IOException;

public interface IConversor {
    void convertirImagen(String imagenentrada, String imagensalida) throws IOException, InterruptedException;
}
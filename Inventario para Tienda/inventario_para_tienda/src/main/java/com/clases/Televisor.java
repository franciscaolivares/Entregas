package com.clases;

public class Televisor extends ProductoElectrodomestico {
    private int tamanoPantalla;
    private String resolucion;

    public Televisor(String nombre, double precio, double cantidadDisponible, int tamanoPantalla, String resolucion) {
        super(nombre, precio, cantidadDisponible);
        this.tamanoPantalla = tamanoPantalla;
        this.resolucion = resolucion;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tamaño de Pantalla: " + tamanoPantalla + " pulgadas");
        System.out.println("Resolución: " + resolucion);
    }
    

}

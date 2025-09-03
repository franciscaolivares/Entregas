package com.clases;

public class ProductoElectrodomestico {

    private String nombre;
    private double precio;
    private double cantidadDisponible;

    public ProductoElectrodomestico(String nombre, double precio, double cantidadDisponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    public ProductoElectrodomestico(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = 0;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public double getCantidadDisponible() {
        return cantidadDisponible;
    }
    public void setCantidadDisponible(double cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad Disponible: " + cantidadDisponible);

    }
}

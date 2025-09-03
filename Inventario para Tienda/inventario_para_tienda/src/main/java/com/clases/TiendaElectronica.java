package com.clases;
import java.util.ArrayList;
public class TiendaElectronica {
    private ArrayList<ProductoElectrodomestico> listaDeProductos;
    public ArrayList<ProductoElectrodomestico> getListaDeProductos() {
        return listaDeProductos;
    }

    public TiendaElectronica() {
        this.listaDeProductos = new ArrayList<>();
    }

    public void agregarProducto(ProductoElectrodomestico producto) {
        listaDeProductos.add(producto);
    }

    public void mostrarProductos() {
        for (ProductoElectrodomestico producto : listaDeProductos) {
            producto.mostrarInformacion();
        }
    }

    public ProductoElectrodomestico buscarProducto (String nombre) {
        for (ProductoElectrodomestico producto : listaDeProductos) {
            if (producto.getNombre().equals(nombre)) {
                return producto;    
            }
        }
        return null;
    }

    public void realizarVenta(String nombre, double cantidad) {
        ProductoElectrodomestico producto = buscarProducto(nombre);
        if (producto != null) {
            int stockActual = (int) producto.getCantidadDisponible();
            if (stockActual > 0) {
                producto.setCantidadDisponible(stockActual - 1);
                System.out.println("Venta realizada: " + producto.getNombre());
            } else {
                System.out.println("Producto agotado: " + producto.getNombre());
                
            }
        } else {
            System.out.println("Producto no encontrado: " + nombre);
        }
    }


}
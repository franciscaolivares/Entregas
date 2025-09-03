package com.clases;

public class Aplicacion {
    public static void main(String[] args) {
        TiendaElectronica tienda = new TiendaElectronica();

        Televisor tv1 = new Televisor("Smart TV Samsung", 320.000, 10, 55, "4K");
        Televisor tv2 = new Televisor("LG OLED", 500.000, 3, 65, "4K");
        ComputadoraPortatil compu1 = new ComputadoraPortatil("Laptop Dell", 550.000, 5, "Dell", "160GB", 123456);
        ComputadoraPortatil compu2 = new ComputadoraPortatil("MacBook Pro", 1200.000, 2, "Apple", "320GB", 654321);
    
        tienda.agregarProducto(tv1);
        tienda.agregarProducto(tv2);
        tienda.agregarProducto(compu1);
        tienda.agregarProducto(compu2);
        System.out.println("Productos en inventario:" );
        tienda.mostrarProductos();
        System.out.println("-----------------------");


        tienda.realizarVenta("LG OLED", 1);
        tienda.realizarVenta("MacBook Pro", 1);

        System.out.println("-----------------------");
        System.out.println("Productos en inventario después de las ventas:");
        tienda.mostrarProductos();

}
}

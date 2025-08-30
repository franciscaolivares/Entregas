package clases;

public class Persona {
    @Override
    public String toString() {
        return nombre + ", edad: " + edad;
    }
    private String nombre = "";
    private int edad = 0;

    /*Constructor */
    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    /*Getters y Setters */

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void despliegaInformacion(){
        System.out.println("Nombre: " + this.nombre + " Edad: " + this.edad);
    } 

}


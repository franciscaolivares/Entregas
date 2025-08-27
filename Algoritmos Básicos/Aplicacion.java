import clases.Algoritmos;

public class Aplicacion {
    public static void main(String[] args) {
        
        // Prueba esPar
        
        System.out.println(" El 4 es par? " + Algoritmos.esPar(4));
        System.out.println(" El 7 es par? " + Algoritmos.esPar(7));

        // Prueba esPrimo
        System.out.println(" El 5 es primo? " + Algoritmos.esPrimo(5));
        System.out.println(" El 10 es primo? " + Algoritmos.esPrimo(10));

        // Prueba stringEnReversa
        System.out.println(" Reversa de 'hola': " + Algoritmos.stringEnReversa("hola"));
        System.out.println(" Reversa de 'ana': " + Algoritmos.stringEnReversa("ana"));

        // Prueba esPalindromo
        System.out.println(" 'hola' es palíndromo? " + Algoritmos.esPalindromo("hola"));
        System.out.println(" 'ana' es palíndromo? " + Algoritmos.esPalindromo("ana"));

        // Prueba secuenciaFizzBuzz
        System.out.println(" Secuencia FizzBuzz hasta 15:");
        Algoritmos.secuenciaFizzBuzz(15);
    }
}    
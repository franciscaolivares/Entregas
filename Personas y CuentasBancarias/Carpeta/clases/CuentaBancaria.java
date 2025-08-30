package clases;
import java.util.ArrayList;
import java.util.Random;

public class CuentaBancaria {
    private double saldo ;
    private Persona titular;
    private int numeroCuenta;

    private static ArrayList<CuentaBancaria> listaDeCuentasBancarias = new ArrayList<>();

    /*Constructor */
    public CuentaBancaria(double saldo, Persona titular){
        this.saldo = saldo;
        this.titular = titular;
        Random rand = new Random();
        this.numeroCuenta = 100000 + rand.nextInt(900000);
        /* Agrega todo a lista */
        listaDeCuentasBancarias.add(this);
    }

    /*Getters y Setters */
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public Persona getTitular() {
        return titular;
    }
    public void setTitular(Persona titular){
        this.titular = titular;
    }
    public int getNumeroCuenta() {
        return numeroCuenta;
    }
    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    public void depositar(double monto){
        saldo += monto;
    }
    public void retirar(double monto){
        if(monto <= saldo){
            saldo -= monto;
        } else {
            System.out.println("Saldo insuficiente");
        } 
    }
    public void despliegaInformacion (){
        System.out.println("Nombre: " + this.titular.getNombre() + ", Numero de cuenta: " + this.numeroCuenta + ", Saldo: " + this.saldo);
    }

    public static void imprimeInformacionDeTodasLasCuentas(){
        for(CuentaBancaria cuenta : listaDeCuentasBancarias){
            cuenta.despliegaInformacion();
        }
    
    }
}

package clases;
public class Aplicacion {
    public static void main(String[] args) {
        Persona persona1 = new Persona ("Francisca",23);
        Persona persona2 = new Persona ("Juan",30); 
        Persona persona3 = new Persona ("Ana",28);
    
        CuentaBancaria cuenta1 = new CuentaBancaria(1000.0, persona1);
        CuentaBancaria cuenta2 = new CuentaBancaria(500.0, persona2);
        CuentaBancaria cuenta3 = new CuentaBancaria(2000.0, persona3);

        cuenta1.depositar(500.0);
        cuenta1.retirar(200.0);

        cuenta2.depositar(200.0);
        cuenta2.retirar(100.0);

        cuenta3.depositar(1000.0);
        cuenta3.retirar(500.0);

        System.out.println("Nombre: " + cuenta1.getTitular().getNombre() + ", Numero de cuenta: " + cuenta1.getNumeroCuenta() + ", Saldo actual: " + cuenta1.getSaldo());
        System.out.println("Nombre: " + cuenta2.getTitular().getNombre() + ", Numero de cuenta: " + cuenta2.getNumeroCuenta() + ", Saldo actual: " + cuenta2.getSaldo());
        System.out.println("Nombre: " + cuenta3.getTitular().getNombre() + ", Numero de cuenta: " + cuenta3.getNumeroCuenta() + ", Saldo actual: " + cuenta3.getSaldo());

        CuentaBancaria.imprimeInformacionDeTodasLasCuentas();
}
}
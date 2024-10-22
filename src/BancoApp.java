
class cuentaBancaria{
    String titular;
    double saldo;

    public cuentaBancaria(String titular, double saldoInicial ){
        this.titular = titular;
        if (saldoInicial < 0){
            throw new IllegalArgumentException("El Saldo no puede ser inferior a 0");
        }
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void retiro(double cantidad) throws Exception{
        if(cantidad <= 0){
            throw new IllegalArgumentException("El monto a retirar debe ser superior a 0");
        }
        if(saldo < cantidad){
            throw new IllegalArgumentException("Saldo Insuficiente");
        }
        saldo -= cantidad;
        System.out.println("Retiro de: " + cantidad + " Exitoso. \n\tSaldo Restante: " + saldo);
    }

    public void deposito(double cantidad){
        if (cantidad <= 0){
            throw new IllegalArgumentException("El deposito no puede ser negativo");
        }
        saldo += cantidad;
        System.out.println("Deposito de: " + cantidad + " Exitoso. \n\tSaldo actual " + saldo );
    }

    public String getTitular() {
        return titular;
    }
}

//Funcion BancoApp

public class BancoApp{
    public static void main(String[]args){
        try{
            cuentaBancaria cuenta1 = new cuentaBancaria("Juan", 800000);

            System.out.println("Su saldo actual es de: " + cuenta1.saldo);
            cuenta1.deposito(400000);
            cuenta1.retiro(260000);


        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}



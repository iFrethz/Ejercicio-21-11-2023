package Banco;

import java.util.Scanner;

public class CuentaBancaria {

    private String usuario, usuarioTransferencia;
    private int saldo, addsaldo, remsaldo, transsaldo;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String usuario = scanner.nextLine();

        System.out.print("Ingresar saldo inicial: ");
        int saldoInicial = scanner.nextInt();
        scanner.nextLine();

        CuentaBancaria cuenta = new CuentaBancaria(usuario, saldoInicial);
        cuenta.ejecutar();
    }
    
    public CuentaBancaria(String usuario, int saldoInicial) {
        this.usuario = usuario;
        this.saldo = saldoInicial;
    }

    private void addsaldo(Scanner scanner) {
        System.out.print("Ingresa la cantidad a depositar: ");
        addsaldo = scanner.nextInt();
        scanner.nextLine();
        saldo = saldo + addsaldo;
    }

    private void remsaldo(Scanner scanner) {
        System.out.println("Dinero Disponible: " + saldo);
        System.out.print("Ingresa la cantidad a retirar: ");
        remsaldo = scanner.nextInt();
        scanner.nextLine();

        if (remsaldo <= saldo) {
            saldo = saldo - remsaldo;
            System.out.println("El dinero se retiró con éxito");
        } else {
            System.out.println("No tiene suficiente dinero");
        }
    }

    private void transsaldo(Scanner scanner) {
        System.out.println("Dinero Disponible: " + saldo);
        System.out.print("Ingrese usuario a transferir: ");
        usuarioTransferencia = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Ingresa la cantidad a transferir: ");
        transsaldo = scanner.nextInt();
        scanner.nextLine();
        
        if (transsaldo <= saldo) {
            saldo = saldo - transsaldo;
            System.out.println("--------------------------");
            System.out.println("INFORME DE TRANSACCIÓN");
            System.out.println("--------------------------");
            System.out.println("Se ha transferido al usuario: " + usuarioTransferencia);
            System.out.println("Cantidad transferida: " + transsaldo);
            System.out.println("--------------------------");
        }else {
            System.out.println("No tiene suficiente dinero");
        }
    }

    private void informacion() {
        System.out.println("--------------------------");
        System.out.println("    INFORMACIÓN");
        System.out.println("--------------------------");
        System.out.println("Nombre Titular: " + usuario);
        System.out.println("Saldo actual: " + saldo);
        System.out.println("--------------------------");
        System.out.println("Ultimo deposito: " + addsaldo);
        System.out.println("Ultimo retiro: " + remsaldo);
        System.out.println("Ultima transferencia: " + usuarioTransferencia + ", cantidad: " + transsaldo);
        System.out.println("--------------------------");
    }

    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        int opciones;

        do {
            System.out.println("--------------------------");
            System.out.println("        Opciones");
            System.out.println("--------------------------");
            System.out.println("1.- Depositar dinero");
            System.out.println("2.- Retirar dinero");
            System.out.println("3.- Transferir dinero");
            System.out.println("4.- INFORMACIÓN");
            System.out.println("--------------------------");
            opciones = scanner.nextInt();

            switch (opciones) {
                case 1:
                    addsaldo(scanner);
                    break;
                case 2:
                    remsaldo(scanner);
                    break;
                case 3:
                    transsaldo(scanner);
                    break;
                case 4:
                    informacion();
                    break;
                case 5:
                    System.out.println("Vuelva Pronto");
                    break;
                default:
                    System.out.println("ERROR al ingresar, intente de nuevo");
                    break;
            }
        } while (opciones != 5);
    }
}
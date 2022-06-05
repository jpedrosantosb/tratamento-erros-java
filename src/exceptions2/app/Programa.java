package exceptions2.app;

import java.util.Locale;
import java.util.Scanner;

import exceptions2.model.entities.Conta;
import exceptions2.model.exceptions.BusinessException;

public class Programa {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.println("Informe os dados da conta");
    System.out.print("Numero: ");
    int numero = sc.nextInt();
    System.out.print("Titular: ");
    sc.nextLine();
    String titular = sc.nextLine();
    System.out.print("Saldo inicial: ");
    double saldo = sc.nextDouble();
    System.out.print("Limite de saque: ");
    double limiteSaque = sc.nextDouble();

    Conta conta = new Conta(numero, titular, saldo, limiteSaque);

    System.out.println();
    System.out.print("Informe uma quantia para sacar: ");
    double valor = sc.nextDouble();
    
    System.out.println();
    System.out.print("Informe uma quantia para deposito: ");
    double dep = sc.nextDouble();
    conta.deposito(dep);

    try {
      conta.saque(valor);
      System.out.printf("Novo saldo: %.2f%n", conta.getSaldo());
    } catch (BusinessException e) {
      System.out.println(e.getMessage());
    }

    sc.close();
    System.out.println("--FIM--");
  }

}

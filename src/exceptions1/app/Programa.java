package exceptions1.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import exceptions1.model.entities.Reserva;
import exceptions1.model.exceptions.DomainException;

public class Programa {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    try {
        System.out.print("nº do quarto: ");
        int numero = sc.nextInt();
        System.out.print("Data de Check-in (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Data de Check-out (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());
        
        Reserva reserva = new Reserva(numero, checkIn, checkOut);
        System.out.println("Reserva: " + reserva);
        
        System.out.println("Deseja atualizar a reserva? (y/n) ");
        String simOUnao = sc.next();
        
        if(simOUnao.equalsIgnoreCase("y")) {
          System.out.println();
          System.out.println("Insira os dados para atualizar a reserva:");
          System.out.print("Data de Check-in (dd/MM/yyyy): ");
          checkIn = sdf.parse(sc.next());
          System.out.print("Data de Check-out (dd/MM/yyyy): ");
          checkOut = sdf.parse(sc.next());
          
          reserva.updateDates(checkIn, checkOut);
          System.out.println("Reserva: " + reserva);
        }
        
        System.out.println("--FIM--");
        
    }
    catch (ParseException e) {
        System.out.println("Formato de data inválido");
    }
    catch (DomainException e) {
        System.out.println("Erro na reserva: " + e.getMessage());
    }
    catch (RuntimeException e) {
        System.out.println("Erro inesperado");
    }

    sc.close();

  }
}

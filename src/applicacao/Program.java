package applicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;
import model.excecoes.ExcecaoDominio;

public class Program {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Numero do quarto: ");
			int numeroDoQuarto = sc.nextInt();
			System.out.print("Data de check-in (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Data de check-out (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());
	
			Reserva reserva = new Reserva(numeroDoQuarto, checkin, checkout);
			System.out.println(reserva);
			
			System.out.println();
			System.out.println("Digite os dados para atualizar a reserva: ");
			System.out.print("Data de check-in (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Data de check-out (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			
	
			reserva.novaData(checkin, checkout);
		
			System.out.println(reserva);
		}
		catch(ParseException e) {
			System.out.println("Formato de data invalido");
		}
		catch(ExcecaoDominio e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}

		
		sc.close();
	}

}

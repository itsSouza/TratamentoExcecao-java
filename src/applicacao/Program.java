package applicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Numero do quarto: ");
		int numeroDoQuarto = sc.nextInt();
		System.out.print("Data de check-in (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Data de check-out (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkin)) {
			System.out.println("Erro na reserva: data do check-out deve ser depois da data de check-in");
		}
		else {
		
			Reserva reserva = new Reserva(numeroDoQuarto, checkin, checkout);
			System.out.println(reserva);
			
			System.out.println();
			System.out.println("Digite os dados para atualizar a reserva: ");
			System.out.print("Data de check-in (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Data de check-out (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			Date agora = new Date();
			if(checkin.before(agora) || checkout.before(agora)) {
				System.out.println("Erro na reserva: a data de reservas atualizadas devem ser em datas futuras");
			}
			else if(!checkout.after(checkin)) {
				System.out.println("Erro na reserva: data do check-out deve ser depois da data de check-in");
			}
			else {
			
			reserva.novaData(checkin, checkout);
			
			System.out.println(reserva);
			}
			
		}
		
		
		sc.close();
	}

}

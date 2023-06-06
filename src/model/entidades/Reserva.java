package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	private Integer numeroDoQuarto;
	private Date checkin;
	private Date checkout;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
	}


	public Reserva(Integer numeroDoQuarto, Date checkin, Date checkout) {
		this.numeroDoQuarto = numeroDoQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}


	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}


	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}


	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	
	public long Duracao() {
		long dif = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	
	public void novaData(Date checkin, Date checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}

	@Override
	public String toString() {
	return "Reserva: Quarto "
			+ numeroDoQuarto
			+ ", check-in: "
			+ sdf.format(checkin)
			+", check-out: "
			+ sdf.format(checkout)
			+ ", "
			+ Duracao()
			+ " noites ";
	
	}
	
	

}

package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Parcelas;
import model.services.Paypal;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		//List <Parcelas> list = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data");
		System.out.print("Number:  ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy):  ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract Value: ");
		double value = sc.nextDouble();
		System.out.print("Entre com o numero de parcelas:  ");
		int meses = sc.nextInt();
		
		System.out.println();
		System.out.println("Parcelas: ");
		Parcelas parcelas = new Parcelas(date, value, meses, new Paypal());
		parcelas.calculoParcelas(new Paypal(), meses);
	
		sc.close();
	}

}

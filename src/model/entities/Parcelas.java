package model.entities;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import model.services.Paypal;
import model.services.ServicoPagamento;

public class Parcelas {
	
	private Date dueDate;
	private Double amount;
	private Integer parcelas;
	
	private ServicoPagamento servicoPagamento;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	
	public Parcelas(Date dueDate, Double amount, Integer parcelas, ServicoPagamento servicoPagamento) {
		this.dueDate = dueDate;
		this.amount = amount;
		this.parcelas = parcelas;
		this.servicoPagamento = servicoPagamento;
		
	}
	
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public Integer getNumeroP() {
		return parcelas;
	}

	public void setNumeroP(Integer parcelas) {
		this.parcelas = parcelas;
	}
	
	public void calculoParcelas (ServicoPagamento servicoPagamento, int parcelas) {
		double divisoes = getAmount()/parcelas;
		
		for (int i = 1; i <= parcelas; i++) {
			
			Date data = addMonths (getDueDate(), i);
			double firstValor = divisoes + servicoPagamento.ServicoPagamento(divisoes, i);
			double fullValor = firstValor + servicoPagamento.paymentFee(firstValor);
			System.out.println(sdf.format(data) + "---" + fullValor);
		}
		
		
	}

	private Date addMonths(Date data, int i) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MONTH, i);
		return cal.getTime();
	}

	public String toString() {
		return sdf.format(dueDate) + " - " + String.format("%.2f", amount);
	}
	
	
}

package model.services;

public class Paypal implements ServicoPagamento{

	@Override
	public double paymentFee(double amount) {
		return amount * 0.02;
	}

	@Override
	public double ServicoPagamento(double amount, int parcelas) {
		return amount * 0.01 * parcelas;
	}

	
	}

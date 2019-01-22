package model.services;

public interface ServicoPagamento {
	
	double paymentFee (double amount);
	double ServicoPagamento (double amount, int parcelas);
		
	
}

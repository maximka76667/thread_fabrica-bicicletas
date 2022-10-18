package main;

public class Main {

	public static void main(String[] args) {

		Operarios operarios = new Operarios(8, 2, 2, 2, 10, 4);
		OperariosMarcos opearariosMarcos = new OperariosMarcos(operarios);

		Thread tOperariosMarcos = new Thread(opearariosMarcos);
		tOperariosMarcos.start();

		for (int i = 0; i < 2; i++) {
			Thread tOperarioMarcos = new Thread(new OperarioMarcos(operarios, opearariosMarcos));
			tOperarioMarcos.start();
		}

		for (int i = 0; i < 2; i++) {
			Thread tOperarioRuedas = new Thread(new OperarioRuedas(operarios));
			tOperarioRuedas.start();
		}

		for (int i = 0; i < 2; i++) {
			Thread tMontador = new Thread(new Montador(operarios));
			tMontador.start();
		}

	}

}

package main;

public class Main {

	public static void main(String[] args) {

		Operarios operarios = new Operarios(8, 2, 2, 2, 10, 4);

		for (int i = 0; i < 2; i++) {
			Thread tOperarioMarcos = new Thread(new OperarioMarcos(operarios), "OM" + i);
			tOperarioMarcos.start();
		}

		for (int i = 0; i < 2; i++) {
			Thread tOperarioRuedas = new Thread(new OperarioRuedas(operarios), "OR" + i);
			tOperarioRuedas.start();
		}

		for (int i = 0; i < 2; i++) {
			Thread tMontador = new Thread(new Montador(operarios));
			tMontador.start();
		}

	}

}

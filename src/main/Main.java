package main;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		System.out.println("START");

		Operarios operarios = new Operarios(8, 2, 2, 2, 10, 4);
		ArrayList<Thread> threads = new ArrayList<Thread>();

		// Operarios Marcos
		for (int i = 0; i < 2; i++) {
			Thread tOperarioMarcos = new Thread(new OperarioMarcos(operarios), "OpMrcs" + i);
			threads.add(tOperarioMarcos);
			tOperarioMarcos.start();
		}

		// Operarios Ruedas
		for (int i = 0; i < 2; i++) {
			Thread tOperarioRuedas = new Thread(new OperarioRuedas(operarios), "OpRds" + i);
			threads.add(tOperarioRuedas);
			tOperarioRuedas.start();
		}

		// Montadores
		for (int i = 0; i < 2; i++) {
			Thread tMontador = new Thread(new Montador(operarios), "Mntdr" + i);
			threads.add(tMontador);
			tMontador.start();
		}

		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("FINISH");
	}

}

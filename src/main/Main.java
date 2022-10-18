package main;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		// Configuracion

		// Cantidad de bicicletas a producir
		final int numBicicletas = 8;

		// Cantidades de los trabajadores
		final int numOperariosRuedas = 2, numOperariosMarcos = 2, numMostradores = 2;

		// Los volumenes de los almacenes
		final int numRuedasMaximo = 10, numMarcosMaximo = 4;

		// ***Configuracion***

		System.out.println("START");

		// Crear clase con todas las configuraciones
		Operarios operarios = new Operarios(numBicicletas, numOperariosRuedas, numOperariosMarcos, numMostradores,
				numRuedasMaximo, numMarcosMaximo);

		ArrayList<Thread> threads = new ArrayList<Thread>();

		// Operarios Marcos
		for (int i = 0; i < numOperariosMarcos; i++) {
			Thread tOperarioMarcos = new Thread(new OperarioMarcos(operarios), "OM-" + i);
			threads.add(tOperarioMarcos);
			tOperarioMarcos.start();
		}

		// Operarios Ruedas
		for (int i = 0; i < numOperariosRuedas; i++) {
			Thread tOperarioRuedas = new Thread(new OperarioRuedas(operarios), "OR-" + i);
			threads.add(tOperarioRuedas);
			tOperarioRuedas.start();
		}

		// Montadores
		for (int i = 0; i < numMostradores; i++) {
			Thread tMontador = new Thread(new Montador(operarios), "M-" + i);
			threads.add(tMontador);
			tMontador.start();
		}

		for (Thread thread : threads) {
			thread.join();
		}

		System.out.println("FINISH");
	}

}

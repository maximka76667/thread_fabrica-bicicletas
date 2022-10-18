package main;

public class Montador implements Runnable {
	private Operarios operarios;
	private int iteraciones;

	public Montador(Operarios operarios) {
		this.operarios = operarios;
		this.iteraciones = operarios.getNumBicicletas() / operarios.getNumMontadores();
	}

	@Override
	public void run() {
		for (int i = 0; i < iteraciones; i++) {
			try {
				operarios.construirBicicleta();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

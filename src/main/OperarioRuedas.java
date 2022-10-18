package main;

public class OperarioRuedas implements Runnable {
	private Operarios operarios;
	private int iteraciones;

	public OperarioRuedas(Operarios operarios) {
		this.operarios = operarios;
		this.iteraciones = 2 * operarios.getNumBicicletas() / operarios.getNumOperariosRuedas();
	}

	@Override
	public void run() {
		for (int i = 0; i < iteraciones; i++) {
			try {
				operarios.construirRueda();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

package main;

public class OperarioMarcos implements Runnable {

	private Operarios operarios;
	private int iteraciones;

	public OperarioMarcos(Operarios operarios) {
		this.operarios = operarios;
		this.iteraciones = operarios.getNumBicicletas() / 2;
	}

	@Override
	public void run() {
		for (int i = 0; i < iteraciones; i++) {
			try {
				operarios.construirMarco();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

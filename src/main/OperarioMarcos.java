package main;

public class OperarioMarcos implements Runnable {

	private OperariosMarcos operariosMarcos;
	private int iteraciones;
	private boolean isActive;

	public OperarioMarcos(Operarios operarios, OperariosMarcos operariosMarcos) {
		this.operariosMarcos = operariosMarcos;
		this.iteraciones = operarios.getNumBicicletas();
		this.isActive = false;
	}

	@Override
	public void run() {
		for (int i = 0; i < iteraciones; i++) {
			if (!isActive) {
				isActive = true;
				operariosMarcos.activarOperario();
				isActive = false;
			}
		}
	}
}

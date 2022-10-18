package main;

public class OperariosMarcos implements Runnable {

	private Operarios operarios;
	private int iteraciones, numOperariosActivos;

	public OperariosMarcos(Operarios operarios) {
		this.operarios = operarios;
		this.iteraciones = operarios.getNumBicicletas();
	}

	public synchronized void activarOperario() {
		this.numOperariosActivos++;
	}

	public void construirMarco() throws InterruptedException {
//		System.out.println(numOperariosActivos);
//		synchronized (this) {
//			while (numOperariosActivos < 2) {
//				wait();
//			}
//			this.notifyAll();
//		}

		synchronized (operarios) {
			operarios.construirMarco();
			disactivarOperarios();
			operarios.notifyAll();
		}
	}

	public synchronized void disactivarOperarios() {
		numOperariosActivos = 0;
	}

	@Override
	public void run() {
		for (int i = 0; i < iteraciones; i++) {
			try {
				construirMarco();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

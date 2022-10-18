package main;

public class Operario implements Runnable {
	private Operarios operarios;
	private int iteraciones;
	private String objeto;

	public Operario(Operarios operarios, String objeto, int iteraciones) {
		this.operarios = operarios;
		this.objeto = objeto;
		this.iteraciones = iteraciones;
	}

	@Override
	public void run() {
		for (int i = 0; i < iteraciones; i++) {
			try {
				operarios.construir(objeto);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

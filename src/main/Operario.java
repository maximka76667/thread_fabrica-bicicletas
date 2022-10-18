package main;

public class Operario implements Runnable {
	private Operarios operarios;
	private int iteraciones;
	private String detalle;

	public Operario(Operarios operarios, String detalle, int iteraciones) {
		this.operarios = operarios;
		this.detalle = detalle;
		this.iteraciones = iteraciones;
	}

	@Override
	public void run() {
		for (int i = 0; i < iteraciones; i++) {
			try {
				operarios.construirDetalle(detalle);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

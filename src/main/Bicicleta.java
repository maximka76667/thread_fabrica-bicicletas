package main;

import java.util.List;

public class Bicicleta extends Objeto {

	static private int numAuto;

	static {
		numAuto = 1;
	}

	private List<Rueda> ruedas;
	private Marco marco;

	public Bicicleta(List<Rueda> ruedas, Marco marco) {
		super("B" + numAuto++);
		this.ruedas = ruedas;
		this.marco = marco;
	}

	@Override
	public String toString() {
		return getId() + " (rs=" + ruedas + ", m=" + marco + ")";
	}

}

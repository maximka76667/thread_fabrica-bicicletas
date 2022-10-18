package main;

import java.util.List;

public class Bicicleta {

	private List<Rueda> ruedas;
	private Marco marco;

	public Bicicleta(List<Rueda> ruedas, Marco marco) {
		this.ruedas = ruedas;
		this.marco = marco;
	}

	@Override
	public String toString() {
		return "Bicicleta [ruedas=" + ruedas + ", marco=" + marco + "]";
	}

}

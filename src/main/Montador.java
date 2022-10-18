package main;

public class Montador extends Operario {
	public Montador(Operarios operarios) {
		super(operarios, "bicicleta", operarios.getNumBicicletas() / operarios.getNumMontadores());
	}
}

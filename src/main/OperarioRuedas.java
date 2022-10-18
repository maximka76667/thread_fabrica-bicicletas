package main;

public class OperarioRuedas extends Operario {
	public OperarioRuedas(Operarios operarios) {
		super(operarios, "rueda", 2 * operarios.getNumBicicletas() / operarios.getNumOperariosRuedas());
	}

}

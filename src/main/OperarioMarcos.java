package main;

public class OperarioMarcos extends Operario {
	public OperarioMarcos(Operarios operarios) {
		super(operarios, "marco", operarios.getNumBicicletas() / operarios.getNumOperariosMarcos());
	}
}

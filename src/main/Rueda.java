package main;

public class Rueda extends Detalle {
	static private int numAuto;

	static {
		numAuto = 1;
	}

	public Rueda() {
		super("R" + numAuto++);
	}
}

package main;

public class Rueda extends Objeto {
	static private int numAuto;

	static {
		numAuto = 1;
	}

	public Rueda() {
		super("R" + numAuto++);
	}
}

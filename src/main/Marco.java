package main;

public class Marco extends Detalle {

	static private int numAuto;

	static {
		numAuto = 1;
	}

	public Marco() {
		super("M" + numAuto++);
	}

}

package main;

public class Marco extends Objeto {

	static private int numAuto;

	static {
		numAuto = 1;
	}

	public Marco() {
		super("M" + numAuto++);
	}

}

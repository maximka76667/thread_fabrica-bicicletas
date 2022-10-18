package main;

public class Rueda {

	static private int numAuto;

	static {
		numAuto = 1;
	}

	private String id;

	public Rueda() {
		this.id = "R" + Rueda.numAuto;
		Rueda.numAuto++;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id;
	}

}

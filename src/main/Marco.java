package main;

public class Marco {

	static private int numAuto;

	static {
		numAuto = 1;
	}

	private String id;

	public Marco() {
		this.id = "M" + Marco.numAuto;
		Marco.numAuto++;
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

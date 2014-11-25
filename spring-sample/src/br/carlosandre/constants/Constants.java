package br.carlosandre.constants;

public enum Constants {
	BREAK_LINE(System.getProperty("line.separator"));

	String value;

	private Constants(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}

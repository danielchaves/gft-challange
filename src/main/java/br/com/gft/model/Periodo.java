package br.com.gft.model;

public enum Periodo {

	MANHA("Manhã"),
	NOITE("Noite");
	
	private Periodo(String periodo) {
		this.periodo = periodo;
	}
	
	private String periodo;
	
	public String getPeriodo() {
		return this.periodo;
	}
}

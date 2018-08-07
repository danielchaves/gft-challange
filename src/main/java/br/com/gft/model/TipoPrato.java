package br.com.gft.model;

public enum TipoPrato {
	
	ENTRADA(1),
	ACOMPANHAMENTO(2),
	BEBIDA(3),
	SOBREMESA(4);
	
	private TipoPrato(Integer codigo) {
		this.codigo = codigo;
	}
	
	private Integer codigo;
	
	public Integer getCodigo() {
		return this.codigo;
	}

	public static TipoPrato getByCodigo(int i) {
		for (TipoPrato tp : values()) {
			if(tp.getCodigo() == i) {
				return tp;
			}
		}
		return null;
	}

}

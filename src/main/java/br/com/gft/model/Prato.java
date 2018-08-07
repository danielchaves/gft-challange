package br.com.gft.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Prato {

	@Id
	@GeneratedValue
	Long id;
	
	@Version
	Integer version;
	
	
	String nome;
	
	@Enumerated(EnumType.ORDINAL)
	TipoPrato tipoPrato;
	
	@Enumerated(EnumType.STRING)
	Periodo periodo;
	
	Boolean podeRepetir;
	
	public Prato() {}

	public Prato(String nome, TipoPrato tipoPrato, Periodo periodo, boolean podeRepetir) {
		this.nome = nome;
		this.tipoPrato = tipoPrato;
		this.periodo = periodo;
		this.podeRepetir = podeRepetir;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoPrato getTipoPrato() {
		return tipoPrato;
	}

	public void setTipoPrato(TipoPrato tipoPrato) {
		this.tipoPrato = tipoPrato;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public Boolean getPodeRepetir() {
		return podeRepetir;
	}

	public void setPodeRepetir(Boolean podeRepetir) {
		this.podeRepetir = podeRepetir;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prato other = (Prato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

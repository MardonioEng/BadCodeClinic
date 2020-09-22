package br.com.ifce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.ifce.model.enums.TipoColeta;

@Entity
@Table(name = "tb_coleta")
public class Coleta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String coletor;
	@Column(name = "tipo_coleta")
	private TipoColeta tipoColeta;

	@OneToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;

	public Coleta() {
	}

	public Coleta(Long id, String coletor, TipoColeta tipoColeta, Paciente paciente) {
		this.id = id;
		this.coletor = coletor;
		this.tipoColeta = tipoColeta;
		this.paciente = paciente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getColetor() {
		return coletor;
	}

	public void setColetor(String coletor) {
		this.coletor = coletor;
	}

	public TipoColeta getTipoColeta() {
		return tipoColeta;
	}

	public void setTipoColeta(TipoColeta tipoColeta) {
		this.tipoColeta = tipoColeta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}

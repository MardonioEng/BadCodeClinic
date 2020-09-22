package br.com.ifce.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.ifce.model.enums.Conclusao;

@Entity
@Table(name = "tb_exame")
public class Exame {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate data;
	@Column(name = "tipo_resultado")
	private Conclusao tipoResultado;

	@OneToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	
	@OneToOne
	@JoinColumn(name = "responsavel_tecnico_id")
	private Usuario responsavelTecnico;

	public Exame() {
	}

	public Exame(Long id, LocalDate data, Conclusao tipoResultado, Paciente paciente, Usuario responsavelTecnico) {
		this.id = id;
		this.data = data;
		this.tipoResultado = tipoResultado;
		this.paciente = paciente;
		this.responsavelTecnico = responsavelTecnico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Conclusao getTipoResultado() {
		return tipoResultado;
	}

	public void setTipoResultado(Conclusao tipoResultado) {
		this.tipoResultado = tipoResultado;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Usuario getResponsavelTecnico() {
		return responsavelTecnico;
	}

	public void setResponsavelTecnico(Usuario responsavelTecnico) {
		this.responsavelTecnico = responsavelTecnico;
	}

}

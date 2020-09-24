package br.com.ifce.model.util;

import java.time.LocalDate;

import br.com.ifce.model.enums.TipoColeta;

public class PacienteTabela {

	private Long id;
	private String nome;
	private Long cpf;
	private LocalDate dataNascimento;
	private TipoColeta tipoColeta;
	
	public PacienteTabela(Long id, String nome, Long cpf, LocalDate dataNascimento, TipoColeta tipoColeta) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.tipoColeta = tipoColeta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public TipoColeta getTipoColeta() {
		return tipoColeta;
	}

	public void setTipoColeta(TipoColeta tipoColeta) {
		this.tipoColeta = tipoColeta;
	}

	@Override
	public String toString() {
		return "PacienteTabela [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento
				+ ", tipoColeta=" + tipoColeta + "]";
	}
	
}

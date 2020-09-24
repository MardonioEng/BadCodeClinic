package br.com.ifce.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Long cpf;
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	private String cidade;
	private String estado;
	private String rua;
	private String cep;
	private String numero;
	private String bairro;
	private String complemento;
	private String comorbidade;

	@OneToOne(mappedBy = "paciente")
	private Coleta coleta;
	@OneToOne(mappedBy = "paciente")
	private Exame exame;

	public Paciente() {
	}

	public Paciente(Long id, String nome, Long cpf, LocalDate dataNascimento, String cidade, String estado, String rua,
			String cep, String numero, String bairro, String complemento, String comorbidade) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.cidade = cidade;
		this.estado = estado;
		this.rua = rua;
		this.cep = cep;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.comorbidade = comorbidade;
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComorbidade() {
		return comorbidade;
	}

	public void setComorbidade(String comorbidade) {
		this.comorbidade = comorbidade;
	}

	public Coleta getColeta() {
		return coleta;
	}

	public void setColeta(Coleta coleta) {
		this.coleta = coleta;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}

package br.com.ifce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_laboratorio")
public class Laboratorio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Column(name = "numero_testes")
	private Integer numeroTestes;

	@OneToMany(mappedBy = "laboratorio")
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	public Laboratorio() {
	}

	public Laboratorio(Long id, String nome, Integer numeroTestes) {
		this.id = id;
		this.nome = nome;
		this.numeroTestes = numeroTestes;
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

	public Integer getNumeroTestes() {
		return numeroTestes;
	}

	public void setNumeroTestes(Integer numeroTestes) {
		this.numeroTestes = numeroTestes;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}

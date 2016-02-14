package br.com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe que representa um Contato da Agenda.
 * 
 * @author Vladwoguer Bezerra
 *
 */
@Entity 
@Table(name="TB_CONTATO")
public class Contato {
	@Column(name="ID")
	@Id
	@GeneratedValue
    Long id;
	
	@Column(name="NOME")
    String nome;
	
	@Column(name="TELEFONE")
	String telefone;
	
	private Contato() {}; // O hibernate necessita de um contrutor vazio mesmo que privado
	
	public Contato(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
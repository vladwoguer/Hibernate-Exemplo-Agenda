package br.com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;

import br.com.bean.Contato;
import br.com.dao.ContatoDAO;

/**
 * Classe que representa a Agenda de Contatos.
 * 
 * @author Vladwoguer Bezerra
 *
 */
public class AgendaContatos {
	ContatoDAO contatoDAO = new ContatoDAO();

	/**
	 * Metodo para salvar um novo contato.
	 * 
	 * @param nome
	 *            Nome do contato
	 * @param telefone
	 *            Telefone do contato
	 * @return true se conseguir salvar o contato
	 */
	public boolean salvaNovoContato(String nome, String telefone) {
		if (nome != null && ("").equals(nome) == false && telefone != null && ("").equals(telefone) == false) {
			try {
				contatoDAO.salvar(new Contato(nome, telefone));
			} catch (HibernateException he) {
				return false;
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo para salvar a edicao de um contato.
	 * 
	 * @param contato
	 *            Contato editado
	 * @return true se conseguir salvar o contato
	 */
	public boolean editarContato(Contato contato) {
		if (contato.getNome() != null && ("").equals(contato.getNome()) == false && contato.getTelefone() != null
				&& ("").equals(contato.getTelefone()) == false) {
			try {
				contatoDAO.salvar(contato);
			} catch (HibernateException he) {
				return false;
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo para deletar um contato.
	 * 
	 * @param contato
	 *            Contato a ser deletado
	 * @return true se conseguir deletar o contato
	 */
	public boolean deletarContato(Contato contato) {
		try {
			contatoDAO.deletar(contato);
		} catch (HibernateException he) {
			return false;
		}
		return true;
	}

	/**
	 * Lista todos os contatos.
	 */
	public List<Contato> listarContatos() {
		try {
			if (contatoDAO.listar() != null) {
				return contatoDAO.listar();
			} else {
				return new ArrayList<Contato>();
			}
		} catch (HibernateException he) {
			return new ArrayList<Contato>();
		}
	}
}

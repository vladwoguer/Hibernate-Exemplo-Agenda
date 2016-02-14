package br.com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import br.com.bean.Contato;

/**
 * DAO - Data Access Object de Contato.
 * 
 * @author Vladwoguer Bezerra
 *
 */
public class ContatoDAO extends SessionMannager {

	public ContatoDAO() {
	};

	/**
	 * Metodo para salvar um novo contato.
	 * 
	 * @param contato
	 *            Contato a ser salvo
	 * @return true se for salva, false se houve um erro
	 * @throws HibernateException 
	 * 				Se houve um erro ao persistir.
	 */
	public void salvar(Contato contato) throws HibernateException {
		begin(); // Inicia a transação
		try {
			getSession().persist(contato); // Tenta salvar o contato
			commit(); // Salvo com sucesso
		} catch (HibernateException e) {
			rollback(); // Houve um erro
			System.out.println(e.getMessage());
			throw e;
		}
	}

	/**
	 * Metodo para deletar um contato.
	 * 
	 * @param contato
	 * 			Contato a ser deletado
	 */
	public void deletar(Contato contato) {
		begin(); // Inicia a transação
		getSession().delete(contato); // Tenta deletar o contato
		try {
			commit(); // Deletado com sucesso
		} catch (HibernateException e) {
			rollback(); // Houve um erro
			throw e;
		}
	}

	/**
	 * Lista todos os contatos.
	 */
	public List<Contato> listar() {
		Query query = getSession().createQuery("from Contato order by nome");
		List<Contato> lista = query.list();
		return lista;
	}
}
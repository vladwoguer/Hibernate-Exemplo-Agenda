package br.com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Manipulador de sessão e transações.
 * 
 * @author Vladwoguer Bezerra
 *
 */
public class SessionMannager {
	private static final ThreadLocal<Session> threadlocal = new ThreadLocal<Session>();
	private static final SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

	public SessionMannager() {};

	/**
	 * Retorna a sessão. Se está não existir a cria e depois retorna.
	 */
	public static Session getSession() {
		Session session = (Session) threadlocal.get();

		if (session == null) {
			session = sessionfactory.openSession();
			threadlocal.set(session);
		}
		return session;
	}

    /**
     * Inicia uma nova Transação.
     */
	public void begin() {
		getSession().beginTransaction();

	}

	/**
	 * Commita a transação.(Encerra com sucesso, as mudanças ocorridas na transação vão pro banco)
	 */
	public void commit() {
		getSession().getTransaction().commit();
	}

	/**
	 * Dá rollback na transação. (Encerra impedindo que as mudanças vão pro banco)
	 */
	public void rollback() {
		getSession().getTransaction().rollback();
	}

	/**
	 * Encerra a sessão.
	 */
	public static void close() {
		getSession().clear();
		threadlocal.set(null);
	}
}
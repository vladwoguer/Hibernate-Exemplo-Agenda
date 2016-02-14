package br.com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Manipulador de sess�o e transa��es.
 * 
 * @author Vladwoguer Bezerra
 *
 */
public class SessionMannager {
	private static final ThreadLocal<Session> threadlocal = new ThreadLocal<Session>();
	private static final SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

	public SessionMannager() {};

	/**
	 * Retorna a sess�o. Se est� n�o existir a cria e depois retorna.
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
     * Inicia uma nova Transa��o.
     */
	public void begin() {
		getSession().beginTransaction();

	}

	/**
	 * Commita a transa��o.(Encerra com sucesso, as mudan�as ocorridas na transa��o v�o pro banco)
	 */
	public void commit() {
		getSession().getTransaction().commit();
	}

	/**
	 * D� rollback na transa��o. (Encerra impedindo que as mudan�as v�o pro banco)
	 */
	public void rollback() {
		getSession().getTransaction().rollback();
	}

	/**
	 * Encerra a sess�o.
	 */
	public static void close() {
		getSession().clear();
		threadlocal.set(null);
	}
}
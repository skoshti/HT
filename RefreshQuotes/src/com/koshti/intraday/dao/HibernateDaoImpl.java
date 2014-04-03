package com.koshti.intraday.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koshti.intraday.model.Quote;

@Repository
public class HibernateDaoImpl {
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Quote> getAllQuotes() {
		String hql = "from Quote";
		Query query = getSessionFactory().openSession().createQuery(hql);
		return (List<Quote>) query.list();			
	}

	public Long getCountOfQuotes() {
		String hql = "Select count(q.ticker) from Quote q";
		Query query = getSessionFactory().openSession().createQuery(hql);
		return (Long) query.uniqueResult(); 
	}
	
	public void updateQuote(Quote quote) {
		String hql = "update Quote set open=:open, " +
				"minimum=:minimum, " +
 				"maximum=:maximum, " +
				"close=:close, " +
				"last=:last " +
				"where ticker=:ticker";
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		
		query.setParameter("open", quote.getOpen());
		query.setParameter("minimum", quote.getMinimum());
		query.setParameter("maximum", quote.getMaximum());
		query.setParameter("close", quote.getClose());
		query.setParameter("last", quote.getLast());
		query.setParameter("ticker", quote.getTicker());
		query.executeUpdate();
		
		session.close();
		
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
}

package com.koshti.intraday.dao;

import java.util.List;

import org.hibernate.Query;
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
	
	public int updateQuote(Quote quote) {
		String hql = "update com.koshti.intraday.model.Quote q set q.open=:open, q.min=:min, q.max=:max, q.close=:close, q.last=:last" +
				"where q.ticker = :ticker";
		Query query = getSessionFactory().openSession().createQuery(hql);
		
		query.setParameter("open", quote.getOpen());
		query.setParameter("min", quote.getMin());
		query.setParameter("max", quote.getMax());
		query.setParameter("close", quote.getClose());
		query.setParameter("last", quote.getLast());
		query.setParameter("ticker", quote.getTicker());
		
		return (query.executeUpdate());
		
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
}

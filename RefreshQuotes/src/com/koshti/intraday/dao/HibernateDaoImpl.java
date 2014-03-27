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

	public Quote getQuote(String ticker) {
		String hql = "SELECT * FROM Quotes where ticker = ?";
		Query query = getSessionFactory().openSession().createQuery(hql);
		return (Quote) query.uniqueResult();
				
	}
/*
	public List<Quote> getAllQuotes() {
		String sql = "SELECT * FROM Quotes";
	}
*/
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

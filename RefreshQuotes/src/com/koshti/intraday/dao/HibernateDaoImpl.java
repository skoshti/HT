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
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
}

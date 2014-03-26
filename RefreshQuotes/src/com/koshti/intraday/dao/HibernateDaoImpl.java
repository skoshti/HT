package com.koshti.intraday.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.koshti.intraday.model.Quote;

public class HibernateDaoImpl {
	
	private SessionFactory sessionFactory;

	public Quote getQuote(String ticker) {

		String sql = "SELECT * FROM Quotes where ticker = ?";
				
	}

	public List<Quote> getAllQuotes() {
		String sql = "SELECT * FROM Quotes";
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

package com.koshti.intraday;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.koshti.intraday.dao.HibernateDaoImpl;
import com.koshti.intraday.dao.JdbcDaoImpl;
import com.koshti.intraday.model.Quote;

import net.restfulwebservices.datacontracts._2008._01.StockQuote;
import net.restfulwebservices.servicecontracts._2008._01.IStockQuoteService;
import net.restfulwebservices.servicecontracts._2008._01.IStockQuoteServiceGetStockQuoteDefaultFaultContractFaultFaultMessage;
import net.restfulwebservices.servicecontracts._2008._01.StockQuoteService;

public class RefreshQuotes {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao1 = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		HibernateDaoImpl dao = context.getBean("hibernateDaoImpl", HibernateDaoImpl.class);
		
//		Long count = dao.getCountOfQuotes();
//		System.out.println(count);

		Iterator<Quote> iterator = dao.getAllQuotes().iterator();
		
		while (iterator.hasNext()) {
			Quote quote = iterator.next();
			String symbol = quote.getTicker();
			StockQuoteService stockQuoteService = new StockQuoteService();
			IStockQuoteService iStockQuoteService = stockQuoteService.getBasicHttpBindingIStockQuoteService();
			try {
				StockQuote stockQuote = iStockQuoteService.getStockQuote(symbol);
				System.out.println(stockQuote.getOpen().getValue());
				quote.setOpen(Double.parseDouble(stockQuote.getOpen().getValue()));
				quote.setMinimum(Double.parseDouble(stockQuote.getLow().getValue()));
				quote.setMaximum(Double.parseDouble(stockQuote.getHigh().getValue()));
				quote.setClose(Double.parseDouble(stockQuote.getPreviousClose().getValue()));
				quote.setLast(Double.parseDouble(stockQuote.getLast().getValue()));
				
				int i = dao.updateQuote(quote);
				
			}
			catch (IStockQuoteServiceGetStockQuoteDefaultFaultContractFaultFaultMessage e) {
				System.out.println("Web service error");
			}
		}
	}
}
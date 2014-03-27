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
		HibernateDaoImpl dao = context.getBean("hibernateDaoImpl", HibernateDaoImpl.class);
		
		Quote quote = dao.getQuote("AAPL");
		System.out.println(quote.getLast());
		
/*		List<Quote> quotes = dao.getAllQuotes();
		
		Iterator<Quote> iterator = quotes.iterator();
		while (iterator.hasNext()) {
			String symbol = iterator.next().getTicker();
			StockQuoteService stockQuoteService = new StockQuoteService();
			IStockQuoteService iStockQuoteService = stockQuoteService.getBasicHttpBindingIStockQuoteService();
			try {
				StockQuote stockQuote = iStockQuoteService.getStockQuote(symbol);
				String lastPrice = stockQuote.getLast().getValue();
				System.out.println(lastPrice);
			}
			catch (IStockQuoteServiceGetStockQuoteDefaultFaultContractFaultFaultMessage e) {
				System.out.println("Web service error");
			}
		}*/
	}
}
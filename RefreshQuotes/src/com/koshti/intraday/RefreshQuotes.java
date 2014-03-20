package com.koshti.intraday;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.koshti.intraday.dao.JdbcDaoImpl;
import com.koshti.intraday.model.Quote;

import net.restfulwebservices.datacontracts._2008._01.StockQuote;
import net.restfulwebservices.servicecontracts._2008._01.IStockQuoteService;
import net.restfulwebservices.servicecontracts._2008._01.IStockQuoteServiceGetStockQuoteDefaultFaultContractFaultFaultMessage;
import net.restfulwebservices.servicecontracts._2008._01.StockQuoteService;

public class RefreshQuotes {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		
		Quote quote = dao.getQuote(args[0]);
		
		System.out.println(quote.getTicker());
		
		if (args.length != 1) {
			System.out.println("You need to pass in the Ticker Symbol");
		}
		else {
			String symbol = args[0];
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
			
		}
	}

}

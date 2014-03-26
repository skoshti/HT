package com.koshti.intraday.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.koshti.intraday.model.Quote;

@Component
public class JdbcDaoImpl extends JdbcDaoSupport {

	public Quote getQuote(String ticker) {

		String sql = "SELECT * FROM Quotes where ticker = ?";
		return this.getJdbcTemplate().queryForObject(sql, new Object[] {ticker}, new QuoteMapper());
				
	}

	public List<Quote> getAllQuotes() {
		String sql = "SELECT * FROM Quotes";
		return this.getJdbcTemplate().query(sql, new QuoteMapper());
	}

	private static final class QuoteMapper implements RowMapper<Quote> {

		@Override
		public Quote mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Quote quote = new Quote();
			quote.setTicker(resultSet.getString("ticker"));
			quote.setOpen(resultSet.getDouble("open"));
			quote.setOpen(resultSet.getDouble("min"));
			quote.setOpen(resultSet.getDouble("max"));
			quote.setOpen(resultSet.getDouble("close"));
			quote.setOpen(resultSet.getDouble("last"));
			return quote;
		}
		
	}
}
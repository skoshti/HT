package com.koshti.intraday.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.koshti.intraday.model.Quote;

@Component
public class JdbcDaoImpl {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	public Quote getQuote(String ticker) {

		String sql = "SELECT * FROM Quotes where ticker = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {ticker}, new QuoteMapper());
				
	}

	@Autowired
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	public DataSource getDataSource() {
		return dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
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
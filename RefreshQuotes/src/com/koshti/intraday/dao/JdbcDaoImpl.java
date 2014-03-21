package com.koshti.intraday.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.koshti.intraday.model.Quote;

@Component
public class JdbcDaoImpl {

	@Autowired	
	private DataSource dataSource;
	
	public Quote getQuote(String ticker) {
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Quotes where Ticker = ?");
			ps.setString(1, ticker);
			Quote quote = null;
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				quote = new Quote(rs.getString("ticker"), rs.getDouble("open"), rs.getDouble("min"), rs.getDouble("max"), rs.getDouble("close"), rs.getDouble("last"));
			}
			
			rs.close();
			ps.close();
		
			return quote;
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
	}
	public DataSource getDataSource() {
		return dataSource;
	}

}
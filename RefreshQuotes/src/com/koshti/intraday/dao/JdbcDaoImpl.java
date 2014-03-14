package com.koshti.intraday.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.koshti.intraday.model.Quote;

@Component
public class JdbcDaoImpl {

	public Quote getQuote(String ticker) {
		Connection conn = null;

		String url = "jdbc:postgresql://localhost:5432/postgres";		

		try {
			conn = DriverManager.getConnection(url, "postgres", "tuesday2");
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
}
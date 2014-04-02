package com.koshti.intraday.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quotes")
public class Quote {
	@Id
	private String ticker;
	private double open;
	@Column(name="min")
	private double minimum;
	@Column(name="max")
	private double maximum;
	private double close;
	private double last;
	
	@Id
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getMinimum() {
		return minimum;
	}
	public void setMinimum(double minimum) {
		this.minimum = minimum;
	}
	public double getMaximum() {
		return maximum;
	}
	public void setMaximum(double max) {
		this.maximum = max;
	}
	public double getLast() {
		return last;
	}
	public void setLast(double last) {
		this.last = last;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public Quote(String ticker, double open, double minimum, double maximum, double close, double last) {
		setTicker(ticker);
		setOpen(open);
		setMinimum(minimum);
		setMaximum(maximum);
		setClose(close);
		setLast(last);
	}
	public Quote() {

	}
}


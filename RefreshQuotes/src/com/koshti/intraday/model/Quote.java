package com.koshti.intraday.model;

public class Quote {
	private String ticker;
	private double open;
	private double min;
	private double max;
	private double close;
	private double last;
	
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
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
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
	public Quote(String ticker, double open, double min, double max, double close, double last) {
		setTicker(ticker);
		setOpen(open);
		setMin(min);
		setMax(max);
		setClose(close);
		setLast(last);
	}
	public Quote() {

	}
}


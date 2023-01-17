package com.smartshop.registerationandlogin.exception;

public class StockNotAvailableException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StockNotAvailableException(String msg)
	{
		super(msg);
	}
}

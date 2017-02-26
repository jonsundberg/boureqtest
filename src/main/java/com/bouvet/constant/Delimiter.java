package com.bouvet.constant;

public enum Delimiter {

	SPACE(" ");
	
	private String delimiter;

	Delimiter(String delimiter){
		this.delimiter = delimiter;
	}

	public String[] split(String s, int limit) {
		return s.split(delimiter, limit);
	}
	
	public String[] split(String s) {
		return s.split(delimiter);
	}
	
	public String getDelimiter() {
		return delimiter;
	}
	
	
	
	
	
	
}

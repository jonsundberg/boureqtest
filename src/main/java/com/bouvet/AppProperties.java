package com.bouvet;

public class AppProperties {

	private static AppProperties instance = null;
	
	private String bouvetUrl;

	public static void init(String bouvetUrl) {
		final AppProperties instance = getInstance();
		instance.bouvetUrl = bouvetUrl;
	}

	public static AppProperties getInstance() {
		if (instance == null) {
			instance = new AppProperties();
		}
		return instance;
	}

	public String getBouvetUrl() {
		return bouvetUrl;
	}


}

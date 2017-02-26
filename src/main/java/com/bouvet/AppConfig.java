package com.bouvet;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class AppConfig extends Configuration {
    
    private String bouvetUrl;
    
    private String defaultName = "App..";



    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }

	public String getBouvetUrl() {
		return bouvetUrl;
	}

	public void setBouvetUrl(String bouvetUrl) {
		this.bouvetUrl = bouvetUrl;
	}

}

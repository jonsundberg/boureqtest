package com.bouvet;

import com.bouvet.resources.ImageResource;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<AppConfig> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public String getName() {
        return "bouvet-test";
    }

    @Override
    public void initialize(Bootstrap<AppConfig> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets","/", "index.html"));
    }

    @Override
    public void run(AppConfig configuration, Environment environment) throws Exception {
    	AppProperties.init(configuration.getBouvetUrl());
        registerResources(configuration, environment);
    }

    private void registerResources(AppConfig configuration, Environment environment) {
    	final ImageResource imageResource = new ImageResource();
        environment.jersey().setUrlPattern("/api/*");
        environment.jersey().register(imageResource);
    }

}
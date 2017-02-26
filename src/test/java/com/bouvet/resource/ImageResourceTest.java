package com.bouvet.resource;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;

import com.bouvet.App;
import com.bouvet.AppConfig;
import com.bouvet.util.UrlUtil;

import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;

public class ImageResourceTest {

	
	@Rule
    public final DropwizardAppRule<AppConfig> RULE =
        new DropwizardAppRule<AppConfig>(App.class,
            ResourceHelpers.resourceFilePath("theapp.yml"));
	
	
	@Test
	public void bouvetUrlIsNotNull(){
		assertThat(RULE.getConfiguration().getBouvetUrl()).isNotEmpty();
	}

	@Test
	public void bouvetReqruitmentTestServerIsReachable(){
		assertThat(UrlUtil.isStatusOk(RULE.getConfiguration().getBouvetUrl())).isTrue();
	}
	
	
	
}

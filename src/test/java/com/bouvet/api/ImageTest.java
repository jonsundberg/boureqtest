package com.bouvet.api;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import io.dropwizard.testing.FixtureHelpers;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.jackson.Jackson;

public class ImageTest {

	
	private static final ObjectMapper MAPPER = Jackson.newObjectMapper();
	
    @Test
    public void deserializesFromJSON() throws Exception {
        final Image image = new Image("http://www.test.com/test.png", "Test comment");
        image.setValid(true);
        assertThat(MAPPER.readValue(FixtureHelpers.fixture("fixtures/image.json"), Image.class))
                .isEqualTo(image);
    }
	
	
}

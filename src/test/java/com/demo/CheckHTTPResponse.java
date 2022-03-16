package com.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class CheckHTTPResponse{
	@LocalServerPort
	private int port = 8080;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void shouldPassIfStringMatches() throws Exception {
		assertThat(restTemplate.getForObject("http://localhost:" + port + "/",
				String.class)).contains("Hello World from Spring Boot");
		}
}

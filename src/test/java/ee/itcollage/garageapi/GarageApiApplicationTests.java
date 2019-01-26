package ee.itcollage.garageapi;

import ee.itcollage.garageapi.controller.GreetingController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GarageApiApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void application_greets_with_greeting_world() {
		ResponseEntity<GreetingController.Greeting> entity = restTemplate.getForEntity("/greeting", GreetingController.Greeting.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		GreetingController.Greeting greeting = entity.getBody();
		assertNotNull(greeting);
		assertEquals("greeting World", greeting.getName());
	}

	@Test
	public void application_greets_with_custom_greeting_if_provided() {
		ResponseEntity<GreetingController.Greeting> entity = restTemplate.getForEntity("/greeting?name=Joseph", GreetingController.Greeting.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		GreetingController.Greeting greeting = entity.getBody();
		assertNotNull(greeting);
		assertEquals("greeting Joseph", greeting.getName());
	}

}


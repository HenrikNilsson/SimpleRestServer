package se.henrik.restserver.integrationtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import se.henrik.restserver.api.v1.ApiPath;
import se.henrik.restserver.api.v1.model.Car;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RandomCarIntegrationTest {
	private static final String RANDOM_CAR_PATH = ApiPath.CAR_BASE + ApiPath.PATH_RANDOM;
	private static final String TESLA_CAR_PATH = ApiPath.CAR_BASE + ApiPath.PATH_RANDOM + "?manufacturer=Tesla";

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testGetAllCars() {
		ResponseEntity<Car[]> response = restTemplate.getForEntity(ApiPath.CAR_BASE, Car[].class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		Car[] cars = response.getBody();
		assertNotNull(cars);
		assertThat(cars.length, is(4));
		assertThat(cars[0].manufacturer(), is("Tesla"));
		assertThat(cars[1].manufacturer(), is("BMW"));
	}

	@Test
	void testGetRandomCar() {
		ResponseEntity<Car> response = restTemplate.getForEntity(RANDOM_CAR_PATH, Car.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		Car randomCar = response.getBody();
		assertNotNull(randomCar);
		assertThat(randomCar.manufacturer(), anyOf(is("Tesla"), is("BMW"), is("Audi"), is("Volvo")));
	}

	@Test
	void testGetRandomCarByManufacturer() {
		ResponseEntity<Car> response = restTemplate.getForEntity(TESLA_CAR_PATH, Car.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		Car randomCar = response.getBody();
		assertNotNull(randomCar);
		assertEquals("Tesla", randomCar.manufacturer());
	}
}
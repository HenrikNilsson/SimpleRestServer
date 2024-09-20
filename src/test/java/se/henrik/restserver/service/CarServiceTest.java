package se.henrik.restserver.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.henrik.restserver.db.domain.CarEntity;
import se.henrik.restserver.db.repository.CarRepository;
import se.henrik.restserver.exception.CarNotFoundException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {
	@Mock
	private CarRepository carRepository;

	@InjectMocks
	private CarService carService;

	@Test
	void testGetAllCars_shouldReturnListOfCars() {
		List<CarEntity> mockCars = Arrays.asList(new CarEntity("Tesla", "Model S", 2022), new CarEntity("BMW", "i8", 2020));
		when(carRepository.findAll()).thenReturn(mockCars);

		List<CarEntity> allCars = carService.getAllCars();
		assertEquals(2, allCars.size());
		verify(carRepository, times(1)).findAll();
	}

	@Test
	void testGetRandomCar_shouldReturnRandomCar() {
		List<CarEntity> mockCars = Arrays.asList(new CarEntity("Tesla", "Model S", 2022), new CarEntity("BMW", "i8", 2020));
		when(carRepository.findAll()).thenReturn(mockCars);

		CarEntity randomCar = carService.getRandomCar();
		assertNotNull(randomCar);
		assertTrue(mockCars.contains(randomCar));
		verify(carRepository, times(1)).findAll();
	}

	@Test
	void testGetRandomCarByManufacturer_shouldReturnRandomCarByManufacturer() {
		String manufacturer = "Tesla";
		List<CarEntity> teslaCars = Collections.singletonList(new CarEntity(manufacturer, "Model S", 2022));
		when(carRepository.findByManufacturerIgnoreCase(manufacturer)).thenReturn(teslaCars);

		CarEntity randomCar = carService.getRandomCar(manufacturer);
		assertNotNull(randomCar);
		assertEquals(manufacturer, randomCar.getManufacturer());
		verify(carRepository, times(1)).findByManufacturerIgnoreCase(manufacturer);
	}

	@Test
	void testGetRandomCarByManufacturer_shouldThrowExceptionWhenNoCarsFound() {
		String manufacturer = "Unknown";
		when(carRepository.findByManufacturerIgnoreCase(manufacturer)).thenReturn(Collections.emptyList());

		assertThrows(CarNotFoundException.class, () -> carService.getRandomCar(manufacturer));
		verify(carRepository, times(1)).findByManufacturerIgnoreCase(manufacturer);
	}
}
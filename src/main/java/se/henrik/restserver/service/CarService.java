package se.henrik.restserver.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import se.henrik.restserver.db.domain.CarEntity;
import se.henrik.restserver.db.repository.CarRepository;
import se.henrik.restserver.exception.CarNotFoundException;

import java.util.List;
import java.util.Random;

/**
 * Car Service class to be used to provide service related to Cars in DB
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CarService {
	private final CarRepository carRepository;

	public List<CarEntity> getAllCars() {
		return carRepository.findAll();
	}

	public CarEntity getRandomCar() {
		List<CarEntity> carList = carRepository.findAll();
		Random random = new Random();
		return carList.get(random.nextInt(carList.size()));
	}

	public CarEntity getRandomCar(String manufacturer) {
		List<CarEntity> carList = carRepository.findByManufacturerIgnoreCase(manufacturer);
		throwIfCarWasNotFound(manufacturer, carList);
		return carList.get(new Random().nextInt(carList.size()));
	}

	private static void throwIfCarWasNotFound(String manufacturer, List<CarEntity> carList) {
		if (carList.isEmpty()) {
			throw new CarNotFoundException(manufacturer);
		}
	}
}

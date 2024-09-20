package se.henrik.restserver.api.v1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.henrik.restserver.api.v1.model.Car;
import se.henrik.restserver.db.domain.CarEntity;
import se.henrik.restserver.service.CarService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A simple Rest Controller class responsible for the /car API
 */
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping(ApiPath.CAR_BASE)
class RandomCarRestController {
	private final CarService carService;

	@GetMapping
	List<Car> getAllCars() {
		List<CarEntity> allCars = carService.getAllCars();
		return allCars.stream().map(carEntity -> new Car(carEntity.getManufacturer(), carEntity.getModel(), carEntity.getYear())).collect(Collectors.toList());
	}

	@GetMapping(ApiPath.PATH_RANDOM)
	Car getRandomCar(@RequestParam(required = false) String manufacturer) {
		CarEntity randomCar = StringUtils.hasText(manufacturer) ? carService.getRandomCar(manufacturer) : carService.getRandomCar();
		return new Car(randomCar.getManufacturer(), randomCar.getModel(), randomCar.getYear());
	}
}

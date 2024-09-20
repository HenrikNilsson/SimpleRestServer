package se.henrik.restserver.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.henrik.restserver.db.domain.CarEntity;

import java.util.List;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
	List<CarEntity> findByManufacturerIgnoreCase(String manufacturer);
}
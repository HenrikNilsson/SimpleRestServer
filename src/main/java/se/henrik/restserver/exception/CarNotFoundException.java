package se.henrik.restserver.exception;

/**
 * Exception used when searched car was not found in DB
 */
public class CarNotFoundException extends RuntimeException {
	private static final String CAR_NOT_FOUND = "Car not found: %s";

	public CarNotFoundException(String manufacturer) {
		super(CAR_NOT_FOUND.formatted(manufacturer));
	}
}

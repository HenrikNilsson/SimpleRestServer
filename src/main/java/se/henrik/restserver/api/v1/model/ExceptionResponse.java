package se.henrik.restserver.api.v1.model;

/**
 * Simple Exception response to API when exception was thrown such as
 * ${@link se.henrik.restserver.exception.CarNotFoundException}
 * 
 * @param message
 *            Message to client
 */
public record ExceptionResponse(String message) {
}

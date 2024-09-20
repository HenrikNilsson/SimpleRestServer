package se.henrik.restserver.api.v1;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * This class is an overview class of the API endpoints and paths to this
 * application
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiPath {
	public static final String API_BASE = "/api/v1";
	public static final String CAR_BASE = API_BASE + "/car";

	public static final String PATH_RANDOM = "/random";
}

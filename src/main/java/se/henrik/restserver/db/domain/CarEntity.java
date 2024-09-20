package se.henrik.restserver.db.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "CAR")
public class CarEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "MANUFACTURER")
	private String manufacturer;

	@Column(name = "MODEL")
	private String model;

	@Column(name = "MANUFACTUREYEAR")
	private int year;

	public CarEntity(String manufacturer, String model, int year) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.year = year;
	}
}

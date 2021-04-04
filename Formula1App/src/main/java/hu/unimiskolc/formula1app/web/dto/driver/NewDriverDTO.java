package hu.unimiskolc.formula1app.web.dto.driver;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

public class NewDriverDTO {

	@NotEmpty
	private String name;
	@DecimalMin(value = "0", message = "The value has to be positive or zero")
	private Integer championships;
	@DecimalMin(value = "0", message = "The value has to be positive or zero")
	private Integer wins;
	@DecimalMin(value = "0", message = "The value has to be positive or zero")
	private Integer poles;
	@DecimalMin(value = "0", message = "The value has to be positive or zero")
	private Integer fastestLaps;
	@DecimalMin(value = "0", message = "The value has to be positive or zero")
	private Integer races;
	@DecimalMin(value = "0", message = "The value has to be positive or zero")
	private Integer podiums;
	
	public NewDriverDTO() {
		super();
	}

	public NewDriverDTO(@NotEmpty String name, Integer championships, Integer wins, Integer poles,
			Integer fastestLaps, Integer races, Integer podiums) {
		super();
		this.name = name;
		this.championships = championships;
		this.wins = wins;
		this.poles = poles;
		this.fastestLaps = fastestLaps;
		this.races = races;
		this.podiums = podiums;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getChampionships() {
		return championships;
	}

	public void setChampionships(Integer championships) {
		this.championships = championships;
	}

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public Integer getPoles() {
		return poles;
	}

	public void setPoles(Integer poles) {
		this.poles = poles;
	}

	public Integer getFastestLaps() {
		return fastestLaps;
	}

	public void setFastestLaps(Integer fastestLaps) {
		this.fastestLaps = fastestLaps;
	}

	public Integer getRaces() {
		return races;
	}

	public void setRaces(Integer races) {
		this.races = races;
	}

	public Integer getPodiums() {
		return podiums;
	}

	public void setPodiums(Integer podiums) {
		this.podiums = podiums;
	}
	
}

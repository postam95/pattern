package hu.unimiskolc.formula1app.model;

import java.time.LocalDateTime;

import hu.unimiskolc.formula1app.service.calculation.DriverValueCalculator;
import hu.unimiskolc.formula1app.service.calculation.ValueCalculator;
import hu.unimiskolc.formula1app.service.calculation.WorldChampionValueCalculator;

public class DriverDTO extends BaseEntityDTO {

	private String name;
	private Integer championships;
	private Integer wins;
	private Integer poles;
	private Integer fastestLaps;
	private Integer races;
	private Integer podiums;
	private ValueCalculator valueCalculator;
	
	public DriverDTO() {
		super();
	}

	public DriverDTO(Long id, LocalDateTime createdAt, LocalDateTime modifiedAt, String name,
			Integer championships, Integer wins, Integer poles, Integer fastestLaps,
			Integer races, Integer podiums) {
		super(id, createdAt, modifiedAt);
		this.name = name;
		this.championships = championships;
		this.wins = wins;
		this.poles = poles;
		this.fastestLaps = fastestLaps;
		this.races = races;
		this.podiums = podiums;
		this.setValueCalculator();
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
	
	private void setValueCalculator()	{
		if (championships != 0)
			this. valueCalculator = new WorldChampionValueCalculator(this);
		else
			this.valueCalculator = new DriverValueCalculator(this);
	}
	
	public double calculateValue()	{
		return this.valueCalculator.calculate();
	}
	
}

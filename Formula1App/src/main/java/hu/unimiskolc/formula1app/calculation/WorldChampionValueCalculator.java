package hu.unimiskolc.formula1app.calculation;

import hu.unimiskolc.formula1app.web.dto.driver.DriverDTO;

public class WorldChampionValueCalculator implements ValueCalculator {

	private DriverDTO driver;
	
	public WorldChampionValueCalculator(DriverDTO driver) {
		this.driver = driver;
	}
	
	@Override
	public double calculate() {
		double oneLapValue = getOneLapValue();
		double raceValue = getRaceValue();
		double experienceValue = getExperienceValue();
		double championValue = getChampionValue();
		return championValue * (0.2 * oneLapValue +  0.4 * raceValue + 0.4 * experienceValue);
	}

	@Override
	public double getOneLapValue() {
		if (driver.getPoles() > 90.0)
			return 1.0;
		else
			return driver.getPoles() / 90.0;
	}

	@Override
	public double getRaceValue() {
		double raceValue = 0.0;
		
		if (driver.getWins() > 90)
			raceValue += 0.4;
		else
			raceValue += 0.4 * (driver.getWins() / 90.0);
		
		if (driver.getPodiums() > 100)
			raceValue += 0.3;
		else
			raceValue += 0.3 * (driver.getPodiums() / 100.0);
		
		if (driver.getFastestLaps() > 50)
			raceValue += 0.3;
		else
			raceValue += 0.3 * (driver.getFastestLaps() /50.0);
		
		return raceValue;
	}

	@Override
	public double getExperienceValue() {
		if (driver.getRaces() > 300)
			return 1.0;
		else
			return driver.getRaces() / 300.0;
	}
	
	public double getChampionValue() {
		if (driver.getChampionships() > 5)
			return 1.3;
		else if (driver.getChampionships() > 2)
			return 1.2;
		else
			return 1.1;
	}

}

package hu.unimiskolc.formula1app.calculation;

import hu.unimiskolc.formula1app.web.dto.driver.DriverDTO;

public class DriverValueCalculator extends ValueCalculator {
	
	private DriverDTO driver;

	public DriverValueCalculator(DriverDTO driver) {
		this.driver = driver;
	}

	@Override
	public double calculate() {
		double oneLapValue = getOneLapValue();
		double raceValue = getRaceValue();
		double experienceValue = getExperienceValue();
		return 0.3 * oneLapValue +  0.4 * raceValue + 0.3 * experienceValue;
	}

	@Override
	protected double getOneLapValue() {
		if (driver.getPoles() > 90.0)
			return 1.0;
		else
			return driver.getPoles() / 90.0;
	}

	@Override
	protected double getRaceValue() {
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
	protected double getExperienceValue() {
		if (driver.getRaces() > 300)
			return 1.0;
		else
			return driver.getRaces() / 300.0;
	}

}

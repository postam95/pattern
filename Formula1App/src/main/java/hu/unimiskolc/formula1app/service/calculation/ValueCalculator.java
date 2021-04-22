package hu.unimiskolc.formula1app.service.calculation;

public abstract class ValueCalculator {
	
	abstract public double calculate();
	
	abstract protected double getOneLapValue();
	
	abstract protected double getRaceValue();
	
	abstract protected double getExperienceValue();
	
}

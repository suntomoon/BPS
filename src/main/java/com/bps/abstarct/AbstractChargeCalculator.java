package com.bps.abstarct;

public abstract class AbstractChargeCalculator {
	protected AbstractChargeStrategy cs;
	public abstract void setChargeStrategy(AbstractChargeStrategy cs);
	public abstract void calculate();
}

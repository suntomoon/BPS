package com.bps.charge;

import com.bps.abstarct.AbstractChargeCalculator;
import com.bps.abstarct.AbstractChargeStrategy;

public class ConcreteChargeCalculator extends AbstractChargeCalculator {

	public ConcreteChargeCalculator() {
	}

	@Override
	public void setChargeStrategy(AbstractChargeStrategy cs) {
		this.cs = cs;
	}

	@Override
	public void calculate() {
		cs.calculate();
	}

}

package com.bps.service;

import java.util.List;

import com.bps.abstarct.AbstractEntity;
import com.bps.abstarct.AbstractFormat;
import com.bps.abstarct.AbstractFormatStrategy;

public class ConcreteFormat extends AbstractFormat {
	public ConcreteFormat() {
	}

	@Override
	public void setFormatStrategy(AbstractFormatStrategy formatter) {
		this.formatter = formatter; 
	}

	@Override
	public String format(List<AbstractEntity> entities) {
		return this.formatter.format(entities);
	}

}

package com.bps.abstarct;

import java.util.List;

public abstract class AbstractFormat {
	protected AbstractFormatStrategy formatter;
	public abstract void setFormatStrategy(AbstractFormatStrategy formatter);
	public abstract String format(List<AbstractEntity> entities);
}

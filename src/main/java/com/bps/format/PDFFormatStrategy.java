package com.bps.format;

import java.util.List;

import com.bps.abstarct.AbstractEntity;
import com.bps.abstarct.AbstractFormatStrategy;

public class PDFFormatStrategy implements AbstractFormatStrategy {

	public PDFFormatStrategy() {
	}

	@Override
	public String format(List<AbstractEntity> entities) {
		return "pdf";
	}

}

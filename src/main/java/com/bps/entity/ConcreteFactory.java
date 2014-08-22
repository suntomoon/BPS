package com.bps.entity;

import com.bps.abstarct.AbstractEntity;
import com.bps.abstarct.AbstractFactory;

public class ConcreteFactory implements AbstractFactory {

	public ConcreteFactory() {
	}

	@Override
	public AbstractEntity createEntity(String entityName) {
		AbstractEntity entity = null;
		try {
			entity = (AbstractEntity)Class.forName("com.bps.entity." + entityName + "Entity").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return entity;
	}
}

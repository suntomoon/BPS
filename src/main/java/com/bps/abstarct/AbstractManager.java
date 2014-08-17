package com.bps.abstarct;

import java.util.List;

public interface AbstractManager {
	public void addEntity(AbstractEntity entirty);
	public List<AbstractEntity> getAllEntity();
	public void deleteEntity(Integer entityId);
}

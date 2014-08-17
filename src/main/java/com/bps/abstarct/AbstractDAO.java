package com.bps.abstarct;

import java.util.List;

public interface AbstractDAO {
	 public void addEntity(AbstractEntity entirty);
	 public List<AbstractEntity> getAllEntity();
	 public void deleteEntity(Integer entityId);
}

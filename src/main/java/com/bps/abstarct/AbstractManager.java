package com.bps.abstarct;

import java.util.List;

public interface AbstractManager {
	 public void addEntity(AbstractEntity entity);
	 public void deleteEntity(int entityId);
	 public void updateEntity(AbstractEntity entity);
	 public AbstractEntity getEntityById(int entityId);
	 public List<AbstractEntity> getAllEntity();
	 public List<AbstractEntity> getAllEntity(String entityId);
}

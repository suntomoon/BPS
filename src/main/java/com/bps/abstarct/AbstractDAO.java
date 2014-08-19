package com.bps.abstarct;

import java.util.List;

public interface AbstractDAO {
	 public void addEntity(AbstractEntity entity);
	 public void deleteEntity(int entityId);
	 public void updateEntity(AbstractEntity entity);
	 public AbstractEntity getEntityById(int entityId);
	 public List<AbstractEntity> getAllEntity();
}

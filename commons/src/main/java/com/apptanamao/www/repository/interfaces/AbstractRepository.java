package com.apptanamao.www.repository.interfaces;

import java.util.List;

public interface AbstractRepository<T> {
	
	public List<T> getAllObjects();

	public void saveObject(T object);

	public T getObject(String id);

	public T updateObject(String id, String name);

	public void deleteObject(String id);

	public void createCollection();

	public void dropCollection();
}

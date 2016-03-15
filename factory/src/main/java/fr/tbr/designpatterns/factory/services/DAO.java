package fr.tbr.designpatterns.factory.services;

public interface DAO<T> {
	
	
	public void create(T toBeCreated);
	
	public void search(T criteria);
	
	public void update(T toBeUpdated);
	
	public void delete(T toBeDeleted);

}

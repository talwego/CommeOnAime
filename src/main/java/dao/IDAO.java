package dao;

import java.util.List;

public interface IDAO<T,K> {

	String urlBdd = "jdbc:mysql://localhost:3306/hopital"; //Windows or Linux
	//String urlBdd = "jdbc:mysql://localhost:8889/space_project"; //Mac
	String loginBdd = "root";
	String passwordBdd=""; //Windows or Linux
	//String passwordBdd="root" //Mac
	
	public List<T> findAll();
	public T findById(K id);
	public void insert(T obj);
	public void update(T obj);
	public void delete(K id);
	
}

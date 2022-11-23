package Sopra.DiscuissonAPI.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;



@Entity
public class Nutritionist extends Compte{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	public Nutritionist() {
		super();
	}

	public Nutritionist(String login, String password) {
		super(login, password);
	}
	
	public Nutritionist(Integer id, String login, String password) {
		super(id, login, password);
	}

	

	@Override
	public String toString() {
		return "Nutritionist []";
	}

	public Object getMessage() {
		// TODO Auto-generated method stub
		return null;
	} 
    

	
}

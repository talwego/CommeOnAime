package Sopra.DiscuissonAPI.model;

import javax.persistence.Entity;

@Entity
public class Admin extends Compte{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}

	public Admin(Integer id, String login, String password) {
		super(id, login, password);
	}

	
	
}

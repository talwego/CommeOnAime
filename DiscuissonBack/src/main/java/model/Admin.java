package model;

import javax.persistence.Entity;

@Entity
public class Admin extends Compte{

	public Admin() {
		super();
	}

	public Admin(Integer id, String login, String password) {
		super(id, login, password);
	}

	
	
}

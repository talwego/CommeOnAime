package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;



@Entity
public class Nutritionist extends Compte{

	@OneToMany(mappedBy="nutritionist")
	private List<Message> messages = new ArrayList<>();

	public Nutritionist() {
		super();
	}

	public Nutritionist(Integer id, String login, String password) {
		super(id, login, password);
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "Nutritionist [messages=" + messages + "]";
	}

	public Object getMessage() {
		// TODO Auto-generated method stub
		return null;
	} 
    

	
}

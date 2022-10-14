package context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Context {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopital");
	
	private static Context singleton=null;


	
	private Context() {}
	

	public static Context getSingleton() {
	
		if(singleton==null) 
		{
			singleton=new Context();	
		}
		return singleton;
	}








	public EntityManagerFactory getEmf() {
		return emf;
	}


	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	
}

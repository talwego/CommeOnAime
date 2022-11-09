package BDD;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.JpaConfig;

public class CreateTableNoData {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(JpaConfig.class);
		
		ctx.close();
	}
}

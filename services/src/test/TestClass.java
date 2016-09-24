package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myschool.configuration.SpringConfiguration;
import com.myschool.services.UserService;


public class TestClass {

	public static void main(String[] args) {

	
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);        
        System.out.println(ctx);
        UserService userService = ctx.getBean(UserService.class);
		userService.addNewUser("abraham");
		
		
	}

}

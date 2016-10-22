package br.com.budgetingtool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BudgetingToolSb2Application {

	public static void main(String[] args) {
		final ApplicationContext ctx = SpringApplication.run(BudgetingToolSb2Application.class, args);
		
		/*
		 System.out.println("Let's inspect the beans provided by Spring Boot:");

	        String[] beanNames = ctx.getBeanDefinitionNames();
	        Arrays.sort(beanNames);
	        for (String beanName : beanNames) {
	            System.out.println(beanName);
	        }
	     */
	}
}

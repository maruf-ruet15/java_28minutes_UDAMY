 package com.in28minutes.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.net.SyslogOutputStream;



@Component
class YourBusinessClass{
	  // autowired using field
//	@Autowired
	Dependency1 dependency1;
//	@Autowired
	Dependency2 dependency2;
	
	
	  //autowired using setter and getter
//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		this.dependency1 = dependency1;
//	}
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		this.dependency2 = dependency2;
//	}
	
	//autowired using constrator funtion(it dont require to type @autowired)
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}
	
	
	
	public String toString() {
		return "using: constractor "+dependency1+" *****and***** "+dependency2;
	}


	


	
	
	
	
}

@Component
class Dependency1{

}

@Component
class Dependency2{
}

@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {

	public static void main(String[] args) {

		try (var context = 
				new AnnotationConfigApplicationContext
					(DepInjectionLauncherApplication.class)) {
    Arrays.stream(context.getBeanDefinitionNames())
    	.forEach(System.out::println);
    
    System.out.println(context.getBean(YourBusinessClass.class));

		}
	}
}
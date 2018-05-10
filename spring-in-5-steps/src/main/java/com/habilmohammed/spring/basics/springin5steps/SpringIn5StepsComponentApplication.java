package com.habilmohammed.spring.basics.springin5steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.habilmohammed.spring.basics.componentscan.ComponentPersonDao;
import com.habilmohammed.spring.basics.springin5steps.scope.PersonDao;

@SpringBootApplication
@ComponentScan("com.habilmohammed.spring.basics.componentscan")
public class SpringIn5StepsComponentApplication {

	private static Logger logger = LoggerFactory.getLogger(SpringIn5StepsComponentApplication.class);
	
	public static void main(String[] args) {
	
		ApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsComponentApplication.class, args);
		
		ComponentPersonDao personDao = applicationContext.getBean(ComponentPersonDao.class);
		ComponentPersonDao personDao2 = applicationContext.getBean(ComponentPersonDao.class);
		
		logger.info("{}", personDao);
		logger.info("{}", personDao.getJdbcConnection());
		
		logger.info("{}", personDao2);
		logger.info("{}", personDao2.getJdbcConnection());
				
	}
}

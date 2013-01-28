package com.catify.processengine.serviceproviders.jpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppContextFactory {

	private static ClassPathXmlApplicationContext context;
	
	/**
	 * Load an existing Spring {@link ApplicationContext}. If there's no
	 * instance yet, a new one will be created.
	 * 
	 * @return
	 */
	public static ApplicationContext loadApplicationContext() {
		
		if(context == null) {
			context = new ClassPathXmlApplicationContext(
					new String[] { "classpath:META-INF/spring/application-context.xml" });
			context.start();
		}
		
		return context;
	}
	
	/**
	 * Shortcut to load an instance from {@link ApplicationContext}.
	 * 
	 * @param clazz
	 * @return
	 */
	public static Object load(Class<?> clazz) {
		Object object = loadApplicationContext().getBean(clazz);
		return object;
	}
	
	
}

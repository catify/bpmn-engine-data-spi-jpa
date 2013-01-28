package com.catify.processengine.serviceproviders.jpa;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.catify.processengine.serviceproviders.jpa.repositories.DataObjectRepository;

public class ApplicationContextFactoryTest {

	@Test
	public void testLoadApplicationContext() {
		ApplicationContext ctx1 = AppContextFactory.loadApplicationContext();
		ApplicationContext ctx2 = AppContextFactory.loadApplicationContext();
		assertNotNull(ctx1);
		assertEquals(ctx1, ctx2);
	}

	@Test
	public void testLoad() {
		Object object = AppContextFactory.load(DataObjectRepository.class);
		assertNotNull(object);
		assertTrue(object instanceof DataObjectRepository);
	}

}

package com.catify.processengine.serviceproviders.jpa;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.catify.processengine.serviceproviders.jpa.beans.DataObjectBean;
import com.catify.processengine.serviceproviders.jpa.repositories.DataObjectRepository;

@Transactional
public class JpaServiceProviderTest {
	
	private DataObjectRepository dataObjectRepository;
	
	@Before
	public void startup() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
		        new String[] {"classpath:META-INF/spring/application-context.xml"});
		appContext.start();
		this.dataObjectRepository = appContext.getBean(DataObjectRepository.class);
	}
	
	@Test
	public void testDataObjectRepository() {
		String id = "42";
		
		DataObjectBean dataObjectBean = new DataObjectBean(id, "uniqueProcessId", "objectId", "instanceId", "dataObject");
		
		dataObjectRepository.save(dataObjectBean);
		
		assertEquals(1, dataObjectRepository.count());
		assertEquals(id, dataObjectRepository.findOne(id).getId());
		
		dataObjectRepository.delete(id);
		assertEquals(0, dataObjectRepository.count());
	}
	
	@Test
	public void testJPADataObjectSPI() {

		JpaDataObjectSpi sp = new JpaDataObjectSpi(); 
		
		sp.saveObject("uniqueProcessId", "objectId", "instanceId", "dataObject");

		assertEquals(1, dataObjectRepository.count());
		assertEquals("dataObject", sp.loadObject("uniqueProcessId", "objectId", "instanceId"));
		
		sp.deleteObject("uniqueProcessId", "objectId", "instanceId");
		assertEquals(0, dataObjectRepository.count());
	}
}

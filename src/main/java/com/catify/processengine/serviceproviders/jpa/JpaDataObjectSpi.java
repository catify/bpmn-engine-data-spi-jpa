package com.catify.processengine.serviceproviders.jpa;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.SerializationUtils;

import com.catify.processengine.core.data.dataobjects.DataObjectSPI;
import com.catify.processengine.serviceproviders.jpa.beans.DataObjectBean;
import com.catify.processengine.serviceproviders.jpa.repositories.DataObjectRepository;

public class JpaDataObjectSpi extends DataObjectSPI {

	private DataObjectRepository dataObjectRepository;

	public JpaDataObjectSpi() {
		this.implementationId = "jpa";
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { "classpath:META-INF/spring/application-context.xml" });
		appContext.start();
		this.dataObjectRepository = appContext
				.getBean(DataObjectRepository.class);
	}

	@Override
	public void saveObject(String uniqueProcessId, String objectId,
			String instanceId, Object dataObject) {
		System.out.println(dataObjectRepository);
		dataObjectRepository.save(new DataObjectBean(getObjectKey(
				uniqueProcessId, objectId, instanceId), uniqueProcessId,
				objectId, instanceId, dataObject));
	}

	@Override
	public Object loadObject(String uniqueProcessId, String objectId,
			String instanceId) {
		return SerializationUtils.deserialize(dataObjectRepository.findOne(
				getObjectKey(uniqueProcessId, objectId, instanceId))
				.getDataObject());
	}

	@Override
	public void deleteObject(String uniqueProcessId, String objectId,
			String instanceId) {
		dataObjectRepository.delete(getObjectKey(uniqueProcessId, objectId,
				instanceId));
	}

}

package com.catify.processengine.serviceproviders.jpa;

import org.springframework.util.SerializationUtils;

import com.catify.processengine.core.data.dataobjects.DataObjectSPI;
import com.catify.processengine.serviceproviders.jpa.beans.DataObjectEntity;
import com.catify.processengine.serviceproviders.jpa.repositories.DataObjectRepository;

/**
 * JPA implementation of the {@link DataObjectSPI}.
 * 
 * @author claus straube
 * @author christopher köster
 * 
 */
public class JpaDataObjectSpi extends DataObjectSPI {

	private DataObjectRepository dataObjectRepository;

	public JpaDataObjectSpi() {
		this.implementationId = "jpa-data-object"; // set this id in spring
		this.dataObjectRepository = (DataObjectRepository) AppContextFactory.load(DataObjectRepository.class);
	}

	@Override
	public void saveObject(String uniqueProcessId, String objectId,
			String instanceId, Object dataObject) {
		dataObjectRepository.save(new DataObjectEntity(getObjectKey(
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

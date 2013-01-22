package com.catify.bpmn.spi.data.jpa;

import com.catify.processengine.core.data.dataobjects.DataObjectSPI;

public class JpaDataObjectSpi extends DataObjectSPI {

	@Override
	public void saveObject(String uniqueProcessId, String objectId,
			String instanceId, Object dataObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object loadObject(String uniqueProcessId, String objectId,
			String instanceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteObject(String uniqueProcessId, String objectId,
			String instanceId) {
		// TODO Auto-generated method stub
		
	}

}

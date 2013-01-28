package com.catify.processengine.serviceproviders.jpa;

import java.util.List;

import com.catify.processengine.core.data.dataobjects.TimerBean;
import com.catify.processengine.core.data.dataobjects.TimerSPI;
import com.catify.processengine.serviceproviders.jpa.beans.TimerEntity;
import com.catify.processengine.serviceproviders.jpa.repositories.TimerRepository;

/**
 * JPA implementation of the {@link TimerSPI}.
 * 
 * @author claus straube
 *
 */
public class JpaTimerSpi extends TimerSPI {

	private TimerRepository repository;
	
	public JpaTimerSpi() {
		this.implementationId = "jpa-timer"; // set this id in spring
		this.repository = (TimerRepository) AppContextFactory.load(TimerRepository.class);
	}
	
	@Override
	public void saveTimer(TimerBean timer) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TimerBean> loadDueTimers(String actorRef) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTimer(String actorRef, String processInstanceId) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Maps the {@link TimerBean} to a {@link TimerEntity}.
	 * 
	 * @param bean the {@link TimerBean}
	 * @return the {@link TimerEntity}
	 */
	public TimerEntity mapTimer(TimerBean bean) {
		TimerEntity entity = new TimerEntity();
		
		entity.setActorRef(bean.getActorRef());
		entity.setTimeToFire(bean.getTimeToFire());
		entity.setProcessInstanceId(bean.getProcessInstanceId());
		
		return entity;
	}

	public TimerRepository getRepository() {
		return repository;
	}

}

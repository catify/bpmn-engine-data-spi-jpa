package com.catify.processengine.serviceproviders.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.catify.processengine.serviceproviders.jpa.beans.TimerEntity;

/**
 * The Interface TimerRepository.
 * 
 * @author claus straube
 * @author chistopher köster
 */
public interface TimerRepository extends CrudRepository<TimerEntity, Long> {

	TimerEntity findByActorRefAndProcessInstanceId (String actorRef, String processInstanceId);
	
	@Query("select t from TimerEntity t where t.actorRef = ?1 and t.timeToFire < ?2")
	List<TimerEntity> findByActorRefAndTimeToFireLessThanTimeNow (String actorRef, long timeNow);
	
}

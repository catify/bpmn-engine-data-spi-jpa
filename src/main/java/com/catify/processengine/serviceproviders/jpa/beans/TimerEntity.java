package com.catify.processengine.serviceproviders.jpa.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="CATIFY_TIMER_SPI")
public class TimerEntity {

	@Id @GeneratedValue
	private long id;
	private long timeToFire;
	private String actorRef;
	private String processInstanceId;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTimeToFire() {
		return timeToFire;
	}
	public void setTimeToFire(long timeToFire) {
		this.timeToFire = timeToFire;
	}
	public String getActorRef() {
		return actorRef;
	}
	public void setActorRef(String actorRef) {
		this.actorRef = actorRef;
	}
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	
	
	
}

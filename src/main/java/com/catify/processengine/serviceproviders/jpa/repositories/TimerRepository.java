package com.catify.processengine.serviceproviders.jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.catify.processengine.serviceproviders.jpa.beans.TimerEntity;

public interface TimerRepository extends CrudRepository<TimerEntity, Long> {

}

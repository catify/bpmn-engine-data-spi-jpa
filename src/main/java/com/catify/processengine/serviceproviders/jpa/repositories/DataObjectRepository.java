package com.catify.processengine.serviceproviders.jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.catify.processengine.serviceproviders.jpa.beans.DataObjectEntity;

public interface DataObjectRepository extends CrudRepository<DataObjectEntity, String>{
}

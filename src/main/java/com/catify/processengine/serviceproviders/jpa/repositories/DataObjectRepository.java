package com.catify.processengine.serviceproviders.jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.catify.processengine.serviceproviders.jpa.beans.DataObjectBean;

public interface DataObjectRepository extends CrudRepository<DataObjectBean, String>{

}

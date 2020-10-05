package com.customer.ms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.customer.ms.model.CustomerM;

public interface CustomerRepository extends MongoRepository<CustomerM, String> {

}

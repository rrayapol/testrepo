package com.nisum.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nisum.model.Employee;

public interface CustomerRepository extends MongoRepository<Employee, String> {

    public Employee findByName(String firstName);
    public List<Employee> findByAddress(String lastName);


}

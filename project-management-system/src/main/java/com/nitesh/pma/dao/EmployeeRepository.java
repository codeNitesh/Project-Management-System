package com.nitesh.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.nitesh.pma.entites.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
}

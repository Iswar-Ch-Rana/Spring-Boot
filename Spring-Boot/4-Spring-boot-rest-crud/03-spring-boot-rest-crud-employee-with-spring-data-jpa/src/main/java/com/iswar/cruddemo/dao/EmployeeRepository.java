package com.iswar.cruddemo.dao;

import com.iswar.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    // No need to write any code
}

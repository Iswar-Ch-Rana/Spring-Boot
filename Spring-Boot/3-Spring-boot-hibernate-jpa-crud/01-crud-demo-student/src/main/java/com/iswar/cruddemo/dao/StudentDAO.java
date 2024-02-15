package com.iswar.cruddemo.dao;

import com.iswar.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    // Create
    void save(Student theStudent);

    // Read
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String theLastName);

    // Update
    void update(Student theStudent);

    // Delete
    void delete(int id);

    int deleteAll ();

}

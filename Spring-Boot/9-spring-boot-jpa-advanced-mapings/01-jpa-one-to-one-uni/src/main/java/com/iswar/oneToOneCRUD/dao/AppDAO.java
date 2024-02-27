package com.iswar.oneToOneCRUD.dao;

import com.iswar.oneToOneCRUD.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}

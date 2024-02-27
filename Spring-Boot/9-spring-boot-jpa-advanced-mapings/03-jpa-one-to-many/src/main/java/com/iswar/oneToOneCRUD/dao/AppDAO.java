package com.iswar.oneToOneCRUD.dao;

import com.iswar.oneToOneCRUD.entity.Instructor;
import com.iswar.oneToOneCRUD.entity.InstructorDetails;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetails finInstructorDetailsById(int id);

    void deleteInstructorDetailsById(int id);
}

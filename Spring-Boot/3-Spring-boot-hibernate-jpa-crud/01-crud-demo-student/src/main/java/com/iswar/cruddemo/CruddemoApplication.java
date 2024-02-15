package com.iswar.cruddemo;

import com.iswar.cruddemo.dao.StudentDAO;
import com.iswar.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {

//            createStudent(studentDAO);
            createMultipleStudent(studentDAO);
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
//            queryForStudentsByLastName(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
//            deleteAllStudent(studentDAO);

        };
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        System.out.println("Deleting all Student");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count: " + numRowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        // delete the student
        int studentId = 4;
        System.out.println("Deleting Student id: " + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {

        // retrieve student based on id
        int studentId = 1;
        Student student = studentDAO.findById(studentId);

        // change first name
        student.setFirstName("John");

        // update the student
        studentDAO.update(student);

        // display updated student
        System.out.println(student);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        // get list of student
        List<Student> students = studentDAO.findByLastName("Doe");

        // display list of student
        for (Student st : students) {
            System.out.println(st);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {

        // get a list of student
        List<Student> students = studentDAO.findAll();

        // display all the student
        for (Student s1 : students) {
            System.out.println(s1);
        }

    }

    private void readStudent(StudentDAO studentDAO) {

        // create student
        System.out.println("Creating new Student Object ...");
        Student tempStudent = new Student("satya", "pursty", "satya@zessta.com");

        // save student
        System.out.println("Saving the Students ...");
        studentDAO.save(tempStudent);

        // display id for the student
        int id = tempStudent.getId();
        System.out.println("Saved Student. Generated id: " + id);

        // retrieve student based on the id:primary key
        System.out.println("Retrieving student with id: " + id);
        Student myStudent = studentDAO.findById(id);

        //display student
        System.out.println(myStudent.toString());

    }

    private void createMultipleStudent(StudentDAO studentDAO) {

        // create multiple students
        System.out.println("Creating 3 Student Objects ...");
        Student tempStudent1 = new Student("John", "Doe", "john@zessta.com");
        Student tempStudent2 = new Student("iswar", "rana", "iswar.rana@zessta.com");
        Student tempStudent3 = new Student("nikhil", "mohanty", "nikhil.mohanty@zessta.com");

        // save the student objects
        System.out.println("Saving the Students ...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

        // display id of the saved student
        System.out.println("Saved Student. Generated id: " + tempStudent1.getId());
        System.out.println("Saved Student. Generated id: " + tempStudent2.getId());
        System.out.println("Saved Student. Generated id: " + tempStudent3.getId());

    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new Student Object ...");
        Student tempStudent = new Student("Paul", "Doe", "paul@zessta.com");

        // save the student object
        System.out.println("Saving the Student Object...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved Student. Generated id: " + tempStudent.getId());

    }
}

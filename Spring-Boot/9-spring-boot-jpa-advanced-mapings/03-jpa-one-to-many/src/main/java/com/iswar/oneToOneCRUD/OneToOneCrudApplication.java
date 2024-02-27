package com.iswar.oneToOneCRUD;

import com.iswar.oneToOneCRUD.dao.AppDAO;
import com.iswar.oneToOneCRUD.entity.Course;
import com.iswar.oneToOneCRUD.entity.Instructor;
import com.iswar.oneToOneCRUD.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneToOneCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneToOneCrudApplication.class, args);
    }

    // Bean For command line runner application
    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//            createInstructor(appDAO);
//            findInstructor(appDAO);
//            deleteInstructor(appDAO);
//            findInstructorDetails(appDAO);
//            deleteInstructorDetails(appDAO);

            // One to Many Mapping

            createInstructorWithCourses(appDAO);
        };
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor instructor = new Instructor(
                "iswar",
                "rana",
                "iswar@zessta.com"
        );
        InstructorDetails instructorDetails = new InstructorDetails(
                "www.zessta.com",
                "coding"
        );
        instructor.setInstructorDetails(instructorDetails);
        Course course1 = new Course("OOPS using Cpp");
        Course course2 = new Course("DBMS");
        Course course3 = new Course("Data Structure and Algorithm");

        instructor.add(course1);
        instructor.add(course2);
        instructor.add(course3);

        // Save the Instructor
        System.out.println("Saving instructor : " + instructor);
        System.out.println("The Courses : " + instructor.getCourses());

        appDAO.save(instructor);

        System.out.println("Done!");
    }

    private void deleteInstructorDetails(AppDAO appDAO) {
        int id = 4 ;
        System.out.println("Deleting Instructor Details With id : " + id);
        appDAO.deleteInstructorDetailsById(id);
        System.out.println("Done!");
    }

    private void findInstructorDetails(AppDAO appDAO) {
        int id = 1 ;
        System.out.println("Finding Instructor Details with id : " + id);
        InstructorDetails instructorDetails = appDAO.finInstructorDetailsById(id);

        System.out.println("Instructor Details = "+instructorDetails);
        System.out.println("Instructor = "+instructorDetails.getInstructor());
    }

    private void deleteInstructor(AppDAO appDAO) {
        int id = 2 ;
        System.out.println("Deleting Instructor With id : " + id);
        appDAO.deleteInstructorById(id);
        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding Instructor with id : " + id);
        Instructor instructor = appDAO.findInstructorById(id);

        System.out.println("Instructor" + instructor);
        System.out.println("Instructor Details = " + instructor.getInstructorDetails());
    }

    private void createInstructor(AppDAO appDAO) {
//        Instructor instructor = new Instructor(
//                "iswar",
//                "rana",
//                "iswar@zessta.com"
//        );
//        InstructorDetails instructorDetails = new InstructorDetails(
//                "www.zessta.com",
//                "coding"
//        );
        Instructor instructor = new Instructor(
                "nikhil",
                "mohanty",
                "nikhil@zessta.com"
        );
        InstructorDetails instructorDetails = new InstructorDetails(
                "www.zessta.com",
                "reading"
        );
        instructor.setInstructorDetails(instructorDetails);

        System.out.println("Saving Instructor" + instructor);

        appDAO.save(instructor);

        System.out.println("Done!");
    }
}

package com.iswar.oneToOneCRUD;

import com.iswar.oneToOneCRUD.dao.AppDAO;
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
            deleteInstructor(appDAO);
        };
    }

    private void deleteInstructor(AppDAO appDAO) {
        int id = 2 ;
        System.out.println("Deleting Instructor With id : " + id);
        appDAO.deleteInstructorById(2);
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

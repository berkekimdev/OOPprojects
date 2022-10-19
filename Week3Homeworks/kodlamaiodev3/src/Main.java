import Business.CategoryManager;
import Business.CourseManager;
import Business.InstructerManager;
import core.logger.DatabaseLogger;
import core.logger.FileLogger;
import core.logger.Logger;
import core.logger.MailLogger;
import dataAccess.*;
import entities.Category;
import entities.Course;
import entities.Instructor;


public class Main {

    public static void main(String[] args) {


            Logger[] loggers = {new MailLogger(), new DatabaseLogger(), new FileLogger()};

            Category category1 = new Category(5, "Mobil");
            CategoryManager categoryManager = new CategoryManager(new HibernateCategoryDao(), loggers);
        try {
            categoryManager.add(category1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Category category2 = new Category(6, "Backend");
            CategoryManager categoryManager2 = new CategoryManager(new JdbcCategoryDao(), loggers);
        try {
            categoryManager2.add(category2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Mobil eklenecek ama backend eklenemeyecek.

            Course course1 = new Course(7, "C#", "C# Eğitimi", 15);
            CourseManager courseManager = new CourseManager(new HibernateCourseDao(), loggers);
        try {
            courseManager.add(course1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Course course2 = new Course(8, "Java", "Java Eğitimi", 15);
            CourseManager courseManager2 = new CourseManager(new HibernateCourseDao(), loggers);
        try {
            courseManager2.add(course2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Java eklenemeycek.
            Course course3 = new Course(7, "Flutter", "Flutter Eğitimi", -1);
            CourseManager courseManager3 = new CourseManager(new HibernateCourseDao(), loggers);
        try {
            courseManager3.add(course3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Fiyatı düşük olduğundan eklenemeyecek.
            Course course4 = new Course(9, "Kotlin", "Kotlin Eğitimi", 24);
            CourseManager courseManager4 = new CourseManager(new JdbcCourseDao(), loggers);
        try {
            courseManager4.add(course4);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Instructor instructor = new Instructor(1, "Engin", "Özdemir");
            InstructerManager instructerManager = new InstructerManager(new JdbcInstructorDao(), loggers);
            instructerManager.add(instructor);


        }




}

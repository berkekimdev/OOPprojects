package Business;

import core.logger.Logger;
import dataAccess.CourseDao;
import entities.Course;



public class CourseManager {

    private CourseDao courseDao;
    private Logger [] loggers;

    public CourseManager(CourseDao courseDao, Logger[] loggers) {
        this.courseDao = courseDao;
        this.loggers = loggers;
    }

    public void add(Course course) throws Exception {
        Course [] courses =  {new Course(1,"Java","Java Backend Eğitimi",18), new Course(2,"Javascript","Frontend Eğitimi",20)};
        for(Course c: courses) {
            if(course.getName().equals(c.getName())) {
                throw new Exception("Kursun adı aynı olamaz");
            }
            else if(course.getPrice()<0)
                throw new Exception("Kursun fiyatı 0'dan küçük olamaz");


        }

        courseDao.add(course);
        for(Logger logger :loggers ) {
            logger.log(course.getName());
        }


    }


}

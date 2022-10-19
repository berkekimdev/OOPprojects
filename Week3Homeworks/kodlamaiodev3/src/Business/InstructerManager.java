package Business;

import core.logger.Logger;
import dataAccess.InstructorDao;
import entities.Instructor;

public class InstructerManager {

    private InstructorDao instructorDao;
    private Logger[] loggers;


    public InstructerManager(InstructorDao instructorDao, Logger[] loggers) {
        this.instructorDao = instructorDao;
        this.loggers = loggers;
    }

    public void add(Instructor instructor) {
        instructorDao.add(instructor);
        for(Logger c: loggers) {
            c.log(instructor.getFirstName()+ " " + instructor.getLastName());
        }
    }



}

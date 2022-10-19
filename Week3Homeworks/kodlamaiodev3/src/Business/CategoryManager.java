package Business;

import core.logger.Logger;
import dataAccess.CategoryDao;
import entities.Category;

public class CategoryManager {

    private CategoryDao categoryDao;
    private Logger[] loggers;

    public CategoryManager(CategoryDao categoryDao, Logger[] loggers) {
        this.categoryDao = categoryDao;
        this.loggers = loggers;
    }


    public void add(Category category) throws Exception {
    Category [] categories = {new Category(1,"Backend"), new Category(2,"Frontend"),new Category(3,"Full Stack")};
    for(Category cat : categories) {
        if(category.getName().equals(cat.getName())) {
            throw new Exception("İki kategorinin  ismi aynı olamaz!");
        }
    }
    categoryDao.add(category);
    for (Logger logs : loggers)
        logs.log(category.getName());

    }
}

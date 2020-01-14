package de.hska.iwi.vslab.Core_Category.Services;

import de.hska.iwi.vslab.Core_Category.Interfaces.CategoryRepository;
import de.hska.iwi.vslab.Core_Category.Models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepo;

    public Category[] getAllCategories() {
        List<Category> list = categoryRepo.findAll();
        Category[] categories = new Category[list.size()];
        categories = list.toArray(categories);
        System.out.println(categories.toString());
        return categories;
    }

    public Category getCategory(String name) {
        return categoryRepo.findByName(name);
    }

    public Category getCategory(int id) {
        return categoryRepo.findById(id);
    }

    public void addCategory(Category category) {
        categoryRepo.save(category);
    }

    public void updateCategory(Category category) {
        categoryRepo.save(category);
    }

    public long deleteAllCategories() {
        long deleted = 0;
        for (Category cat : categoryRepo.findAll())
            deleted += categoryRepo.deleteById(cat.getId());
        return deleted;
    }

    public long deleteCategory(String name) {
        return categoryRepo.deleteByName(name);
    }

    public long deleteCategory(int id) {
        return categoryRepo.deleteById(id);
    }
}

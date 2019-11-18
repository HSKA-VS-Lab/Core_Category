package de.hska.iwi.vslab.Core_Category.Controllers;

import de.hska.iwi.vslab.Core_Category.Models.Category;
import de.hska.iwi.vslab.Core_Category.Services.CategoryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    
    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public List<Category> getAllCategories() {
        log.info("getAllCategories() was called");
        return categoryService.getAllCategories();
    }

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable int id) {
        log.info("getCategory(id) was called");
        return categoryService.getCategory(id);
    }

    @PostMapping("/category")
    public void addCategory(@RequestBody Category category) {
        log.info("addCategory(Category) was called");
        categoryService.addCategory(category);
    }

    @PutMapping("/category")
    public void updateCategory(@RequestBody Category category) {
        log.info("updateCategory(Category) was called");
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable int id){
        log.info("deleteCategory(id) was called");
        categoryService.deleteCategory(id);
    }

    @DeleteMapping("/category")
    public void deleteCategory(){
        log.info("deleteCategory() was called");
        categoryService.deleteAllCategories();
    }
}

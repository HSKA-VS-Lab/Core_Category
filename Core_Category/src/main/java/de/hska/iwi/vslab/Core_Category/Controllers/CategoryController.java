package de.hska.iwi.vslab.Core_Category.Controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import de.hska.iwi.vslab.Core_Category.Models.Category;
import de.hska.iwi.vslab.Core_Category.Services.CategoryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableCircuitBreaker
public class CategoryController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public Category[] getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable int id) {
        return categoryService.getCategory(id);
    }

    @PostMapping(path = "/category", consumes = "application/json")
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @PutMapping(path = "/category/{id}", consumes = "application/json")
    public void updateCategory(@PathVariable int id, @RequestBody Category category) {
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
    }

    @DeleteMapping("/category")
    public void deleteCategory() {
        categoryService.deleteAllCategories();
    }
}

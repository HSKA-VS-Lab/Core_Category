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
    @HystrixCommand(fallbackMethod = "fallbackGetCategories")
    public Category[] getAllCategories() {
        log.info("getAllCategories() was called");
        return categoryService.getAllCategories();
    }

    public Category[] fallbackGetCategories() {
        Category category1 = new Category(1, "fallbackCategory1");
        Category category2 = new Category(2, "fallbackCategory2");
        Category[] categoryA = new Category[2];
        categoryA[0] = category1;
        categoryA[1] = category2;
        return categoryA;
    }

    @GetMapping("/category/{id}")
    //@HystrixCommand(fallbackMethod = "fallbackGetCategory")
    public Category getCategory(@PathVariable int id) {
        log.info("getCategory(id) was called");
        return categoryService.getCategory(id);
    }

    public Category fallbackGetCategory() {
        Category category = new Category(1, "fallbackCategory1");
        return category;
    }

    @PostMapping(path = "/category", consumes = "application/json")
    //@HystrixCommand(fallbackMethod = "fallbackAddCategory")
    public void addCategory(@RequestBody Category category) {
        log.info("addCategory(Category) was called");
        categoryService.addCategory(category);
    }

    public void fallbackAddCategory(Category category, Throwable throwable) {
        System.out.printf("DefaultFallback, exception=%s%n", throwable);
    }

    @PutMapping(path = "/category/{id}", consumes = "application/json")
    //@HystrixCommand(fallbackMethod = "defaultFallbackWithId")
    public void updateCategory(@PathVariable int id, @RequestBody Category category) {
        log.info("updateCategory(Category) was called");
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/category/{id}")
    //@HystrixCommand(fallbackMethod = "defaultFallbackWithId")
    public void deleteCategory(@PathVariable int id) {
        log.info("deleteCategory(id) was called");
        categoryService.deleteCategory(id);
    }

    @DeleteMapping("/category")
    //@HystrixCommand(fallbackMethod = "defaultFallback")
    public void deleteCategory() {
        log.info("deleteCategory() was called");
        categoryService.deleteAllCategories();
    }

    public void defaultFallback(Throwable throwable) {
        System.out.printf("DefaultFallback, exception=%s%n", throwable);
    }

    public void defaultFallbackWithId(int id, Throwable throwable) {
        System.out.printf("DefaultFallbackWithId, id=%s, exception=%s%n", id, throwable);
    }
}

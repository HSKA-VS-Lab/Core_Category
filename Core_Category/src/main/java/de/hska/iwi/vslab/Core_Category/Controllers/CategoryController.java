package de.hska.iwi.vslab.Core_Category.Controllers;

import de.hska.iwi.vslab.Core_Category.Models.Category;
import de.hska.iwi.vslab.Core_Category.Services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public List getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable int id) {
        return categoryService.getCategory(id);
    }

    /*@GetMapping("/category/{name}")
    public Category getCategory(@PathVariable String name) {
        return categoryService.getCategory(name);
    }*/

    @PostMapping("/category")
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @PutMapping("/category")
    public void updateCategory(@RequestBody Category category) {
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/category/{id}")
    public long deleteCategory(@PathVariable int id){
        return categoryService.deleteCategory(id);
    }

    /*@DeleteMapping("/category/{name}")
    public long deleteCategory(@PathVariable String name){
        return categoryService.deleteCategory(name);
    }*/

    @DeleteMapping("/category")
    public long deleteCategory(){
        return categoryService.deleteAllCategories();
    }
}

package de.hska.iwi.vslab.Core_Category.Interfaces;

import de.hska.iwi.vslab.Core_Category.Models.Category;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long>{

    Category findByName(String name);

    Category findById(int id);

    List<Category> findAll();

    long deleteById(int id);

    long deleteByName(String name);




}

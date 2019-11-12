package de.hska.iwi.vslab.Core_Category.Interfaces;

import de.hska.iwi.vslab.Core_Category.Models.Category;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDB_Repo extends CrudRepository<Category, Long>{

    List<Category> findByName(String name);

    List<Category> findAll();

    Category findById(int id);
}

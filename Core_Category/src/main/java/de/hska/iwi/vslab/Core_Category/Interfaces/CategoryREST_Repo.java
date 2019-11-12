package de.hska.iwi.vslab.Core_Category.Interfaces;

import de.hska.iwi.vslab.Core_Category.Models.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "category", path = "category")
public interface CategoryREST_Repo extends PagingAndSortingRepository<Category, Long> {

    List<Category> findByName(@Param("name") String name);

    List<Category> findAll();
}

package com.category.category.repository;

import com.category.category.entity.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, String> {

    List<Category> findAllbyId(String idCategory);

    List<Category> findAllByName(String nameCategory, Pageable pageable);

    //List<Category> save(Category category);

}

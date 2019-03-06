package com.category.category.service;

import com.category.category.Category;

import java.util.ArrayList;

public interface CategoryService {


    Category create(Category category);

    Category findById(String id);

    ArrayList<Category> findAll();

    Category update(Category category);

    Category delete(String id);
}

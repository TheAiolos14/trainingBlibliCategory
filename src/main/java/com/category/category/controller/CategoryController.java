package com.category.category.controller;

import com.category.category.Category;
import com.category.category.service.CategoryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(
            value = "/categories",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Category create(@RequestBody Category category){
        return categoryService.create(category);
    }

    @RequestMapping(
            value = "/categories/{idCategory}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public Category findById(@PathVariable("idCategory") String id){
        return categoryService.findById(id);
    }

    @RequestMapping(
            value = "/category",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ArrayList<Category> findAll(){
        return categoryService.findAll();
    }

}

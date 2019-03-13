package com.category.category.service;

import com.category.category.entity.Category;
import com.category.category.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CategoryServiceImpl implements  CategoryService{


    private ArrayList<Category> list = new ArrayList<>();
    private CategoryRepository categoryRepository;

    @Override
    public Category create(Category category) {

        list.add(category);
        return category;
    }

    @Override
    public Category findById(String id) {

        for(int i=0;i<list.size();i++){

            Category newCategory = list.get(i);
            if(id.compareTo(newCategory.getNameCategory()) == 0){
                return newCategory;
            }
            else{
                return null;
            }

        }

        return null;
    }

    @Override
    public ArrayList<Category> findAll() {
        return list;
    }

    @Override
    public Category update(Category category) {

        Category temp = findById(category.getNameCategory());

        if(temp == null){
            return  null;
        }

        BeanUtils.copyProperties(category, temp);
        return null;
    }

    @Override
    public Category delete(String id) {

        for(int i=0;i<list.size();i++){

            Category newCategory = list.get(i);

            if(id.compareTo(newCategory.getNameCategory()) == 0){

                list.remove(newCategory);

                return newCategory;
            }

        }
        return null;
    }
}

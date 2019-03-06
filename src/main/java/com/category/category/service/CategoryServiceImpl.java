package com.category.category.service;

import com.category.category.Category;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CategoryServiceImpl implements  CategoryService{


    private ArrayList<Category> list = new ArrayList<>();

    @Override
    public Category create(Category category) {

        list.add(category);
        return category;
    }

    @Override
    public Category findById(String id) {

        for(int i=0;i<list.size();i++){

            Category newCategory = list.get(i);
            if(id.compareTo(newCategory.getCategoryId()) == 0){
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

        Category temp = findById(category.getCategoryId());

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

            if(id.compareTo(newCategory.getCategoryId()) == 0){

                list.remove(newCategory);

                return newCategory;
            }

        }
        return null;
    }
}

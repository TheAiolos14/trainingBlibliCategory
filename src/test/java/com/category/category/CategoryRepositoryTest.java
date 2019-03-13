package com.category.category;

import com.category.category.entity.Category;
import com.category.category.repository.CategoryRepository;
import com.sun.org.apache.xml.internal.resolver.Catalog;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {

    private Category category;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testFindAll() {

        //categoryRepository.deleteAll().block();

        categoryRepository.save(new Category("1", "Handphone"));

        categoryRepository.save(new Category("2", "Fashion Wanita"))

        List<Category> category = categoryRepository.findAll();

        Assert.assertTrue(category.size() == 2);
    }
}
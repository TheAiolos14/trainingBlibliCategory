package com.category.category;

import com.category.category.service.CategoryServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class CategoryServiceTest {


    CategoryServiceImpl service = new CategoryServiceImpl();

    @Test
    public void testCreate(){

        Category category = new Category("1", "Mobile Phone");
        service.create(category);

        Assert.assertTrue("Total data harus 1", service.findAll().size() ==1);

        Category temp = service.findById("1");
        Assert.assertTrue("Category harus ada", category == temp);
    }

    @Test
    public void testFindById() {

        Category category= service.findById("kosong");
        Assert.assertTrue("Category harus null", category == null);

        service.create(new Category("1", "Sonyia"));
        service.findById("1");

        Assert.assertTrue("Harus ada Category", category != null);

    }

    @Test
    public void testFindAll(){

        service.create(new Category("1", "Mobile"));
        service.create(new Category("2", "Fashion"));
        Assert.assertTrue(service.findAll().size() == 2);


    }

    @Test
    public void testUpdate(){

        service.create(new Category("1", "Mobile"));
        service.create(new Category("2", "Fashion"));

        Category category= service.findById("1");
        Assert.assertTrue(category.getCategoryName().equals("Dua"));

        Assert.assertTrue("Harus ada Product", category != null);

    }

    @Test
    public  void testDelete(){

        service.create(new Category("1", "Mobile"));
        service.create(new Category("2", "Fashion"));

        Assert.assertTrue(service.findAll().size() == 2);

        service.delete("1");
        Assert.assertTrue(service.findAll().size() == 1);

        service.delete("2");
        Assert.assertTrue(service.findAll().size() == 0 );

    }


}

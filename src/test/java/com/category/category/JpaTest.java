package com.category.category;


import com.category.category.entity.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@RunWith(SpringRunner.class) //buat nambahin testing dengan menggunakan spring
@SpringBootTest
public class JpaTest {

    @Autowired //buat inject secara otomatis
    private EntityManagerFactory factory;


    @Test
    public void testInsertProduct(){

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        //Insert Data

        Category category= new Category();
        category.setNameCategory("contoh name");

        entityManager.persist(category);

        Assert.assertNotNull("Product tidak boleh kosong", category.getIdCategory());

        //Update Data
        Category temp = entityManager.find(Category.class, category.getIdCategory());
        temp.setNameCategory("Diubah");
        entityManager.merge(temp);


        //Remove
        entityManager.remove(temp);

        //SearchData
        List<Category> list = entityManager.createQuery("select p from Product p", Category.class)
                .getResultList();

        List<Category> list1 = entityManager
                .createQuery("select p from Category p WHERE p.name = :name", Category.class)
                .setParameter("name", "Blibli")
                .getResultList();


        entityManager.getTransaction().commit();
        entityManager.close();
    }

}

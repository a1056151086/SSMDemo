package com.trone;

import com.trone.mapper.CategoryMapper;
import com.trone.pojo.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AddCategories {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private Category category;

    @Test
    public void addSomeCategories() {
        for (int i = 1000; i <= 1200; i++) {
            category.setId(i);
            category.setName("Category" + i);
            categoryMapper.add(category);
        }
    }
}

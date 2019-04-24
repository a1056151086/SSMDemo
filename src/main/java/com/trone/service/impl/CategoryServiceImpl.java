package com.trone.service.impl;

import com.trone.mapper.CategoryMapper;
import com.trone.pojo.Category;
import com.trone.service.CategoryService;
import com.trone.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> list() {
        return categoryMapper.list();
    }

    @Override
    public void delete(Category category) {
        categoryMapper.delete(category.getId());
    }

    @Override
    public void add(Category category) {
        categoryMapper.add(category);
    }

    @Override
    public void update(Category category) {
        categoryMapper.update(category);
    }

    @Override
    public Category get(int id) {
        return categoryMapper.get(id);
    }

    @Override
    public void addTwo() {
        Category c1 = new Category();
        c1.setName("短的名字");
        categoryMapper.add(c1);

        Category c2 = new Category();
        c2.setName("名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,");
        categoryMapper.add(c2);
    }

    //    @Override
//    public List<Category> list(Page page) {
//        return categoryMapper.list(page);
//    }
//
//    @Override
//    public int total() {
//        return categoryMapper.total();
//    }
}

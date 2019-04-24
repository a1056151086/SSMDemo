package com.trone.service;

import com.trone.pojo.Category;
import com.trone.util.Page;

import java.util.List;

public interface CategoryService {
    List<Category> list();

    void delete(Category category);

    void add(Category category);

    void update(Category category);

    Category get(int id);

    void addTwo();

    //List<Category> list(Page page);

    //int total();
}

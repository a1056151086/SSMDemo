package com.trone.mapper;

import com.trone.pojo.Category;
import com.trone.util.Page;

import java.util.List;

public interface CategoryMapper {
    int add(Category category);

    void delete(int id);

    Category get(int id);

    int update(Category category);

    List<Category> list();

//    List<Category> list(Page page);
//
//    int total();
}

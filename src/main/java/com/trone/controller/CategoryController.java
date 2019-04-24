package com.trone.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trone.pojo.Category;
import com.trone.service.CategoryService;
import com.trone.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //@RequestMapping(value = "listCategory", method = RequestMethod.GET)
    @RequestMapping(value = "categories", method = RequestMethod.GET)
    public String listCategory(Model model, Page page) {
//        List<Category> categories = categoryService.list();
//
//        model.addAttribute("categories", categories);

        //手动分页
//        List<Category> categories = categoryService.list(page);
//
//        int total = categoryService.total();
//
//        page.caculateLast(total);
//
//        model.addAttribute("categories", categories);

        //使用pagehelper
        PageHelper.offsetPage(page.getStart(), 5);

        List<Category> categories = categoryService.list();

        int total = (int) new PageInfo<>(categories).getTotal();

        page.caculateLast(total);

        model.addAttribute("categories", categories);

        return "listCategory";
    }

    //@RequestMapping(value = "deleteCategory", method = RequestMethod.GET)
    @RequestMapping(value = "categories/{id}", method = RequestMethod.DELETE)
    public String deleteCategory(Category category) {
        categoryService.delete(category);
        return "redirect:/categories";
    }

    //@RequestMapping(value = "addCategory", method = RequestMethod.POST)
    @RequestMapping(value = "categories", method = RequestMethod.POST)
    public String addCategory(Category category) {
        categoryService.add(category);
        return "redirect:/categories";
    }

    //@RequestMapping(value = "editCategory", method = RequestMethod.GET)
    @RequestMapping(value = "categories/{id}", method = RequestMethod.GET)
    public String editCategory(Model model, Category category) {
        System.out.println(category);
        model.addAttribute("category", categoryService.get(category.getId()));
        return "editCategory";
    }

    //@RequestMapping(value = "updateCategory", method = RequestMethod.POST)
    @RequestMapping(value = "categories/{id}", method = RequestMethod.PUT)
    public String upadteCategory(Category category) {
        System.out.println(category);
        categoryService.update(category);
        return "redirect:/categories";
    }

    @ResponseBody
    @RequestMapping(value = "submitCategory")
    public String submitCategory(@RequestBody Category category) {

        System.out.println("SSM接收到浏览器提交的json，并转换为Category对象：" + category);

        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "getOneCategory")
    public String getOneCategory() {
        Category category = new Category();
        category.setId(300);
        category.setName("第300个Category");

        JSONObject json = new JSONObject();

        json.put("category", JSONObject.toJSON(category));

        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "getManyCategories")
    public String getManyCategories() {
        List<Category> categories = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Category c = new Category();
            c.setId(i);
            c.setName("分类名称:" + i);
            categories.add(c);
        }

        return JSONObject.toJSON(categories).toString();
    }
}

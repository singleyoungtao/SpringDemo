package com.test1.controller;

import com.test1.model.BlogEntity;
import com.test1.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by tliu on 12/8/16.*
 */


@Controller
public class BlogController {

    @Autowired
    BlogRepository blogRepository;

    //  查看所有博文
    @RequestMapping(value = "/admin/blogs", method = RequestMethod.GET)
    public String showBlogs(ModelMap modelMap) {
        List<BlogEntity> blogList = blogRepository.findAll();
        modelMap.addAttribute("blogList", blogList);
        return "admin/blogs";
    }

}

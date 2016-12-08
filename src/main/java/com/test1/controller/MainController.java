package com.test1.controller;

import com.test1.model.UserEntity;
import com.test1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.StringJoiner;

/**
 * Created by tliu on 12/6/16. *
 */
@Controller //采用注解方式，可以明确地定义该类为处理请求的Controller类；
public class MainController {

    // 自动装配数据库接口，不需要再写原始的Connection来操作数据库。
    @Autowired
    UserRepository userRepository;


    //@RequestMapping()注解：用于定义一个请求映射，value为请求的url，值为
    // "/"说明，该请求是首页请求，method用以指定该method请求类型。
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
        //处理完该请求后返回index.jsp页面。
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String getUsers(ModelMap modelMap) {
        // 查询user表中所有记录
        List<UserEntity> userList = userRepository.findAll();

        // 将所有记录传递给要返回的Jsp页面，放在userList当中
        modelMap.addAttribute("userList", userList);

        // 返回pages目录下的admin/users.jsp页面
        return "admin/users";
    }

    // get请求，访问添加用户 页面
    @RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
    public String addUser() {
        // 转到 admin/addUser.jsp页面
        return "admin/addUser";
    }

    // post请求，处理添加用户请求，并重定向到用户管理页面
    @RequestMapping(value = "/admin/users/addP", method = RequestMethod.POST)
    public String  addUserPost(@ModelAttribute("user") UserEntity userEntity) {
        // 注意此处，post请求传递过来的是一个UserEntity对象，里面包含了该用户的信息
        // 通过@ModelAttribute()注解可以获取传递过来的「user」，并创建这个对象

        // 数据库中添加一个用户，该步暂时不会刷新缓存
        // userRepository.save(userEntity);

        // 数据库中添加一个用户，并立即刷新缓存
        userRepository.saveAndFlush(userEntity);

        // 重定向到用户管理页面，方法为 redirect:url
        return "redirect:/admin/users";
    }
}

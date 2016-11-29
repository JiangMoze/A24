package com.weikun.controller;

import com.weikun.model.Account;
import com.weikun.model.Category;
import com.weikun.model.CategoryExample;
import com.weikun.service.PetService;
import com.weikun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/11/27.
 */
@Controller


public class UserController {
    @Value("${error.login.msg}")
    private String error;

    @Value("${error.register.pwd}")
    private String errorPwd;

    @Value("${error.register.email}")
    private String errorEmail;

    @Value("${error.register.category}")
    private String errorCate;

    @Value("${error.register.all}")
    private String errorAll;

    @Autowired
    private UserService service;

    @Autowired
    private PetService pservice;

    @RequestMapping("/lmain")
    public String loginMain(){

        return "shop/login";
    }
    @RequestMapping("/rmain")
    public String registerMain(Map map){
        getCategorys(map);
        return "shop/register";
    }

    private void getCategorys(Map map) {
        CategoryExample example=new CategoryExample();
        example.createCriteria().andCatidIsNotNull();
        List<Category> list=pservice.selectByExample(example);
        map.put("clist" ,list);//宠物种类
    }

    @RequestMapping("/register")
    public String register(@ModelAttribute("user") Account account,Map map){
        if(!account.getPassword().equals(account.getRepassword())){
            map.put("errorPwd",errorPwd);
            getCategorys(map);
            return "shop/register";
        }


        if(!Pattern.matches("^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$",account.getEmail())){
            map.put("errorEmail",errorEmail);
            getCategorys(map);
            return "shop/register";
        }
        if(account.getProfile().getCatid().equals("999")){
            map.put("errorCate",errorCate);
            getCategorys(map);
            return "shop/register";
        }
        if(service.save(account)){

            return "shop/login";
        }
        getCategorys(map);
        map.put("errorAll",errorAll);
        return "shop/register";
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute("user") Account account,
                        HttpSession session,Map map){

        Account ac=service.login(account);
        if(ac!=null){
            session.setAttribute("account",ac);
            return "shop/main";
        }else{//登录失败
            map.put("error",error);
            return "shop/login";
        }


    }
}

package com.weikun.controller;

import com.weikun.model.Account;
import com.weikun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/27.
 */
@Controller
public class UserController {
    @Value("${error.login.msg}")
    private String error;
    @Autowired
    private UserService service;

    @RequestMapping("/lmain")
    public String loginMain(){

        return "shop/login";
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

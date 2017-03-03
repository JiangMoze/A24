package com.moze.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/11/27.
 */
@Controller   //声明控制器类
public class IndexController {
    @RequestMapping("/")  //当请求路径为“/”时 返回动态文件夹下的index页面
    public String index(){
        return "index";
    }

    @RequestMapping("/main")    //当请求路径为“/main” 返回动态文件架下的shop/main页面
    public String main(){
        return "shop/main";
    }
}

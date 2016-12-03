package com.weikun.controller;

import com.weikun.model.*;
import com.weikun.service.PetService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/29.
 */
@Controller
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService pservice;

    @RequestMapping("/qp/in_catid/{in_catid}")
    public String queryProducts(
            @PathVariable("in_catid")String in_catid,ModelMap map1){
        Map map=new HashMap();
        map.put("in_catid",in_catid);
        map.put("in_proid","");
        map.put("in_itemid","");

        List<Product> plist=pservice.queryProducts(map);
        map1.put("plist",plist);

        return "shop/queryProducts";
    }


    @RequestMapping("/qp/in_proid/{in_proid}")
    public String queryItems(
            @PathVariable("in_proid")String in_proid,
            ModelMap map1){
        Map map=new HashMap();
        map.put("in_catid","");
        map.put("in_proid",in_proid);
        map.put("in_itemid","");

        List<Item> ilist=pservice.queryItems(map);
        map1.put("ilist",ilist);

        return "shop/queryItems";
    }

    @RequestMapping("/qp/in_itemid/{in_itemid}")
    public String queryItem(
            @PathVariable("in_itemid")String in_itemid,
            ModelMap map1){
        Map map=new HashMap();
        map.put("in_catid","");
        map.put("in_proid","");
        map.put("in_itemid",in_itemid);

        List<Item> ilist=pservice.queryItems(map);
        map1.put("ilist",ilist);

        return "shop/queryItem";
    }
    @RequestMapping("/check/in_orderid/{orderid}/total/{total}")
    public String check(@PathVariable("orderid")  String  orderid,
                        @PathVariable("total")  float  total){
        Orders orders=new Orders();
        orders.setOrderid(Integer.parseInt(orderid));
        orders.setTotalprice(new BigDecimal(total));
        orders.setOrderdate(new Date(System.currentTimeMillis()));
        pservice.updateByPrimaryKey(orders);

        return "shop/main";
    }


    @RequestMapping("/check1")
    public String check1(@RequestParam("total") String total,@RequestParam("oid") String oid){
        Orders orders=new Orders();
        orders.setOrderid(Integer.parseInt(oid));
        orders.setTotalprice(new BigDecimal(total));
        orders.setOrderdate(new Date(System.currentTimeMillis()));

        pservice.updateByPrimaryKey(orders);

        return "shop/main";
    }


    @RequestMapping("/cart/update")
    public String updateCart(
            @RequestParam("itemid" )String[] itemid,
            @RequestParam("qty" )String[] qty,
            @RequestParam("oid" )String[] oid,
            ModelMap map1

    ){
        for(int i=0;i<itemid.length;i++){
            Cart c=new Cart();
            c.setItemid(itemid[i]);
            c.setOrderid(Integer.parseInt(oid[i]));
            c.setQuantity(Integer.parseInt(qty[i]));
            pservice.updateByPrimaryKey(c);
        }

        List<Cart> list=pservice.selectByOrderid(Integer.parseInt(oid[0]));
        map1.put("clist",list);
        return "shop/cart";
    }
    @RequestMapping("/cart/in_itemid/{in_itemid}/in_orderid/{in_orderid}")
    public String delCart(
            @PathVariable("in_itemid")String in_itemid,
            @PathVariable("in_orderid")String in_orderid,
            ModelMap map1

    ){
        CartKey key=new CartKey();
        key.setOrderid(Integer.parseInt(in_orderid));
        key.setItemid(in_itemid);
        if(pservice.deleteByPrimaryKey(key)>0){
            List<Cart> list=pservice.selectByOrderid(Integer.parseInt(in_orderid));
            map1.put("clist",list);
        }
        return "shop/cart";
    }



    @RequestMapping("/cart/in_itemid/{in_itemid}/in_quantity/{in_quantity}")
    public String addCart(
            @PathVariable("in_itemid")String in_itemid,
            @PathVariable("in_quantity")String in_quantity,
            ModelMap map1
    ){
        Map map=new HashMap();
        map.put("in_itemid",in_itemid);
        map.put("in_quantity",in_quantity);
        map.put("out_orderid","");
        pservice.addCart(map);

        List<Cart> list=pservice.selectByOrderid(Integer.parseInt(map.get("out_orderid").toString()));
        map1.put("clist",list);
        return "shop/cart";


    }



}

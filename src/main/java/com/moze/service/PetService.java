package com.moze.service;

import com.moze.mapper.CartMapper;
import com.moze.mapper.CategoryMapper;
import com.moze.mapper.OrdersMapper;
import com.moze.mapper.PetMapper;
import com.moze.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/29.
 */
@Service
public class PetService {
    @Autowired
    private PetMapper pdao;
    @Autowired
    private CategoryMapper cdao;

    @Autowired
    private CartMapper c1dao;


    @Autowired
    private OrdersMapper odao;

    /**
     *
     * @param example 查询条件
     * @return根据条件返回所有宠物种类。
     */
    public List<Category> selectByExample(CategoryExample example){

        return cdao.selectByExample(example);
    }

    public List<Product> queryProducts(Map map){
        return pdao.queryProducts(map);
    }

    public List<Item> queryItems(Map map){
        return pdao.queryItems(map);
    }
    public void addCart(Map map){

        pdao.addCart(map);
    }
    public List<Cart> selectByOrderid(int orderid){
        return c1dao.selectByOrderid(orderid);
    }
    public  int deleteByPrimaryKey(CartKey key){
        return c1dao.deleteByPrimaryKey(key);
    }

    public int updateByPrimaryKey(Cart record){
        return c1dao.updateByPrimaryKey(record);
    }

    public int updateByPrimaryKey(Orders record){
        return odao.updateByPrimaryKey(record);
    }

}

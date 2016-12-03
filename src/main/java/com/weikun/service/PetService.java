package com.weikun.service;

import com.weikun.mapper.CartMapper;
import com.weikun.mapper.CategoryMapper;
import com.weikun.mapper.PetMapper;
import com.weikun.model.*;
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

}

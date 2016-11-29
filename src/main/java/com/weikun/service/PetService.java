package com.weikun.service;

import com.weikun.mapper.CategoryMapper;
import com.weikun.mapper.PetMapper;
import com.weikun.model.Category;
import com.weikun.model.CategoryExample;
import com.weikun.model.Item;
import com.weikun.model.Product;
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

}

package com.weikun.mapper;

import com.weikun.model.Item;
import com.weikun.model.Product;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/29.
 */
public interface PetMapper {//操作宠物的dao


    @Select("call p_7 (" +
            " #{in_catid,mode=IN,jdbcType=VARCHAR}  ," +
            " #{in_proid,mode=IN,jdbcType=VARCHAR}  ," +
            " #{in_itemid,mode=IN,jdbcType=VARCHAR}  )")
    @Options(statementType = StatementType.CALLABLE)
    @Results({
            @Result(column="productid", property="productid", jdbcType= JdbcType.VARCHAR, id=true),
            @Result(column="catid", property="catid", jdbcType=JdbcType.VARCHAR),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="descn", property="descn", jdbcType=JdbcType.VARCHAR),
            @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR),
            @Result(column="catid", property="category",
                    one = @One(select = "com.weikun.mapper.CategoryMapper.queryCategoryByid")),
    })

    List<Product> queryProducts(Map map);



    @Select("call p_7 (" +
            " #{in_catid,mode=IN,jdbcType=VARCHAR}  ," +
            " #{in_proid,mode=IN,jdbcType=VARCHAR}  ," +
            " #{in_itemid,mode=IN,jdbcType=VARCHAR}  )")
    @Options(statementType = StatementType.CALLABLE)
    @Results({
            @Result(column="itemid", property="itemid", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="productid", property="productid", jdbcType=JdbcType.VARCHAR),
            @Result(column="listprice", property="listprice", jdbcType=JdbcType.DECIMAL),
            @Result(column="unitcost", property="unitcost", jdbcType=JdbcType.DECIMAL),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="attr1", property="attr1", jdbcType=JdbcType.VARCHAR),
            @Result(column="attr2", property="attr2", jdbcType=JdbcType.VARCHAR),
            @Result(column="attr3", property="attr3", jdbcType=JdbcType.VARCHAR),
            @Result(column="attr4", property="attr4", jdbcType=JdbcType.VARCHAR),
            @Result(column="attr5", property="attr5", jdbcType=JdbcType.VARCHAR),
            @Result(column="productid", property="product",
                    one = @One(select = "com.weikun.mapper.ProductMapper.queryProductByid")),
    })

    List<Item> queryItems(Map map);

}

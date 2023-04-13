package com.ohc.dao;

import com.ohc.model.Cart;
import com.ohc.model.Commodity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CartDao {
    //获取用户的购物车列表
    public List<Cart> selectCarts(Cart cart);
    //根据商品ID查找商品
    public Commodity selectCommodity(Integer commodityId);
    //根据ID修改商品总价
    public Integer updateAmount(Cart cart);
    //根据商品名称去商品表里查商品ID
    public Integer selectCommodityId(Cart cart);
    //根据商品ID和用户ID去查找购物车
    public Cart selectCartByCondition(Cart cart);
    //若用户购物车已有该商品则修改
    public Integer updateCart(Cart cart);
    //若用户购物车没有该商品则新增
    public Integer insertCart(Cart cart);
    //根据ID删除记录
    public Integer deleteOne(Integer id);
    //根据购物车ID查找商品ID
    public Integer selectId(Integer id);
}

package com.in.market.service.goods;

import com.in.market.pojo.goods.Goods;

import java.util.List;

/**
 * @author TheSevenSky
 */
public interface GoodsService {
        /**
         * 此业务用户获取Goods的业务层
         * @param id goods的id
         * @return 返回goods
         */
        Goods queryById(Integer id);

        /**
         * 返回商品的业务
         * @return 返回全部商品
         */
        List<Goods> queryAll();

        /**
         *通过销量排序
         * @return 返回排序后的商品
         */
        List<Goods> queryAllOrderByVolume();

        /**
         *按类别返回goods的集合
         * @param typeId 类型的id
         * @return goods集合
         */
        List<Goods> queryAllForType(Integer typeId);

        /**
         * 用类别返回goods集合用销量排序
         * @param typeId 类型id
         * @return goods集合
         */
        List<Goods> queryAllForTypeByVolume(Integer typeId);

        /**
         * 根据商品状态来查
         * @param state 状态
         * @return goods集合
         */
        List<Goods> queryAllForState(Integer state);

        void updateForGoodsVolume(com.in.market.pojo.order.Order order);
        }

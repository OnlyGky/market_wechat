package com.in.market.service.goods.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.in.market.commons.cache.rediscache.RedisCacheable;
import com.in.market.dao.goods.GoodsDao;
import com.in.market.dto.PageAndList;
import com.in.market.dto.PageNumAndList;
import com.in.market.pojo.goods.Goods;
import com.in.market.service.goods.PageAndGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TheSevenSky
 */
@Service
public class  PageAndGoodsServiceImpl implements PageAndGoodsService {

    private static final String CACHE_NAME = "pageAndGoods";


    @Autowired
    private GoodsDao goodsDao = null;

    @Override
    public Goods queryById(Integer id) {
        return goodsDao.queryById(id);
    }

    @Override
    @Cacheable(cacheNames = CACHE_NAME, key = "'cache_page_goods_' + #num + '_' + #size")
    public PageNumAndList<Goods> queryAll(Integer num, Integer size) {
        Page<Goods> goods = PageHelper.startPage(num, size).doSelectPage(() -> goodsDao.queryAll());
        return new PageNumAndList<>(goods.getPages(), goods.getResult());
    }

    @Override
    @Cacheable(cacheNames = "hot", key = "'cache_page_goods_' + #num + '_' + #size")
    public PageNumAndList<Goods> queryAllOrderByVolume(Integer num, Integer size) {
        Page<Goods> goods = PageHelper.startPage(num, size).doSelectPage(() -> goodsDao.queryAllOrderByVolume());
        return new PageNumAndList<>(goods.getPages(), goods.getResult());
    }

    @Override
    @Cacheable(cacheNames = CACHE_NAME, key = "'cache_page_goods_typeId_'+ #typeId + '_' + #num + '_' + #size")
    public PageNumAndList<Goods> queryAllForType(Integer typeId, Integer num, Integer size) {
        Page<Goods> goods = PageHelper.startPage(num, size).doSelectPage(
                () -> goodsDao.queryAllForType(typeId));
        return new PageNumAndList<>(goods.getPages(), goods.getResult());
    }

    @Override
    @Cacheable(cacheNames = CACHE_NAME, key = "'cache_page_goods_volume_'+ #typeId + '_' + #num + '_' + #size")
    public PageNumAndList<Goods> queryAllForTypeByVolume(Integer typeId, Integer num, Integer size) {

        Page<Goods> goods = PageHelper.startPage(num, size).doSelectPage(
                () -> goodsDao.queryAllForType(typeId));
        return new PageNumAndList<>(goods.getPages(), goods.getResult());
    }

    @Override
    @Cacheable(cacheNames = CACHE_NAME, key = "'cache_page_goods_state_'+ #state + '_' + #num + '_' + #size")
    public PageNumAndList<Goods> queryAllForState(Integer state, Integer num, Integer size) {
        Page<Goods> goods = PageHelper.startPage(num, size).doSelectPage(
                () -> goodsDao.queryAllForState(state));
        return new PageNumAndList<>(goods.getPages(), goods.getResult());
    }

}

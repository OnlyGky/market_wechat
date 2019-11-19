package com.in.market.service.goods.impl;

import com.in.market.dao.goods.GoodsDetailDao;
import com.in.market.pojo.goods.GoodsDetail;
import com.in.market.service.goods.GoodsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class GoodsDetailServiceImpl implements GoodsDetailService {

    private static final String REDIS_TABLE = "goodsDetail";

    @Autowired
    private GoodsDetailDao goodsDetailDao = null;

    @Override
    @Cacheable(cacheNames = REDIS_TABLE, key = "'cache_goodsDetail_' + #id")
    public GoodsDetail queryById(Integer id) {
        return goodsDetailDao.queryById(id);
    }
}

package com.in.market.service.goods.impl;

import com.in.market.commons.cache.typecache.TypeCache;
import com.in.market.dao.goods.GoodsTypeDao;
import com.in.market.dto.PrefixGoodsType;
import com.in.market.pojo.goods.GoodsType;
import com.in.market.service.goods.GoodsTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TheSevenSky
 */
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    private static final String REDIS_TABLE = "goodsType";
    private static final String PREFIX_GOODS_TYPE_NAME = "prefixGoodsType";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GoodsTypeDao goodsTypeDao = null;

    @Autowired
    private TypeCache<String,List> cache = null;

    @Override

    public GoodsType queryById(Integer id) {
        return goodsTypeDao.queryById(id);
    }

    @Override
    public List<GoodsType> queryAll() {
        if(cache.containsKey(REDIS_TABLE)) return  cache.get(REDIS_TABLE);
        else {
            List<GoodsType> goodsTypeList = goodsTypeDao.queryAll();
            cache.put(REDIS_TABLE, goodsTypeList);
            return goodsTypeList;
        }
    }

    @Override
    public List<PrefixGoodsType> queryAllForPrefix() {
        if(!cache.containsKey(PREFIX_GOODS_TYPE_NAME)) {
            List<GoodsType> goodsTypes = queryAll();
            List<PrefixGoodsType> prefixGoodsTypes = new ArrayList<>();
            for(GoodsType goodsType : goodsTypes) {
                PrefixGoodsType prefixGoodsType = new PrefixGoodsType(goodsType);
                prefixGoodsTypes.add(prefixGoodsType);
            }
            cache.put(PREFIX_GOODS_TYPE_NAME, prefixGoodsTypes);
        }
        return cache.get(PREFIX_GOODS_TYPE_NAME);
    }

    @Override
    public void clearCache() {
        cache.clear();
        logger.info("GoodsType的服务 -- 清空了缓存");
    }
}

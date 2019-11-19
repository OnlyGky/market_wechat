package com.in.market.dao.goods;

import com.in.market.pojo.goods.GoodsType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * GoodsType对数据库的操作
 * @author TheSevenSky
 */
@Mapper
public interface GoodsTypeDao {
    /**
     * 通过goodsType的id查询
     * @param id goodsType的id
     * @return 返回goodsType
     */
    GoodsType queryById(Integer id);

    /**
     * 查询所有GoodsType
     * @return 返回GoodsType的集合
      */
    List<GoodsType> queryAll();
}

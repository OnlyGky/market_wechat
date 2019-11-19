package com.in.market.service.goods;

import com.in.market.pojo.goods.GoodsType;

import java.util.List;

/**
 * @author TheSevenSky
 */
public interface GoodsTypeService {
    /**
     * 通过id查询
     * @param id goodsType的id
     * @return 返回goodsType
     */
     GoodsType queryById(Integer id);

    /**
     *返回所有GoodsType
     * @return 返回GoodsType的集合
     */
    List<GoodsType> queryAll();

    /**
     * id使用前缀封装
     * @return 返回封装后的GoodsType集合
     */
    List queryAllForPrefix();

    void clearCache();
}

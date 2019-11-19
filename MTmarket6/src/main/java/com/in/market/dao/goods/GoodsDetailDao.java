package com.in.market.dao.goods;

import com.in.market.pojo.goods.GoodsDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsDetailDao {

    public GoodsDetail queryById(Integer id);

}

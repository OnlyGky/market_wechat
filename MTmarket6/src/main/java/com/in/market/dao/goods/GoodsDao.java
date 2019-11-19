package com.in.market.dao.goods;

import com.in.market.pojo.goods.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 这是Goods的数据库操作
 * @author TheSevenSky
 */
@Mapper
public interface GoodsDao {
    /**
     * 通过goods的id查询
     * @param id goods的id
     * @return  返回goods
     */
    Goods queryById(Integer id);

    /**
     * 查询所有
     * @return 返回所有的商品
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

    void updateForGoodsVolume(@Param("goodsId") Integer goodsId, @Param("num") Integer num);

}

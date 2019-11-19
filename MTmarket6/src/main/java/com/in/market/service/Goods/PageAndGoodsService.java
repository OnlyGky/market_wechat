package com.in.market.service.goods;

import com.github.pagehelper.Page;
import com.in.market.dto.PageNumAndList;
import com.in.market.pojo.goods.Goods;

import java.util.List;

/**
 * 用于分页的goods
 * @author TheSevenSky
 */
public interface PageAndGoodsService {

    /**
     * 此业务用户获取Goods的业务层
     * @param id goods的id
     * @return 返回goods
     */
    Goods queryById(Integer id);

    /**
     * 查找分页全部
     * @param num 页数
     * @param size 一页大小
     * @return 分页的全部
     */
    PageNumAndList<Goods> queryAll(Integer num, Integer size);

    /**
     * 分页并且排序后的
     * @param num 当前页数
     * @param size 一页大小
     * @return 分页并且排序后的
     */
    PageNumAndList<Goods> queryAllOrderByVolume(Integer num, Integer size);

    /**
     *按类别返回goods的集合
     * @param typeId 类型的id
     * @param num 当前页数
     * @param size 一页大小
     * @return goods集合
     */
    PageNumAndList<Goods> queryAllForType(Integer typeId,Integer num, Integer size);

    /**
     * 用类别返回goods集合用销量排序
     * @param typeId 类型id
     * @param num 当前页数
     * @param size 一页大小
     * @return goods集合
     */
    PageNumAndList<Goods> queryAllForTypeByVolume(Integer typeId,Integer num, Integer size);

    /**
     * 根据商品状态来查
     * @param num 当前页数
     * @param size 一页大小
     * @return goods集合
     */
    PageNumAndList<Goods> queryAllForState(Integer state, Integer num, Integer size);
}

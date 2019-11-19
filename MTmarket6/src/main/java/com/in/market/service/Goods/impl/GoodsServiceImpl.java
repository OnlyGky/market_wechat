package com.in.market.service.goods.impl;

import com.in.market.dao.goods.GoodsDao;
import com.in.market.pojo.cart.Cart;
import com.in.market.pojo.goods.Goods;
import com.in.market.pojo.order.Order;
import com.in.market.pojo.order.OrderDetail;
import com.in.market.service.goods.GoodsService;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TheSevenSky
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    private static final String REDIS_TABLE = "goods";


    @Autowired
    private GoodsDao goodsDao = null;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate = null;

    @Override
    @Cacheable(cacheNames = REDIS_TABLE, key = "'cache_goods_' + #id")
    public Goods queryById(Integer id) {
        return goodsDao.queryById(id);
    }


    @Override
    public List<Goods> queryAll() {
        return goodsDao.queryAll();
    }

    @Override
    public List<Goods> queryAllOrderByVolume() {
        return goodsDao.queryAllOrderByVolume();
    }

    @Override
    public List<Goods> queryAllForType(Integer typeId) {
        return goodsDao.queryAllForType(typeId);
    }

    @Override
    public List<Goods> queryAllForTypeByVolume(Integer typeId) {
        return goodsDao.queryAllForTypeByVolume(typeId);
    }

    @Override
    public List<Goods> queryAllForState(Integer state) {
        return goodsDao.queryAllForState(state);
    }

    @Override
    public void updateForGoodsVolume(Order order) {
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        GoodsDao mapper = sqlSession.getMapper(GoodsDao.class);
        List<OrderDetail> orderDetails = order.getOrderDetails();
        for(OrderDetail orderDetail : orderDetails) {
            mapper.updateForGoodsVolume(orderDetail.getDetailGoods(),orderDetail.getDetailNum());
        }
        sqlSession.commit();
        sqlSession.close();
    }
}

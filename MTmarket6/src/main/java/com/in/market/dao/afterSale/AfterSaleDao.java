package com.in.market.dao.afterSale;

import com.in.market.pojo.afterSale.AfterSale;

import java.util.List;
import java.util.Map;

public interface AfterSaleDao {

    public void save(AfterSale afterSale);

    void updateStatus(Map map);

    List<AfterSale> findAll();

    void delete(Long id);
}

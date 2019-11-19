package com.in.market.service.afterSale;

import com.in.market.pojo.afterSale.AfterSale;

import java.util.List;

public interface AfterSaledService {
    void save(AfterSale afterSale);

    void updateStatus(Long id,Integer status);

    List<AfterSale> findAll();

    void delete(Long id);
}

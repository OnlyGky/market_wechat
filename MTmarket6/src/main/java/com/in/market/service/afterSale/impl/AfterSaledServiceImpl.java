package com.in.market.service.afterSale.impl;

import com.in.market.dao.afterSale.AfterSaleDao;
import com.in.market.pojo.afterSale.AfterSale;
import com.in.market.service.afterSale.AfterSaledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AfterSaledServiceImpl implements AfterSaledService {

    @Autowired
    public AfterSaleDao afterSaleDao;

    @Override
    public void save(AfterSale afterSale){
        afterSale.setId(null);
        afterSale.setQuestDate(new Date());
        afterSale.setStatus(1);
        this.afterSaleDao.save(afterSale);
    }

    @Override
    public void updateStatus(Long id,Integer status) {
        Map map = new HashMap();
        map.put("id",id);
        map.put("status",status);
        this.afterSaleDao.updateStatus(map);
    }

    @Override
    public List<AfterSale> findAll() {
        return this.afterSaleDao.findAll();
    }

    @Override
    public void delete(Long id) {
        this.afterSaleDao.delete(id);
    }

}

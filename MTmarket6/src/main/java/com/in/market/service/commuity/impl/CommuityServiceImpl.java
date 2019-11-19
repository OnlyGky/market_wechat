package com.in.market.service.commuity.impl;


import com.in.market.dao.commuity.CommuityDao;
import com.in.market.pojo.commuity.Commuity;
import com.in.market.service.commuity.CommuityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommuityServiceImpl implements CommuityService {

    @Autowired
    CommuityDao commuityDao;

    @Override
    public List<Commuity> query() {
        List<Commuity>list=commuityDao.query();
        return list;
    }
}

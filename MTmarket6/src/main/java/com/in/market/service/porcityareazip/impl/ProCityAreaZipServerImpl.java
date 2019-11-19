package com.in.market.service.porcityareazip.impl;

import com.in.market.dao.address.AddressDao;
import com.in.market.dao.areas.AreasDao;
import com.in.market.dao.cities.CitiesDao;
import com.in.market.dao.provinces.ProvincesDao;
import com.in.market.dao.zipcode.ZipcodeDao;
import com.in.market.pojo.areas.Areas;
import com.in.market.pojo.cities.Cities;
import com.in.market.pojo.provinces.Provinces;
import com.in.market.pojo.zipcode.Zipcode;
import com.in.market.service.porcityareazip.ProCityAreaZipServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProCityAreaZipServerImpl implements ProCityAreaZipServer {
    @Autowired
    ProvincesDao provincesDao;
    @Autowired
    CitiesDao citiesDao;
    @Autowired
    AreasDao areasDao;
    @Autowired
    AddressDao addressDao;
    @Autowired
    ZipcodeDao zipcodeDao;

    @Override
    public List<Provinces> findAllPro() {
        return provincesDao.findAllProvince();
    }

    @Override
    public List<Cities> queryCityByProId(String provinceId) {
        System.out.println("传参"+provinceId);
        return citiesDao.queryCitiesByProvinceId(provinceId);
    }

    @Override
    public List<Areas> queryAreaByCityId(String cityId) {
        return areasDao.queryAreaByCityId(cityId);
    }

    @Override
    public Zipcode queryZipByAreaId(String areaId) {
        return zipcodeDao.queryZipByAreaId(areaId);
    }
}

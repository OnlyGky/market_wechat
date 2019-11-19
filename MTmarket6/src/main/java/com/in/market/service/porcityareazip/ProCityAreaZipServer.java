package com.in.market.service.porcityareazip;

import com.in.market.pojo.areas.Areas;
import com.in.market.pojo.cities.Cities;
import com.in.market.pojo.provinces.Provinces;
import com.in.market.pojo.zipcode.Zipcode;

import java.util.List;

public interface ProCityAreaZipServer {

    public List<Provinces> findAllPro();

    public List<Cities> queryCityByProId(String provinceId);

    public List<Areas> queryAreaByCityId(String cityId);

    public Zipcode queryZipByAreaId(String areaId);
}

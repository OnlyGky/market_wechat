package com.in.market.porcityareazip;


import com.in.market.pojo.areas.Areas;
import com.in.market.pojo.cities.Cities;
import com.in.market.pojo.provinces.Provinces;
import com.in.market.pojo.zipcode.Zipcode;
import com.in.market.service.porcityareazip.ProCityAreaZipServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/addressDetail")
public class ProCityAreaZipController {
    @Autowired
    ProCityAreaZipServer proCityAreaZipServer;

    /**
     * 查询所有的省份
     */
    @RequestMapping("queryAllPro")
    @ResponseBody
    public List<Provinces> queryAllPro(){
        return proCityAreaZipServer.findAllPro();
    }
    /**
     * 通过provincesId查找城市Id
     */
    @RequestMapping("queryCityByProId")
    @ResponseBody
    public List<Cities> queryCityByProId(String provinceId){

        return proCityAreaZipServer.queryCityByProId(provinceId);
    }

    /**
     *
     * 通过城市查找地址Id
     */
    @RequestMapping("queryAreaByCityId")
    @ResponseBody
    public List<Areas> queryAreaByCityId(String cityId){
        return proCityAreaZipServer.queryAreaByCityId(cityId);
    }

    /**
     * 根据地区id查找邮政编码
     */
    @ResponseBody
    @RequestMapping("queryZipByAreaId")
    public Zipcode queryZipByAreaId(String areaId){
        return proCityAreaZipServer.queryZipByAreaId(areaId);
    }
}

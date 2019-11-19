package com.in.market.controller.commuity;

import com.in.market.pojo.commuity.Commuity;

import com.in.market.service.commuity.CommuityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/commuity")
public class CommuityController {
    @Autowired
    CommuityService commuityService;
    /**
     * 查找所有的小区
     */
    @RequestMapping("/query")
    public ResponseEntity<List<Commuity>> query(){
        List<Commuity>list=commuityService.query();
        return ResponseEntity.ok(list);
    }


}

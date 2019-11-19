package com.in.market.controller.integral;

import com.in.market.pojo.integral.IntegralDetail;
import com.in.market.service.integral.IntegralDetailService;
import com.in.market.util.ResultList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RequestMapping("/integralDetail")
@Controller
public class IntegralDetailController {

    @Autowired
    public IntegralDetailService integralDetailService;

    @RequestMapping(value = "/query/{userId}",method = RequestMethod.GET)
    public ResponseEntity<ResultList> queryIntegralDetailByUserId(@PathVariable(value = "userId") Integer userId){
        try{
            ResultList resultList = this.integralDetailService.queryIntegralDetailByUserId(userId);
            return ResponseEntity.ok(resultList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseEntity<Void> addIntegralDetail(@RequestBody String integralDetailJson){
        try{
            this.integralDetailService.addIntegralDetail(integralDetailJson);
            return ResponseEntity.ok(null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/delete/{userId}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteIntegralDetailsByUserId(@PathVariable(value = "userId")Integer userId){
        try{
           this.integralDetailService.deleteIntegralDetailsByUserId(userId);
            return ResponseEntity.ok(null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}

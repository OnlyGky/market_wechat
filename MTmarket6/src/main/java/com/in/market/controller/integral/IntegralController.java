package com.in.market.controller.integral;

import com.in.market.service.integral.IntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/integral")
@Controller
public class IntegralController {

    @Autowired
    private IntegralService integralService;

    @RequestMapping(value = "/query/{userId}",method = RequestMethod.GET)
    public ResponseEntity<Long> queryTotalByUserId(@PathVariable(value = "userId") Integer userId){
        try{
            Long total = this.integralService.queryTotalByUserId(userId);
            return ResponseEntity.ok(total);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @RequestMapping(value = "/update/{userId}/{total}",method = RequestMethod.PUT)
    public ResponseEntity<Void> updateIntegralByUserId(@PathVariable(value = "userId") Integer userId,@PathVariable(value = "total") Long total){
        try{

            this.integralService.updateIntegralByUserId(userId,total);
            return ResponseEntity.ok(null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}


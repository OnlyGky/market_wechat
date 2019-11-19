package com.in.market.controller.afterSale;

import com.in.market.pojo.afterSale.AfterSale;
import com.in.market.service.afterSale.AfterSaledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/afterSale")
@RestController
public class AfterSaledController {

    @Autowired
    private AfterSaledService afterSaledService;

    @PostMapping
    public String saveAfterSaled(@RequestBody AfterSale afterSale){
        afterSaledService.save(afterSale);
        return "ok";
    }

    @GetMapping(value = "/{id}/{status}")
    public String updateStatus(@PathVariable(value = "id")Long id,@PathVariable(value = "status")Integer status){
        afterSaledService.updateStatus(id,status);
        return "ok";
    }

    @GetMapping("/list")
    public List<AfterSale> findAll(){
        return afterSaledService.findAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id")Long id){
        afterSaledService.delete(id);
        return "ok";
    }

}

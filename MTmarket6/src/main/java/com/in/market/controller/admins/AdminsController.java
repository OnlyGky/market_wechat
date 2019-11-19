package com.in.market.controller.admins;

import com.in.market.pojo.admins.Admins;
import com.in.market.service.admins.AdminsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/admins")
@Controller
public class AdminsController {
    @Autowired
    AdminsService adminsService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResponseEntity<Admins> save(@RequestBody String json){
//        JSONObject jsonObject=JSONObject.parseObject(json);
        if(StringUtils.isNotEmpty(json)){
            Admins admins=null;
           admins= adminsService.save(json);
           if(admins!=null)
               return ResponseEntity.ok(admins);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 查找会员及会员状态
     * @param json
     * @return
     */
    @RequestMapping(value="/query",method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>>query(@RequestBody String json){
        Map<String,String>map=new HashMap<>();
        String result=null;
        Admins admins=null;
        if(StringUtils.isNotEmpty(json)){
            admins=adminsService.query(json);
            if(admins!=null){
            if(admins.getAdminState()==3){
                map.put("adminsState","高级会员");
                map.put("adminName",admins.getAdminName());
                map.put("adminDate",admins.getAdminDate());
                map.put("adminRole",String.valueOf(admins.getAdminState()));
            }
            else{
                if(admins.getAdminState()==2){
                    map.put("adminsState","普通会员");
                    map.put("adminName",admins.getAdminName());
                    map.put("adminDate",admins.getAdminDate());
                    map.put("adminRole",String.valueOf(admins.getAdminState()));
                }else{
                    map.put("adminsState","普通成员");
                    map.put("adminName",admins.getAdminName());
                    map.put("adminDate","会员已过期");
                    map.put("adminRole",String.valueOf(1));
                }
            }
            return ResponseEntity.ok(map);
            }
        }
        map.put("adminsState","普通用户");
        map.put("adminName",null);
        map.put("adminDate","会员未开通");
        map.put("adminRole",String.valueOf(1));
        return ResponseEntity.ok(map);
    }

//    @RequestMapping("/queryRole")
//    public ResponseEntity<Integer> queryRole(@RequestBody String json){
//        if(StringUtils.isNotEmpty(json)){
//            Integer result=adminsService.queryRole(json);
//        }

//    }





}

package com.in.market.controller.Address;

import com.in.market.pojo.address.Address;
import com.in.market.service.address.AddressService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @RequestMapping("/save")
    public ResponseEntity<Void> save(@RequestBody String jsonAddress){
        System.out.println(jsonAddress);
        if (StringUtils.isNotEmpty(jsonAddress)){
            if(addressService.save(jsonAddress)){
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/delete/{Id}",method = RequestMethod.GET)
    public ResponseEntity<Void> delete(@PathVariable("Id") Integer addrId){
        if(!addrId.equals(null))
            if(addressService.delete(addrId)){
                return ResponseEntity.ok().build();
            }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping("/update")
    public ResponseEntity<Void> update(@RequestBody String jsonAddress){
        System.out.println(jsonAddress);
        if(StringUtils.isNotEmpty(jsonAddress))
            if(addressService.update(jsonAddress)) {
                return ResponseEntity.ok().build();
            }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 根据地址Id查找地址
     * @param addrId
     * @return
     */
    @RequestMapping("/query/{addrId}")
    public ResponseEntity<Address> query(@PathVariable Integer addrId){
        Address address=null;
        address=addressService.query(addrId);
        if (address!=null)
            return ResponseEntity.ok(address);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /*
     *根据addr_user返回所存地址
     */
    @RequestMapping("/queryAllId/{addrUser}")
    public ResponseEntity<List<Address>> queryAllId(@PathVariable Integer addrUser){
        List<Address>list=null;
        if(!addrUser.equals(null))
            list=addressService.queryAllId(addrUser);
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        return ResponseEntity.ok().body(list);
    }
}

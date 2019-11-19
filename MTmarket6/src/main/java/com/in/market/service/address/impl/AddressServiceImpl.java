package com.in.market.service.address.impl;

//import com.in.market.mapper.address.AddressMapper;
import com.alibaba.fastjson.JSONObject;

import com.in.market.dao.address.AddressDao;
import com.in.market.dao.commuity.CommuityDao;
import com.in.market.pojo.address.Address;
import com.in.market.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressDao addressMapper;
    @Autowired
    CommuityDao commuityDao;

    /**
     * 通过小区和用户名查找是否已经有同一小区快递号存在
     */
    public List<String> queryByuc(Integer addrUser, String addrCommuity){
        List<String> addr=null;
        System.out.println(addrUser+addrCommuity);
        addr=addressMapper.queryByuc(addrUser,addrCommuity);
        return addr;
    }

//    public boolean save(String jsonAddress) {
//        Address address=null;
//        address =  JSONObject.parseObject(jsonAddress, Address.class);
//        if (address!=null){
//            Address temp=this.queryByuc(address.getAddrUser(),address.getAddrCommuity()).get(0);
//            if(temp!=null){
//                address.setAddrDid(temp.getAddrDid());
//            }
//            else{
//
//                address.setAddrDid(commuityDao.querBycommuity(address.getAddrCommuity())+(addressMapper.selectmaxkey()+1));
//            }
//            return addressMapper.insert(address)!=0;
//        }
//        return false;
//    }

    public boolean save(String jsonAddress) {
        Address address=null;
        address =  JSONObject.parseObject(jsonAddress, Address.class);
        if (address!=null){
            List<String>list=null;
            String temp=null;
            list=this.queryByuc(address.getAddrUser(),address.getAddrCommuity());
            if(list!=null&&list.size()>0){
//                temp=new Address();
                temp=list.get(0);
                System.out.println(list);
                if(temp!=null){
                    System.out.println("查找"+temp);
                    address.setAddrDid(temp);
                }
            }
            else{
                Integer result=null;
                try{
                    result=addressMapper.selectmaxkey()+1;
                }catch (Exception e){
                    result=1;
                }
                address.setAddrDid(commuityDao.querBycommuity(address.getAddrCommuity())+result);
            }
            return addressMapper.insert(address)!=0;
        }
        return false;
    }


    public boolean delete(Integer addrId){
        return addressMapper.deleteByPrimaryKey(addrId)!=0;
    }

//    public boolean update(String jsonAddress) {
//        Address address=null;
//        address=JSONObject.parseObject(jsonAddress, Address.class);
//        if(address!=null)
//            return addressMapper.updateByPrimaryKey(address)!=0;
//        return false;
//    }

    public boolean update(String jsonAddress) {
        Address address=null;
        address=JSONObject.parseObject(jsonAddress, Address.class);

        if(address!=null){
            String cmoouityId=commuityDao.queryCId(address.getAddrCommuity());
            address.setAddrDid(cmoouityId+address.getAddrId());
            return addressMapper.updateByPrimaryKey(address)!=0;
        }
        return false;
    }



    public Address query(Integer addrId) {
        return addressMapper.selectByPrimaryKey(addrId);
    }

    public List<Address> queryAllId(Integer addrUser) {
        return addressMapper.queryAllId(addrUser);
    }
}

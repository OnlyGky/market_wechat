package com.in.market.service.address;

import com.in.market.pojo.address.Address;

import java.util.List;

public interface AddressService {
     List<String> queryByuc(Integer addrUser, String addrCommuity);
     boolean save(String jsonAddress) ;
     boolean delete(Integer addrId);
     boolean update(String jsonAddress);
     Address query(Integer addrId) ;
     List<Address> queryAllId(Integer addrUser);

    }

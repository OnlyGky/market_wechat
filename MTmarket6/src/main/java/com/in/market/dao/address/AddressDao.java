package com.in.market.dao.address;


import com.in.market.pojo.address.Address;
import com.in.market.pojo.address.AddressExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface AddressDao {
    int deleteByPrimaryKey(Integer addrId);

    int insert(Address record);

    Address selectByPrimaryKey(Integer addrId);


    int updateByPrimaryKey(Address record);

    List<Address> queryAllId(Integer addrUser);
    @Select("select addr_did from address where addr_user=#{addrUser} and addr_commuity=#{addrCommuity};")
    List<String> queryByuc(@Param(value = "addrUser") Integer addrUser,@Param(value = "addrCommuity") String addrCommuity);

//    Integer selectmaxkey();
    Integer selectmaxkey() throws Exception;
}
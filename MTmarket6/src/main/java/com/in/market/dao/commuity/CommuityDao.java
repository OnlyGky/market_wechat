package com.in.market.dao.commuity;

import com.in.market.pojo.commuity.Commuity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface CommuityDao {
    public List<Commuity>query();

    String querBycommuity(String addrCommuity);

    @Select("select c_abbr from commuity where c_name=#{addrCommuity}")
    String queryCId(String addrCommuity);

}

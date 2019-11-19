package com.in.market.service.admins;

import com.in.market.pojo.admins.Admins;

public interface AdminsService {

    public Admins save(String json);

    public Admins query(String json);
}

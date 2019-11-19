package com.in.market.commons.cache.rediscache;

public enum RedisMethodEnum {
    /**
     * GETANDFIND先从缓存获得 然后 数据库
     * INSERTANDPUT 先插入 然后放入缓存
     * DELETE 删除缓存
     */

    GETANDFIND,INSERTANDPUT,DELETE

}

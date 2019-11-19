package com.in.market.service.evaluate;

import com.in.market.util.ResultList;

import java.util.List;

public interface EvaluateService {

    public ResultList queryByGId(Integer goodsId);
    public Integer evaUpload(String json);
    public ResultList queryAllByUId(Integer userId);
    public boolean deleteByevaId(Integer evaId);
    public boolean updateEva(String json);
    public ResultList queryBylevel(Integer evaLevel);
    public List<String> queryImasByeId(Integer evaId);
    public double goodpanel(Integer goodId);
}

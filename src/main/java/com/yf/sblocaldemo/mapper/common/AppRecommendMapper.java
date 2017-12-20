package com.yf.sblocaldemo.mapper.common;

import com.yf.sblocaldemo.domain.common.AppRecommend;
import com.yf.sblocaldemo.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface AppRecommendMapper extends MyMapper<AppRecommend> {

    List<AppRecommend> getList(Map<String, Object> map);

}
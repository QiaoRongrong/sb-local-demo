package com.yf.sblocaldemo.service.common;


import com.yf.sblocaldemo.common.PageInfo;
import com.yf.sblocaldemo.domain.common.AppRecommend;

import java.util.List;

public interface AppRecommendService {


    List<AppRecommend> getList(Integer cateId, String cateName, PageInfo pageInfo);

    void countDownload(Integer id);
}

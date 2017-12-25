package com.yf.sblocaldemo.service.common.impl;

import com.yf.sblocaldemo.common.PageInfo;
import com.yf.sblocaldemo.domain.common.AppRecommend;
import com.yf.sblocaldemo.mapper.common.AppRecommendMapper;
import com.yf.sblocaldemo.service.common.AppRecommendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class AppRecommendServiceImpl implements AppRecommendService {

    @Autowired
    private AppRecommendMapper appRecommendMapper;

    @Override
    public List<AppRecommend> getList(Integer cateId, String cateName, PageInfo pageInfo) {
        Map<String, Object> map = new HashMap();
        map.put("offset", pageInfo.getPageInfo().getOffset());
        map.put("limit", pageInfo.getPageInfo().getLimit());


        return appRecommendMapper.getList(map);
    }

    @Override
    public void countDownload(Integer id) {
        AppRecommend form = new AppRecommend();
        form.setId(id);
        AppRecommend appRecommend = appRecommendMapper.selectByPrimaryKey(form);

        appRecommend.setDownloadCount((appRecommend.getDownloadCount() + 1));
        appRecommend.setRealDownloadCount((appRecommend.getRealDownloadCount() + 1));

        appRecommendMapper.updateByPrimaryKey(appRecommend);
    }
}

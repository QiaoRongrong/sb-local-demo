package com.yf.sblocaldemo.service.joke.impl;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;

import com.yf.sblocaldemo.common.PageInfo;
import com.yf.sblocaldemo.controller.vo.DuanziVO;
import com.yf.sblocaldemo.domain.joke.SfDuanzi;
import com.yf.sblocaldemo.domain.joke.UserOperateEnum;
import com.yf.sblocaldemo.mapper.joke.SfDuanziMapper;
import com.yf.sblocaldemo.service.joke.SfDuanziService;
import com.yf.sblocaldemo.util.CollectionUtils;
import com.yf.sblocaldemo.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class SfDuanziServiceImpl implements SfDuanziService {

    @Autowired
    private SfDuanziMapper sfDuanziMapper;

    @Override
    public List<SfDuanzi> getDuanziList(Integer labelId, String labelName, String mediaType, PageInfo pageInfo) {
        List<SfDuanzi> duanziList = getSfDuanzisByPage(pageInfo, mediaType);

        return duanziList;

    }

    @Override
    public List<DuanziVO> getDuanziVOList(Integer labelId, String labelName, String mediaType, String searchKey, PageInfo pageInfo) {
        List<DuanziVO> rawList = getDuanzisVOByPage(pageInfo, mediaType, labelName, searchKey);

        if (CollectionUtils.isEmpty(rawList)) {
            return Lists.newArrayList();
        }

        return FluentIterable.from(rawList).transform(SfDuanziServiceImpl::apply).toList();
    }

    @Override
    public boolean like(Long jokeId, Integer userId, String userOperate) {
        SfDuanzi duanzi = getById(jokeId);

        UserOperateEnum userOperateEnum = UserOperateEnum.match(userOperate);
        if (UserOperateEnum.LIKE.equals(userOperateEnum)) {
            duanzi.setGood(duanzi.getGood() + 1);
        } else if (UserOperateEnum.UNLIKE.equals(userOperateEnum)) {
            duanzi.setBad(duanzi.getBad() + 1);
        } else if (UserOperateEnum.SHARE.equals(userOperateEnum)) {
            duanzi.setShareCount(duanzi.getShareCount() + 1);
        } else {
            log.warn("What r u funking doing, buddy?");
            return false;
        }

        int updated = sfDuanziMapper.updateByPrimaryKey(duanzi);

        return updated == 1;
    }


    @Override
    public SfDuanzi getById(Long id) {
        SfDuanzi form = new SfDuanzi();
        form.setId(id);
        return sfDuanziMapper.selectByPrimaryKey(form);
    }

    /**
     * choose one duanzi then update the create time
     *
     * @return
     */
    @Override
    public SfDuanzi chooseRandomOne() {

        int randomId = new Random().nextInt(30000); // FIXME: 30/11/2017 bound???
        SfDuanzi chosenOne = getById((long) randomId);

        if (chosenOne != null) {
            chosenOne.setUserAddTime(generateRandomTime());

            sfDuanziMapper.updateByPrimaryKey(chosenOne);
            log.info("Choose One - update: {}", chosenOne.getId());
        }

        return chosenOne;
    }

    // in 10 mins
    private Date generateRandomTime() {
        Date current = new Date();
        Random random = new Random();
        int numberOfRandom = random.nextInt(10);
        return org.apache.commons.lang3.time.DateUtils.addMinutes(current, numberOfRandom);
    }

    private List<SfDuanzi> getSfDuanzisByPage(PageInfo pageInfo, String mediaType) {
        Map<String, Object> map = new HashMap();
        map.put("offset", pageInfo.getPageInfo().getOffset());
        map.put("limit", pageInfo.getPageInfo().getLimit());

        map.put("mediaType", mediaType);

        // FIXME: 29/11/2017 update sql.
        return sfDuanziMapper.getDuanziList(map);
    }

    private List<DuanziVO> getDuanzisVOByPage(PageInfo pageInfo, String mediaType, String labelName, String searchKey) {
        Map<String, Object> map = new HashMap();
        map.put("offset", pageInfo.getPageInfo().getOffset());
        map.put("limit", pageInfo.getPageInfo().getLimit());

        map.put("mediaType", mediaType);
        map.put("labelName", labelName);

        map.put("searchKey", searchKey); //内容搜索

        return sfDuanziMapper.getDuanziVOList(map);
    }

    /**
     * 对段子VO对象进行处理
     */
    private static DuanziVO apply(DuanziVO input) {
        String formated = DateUtils.format(input.getUserAddTime(), DateUtils.DATE_TIME_NO_SENCOND);
        input.setCreateTime(formated);

        input.setJid(null);
        input.setSource(null);
        input.setType(null);
        input.setUserAddTime(null);

        return input;
    }


}

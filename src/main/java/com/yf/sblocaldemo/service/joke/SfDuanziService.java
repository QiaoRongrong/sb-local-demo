package com.yf.sblocaldemo.service.joke;


import com.yf.sblocaldemo.common.PageInfo;
import com.yf.sblocaldemo.controller.vo.DuanziVO;
import com.yf.sblocaldemo.domain.joke.SfDuanzi;

import java.util.List;

public interface SfDuanziService {

    List<SfDuanzi> getDuanziList(Integer labelId, String labelName, String mediaType, PageInfo pageInfo);

    List<DuanziVO> getDuanziVOList(Integer labelId, String labelName, String mediaType, String searchKey, PageInfo pageInfo);

    boolean like(Long jokeId, Integer userId, String userOperate);

    SfDuanzi getById(Long id);

    SfDuanzi chooseRandomOne();


}

package com.yf.sblocaldemo.mapper.joke;

import com.yf.sblocaldemo.controller.vo.DuanziVO;
import com.yf.sblocaldemo.domain.joke.SfDuanzi;
import com.yf.sblocaldemo.util.MyMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface SfDuanziMapper extends MyMapper<SfDuanzi> {

    List<SfDuanzi> getDuanziList(Map<String, Object> map);

    List<DuanziVO> getDuanziVOList(Map<String, Object> map);

    /**
     *
     baoxiaoduanzi
     MeiNvFuLi
     GaoXiaoPic
     HahaMX
     GaoXiaoDongWu
     GetZhengNengLiang
     */
    @Select("select * from sf_duanzi where type = #{type}")
    List<SfDuanzi> getDuanziListByType(String type);


    @Select("SELECT dz.*, u.loginName, u.avatarImg FROM sf.sf_duanzi dz LEFT JOIN sf.user u on dz.userId = u.id where dz.id = #{id}")
    DuanziVO getDuanziVOById(Long id);

}
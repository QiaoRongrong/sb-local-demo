package com.yf.sblocaldemo.controller.vo;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Slf4j
@Setter
@Getter
public class JokeListVO {

    protected String mediaType;
    protected List<DuanziVO> duanziVOList;

    protected Integer pageOn;
    protected Integer pageSize;


}

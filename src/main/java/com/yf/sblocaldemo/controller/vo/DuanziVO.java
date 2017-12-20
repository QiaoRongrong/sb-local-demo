package com.yf.sblocaldemo.controller.vo;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.yf.sblocaldemo.domain.joke.SfDuanzi;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DuanziVO extends SfDuanzi {


    protected String loginName;
    protected String avatarImg;


}

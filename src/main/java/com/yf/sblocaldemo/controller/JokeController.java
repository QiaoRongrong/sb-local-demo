package com.yf.sblocaldemo.controller;



import com.yf.sblocaldemo.common.BaseResponse;
import com.yf.sblocaldemo.common.PageInfo;
import com.yf.sblocaldemo.controller.vo.DuanziVO;
import com.yf.sblocaldemo.controller.vo.JokeListVO;
import com.yf.sblocaldemo.service.joke.SfDuanziService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;


@Slf4j
@RequestMapping(value = "joke", produces = {APPLICATION_JSON_UTF8_VALUE})
@RestController
public class JokeController {

    @Autowired
    private SfDuanziService sfDuanziService;

    @RequestMapping(value = "dzlist", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity getDuanziList(
            @RequestParam(value = "labelId", required = false, defaultValue = "0") Integer labelId,
            @RequestParam(value = "labelName", required = false, defaultValue = "") String labelName,
            @RequestParam(value = "searchKey", required = false, defaultValue = "") String searchKey,
            @RequestParam(value = "mediaType", required = false, defaultValue = "") String mediaType,
            @Valid @Pattern(regexp = "[0-9]+") @RequestParam(value = "pageOn", required = false, defaultValue = "0") Integer pageOn,
            @Valid @Pattern(regexp = "[0-9]+") @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize
    ) {

        PageInfo pageInfo = new PageInfo(pageOn, pageSize);
        List<DuanziVO> duanziList = sfDuanziService.getDuanziVOList(labelId, labelName, mediaType, searchKey, pageInfo);

        JokeListVO jokeListVO = new JokeListVO();
        jokeListVO.setDuanziVOList(duanziList);
        jokeListVO.setMediaType(mediaType);
        jokeListVO.setPageOn(pageOn);
        jokeListVO.setPageSize(pageSize);

        BaseResponse baseResponse = BaseResponse.buildSuccessResponse(jokeListVO);

        return new ResponseEntity(baseResponse, HttpStatus.OK);
    }


//    @ApiOperation(value = "点赞", response = JokeVO.class, responseContainer = "List")
//    @RequestMapping(value = "like", method = {RequestMethod.GET, RequestMethod.POST})
//    public ResponseEntity like(Long jokeId, Integer userId, String userOperateEnum) {
//
//        boolean result = sfDuanziService.like(jokeId, userId, userOperateEnum);
//
//        BaseResponse baseResponse = BaseResponse.buildSuccessResponse(result);
//
//        return new ResponseEntity(baseResponse, HttpStatus.OK);
//    }


}

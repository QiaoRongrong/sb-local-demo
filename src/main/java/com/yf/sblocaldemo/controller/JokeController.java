package com.yf.sblocaldemo.controller;



import com.yf.sblocaldemo.common.BaseResponse;
import com.yf.sblocaldemo.common.PageInfo;
import com.yf.sblocaldemo.controller.vo.DuanziVO;
import com.yf.sblocaldemo.controller.vo.JokeListVO;
import com.yf.sblocaldemo.domain.joke.SfDuanzi;
import com.yf.sblocaldemo.service.joke.SfDuanziService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value="获取段子列表", notes="分页获取,并提供搜索支持")
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

    @ApiOperation(value = "根据Id获取段子", response = SfDuanzi.class, responseContainer = "")
    @RequestMapping(value = "dz-content", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity getDuanziById(
            @Pattern(regexp = "[0-9]+") @RequestParam(value = "dzId", defaultValue = "0") Long dzId) {

        BaseResponse baseResponse;
        if (dzId == 0) {
            baseResponse = BaseResponse.buildResponse(1001, "参数为空", null);
        } else {
            DuanziVO vo = sfDuanziService.getDuanziVOById(dzId);
            baseResponse = BaseResponse.buildSuccessResponse(vo);
        }

        return new ResponseEntity(baseResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "点赞", response = DuanziVO.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jokeId", value = "段子ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "userOperateEnum", value = "用户操邹:{LIKE, UNLIKE, SHARE}", required = true, dataType = "String")
    })
    @RequestMapping(value = "like", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity like(Long jokeId, Integer userId, String userOperateEnum) {

        boolean result = sfDuanziService.like(jokeId, userId, userOperateEnum);

        BaseResponse baseResponse = BaseResponse.buildSuccessResponse(result);

        return new ResponseEntity(baseResponse, HttpStatus.OK);
    }


}

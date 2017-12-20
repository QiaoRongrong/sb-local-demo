package com.yf.sblocaldemo.controller;


import com.yf.sblocaldemo.common.BaseResponse;
import com.yf.sblocaldemo.domain.common.Feedback;
import com.yf.sblocaldemo.service.common.FeedbackService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Slf4j
@RequestMapping(value = "feedback", produces = {APPLICATION_JSON_UTF8_VALUE})
@RestController
@Api(value = "/feedback", tags = "feedbackApi", description = "意见反馈接口")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping(value="/add", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResponseEntity feedback(HttpServletRequest request, Integer uid, String content, String contactInformation){
        BaseResponse baseResponse = BaseResponse.buildSuccessResponse("Succeed");
        try {
            String channel = request.getParameter("channel");
            Integer channelInt = StringUtils.isEmpty(channel) ? 0 : Integer.parseInt(channel);

            Feedback feedback = Feedback.of(uid, channelInt, contactInformation, content, new Date(), 0);
            feedbackService.insertFeedback(feedback);

        } catch (Exception e) {
            log.error("意见反馈失败", e);
            baseResponse = BaseResponse.buildFailResponse(9999, "异常");
        }
        return new ResponseEntity(baseResponse, HttpStatus.OK);
    }


}

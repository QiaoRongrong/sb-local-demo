package com.yf.sblocaldemo.domain.common;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "feedback")
public class Feedback implements Serializable {

	private static final long serialVersionUID = -8258260781870314633L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 意见提交人id
     */
    @Column(name = "userId")
    private Integer userId;

    /**
     * 反馈渠道
     */
    private Integer channel;

    /**
     * 联系方式
     */
    @Column(name = "contactInformation")
    private String contactInformation;

    /**
     * 意见内容
     */
    private String content;

    /**
     * 意见提交时间
     */
    @Column(name = "feedbackTime")
    private Date feedbackTime;

    /**
     * 处理结果
     */
    @Column(name = "handleResult")
    private String handleResult;

    /**
     * 处理时间
     */
    @Column(name = "handleTime")
    private Date handleTime;
    /**
     * 处理人id
     */
    @Column(name = "handleId")
    private Integer handleId;

    /**
     * 状态（0未处理，1已处理）
     */
    private Integer status;

    public static Feedback of(Integer userId, Integer channel, String contactInformation,
                              String content, Date feedbackTime, Integer status) {

        Feedback feedback = new Feedback();
        feedback.setUserId(userId);
        feedback.setChannel(channel);
        feedback.setContactInformation(contactInformation);
        feedback.setContent(content);
        feedback.setFeedbackTime(feedbackTime);
        feedback.setStatus(status);

        return feedback;
    }


    
    

}
package com.yf.sblocaldemo.domain.joke;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Table(name = "sf_duanzi")
public class SfDuanzi implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * 小图片地址
     */
    @Column(name = "smallImage")
    protected String smallImage;

    /**
     * 大图片地址
     */
    @Column(name = "bigImage")
    protected String bigImage;

    /**
     * 段子id
     */
    protected Long jid;

    /**
     * 点赞数
     */
    protected Long good;

    /**
     * 拍砖数
     */
    protected Long bad;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    protected String createTime;

    /**
     * 爬取来源
     */
    protected String source;

    /**
     * 段子类型
     */
    protected String type;

    /**
     * 0-normal; 1-forbidden
     */
    protected Integer status;

    /**
     * userId
     */
    @Column(name = "userId")
    protected Long userId;

    /**
     * 上架时间
     */
    @Column(name = "userAddTime")
    protected Date userAddTime;

    /**
     * 段子内容
     */
    protected String content;


    @Column(name = "shareCount")
    protected Integer shareCount;

    @Column(name = "mediaType")
    protected String mediaType;


    @Column(name = "labelName")
    protected String labelName;

    @Column(name = "labelId")
    protected Integer labelId;


}
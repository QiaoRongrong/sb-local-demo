package com.yf.sblocaldemo.domain.common;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "app_recommend")
public class AppRecommend {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述/介绍
     */
    private String descpt;

    /**
     * 下载地址
     */
    @Column(name = "downloadUrl")
    private String downloadUrl;

    /**
     * icon下载地址
     */
    @Column(name = "iconDownloadUrl")
    private String iconDownloadUrl;

    /**
     * 开发者
     */
    private String developer;

    /**
     * 分数
     */
    private String score;

    /**
     * 平分次数
     */
    @Column(name = "scoreTimes")
    private Integer scoreTimes;

    /**
     * 显示下载次数
     */
    @Column(name = "downloadCount")
    private Integer downloadCount;

    /**
     * real下载次数
     */
    @Column(name = "realDownloadCount")
    private Integer realDownloadCount;

    /**
     * 大小 43.67M
     */
    private String size;

    /**
     * slogan 标语
     */
    private String slogan;

    /**
     * 分类
     */
    private String category;

    /**
     * 支持平台
     */
    @Column(name = "supportedPltf")
    private String supportedPltf;

    /**
     * 应用图片
     */
    private String images;

    /**
     * 状态（0显示，1不显示）
     */
    private Integer status;

    /**
     * 添加用户id
     */
    @Column(name = "sysUserId")
    private Integer sysUserId;

    /**
     * 提交时间
     */
    @Column(name = "updTime")
    private Date updTime;


}
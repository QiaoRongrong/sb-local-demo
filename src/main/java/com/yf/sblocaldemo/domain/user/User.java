package com.yf.sblocaldemo.domain.user;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;

    /**
     * 登录名
     */
    @Column(name = "loginName")
    private String loginName;

    /**
     * 登录密码
     */
    @Column(name = "loginPwd")
    private String loginPwd;

    /**
     * phone
     */
    private String phone;

    /**
     * 头像图片路径
     */
    @Column(name = "avatarImg")
    private String avatarImg;

    /**
     * 上次登录密码修改时间
     */
    @Column(name = "loginpwdModifyTime")
    private Date loginpwdModifyTime;

    /**
     * 注册时间
     */
    @Column(name = "registTime")
    private Date registTime;

    /**
     * 注册客户端
     */
    @Column(name = "registerClient")
    private String registerClient;

    /**
     * 邀请码
     */
    @Column(name = "invitationCode")
    private String invitationCode;

    /**
     * 渠道
     */
    @Column(name = "channelId")
    private Long channelId;

    /**
     * 代理等级 ，1一级，2二级，3普通用户
     */
    private String level;

    /**
     * 登录时间
     */
    @Column(name = "loginTime")
    private Date loginTime;


}
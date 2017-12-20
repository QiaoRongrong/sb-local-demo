package com.yf.sblocaldemo.domain.joke;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "joke")
public class Joke implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String content;

    @Column(name = "likeCount")
    private Integer likeCount;  //赞

    @Column(name = "unlikeCount")
    private Integer unlikeCount;  //踩

    @Column(name = "shareCount")
    private Integer shareCount;  //

    private String type;  //

    @Column(name = "formatType")
    private String formatType; // text, image, gif, video

    @Column(name = "openDate")
    private Date openDate;

    @Column(name = "originLink")
    private String originLink;  //原段子链接

    @Column(name = "imgPathS")
    private String imgPathS;  // 小图 路径  分号分割

    @Column(name = "originImgSLink")
    private String originImgSLink;  //原图片链接

    @Column(name = "imgPathB")
    private String imgPathB; // 大图 路径  分好分割

    @Column(name = "originImgBLink")
    private String originImgBLink;  //原图片链接 分号分割

    @Column(name = "videoPath")
    private String videoPath;

    @Column(name = "videoLink")
    private String videoLink;

    @Column(name = "addUserId")
    private Integer addUserId;

    @Column(name = "addTime")
    private Date addTime;

    @Column(name = "status")
    private Integer status; //0 - normal; 1 - forbidden

    @Column(name = "labelIds")
    private String labelIds; //分好分割

}

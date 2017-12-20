package com.yf.sblocaldemo.domain.common;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "app_version")
public class AppVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "currentVersion")
    private String currentVersion;  //当前版本

    @Column(name = "targetVersion")
    private String targetVersion;   //升级到的版本


    @Column(name = "forceUpgrade")
    private Integer forceUpgrade;   //是否强制升级 1 是, 0 否

    @Column(name = "minVersion")
    private String minVersion;

    @Column(name = "forceUpgradeMinVersion")
    private Integer forceUpgradeMinVersion;  // 是否强制升级到最小的版本 1 是, 0 否

    private Integer status;

    private String content; //更新内容

    @Column(name = "updTime")
    private Date updTime;
}
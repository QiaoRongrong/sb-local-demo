package com.yf.sblocaldemo.mapper.common;

import com.yf.sblocaldemo.domain.common.AppVersion;
import tk.mybatis.mapper.common.MySqlMapper;


public interface AppVersionMapper extends MySqlMapper<AppVersion> {

    AppVersion getAppVersion();

}
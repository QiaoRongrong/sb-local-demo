package com.yf.sblocaldemo.domain.joke;

import org.apache.commons.lang3.StringUtils;

public enum UserOperateEnum {

    LIKE,
    UNLIKE,
    SHARE,
    COMMENT,

    OTHER;

    public static UserOperateEnum match(String operate) {
        for (UserOperateEnum operateEnum : UserOperateEnum.values()) {
            if (StringUtils.endsWith(operateEnum.name(), operate)) {
                return operateEnum;
            }
        }

        return OTHER;
    }
}

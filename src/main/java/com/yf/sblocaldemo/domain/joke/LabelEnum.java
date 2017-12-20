package com.yf.sblocaldemo.domain.joke;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
@AllArgsConstructor
public enum LabelEnum {

    BAOXIAODUANZI("爆笑段子", "段子手", 1),
    MEINVFULI("美女福利", "羞羞的福利", 2),
    GAOXIAOPIC("搞笑图片", "逗逗的小图", 3),
    HAHAMX("哈哈MX", "最羞逗", 4),
    GAOXIAODONGWU("搞笑动物", "飞禽走兽", 5),
    GETZHENGNENGLIANG("get正能量", "心灵鸡汤", 6),

    OTHER("未匹配", "未匹配", 0);

    private String fromLabelName;
    private String sfLabelName;
    private Integer labelId;  // come from DB, primary Key

    public static LabelEnum match(String type) {
        for (LabelEnum labelEnum : LabelEnum.values()) {
            if (StringUtils.equalsIgnoreCase(labelEnum.name(), type)) {
                return labelEnum;
            }
        }

        return OTHER;
    }





}

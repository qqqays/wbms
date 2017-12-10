package com.shuwang.wbms.common.enums;

/**
 * Created by Q-ays.
 * 12-10-2017 23:36
 */
public enum  DisplayEnum {
    NONE(0),
    TOP(1),
    FOOT(2),
    BOTH(3);

    private Integer dpl;

    DisplayEnum(Integer dpl) {
        this.dpl = dpl;
    }

    public Integer getDpl() {
        return dpl;
    }

}

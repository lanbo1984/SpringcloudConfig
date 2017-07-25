package com.coolq.ap.common.datasource.annotation;

/**
 * 主从库枚举
 */
public enum DbMsEnum {
    SCHEDB("schedbDs"),  // 主库
    OOZIE("oozieDs");  // oozie库

    private final String s;

    public String get() {
        return this.s;
    }

    DbMsEnum(String s) {
        this.s = s;
    }
}

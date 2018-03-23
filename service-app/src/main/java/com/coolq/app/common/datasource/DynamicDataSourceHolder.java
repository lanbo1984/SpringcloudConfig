package com.coolq.app.common.datasource;

public class DynamicDataSourceHolder {

    public static final ThreadLocal<String> holder = new InheritableThreadLocal<String>();

    public static void putDataSource(String name) {
        holder.set(name);
    }

    public static String getDataSource() {
        return holder.get();
    }
}

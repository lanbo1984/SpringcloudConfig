package com.coolq.ap.datasource.annotation;

import com.coolq.ap.datasource.DynamicDataSourceHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源，根据相应规则，可自主选择
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final Logger log = LoggerFactory.getLogger(DynamicDataSource.class);


    protected Object determineCurrentLookupKey() {
        Object obj = DynamicDataSourceHolder.getDataSource();
        log.info("get current datasource is {}", obj);
        return obj;
    }


}

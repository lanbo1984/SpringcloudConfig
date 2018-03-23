package com.coolq.app.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.coolq.app.common.datasource.annotation.DynamicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lanbo
 * @Description:
 * @date 17/7/20
 */
@Configuration
@MapperScan("com.coolq.ap.mapper")
@EnableTransactionManagement
public class DataSourceConfig {

    @Autowired
    private Environment env;

    /**
     * 数据库1
     *
     * @return
     */
    public DruidDataSource schedbDs() {
        return createDataSource(env.getProperty("schedb.url"), env.getProperty("schedb.username"), env.getProperty("schedb.password"));
    }

    /**
     * 数据库2
     *
     * @return
     */
    public DruidDataSource oozieDs() {
        return createDataSource(env.getProperty("oozie.url"), env.getProperty("oozie.username"), env.getProperty("oozie.password"));
    }

    @Bean
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();

        Map<Object, Object> map = new HashMap<>();
        map.put("schedbDs", this.schedbDs());
        map.put("oozieDs", this.oozieDs());
        //设置数据源
        dynamicDataSource.setTargetDataSources(map);

        //设置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(this.schedbDs());
        return dynamicDataSource;
    }

    public DruidDataSource createDataSource(String url, String username, String password) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setInitialSize(30);
        dataSource.setMaxActive(100);
        dataSource.setMinIdle(0);
        dataSource.setMaxWait(60000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnReturn(false);
        dataSource.setPoolPreparedStatements(false);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        return dataSource;
    }

}

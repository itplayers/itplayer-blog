package com.itplayer.dbconfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author caijun.yang
 * @date 2018/10/11
 */
@Configuration
@PropertySource(value = {"classpath:jdbc.properties"})
public class DataSourceConfig {
    @Value("${db.driverClassName}")
    private String driverClassName;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Value("${db.initialSize}")
    private int initialSize;
    @Value("${db.maxActive}")
    private int maxActive;
    @Value("${db.maxWait}")
    private int maxWait;
    @Value("${db.minIdle}")
    private int minIdle;
    @Value("${db.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    @Value("${db.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;
    @Value("${db.validationQuery}")
    private String validationQuery;
    @Value("${db.testWhileIdle}")
    private Boolean testWhileIdle;
    @Value("${db.testOnBorrow}")
    private Boolean testOnBorrow;
    @Value("${db.testOnReturn}")
    private Boolean testOnReturn;
    @Value("${db.poolPreparedStatements}")
    private Boolean poolPreparedStatements;
    @Value("${db.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
//        DruidDataSource druidDataSource = new DruidDataSource();
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setPassword(password);
        druidDataSource.setUsername(username);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);

        return druidDataSource;
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}

package com.newroad.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.google.common.collect.Lists;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DruidConfig {
    /*
     * 将application.properties和类绑定
     * 将bean方法的返回对象与外部的配置文件绑定
     */
    @ConfigurationProperties(prefix = "spring.druid")
    @Bean(initMethod="init",destroyMethod = "close")
    public DruidDataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        //将慢日志的功能加入druid
        druidDataSource.setProxyFilters(Lists.newArrayList(statFilter()));
        return druidDataSource;
    }

    /**
     * Druid自带的慢sqlfilter
     * @return
     */
    @Bean
    public Filter statFilter(){
        StatFilter statFilter=new StatFilter();
        statFilter.setSlowSqlMillis(1);
        statFilter.setMergeSql(true);
        return statFilter;
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new StatViewServlet(),
                "/druid/*");
    }
}

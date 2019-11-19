package com.in.market.config;

import com.github.pagehelper.PageHelper;
import org.aopalliance.intercept.Interceptor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Mybatis的配置类
 * @author TheSevenSky
 */
@MapperScan("com.in.market.dao")
@Configuration
public class MybatisConfig {
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
//                configuration.setLazyLoadingEnabled(true);
//                configuration.setAggressiveLazyLoading(false);
            }
        };
    }

//    @Bean
//    PageHelper pageHelper(){
//        //分页插件
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("reasonable", "true");
//        properties.setProperty("supportMethodsArguments", "true");
//        properties.setProperty("returnPageInfo", "check");
//        properties.setProperty("params", "count=countSql");
//        pageHelper.setProperties(properties);
//
//        //添加插件
//        new SqlSessionFactoryBean().setPlugins(new Interceptor[]{pageHelper});
//        return pageHelper;
//    }

}

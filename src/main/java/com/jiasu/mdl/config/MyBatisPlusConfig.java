package com.jiasu.mdl.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * <p>
 * mybatis config
 * </p>
 *
 * @author gaopeng
 * @since 2022-06-01
 */
@Configuration
@MapperScan("com.jiasu.mdl.mapper")
public class MyBatisPlusConfig {

    /**
     * sql性能拦截器 在dev/qa生效
     *
     * @return
     */
    @Bean
    @Profile({"dev", "qa"})
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    /**
     * version乐观锁拦截器
     *
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
//		注解实体字段 @Version 必须要!
//		仅支持 updateById(id) 与 update(entity, wrapper) 方法

//		if(userService.updateById(u)){
//		    System.out.println("Update successfully");
//		}else{
//		    System.out.println("Update failed due to modified by others");
//		}
        return new OptimisticLockerInterceptor();
    }

    /**
     * 分页拦截器
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 逻辑删除
     *
     * @return
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }
}

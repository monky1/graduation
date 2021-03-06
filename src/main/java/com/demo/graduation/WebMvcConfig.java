/*
 * #{copyright}#
 */
package com.demo.graduation;

import com.demo.graduation.com.pudding.core.message.CacheMessageSource;
import com.demo.graduation.com.pudding.core.web.BaseWebMvcConfig;
import com.demo.graduation.common.constant.Constant;
//import com.pudding.core.message.CacheMessageSource;
//import com.pudding.core.web.BaseWebMvcConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author chenjingxiong
 */
@Configuration
public class WebMvcConfig extends BaseWebMvcConfig {

    @Autowired
    private CacheManager cacheManager;

    @Bean
    public MessageSource messageSource() {
        Cache cache = cacheManager.getCache(Constant.MESSAGE_CACHE_NAME + Constant.RDS_KEY_SEPARATOR + Constant.DEFAULT_APPLICATION_ID);
        CacheMessageSource cacheMessageSource = new CacheMessageSource(cache);
        return cacheMessageSource;
    }
}

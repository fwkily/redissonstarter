package com.fwkily.redissonstarter;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RedissonProperties.class)
public class RedissonAutoConfiguration {
    @Bean
    public RedissonClient getRedissonClient(RedissonProperties redissonProperties){
        Config config=new Config();
        String prefix="redis://";
        if(redissonProperties.isSsl()){
            prefix="rediss://";
        }
         config.useSingleServer()
                 .setAddress(prefix+redissonProperties.getPost()+":"+redissonProperties.getPort())
                 .setTimeout(redissonProperties.getTimeout());
        return Redisson.create(config);
    }
 
}
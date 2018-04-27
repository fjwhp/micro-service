package com.whp.config.redis;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.alibaba.fastjson.parser.ParserConfig;
/**
 * 
 * @描述：redis缓存配置
 *
 * @作者：wuhp
 * 
 * @时间：2018年3月16日 下午2:18:06
 */
//@Configuration TODO
public class RedisConfig  extends CachingConfigurerSupport {
  /**
   * 重写Redis序列化方式，使用Json方式:
   * 当我们的数据存储到Redis的时候，我们的键（key）和值（value）都是通过Spring提供的Serializer序列化到数据库的。RedisTemplate默认使用的是JdkSerializationRedisSerializer，StringRedisTemplate默认使用的是StringRedisSerializer。
   * Spring Data JPA为我们提供了下面的Serializer：
   * GenericToStringSerializer、Jackson2JsonRedisSerializer、JacksonJsonRedisSerializer、JdkSerializationRedisSerializer、OxmSerializer、StringRedisSerializer。
   * 在此我们将自己配置RedisTemplate并定义Serializer。
   *
   * @param redisConnectionFactory
   * @return
   */
  @Bean
  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
      RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
      redisTemplate.setConnectionFactory(redisConnectionFactory);
      
      FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
      // 全局开启AutoType，不建议使用
      // ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
      // 建议使用这种方式，小范围指定白名单
      //ParserConfig.getGlobalInstance().addAccept("com.xiaolyuh.");
      ParserConfig.getGlobalInstance().addAccept("com.whp.");
      // 设置值（value）的序列化采用FastJsonRedisSerializer。
      redisTemplate.setValueSerializer(fastJsonRedisSerializer);
      redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);
      // 设置键（key）的序列化采用StringRedisSerializer。
      redisTemplate.setKeySerializer(new StringRedisSerializer());
      redisTemplate.setHashKeySerializer(new StringRedisSerializer());

      redisTemplate.afterPropertiesSet();
      return redisTemplate;
  }
}

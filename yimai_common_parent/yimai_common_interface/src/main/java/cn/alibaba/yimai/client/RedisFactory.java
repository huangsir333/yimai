package cn.alibaba.yimai.client;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class RedisFactory implements FallbackFactory<RedisClient>{
    /*
    * 这里配置托底方法
    * */
    public RedisClient create(Throwable throwable) {
        return new RedisClient() {
            public void set(String key, String value) {

            }

            public String get(String key) {
                return null;
            }
        };
    }
}

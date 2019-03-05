package cn.alibaba.yimai.client;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PageStaticFactory implements FallbackFactory<PageStaticClient> {

    public PageStaticClient create(Throwable throwable) {
        return new PageStaticClient() {
            public void getPageStatic(Map<String, Object> map) {

            }
        };
    }
}

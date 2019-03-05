package cn.alibaba.yimai.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(value = "COMMON-PROVIDER",fallbackFactory = PageStaticFactory.class)
@RequestMapping("/common")
public interface PageStaticClient {

    @RequestMapping(value = "/page",method = RequestMethod.POST)
    void getPageStatic(@RequestBody Map<String,Object> map);


}

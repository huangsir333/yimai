package cn.alibaba.yimai.controller;

import cn.alibaba.yimai.client.RedisClient;
import cn.alibaba.yimai.util.RedisUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/common")
public class RedisController implements RedisClient {

    @RequestMapping(value = "/redis",method = RequestMethod.POST)
    public void set(@RequestParam("key") String key, @RequestParam("value") String value) {
        RedisUtil.set(key, value);
    }

    @RequestMapping(value = "/redis/{key}",method = RequestMethod.GET)
    public String get(@PathVariable("key") String key) {
        return RedisUtil.get(key);
    }
}

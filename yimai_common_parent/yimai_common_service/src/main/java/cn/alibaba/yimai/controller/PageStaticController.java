package cn.alibaba.yimai.controller;

import cn.alibaba.yimai.client.PageStaticClient;
import cn.alibaba.yimai.util.GlobelConstants;
import cn.alibaba.yimai.util.VelocityUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
@RequestMapping("/common")
public class PageStaticController implements PageStaticClient {

    @RequestMapping(value = "/page",method = RequestMethod.POST)
    public void getPageStatic(@RequestBody Map<String, Object> map) {
        //逻辑实现:
        Object model = map.get(GlobelConstants.PAGE_MODE);
        String templateFilePathAndName = (String) map.get(GlobelConstants.PAGE_TEMPLATE);
        String targetFilePathAndName = (String) map.get(GlobelConstants.PAGE_TEMPLATE_HTML);

        VelocityUtils.staticByTemplate(model, templateFilePathAndName, targetFilePathAndName);
    }
}

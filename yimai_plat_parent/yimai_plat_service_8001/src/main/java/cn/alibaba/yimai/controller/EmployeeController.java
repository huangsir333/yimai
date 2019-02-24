package cn.alibaba.yimai.controller;

import cn.alibaba.yimai.domain.Employee;
import cn.alibaba.yimai.util.AjaxResult;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@EnableEurekaClient
@RequestMapping("/employee")
public class EmployeeController {
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public AjaxResult longin(@RequestBody Employee employee){

        if ("admin".equals(employee.getName())&&"admin".equals(employee.getPassword())){
            return AjaxResult.get();
        }else {

            return AjaxResult.get().setSuccess(false).setMsg("登录出错");
        }
    }
}

package cn.alibaba.yimai.controller;

import cn.alibaba.yimai.util.AjaxResult;

public class xx {
    public static void main(String[] args) {
        /*AjaxResult ajaxResult=new meAjaxResult();
        System.out.println(ajaxResult);*/
//        链式编程；
        AjaxResult.me().setMsg("123").setSuccess(false).setMsg("123");

    }
}

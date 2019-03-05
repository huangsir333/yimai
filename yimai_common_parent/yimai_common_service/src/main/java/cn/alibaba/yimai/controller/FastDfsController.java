package cn.alibaba.yimai.controller;

import cn.alibaba.yimai.util.AjaxResult;
import cn.alibaba.yimai.util.FastDfsApiOpr;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/common")
public class FastDfsController {


    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public AjaxResult upload(@RequestBody MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);
        //获取文件的后缀，用于工具类操作
        String extName = FilenameUtils.getExtension(originalFilename);
        System.out.println(extName);
        try {
            String filePath = FastDfsApiOpr.upload(file.getBytes(), extName);
            return AjaxResult.me().setSuccess(true).setMsg("上传成功").setObject(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("上传失败"+e.getMessage());
        }

    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public AjaxResult delete(@RequestParam("filepath") String filepath){
        try {
            // 前台在传的时候: 第一个是 /
            // filePath = /group1/M00/00/01/rBAHllx6scGAUV9WAACIceIBrog953.jpg
            String filepath1 = filepath.substring(1);
            String group = filepath1.substring(0, filepath1.indexOf("/"));
            String filename= filepath1.substring(filepath1.indexOf("/")+1);
            int delete = FastDfsApiOpr.delete(group, filename);
            if(delete==0){
                return AjaxResult.me().setSuccess(true).setMsg("删除成功");
            }else {
                return AjaxResult.me().setSuccess(false).setMsg("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("删除失败");
        }
    }

    public static void main(String[] args) {
       String filePath  = "/group1/M00/00/01/rBAHllx6l32AHfQtAAEu5hxxfm4554.jpg";
        //group1
        String s = filePath.substring(0, filePath.indexOf("/"));
        System.out.println(s);
//        /M00/00/01/rBAHllx6l32AHfQtAAEu5hxxfm4554.jpg
        System.out.println(filePath.substring(filePath.indexOf("/")));
//        substring把前面的抛掉保留后面的
        System.out.println(filePath.substring(1));
    }

}

package com.poewrnode.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * User: hallen
 * Date: 2023/8/21
 * Time: 23:37
 */
@Controller
public class UploadController2 {

    //多文件上传
    @PostMapping("/uploadFile2")
    public String uploadFile(@RequestParam("upfile") MultipartFile[] multipartFiles) {
        System.out.println("开始处理上传文件");
        Map<String, String> map = new HashMap<>();
        for (MultipartFile multipartFile : multipartFiles) {
            try {
                //判断上传了文件
                if (!multipartFile.isEmpty()) {
                    map.put("上传文件参数名称", multipartFile.getName());
                    map.put("内容类型", multipartFile.getContentType());
                    var ext = "unknown";
                    var filename = multipartFile.getOriginalFilename();//原始文件名称
                    if (filename.indexOf(".") > 0) {
                        ext = filename.substring(filename.lastIndexOf(".") + 1);
                    }
                    //生成服务使用的的文件名称
                    var newFileName = UUID.randomUUID().toString() + "." + ext;
                    var path = "//Users/hallen/Decuments/Code/" + newFileName;
                    //把文件存放在path目录
                    multipartFile.transferTo(new File(path));
                    map.put("文件名称", newFileName);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(map);
        //重定向
        return "redirect:/index.html";
    }
}
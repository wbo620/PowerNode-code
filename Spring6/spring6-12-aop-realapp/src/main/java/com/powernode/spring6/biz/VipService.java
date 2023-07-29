package com.powernode.spring6.biz;

import org.springframework.stereotype.Service;

@Service
public class VipService {
    public void saveVip(){
        System.out.println("保存Vip信息");
    }

    public void deleteVip(){
        System.out.println("删除Vip信息");
    }

    public void modifyVip(){
        System.out.println("修改Vip信息");
    }
    public void getVip(){
        System.out.println("获取Vip信息");
    }
}

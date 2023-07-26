package com.powernode.client;

import com.powernode.annoatation.Component;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReflectAnnotationTest1 {
    // 获取com.powernode.bean包里的User类
    // 并把带有Compont注解的类通过反射机制创建对象并放入map集合中曝光
    public static void main(String[] args) {

        Map<String, Object> beanMap = new HashMap<String, Object>();
        String packageName = "com.powernode.bean";
        //把包替换成路径
        String packagePath = packageName.replaceAll("\\.", "/");
        //获取根路径
        URL url = ClassLoader.getSystemClassLoader().getResource(packagePath);
        // System.out.println(url);
        //获取绝对路径
        String path = url.getPath();
        //System.out.println(path);
        //扫描该路径下的文件(类)
        File file = new File(path);
        File[] files = file.listFiles();
        //取类名
        Arrays.stream(files).forEach(f -> {
            try {
                //System.out.println(f.getName().split("\\.")[0]);
                //获取各个文件的全类名
                String className = packageName + "." + f.getName().split("\\.")[0];
                // System.out.println(className);
                //创建对象
                Class<?> aClass = Class.forName(className);
                // System.out.println(aClass);
                //判断是否包含component注解,
                if (aClass.isAnnotationPresent(Component.class)) {
                    //包含此注解的获取注解
                    Component annotation = aClass.getAnnotation(Component.class);
                    //获取注解中的id值
                    String id = annotation.value();
                    //有这个注解的创建对象
                    Object obj = aClass.newInstance();
                    //加入到map集合中进行曝光
                    beanMap.put(id, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(beanMap);

    }
}

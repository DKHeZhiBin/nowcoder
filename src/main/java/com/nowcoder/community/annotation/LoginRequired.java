package com.nowcoder.community.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//该注解的作用是检查登录状态，防止有人直接输入网址进入到修改个人信息界面和上传文件界面进行操作
//利用拦截器去实现对该注解的操作
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginRequired {



}

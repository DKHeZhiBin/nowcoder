package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import com.nowcoder.community.util.CommunityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/k423")
    public void http(HttpServletRequest request, HttpServletResponse response){
        //获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration <String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println("name:" + name + "value: " + value);
        }
        System.out.println(request.getParameter("code"));

        //返回相应数据
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write("<h1>牛客网</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            writer.close();
        }
    }

    //Get请求
    // /students?limit=20&current=2
    @RequestMapping(path = "/students",method= RequestMethod.GET)
    @ResponseBody
    public  String getStudents(@RequestParam(name="current",required = false,defaultValue = "1") int current, int limit){
        return "some students";
    }

    //Get请求
    // /students?limit=20&current=2
    @RequestMapping(path = "/students/{id}",method= RequestMethod.GET)
    @ResponseBody
    public  String getStudents1(@PathVariable("id") int id){
        return ""+id;
    }

    //POST请求
    @RequestMapping(path = "/addstudents",method= RequestMethod.POST)
    @ResponseBody
    public  String addStudents(String name,int age){
        return ""+name + age;
    }

    //相应html数据
    @RequestMapping(path = "/teacher",method= RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","张三");
        mav.addObject("age","12");
        mav.setViewName( "/teacher");
        return mav;
    }

    //与上一种效果等同，开发推荐用这种
    @RequestMapping(path = "/school",method= RequestMethod.GET)
    public  String getSchool(Model model){
       model.addAttribute("name","斯坦福大学");
       model.addAttribute("age","12");
        return "/teacher";
    }

    // 相应json数据（异步请求）
    //java对象 -> 利用json ->JS对象
    @RequestMapping(path = "/emp",method= RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEMP(){
        Map<String,Object> emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age","15");
        emp.put("salary","1222");
        return emp;
    }

    @RequestMapping(path = "/emps",method= RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getEMPs(){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age","15");
        emp.put("salary","1222");

        emp = new HashMap<>();
        emp.put("name","李四");
        emp.put("age","23");
        emp.put("salary","412");
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name","王五");
        emp.put("age","12");
        emp.put("salary","524");
        list.add(emp);

        return list;
    }

    // cookie示例

    @RequestMapping(path = "/cookie/set", method = RequestMethod.GET)
    @ResponseBody
    public String setCookie(HttpServletResponse response) {
        // 创建cookie
        Cookie cookie = new Cookie("code", CommunityUtil.generateUUID());
        // 设置cookie生效的范围
        cookie.setPath("/community/alpha");
        // 设置cookie的生存时间 这样即使关闭了浏览器也不会消失
        cookie.setMaxAge(60 * 10);
        // 发送cookie
        response.addCookie(cookie);

        return "set cookie";
    }

    @RequestMapping(path = "/cookie/get", method = RequestMethod.GET)
    @ResponseBody
    public String getCookie(@CookieValue("code") String code) {
        System.out.println(code);
        return "get cookie";
    }

    // session示例

    @RequestMapping(path = "/session/set", method = RequestMethod.GET)
    @ResponseBody
    public String setSession(HttpSession session) {
        session.setAttribute("id", 1);
        session.setAttribute("name", "Test");
        return "set session";
    }

    @RequestMapping(path = "/session/get", method = RequestMethod.GET)
    @ResponseBody
    public String getSession(HttpSession session) {
        System.out.println(session.getAttribute("id"));
        System.out.println(session.getAttribute("name"));
        return "get session";
    }

}

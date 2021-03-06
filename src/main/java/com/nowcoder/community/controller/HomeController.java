package com.nowcoder.community.controller;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.Page;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService userService;

    @RequestMapping(path="/index",method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        //方法调用前，springmvc会自动实例化model和page，并将page注入到model中，
        //所以，在thymeleaf中可以直接访问page对象中的数据，不需要再model.addAttribute
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> list= discussPostService.findDiscussPosts(0,page.getOffset(),page.getLimit());
        List<Map<String,Object>> discussposts = new ArrayList<>();
        if(list != null){
            for(DiscussPost post:list){
                Map<String,Object> map = new HashMap<>();
                map.put("post",post);
                map.put("user",userService.findUserById(post.getUserId()));
                discussposts.add(map);
            }
        }
        model.addAttribute("discussPosts",discussposts);
        return "/index";
    }
}

package com.controller.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.model.Blog;
import com.model.Blogger;
import com.model.Comment;
import com.service.BlogService;
import com.service.CommentService;
import com.util.ResponseUtil;

/**
 * @Description 前台评论控制器
 */
@Controller
@RequestMapping(value = "/comment")
public class CommentWebController {

    @Resource
    private CommentService commentService;
    @Resource
    private BlogService blogService;
 
    //评论更新或者添加
    @RequestMapping(value = "save")
    public  String save(
            Comment comment,
            @RequestParam("imageCode")String imageCode, //前台传来的验证码
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session) throws Exception {
        String sRand = (String) session.getAttribute("sRand");//获取session中正确的验证码，验证码产生后会存到session中的
        JSONObject result = new JSONObject();
        int resultTotal = 0; //执行记录数
        if(!imageCode.equals(sRand)){
            result.put("success",false);
            result.put("errorInfo","验证码有误");
        }else{
        	Blogger blogger = (Blogger) request.getSession().getAttribute("user");
        	comment.setUname(blogger.getNickname());;
        	comment.setUserid(blogger.getId());
        	String cdate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        	comment.setCdate(cdate);
        	comment.setState(1);
            if(comment.getId() == null){
                resultTotal = commentService.insertComment(comment); //添加评论
                Blog blog = blogService.queryBlogById(comment.getBlogid()); //更新一下博客的评论次数
                blog.setReplyhit(blog.getReplyhit() + 1);
                blogService.updateBlog(blog);
            }else{
                //更新操作
            }
        }
        if(resultTotal > 0) {
            result.put("success", true);
        }
        ResponseUtil.write(response, result);
        return null;
    }

}

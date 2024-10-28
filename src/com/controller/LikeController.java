package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Blog;
import com.model.Blogger;
import com.model.Like;
import com.service.BlogService;
import com.service.LikeService;

/**
 * 点赞Controller业务控制类
 */
@Controller
public class LikeController {
	/**
	 * 注入Service
	 */
	@Autowired
	private LikeService likeService;

	@Autowired
	private BlogService blogService;

	/**
	 * 跳转到新增点赞界面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/like_toAdd")
	public String toAdd(HttpServletRequest request) throws Exception {
		return "/admin/like/like_add.jsp";
	}

	/**
	 * 保存新增点赞
	 * 
	 * @param like
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/like_add")
	public String add(Like like, HttpServletRequest request) throws Exception {
		// 保存到数据库
		likeService.insertLike(like);
		return "redirect:like_list.action";
	}

	

	/**
	 * 删除点赞
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/like_delete")
	public String delete(HttpServletRequest request) throws Exception {
		// 根据id删除数据库记录
		int id = Integer.parseInt(request.getParameter("id"));
		likeService.deleteLike(id);
		return "redirect:like_list.action";
	}
	
	
	
	@RequestMapping(value = "/likeAdd")
	@ResponseBody
	public String likeAdd(HttpServletRequest request){
		String s="false";
		try {
			int bkid = Integer.parseInt(request.getParameter("bkid"));
			Blog blog = blogService.queryBlogById(bkid);
			blog.setLikenum(blog.getLikenum()+1);
			blogService.updateBlog(blog);
			Blogger user = (Blogger) request.getSession().getAttribute("user");
			Like like = new Like();
			like.setBkid(bkid);
			like.setUid(user.getId());
			likeService.insertLike(like);
			s="true";
		} catch (Exception e) {
			return s;
		}
		
		return s;
	}

	@RequestMapping(value = "/likeDel")
	@ResponseBody
	public String likeDel(HttpServletRequest request) throws Exception {
		String s="false";
		try {
			int bkid = Integer.parseInt(request.getParameter("bkid"));
			Blogger user = (Blogger) request.getSession().getAttribute("user");
			Blog blog = blogService.queryBlogById(bkid);
			blog.setLikenum(blog.getLikenum()-1);
			blogService.updateBlog(blog);
			int uid = user.getId();
			likeService.deleteLike(uid, bkid);
			s="true";
		} catch (Exception e) {
			return s;
		}
		
		return s;
	}

	
}

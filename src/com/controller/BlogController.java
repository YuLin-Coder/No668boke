package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Blog;
import com.model.Blogger;
import com.model.Blogtype;
import com.model.Tag;
import com.service.BlogService;
import com.service.BloggerService;
import com.service.BlogtypeService;
import com.service.TagService;
import com.util.PageBean;

/**
 * 博客Controller业务控制类
 */
@Controller
public class BlogController {
	/**
	 * 注入Service
	 */
	@Autowired
	private BlogService blogService;
	@Autowired
	private BloggerService bloggerService;
	@Autowired
	private BlogtypeService blogtypeService;
	@Autowired
	private TagService tagService;
	/**
	 * 博客列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blog_list")
	public String list(HttpServletRequest request) throws Exception {
		/**
		 * 获取分页参数
		 */
		int offset = 0; // 记录偏移量
		int counts = 0; // 总记录数
		try {
			offset = Integer.parseInt(request.getParameter("pager.offset"));
		} catch (Exception e) {
		}
		int utype= Integer.parseInt(request.getSession().getAttribute("utype").toString());
		PageBean page = new PageBean(offset);
		Blog blog = new Blog();
		
        if(utype==1){
        	Blogger blogger = (Blogger) request.getSession().getAttribute("user");
        	blog.setUid(blogger.getId());
        }
        
		String title = request.getParameter("title");
		blog.setTitle(title);
		request.setAttribute("title", title);
		String keyword = request.getParameter("keyword");
		blog.setKeyword(keyword);
		request.setAttribute("keyword", keyword);
		
		String typeid = request.getParameter("typeid");
		blog.setTypeid(typeid == null || "".equals(typeid) ? null : Integer
				.parseInt(typeid));
		request.setAttribute("typeid", typeid);
		String tagid = request.getParameter("tagid");
		if(tagid == null || "".equals(tagid)){
			request.setAttribute("tagid", null);
		}else {
			blog.setTagid(Integer.parseInt(tagid));
			request.setAttribute("tagid", tagid);
		}
		
		// 查询记录总数
		counts = blogService.getCount(blog);
		// 获取当前页记录
		List blogList = blogService.queryBlogList(blog, page);
		request.setAttribute("list", blogList);
	
		Blogtype blogtypeQuery = new Blogtype();
		List<Blogtype> blogtypeList = blogtypeService.queryBlogtypeList(
				blogtypeQuery, null);
		request.setAttribute("blogtypeList", blogtypeList);
		
		Tag tagQuery = new Tag();
		List<Tag> tagList = tagService.queryTagList(
				tagQuery, null);
		request.setAttribute("tagList", tagList);
		
		
		// 将分页相关参数放到request中
		request.setAttribute("itemSize", counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts
				/ PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		request.setAttribute("pageItem", PageBean.PAGE_IETM);
		request.setAttribute("pageTotal", page_count);
		return "/admin/blog/blog_list.jsp";
	}

	/**
	 * 跳转到新增博客界面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blog_toAdd")
	public String toAdd(HttpServletRequest request) throws Exception {
		
    	
		Blogtype blogtype = new Blogtype();
		List<Blogtype> blogtypeList = blogtypeService.queryBlogtypeList(
				blogtype, null);
		request.setAttribute("blogtypeList", blogtypeList);
		Tag tagQuery = new Tag();
		List<Tag> tagList = tagService.queryTagList(
				tagQuery, null);
		request.setAttribute("tagList", tagList);
		return "/admin/blog/blog_add.jsp";
	}

	/**
	 * 保存新增博客
	 * 
	 * @param blog
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blog_add")
	public String add(Blog blog, HttpServletRequest request) throws Exception {
		Blogger blogger = (Blogger) request.getSession().getAttribute("user");
		blog.setUid(blogger.getId());
		blog.setClickhit(0);
		blog.setReplyhit(0);
		blog.setLikenum(0);
		blog.setXq(1);
		String cdate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
		blog.setCdate(cdate);
		// 保存到数据库
		blogService.insertBlog(blog);
		return "redirect:blog_list.action";
	}

	
	/**
	 * 跳转到更新博客界面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blog_toUpdate")
	public String toUpdate(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出需要更新的记录
		Blog blog = blogService.queryBlogById(id);
		request.setAttribute("blog", blog);
	
		Blogtype blogtype = new Blogtype();
		List<Blogtype> blogtypeList = blogtypeService.queryBlogtypeList(
				blogtype, null);
		request.setAttribute("blogtypeList", blogtypeList);
		Tag tagQuery = new Tag();
		List<Tag> tagList = tagService.queryTagList(
				tagQuery, null);
		request.setAttribute("tagList", tagList);
		return "/admin/blog/blog_update.jsp";
	}

	/**
	 * 更新博客
	 * 
	 * @param blog
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blog_update")
	public String update(Blog blog, HttpServletRequest request)
			throws Exception {
		// 更新数据库
		blogService.updateBlog(blog);
		return "redirect:blog_list.action";
	}

	/**
	 * 删除博客
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blog_delete")
	public String delete(HttpServletRequest request) throws Exception {
		// 根据id删除数据库记录
		int id = Integer.parseInt(request.getParameter("id"));
		blogService.deleteBlog(id);
		return "redirect:blog_list.action";
	}

	/**
	 * 查看博客详情
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blog_toView")
	public String toView(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出记录放到request中，到前台jsp界面显示
		Blog blog = new Blog();
		blog.setId(id);
		List<Blog> list = blogService.queryBlogList(blog, null);
		blog = list.get(0);
		request.setAttribute("blog", blog);
		return "/admin/blog/blog_view.jsp";
	}
}

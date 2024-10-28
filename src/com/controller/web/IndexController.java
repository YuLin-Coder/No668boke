package com.controller.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Blog;
import com.model.Blogger;
import com.model.Blogtype;
import com.model.Fav;
import com.model.Tag;
import com.service.BlogService;
import com.service.BloggerService;
import com.service.BlogtypeService;
import com.service.FavService;
import com.service.TagService;
import com.util.PageBean;
import com.util.PageUtil;
import com.util.StringUtil;

/**
 * @Description 主页Controller
 *
 */
@Controller
public class IndexController {

	@Resource
	private BlogService blogService;
	@Resource
	private BloggerService bloggerService;
	@Resource
	private BlogtypeService blogTypeService;

	@Resource
	private FavService favService;
	
	@Resource
	private TagService tagService;

	/**
	 * @Description 请求主页
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(@RequestParam(value = "page", required = false) String page, 
			@RequestParam(value = "typeId", required = false) String typeId, 
			@RequestParam(value = "tagId", required = false) String tagId, 
			@RequestParam(value = "releaseDateStr", required = false) String releaseDateStr,
			HttpServletRequest request) throws Exception {

		ModelAndView modelAndView = new ModelAndView();

		if (StringUtil.isEmpty(page)) {
			page = "1";
		}
		// 获取分页的bean
		PageBean pageBean = new PageBean((Integer.parseInt(page)-1)*PageBean.PAGE_IETM); // 每页显示10条数据

		
		Blog ser = new Blog();
		if(tagId!=null&&!"".equals(tagId)){
			ser.setTagid(Integer.parseInt(tagId));
		}
		
		if(typeId!=null&&!"".equals(typeId)){
			ser.setTypeid(Integer.parseInt(typeId));
		}
		ser.setXq(1);
		ser.setCdate(releaseDateStr);
		int count = blogService.getCount(ser);
		// 获取博客信息
		List<Blog> blogList = blogService.queryBlogList(ser, pageBean);

		
		// 分页
		StringBuffer param = new StringBuffer();
		// 拼接参数，主要对于点击文章分类或者日期分类后，查出来的分页，要拼接具体的参数
		if (StringUtil.isNotEmpty(typeId)) {
			param.append("typeId=" + typeId + "&");
		}
		if (StringUtil.isNotEmpty(releaseDateStr)) {
			param.append("releaseDateStr=" + releaseDateStr + "&");
		}
		modelAndView.addObject("pageCode", PageUtil.genPagination( // 调用代码生成的工具类生成前台显示
				request.getContextPath() + "/index.do", // 还是请求该controller的index方法
				count, Integer.parseInt(page), 8, param.toString()));

		modelAndView.addObject("blogList", blogList);
		modelAndView.addObject("commonPage", "foreground/blog/blogList.jsp");
		modelAndView.addObject("title", "个人博客系统");
		modelAndView.setViewName("mainTemp.jsp");

		List<Blogtype> blogTypeList = blogTypeService.getBlogTypeData(null);
		request.getSession().setAttribute("blogTypeList", blogTypeList);

		
		List<Tag> tagList = tagService.queryTagList(null, null);
		request.getSession().setAttribute("tagList", tagList);

//		Blogger blogger = bloggerService.getBloggerData();
//		request.getSession().setAttribute("blogger", blogger);
		return modelAndView;

	}
	
	
	
	/**
	 * @Description 请求主页
	 * @return
	 */
	@RequestMapping("/user_index")
	public ModelAndView user_index(@RequestParam(value = "page", required = false) String page, @RequestParam(value = "typeId", required = false) String typeId, @RequestParam(value = "releaseDateStr", required = false) String releaseDateStr,
			HttpServletRequest request) throws Exception {

		ModelAndView modelAndView = new ModelAndView();

		if (StringUtil.isEmpty(page)) {
			page = "1";
		}
		// 获取分页的bean
		PageBean pageBean = new PageBean((Integer.parseInt(page)-1)*PageBean.PAGE_IETM); // 每页显示10条数据
		int bid=0;//博主页面
		if(StringUtil.isNotEmpty(request.getParameter("bid"))){
			bid = Integer.parseInt(request.getParameter("bid"));
			request.getSession().setAttribute("bid", bid);
		}
		if(bid==0){
			bid = Integer.parseInt(request.getSession().getAttribute("bid").toString()) ;
		}
		
		// map中封装起始页和每页的记录
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("start", pageBean.getStart());
//		map.put("end", pageBean.getEnd());
//		map.put("typeId", typeId);
//		map.put("releaseDateStr", releaseDateStr);
//		map.put("uid", bid);
		
		Blog ser = new Blog();
		if(typeId!=null&&!"".equals(typeId)){
			ser.setTypeid(Integer.parseInt(typeId));
		}
		ser.setUid(bid);
		ser.setCdate(releaseDateStr);
		int count = blogService.getCount(ser);
		ser.setXq(1);
		// 获取博客信息
		List<Blog> blogList = blogService.queryBlogList(ser, pageBean);


		// 分页
		StringBuffer param = new StringBuffer();
		// 拼接参数，主要对于点击文章分类或者日期分类后，查出来的分页，要拼接具体的参数
		if (StringUtil.isNotEmpty(typeId)) {
			param.append("typeId=" + typeId + "&");
		}
		if (StringUtil.isNotEmpty(releaseDateStr)) {
			param.append("releaseDateStr=" + releaseDateStr + "&");
		}
		modelAndView.addObject("pageCode", PageUtil.genPagination( // 调用代码生成的工具类生成前台显示
				request.getContextPath() + "/index.do", // 还是请求该controller的index方法
				count, Integer.parseInt(page), 10, param.toString()));

		modelAndView.addObject("blogList", blogList);
		modelAndView.addObject("commonPage", "foreground/blog/blogList_user.jsp");
		modelAndView.addObject("title", "博客主页 - 个人博客");
		modelAndView.setViewName("mainTemp2.jsp");

		List<Blogtype> blogTypeList = blogTypeService.getBlogTypeData(bid);
		request.getSession().setAttribute("blogTypeList", blogTypeList);

		Blogger blogger = bloggerService.queryBloggerById(bid);
		request.getSession().setAttribute("blogger", blogger);
		
		  //判断是否点赞
        boolean favbool=false;
        if(request.getSession().getAttribute("user")!=null){
        	Blogger user = (Blogger) request.getSession().getAttribute("user");
			Fav fav = new Fav();
			fav.setBzid(bid);
			fav.setUid(user.getId());
			List<Fav>  fs = favService.queryFavList(fav, null);
			if(fs!=null&&fs.size()>0){
				favbool = true;
			}
        }
		
		
		modelAndView.addObject("favbool", favbool);
		
		return modelAndView;

	}

	/**
	 * @Description 请求主页
	 * @return
	 */
	@RequestMapping("/")
	public String home(HttpServletRequest request) throws Exception {

		return "/index";

	}
}

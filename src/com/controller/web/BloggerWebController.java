package com.controller.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.model.Blogger;
import com.model.Rizhi;
import com.service.BlogService;
import com.service.BloggerService;
import com.service.BlogtypeService;
import com.service.CommentService;
import com.util.MD5Util;
import com.util.ResponseUtil;

/**
 * @Description 博主控制层前台 不需要shiro认证
 */
@Controller
@RequestMapping("/blogger")
public class BloggerWebController {

	@Resource
	private BloggerService bloggerService;

	
	
	
	@Resource
	private BlogtypeService blogTypeService;
	@Resource
	private CommentService commentService;

	@Resource
	private BlogService blogService;
	
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(Blogger blogger, HttpServletResponse response, HttpServletRequest req) throws Exception {
		Blogger ser = new Blogger();
		ser.setUsername(blogger.getUsername());
		List list = bloggerService.queryBloggerList(ser, null);
		
		if (list != null && list.size() > 0) {
			req.setAttribute("errinfo", "用户名已存在");
		} else {
			String password = MD5Util.md5(blogger.getPassword(), "blog");
			blogger.setPassword(password);
			
			bloggerService.insertBlogger(blogger);
			req.setAttribute("closeDiv", "Y");
		}
		return "foreground/register.jsp";
	}

	
	/**
	 * 用户登陆
	 * @param blogger
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Blogger blogger,HttpServletResponse response,  HttpServletRequest request) throws Exception {
		JSONObject result = new JSONObject();
		// 获取登录实体
		boolean flag = false;
		
		Blogger ser = new Blogger();
		String password = MD5Util.md5(blogger.getPassword(), "blog");
		ser.setUsername(blogger.getUsername());
		ser.setPassword(password);
		List<Blogger> userList = bloggerService.queryBloggerList(ser, null);
		if (userList != null && userList.size() > 0) {
			result.put("success", "Y");
			Blogger user = userList.get(0);
			Rizhi rizhi = new Rizhi();
			rizhi.setUid(user.getId());
			String cdate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
			rizhi.setCdate(cdate);
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("utype", 1);
			flag = true;
			
		}
		if(!flag){
			result.put("success", "N");
		}
		ResponseUtil.write(response, result);
		return null;
		
	}
	
	@RequestMapping(value = "/loginout")
	public String loginout( HttpServletResponse response, HttpServletRequest req) throws Exception {
		req.getSession().setAttribute("user", null);
		req.getSession().setAttribute("bid", null);
		req.getSession().setAttribute("utype", null);
		req.getSession().invalidate();
		return "/default.jsp";
	}
	
	@RequestMapping("/indexinfo")
	public String indexinfo(HttpServletRequest request) {
		return "forward:/admin/index.jsp";
		
	}

	
	
	@RequestMapping("/aboutme")
	public ModelAndView abouotMe(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		int bid = Integer.parseInt(request.getSession().getAttribute("bid").toString()) ;
		
		Blogger blogger = bloggerService.queryBloggerById(bid);
		modelAndView.addObject("blogger", blogger);
		modelAndView.addObject("commonPage", "foreground/blogger/bloggerInfo.jsp");
		modelAndView.addObject("title", "关于");
		modelAndView.setViewName("mainTemp2.jsp");
		return modelAndView;
	}

//	@RequestMapping("/liuyan")
//	public ModelAndView liuyan(HttpServletRequest request) {
//		int bid = Integer.parseInt(request.getSession().getAttribute("bid").toString()) ;
//		ModelAndView modelAndView = new ModelAndView();
//		List<Liuyan> lylist = wendaService.getTotalData( bid);
//		modelAndView.addObject("lylist", lylist);
//		modelAndView.addObject("commonPage", "foreground/blogger/liuyanInfo.jsp");
//		modelAndView.addObject("title", "在线留言");
//		modelAndView.setViewName("mainTemp2");
//		return modelAndView;
//	}
	

	
	
	@RequestMapping("/suggest")
	public ModelAndView suggest() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("commonPage", "foreground/blogger/suggestInfo.jsp");
		modelAndView.addObject("title", "留言建议");
		modelAndView.setViewName("mainTemp.jsp");
		return modelAndView;
	}


	
	
	
	

}

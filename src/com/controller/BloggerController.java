package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Blogger;
import com.service.BloggerService;
import com.util.MD5Util;
import com.util.PageBean;

/**
 * 用户Controller业务控制类
 */
@Controller
public class BloggerController {
	/**
	 * 注入Service
	 */
	@Autowired
	private BloggerService bloggerService;

	/**
	 * 用户列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blogger_list")
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
		PageBean page = new PageBean(offset);
		Blogger blogger = new Blogger();
		String username = request.getParameter("username");
		blogger.setUsername(username);
		request.setAttribute("username", username);
		String nickname = request.getParameter("nickname");
		blogger.setNickname(nickname);
		request.setAttribute("nickname", nickname);
		// 查询记录总数
		counts = bloggerService.getCount(blogger);
		// 获取当前页记录
		List bloggerList = bloggerService.queryBloggerList(blogger, page);
		request.setAttribute("list", bloggerList);
		// 将分页相关参数放到request中
		request.setAttribute("itemSize", counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts
				/ PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		request.setAttribute("pageItem", PageBean.PAGE_IETM);
		request.setAttribute("pageTotal", page_count);
		return "/admin/blogger/blogger_list.jsp";
	}

	/**
	 * 跳转到新增用户界面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blogger_toAdd")
	public String toAdd(HttpServletRequest request) throws Exception {
		return "/admin/blogger/blogger_add.jsp";
	}

	/**
	 * 保存新增用户
	 * 
	 * @param blogger
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blogger_add")
	public String add(Blogger blogger, HttpServletRequest request)
			throws Exception {
		// 保存到数据库
		bloggerService.insertBlogger(blogger);
		return "redirect:blogger_list.action";
	}

	/**
	 * 跳转到更新用户界面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blogger_toUpdate")
	public String toUpdate(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出需要更新的记录
		Blogger blogger = bloggerService.queryBloggerById(id);
		request.setAttribute("blogger", blogger);
		return "/admin/blogger/blogger_update.jsp";
	}

	/**
	 * 更新用户
	 * 
	 * @param blogger
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blogger_update")
	public String update(Blogger blogger, HttpServletRequest request)
			throws Exception {
		// 更新数据库
		bloggerService.updateBlogger(blogger);
		return "redirect:blogger_list.action";
	}

	/**
	 * 删除用户
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blogger_delete")
	public String delete(HttpServletRequest request) throws Exception {
		// 根据id删除数据库记录
		int id = Integer.parseInt(request.getParameter("id"));
		bloggerService.deleteBlogger(id);
		return "redirect:blogger_list.action";
	}

	/**
	 * 查看用户详情
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blogger_toView")
	public String toView(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出记录放到request中，到前台jsp界面显示
		Blogger blogger = bloggerService.queryBloggerById(id);
		request.setAttribute("blogger", blogger);
		return "/admin/blogger/blogger_view.jsp";
	}

	/**
	 * 判断账号是否存在
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/blogger_usernameExist")
	public String usernameExist(HttpServletRequest request) throws Exception {
		String exist = "true";
		String username = request.getParameter("username");
		Blogger blogger = new Blogger();
		blogger.setUsername(username);
		List list = bloggerService.queryBloggerList(blogger, null);
		if (list != null && list.size() > 0) {
			exist = "false"; // 验证插件需要返回false 返回false时验证提示已存在
		}
		return exist;
	}

	

	/**
	 * 修改个人主页
	 * 
	 * @param blogger
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blogger_zhuye")
	public String zhuye(Blogger blogger, HttpServletRequest request)
			throws Exception {
		Blogger old_blogger = bloggerService.queryBloggerById(blogger.getId());
		old_blogger.setProfile(blogger.getProfile());
		// 更新数据库
		bloggerService.updateBlogger(old_blogger);
		
		request.getSession().setAttribute("user", old_blogger);
		request.setAttribute("message", "操作成功");
		request.setAttribute("path", "/admin/blogger/blogger_zhuye.jsp");
		return "/common/succeed.jsp";
	}
	
	
	/**
	 * 个人中心信息修改
	 * 
	 * @param blogger
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blogger_info")
	public String info(Blogger blogger, HttpServletRequest request) throws Exception {
		// 更新数据库
		Blogger old_blogger = bloggerService.queryBloggerById(blogger.getId());
		
		blogger.setProfile(old_blogger.getProfile());
		bloggerService.updateBlogger(blogger);
		List<Blogger> list = bloggerService.queryBloggerList(blogger, null);
		blogger = list.get(0);
		request.getSession().setAttribute("user", blogger);
		request.setAttribute("message", "操作成功");
		request.setAttribute("path", "/admin/blogger/blogger_info.jsp");
		return "/common/succeed.jsp";
	}

	/**
	 * 更新密码
	 * 
	 * @param tadmin
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blogger_upwd")
	public String upwd(HttpServletRequest request) throws Exception {
		String upwd = request.getParameter("upwd");
		Blogger blogger = (Blogger) request.getSession().getAttribute("user");
		
		// 需要用md5
		String password = MD5Util.md5(upwd, "blog");
		blogger.setPassword(password);
		bloggerService.updateBlogger(blogger);
		request.getSession().setAttribute("user", blogger);

		request.setAttribute("message", "操作成功");
		request.setAttribute("path", "/admin/blogger/blogger_upwd.jsp");
		return "/common/succeed.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value = "/blogger_upwdVal")
	public String upwdVal(HttpServletRequest request) throws Exception {
		String exist = "true";
		String pwd = request.getParameter("pwd");
		String password = MD5Util.md5(pwd, "blog");
		
		Blogger blogger = (Blogger) request.getSession().getAttribute("user");
		if (!blogger.getPassword().equals(password)) {
			exist = "false"; // 验证插件需要返回false 返回false时验证提示已存在
		}
		return exist;
	}
}

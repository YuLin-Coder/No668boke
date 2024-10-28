package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Blogger;
import com.model.Rizhi;
import com.model.Tadmin;
import com.service.BloggerService;
import com.service.RizhiService;
import com.service.TadminService;

/**
 * 登录Controller控制类
 */
@Controller
public class LoginController {
	/**
	 * 注入Service
	 */
	@Autowired
	private TadminService tadminService;
	@Autowired
	private BloggerService userService;
	@Autowired
	private RizhiService rizhiService;
	/**
	 * 用户登录
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/tadmin_login")
	public String login(HttpServletRequest request) throws Exception {
		String flag = "false";
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		int utype = Integer.parseInt(request.getParameter("utype"));

		if (utype == 0) {
			Tadmin tadmin = new Tadmin();
			tadmin.setUname(uname);
			tadmin.setUpwd(upwd);
			List<Tadmin> tadminList = tadminService.queryTadminList(tadmin,
					null);
			if (tadminList != null && tadminList.size() > 0) {
				Tadmin admin = tadminList.get(0);
				request.getSession().setAttribute("cuser", admin);
				
				
				flag = "true";
			}
		}

		if (utype == 1) {
			Blogger ser = new Blogger();
			ser.setUsername(uname);
			ser.setPassword(upwd);
			List<Blogger> userList = userService.queryBloggerList(ser, null);
			if (userList != null && userList.size() > 0) {
				Blogger user = userList.get(0);
				
				request.getSession().setAttribute("user", user);
				
				Rizhi rizhi = new Rizhi();
				rizhi.setUid(user.getId());
				String cdate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				rizhi.setCdate(cdate);
				rizhiService.insertRizhi(rizhi);
				flag = "true";
			}

		}

		request.getSession().setAttribute("utype", utype);
		return flag;
	}

	@RequestMapping(value = "/tadmin_loginout")
	public String loginout(HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("cuser", null);
		request.getSession().invalidate();
		return "/admin/login.jsp";
	}

}

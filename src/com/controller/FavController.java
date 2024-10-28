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
import com.model.Fav;
import com.service.BloggerService;
import com.service.FavService;
import com.util.PageBean;

/**
 * 关注Controller业务控制类
 */
@Controller
public class FavController {
	/**
	 * 注入Service
	 */
	@Autowired
	private FavService favService;
	@Autowired
	private BloggerService bloggerService;

	/**
	 * 关注列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/fav_list")
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
		
		Blogger blogger = (Blogger) request.getSession().getAttribute("user");
		Fav fav = new Fav();
		fav.setUid(blogger.getId());
		String bzid = request.getParameter("bzid");
		fav.setBzid(Integer.parseInt(bzid == null || "".equals(bzid) ? "0"
				: bzid));
		request.setAttribute("bzid", bzid);
		// 查询记录总数
		counts = favService.getCount(fav);
		// 获取当前页记录
		List favList = favService.queryFavList(fav, page);
		request.setAttribute("list", favList);
		Blogger bloggerQuery = new Blogger();
		List<Blogger> bloggerList = bloggerService.queryBloggerList(
				bloggerQuery, null);
		request.setAttribute("bloggerList", bloggerList);
		// 将分页相关参数放到request中
		request.setAttribute("itemSize", counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts
				/ PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		request.setAttribute("pageItem", PageBean.PAGE_IETM);
		request.setAttribute("pageTotal", page_count);
		return "/admin/fav/fav_list.jsp";
	}

	/**
	 * 跳转到新增关注界面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/fav_toAdd")
	public String toAdd(HttpServletRequest request) throws Exception {
		Blogger blogger = new Blogger();
		List<Blogger> bloggerList = bloggerService.queryBloggerList(blogger,
				null);
		request.setAttribute("bloggerList", bloggerList);
		return "/admin/fav/fav_add.jsp";
	}

	/**
	 * 保存新增关注
	 * 
	 * @param fav
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/fav_add")
	public String add(Fav fav, HttpServletRequest request) throws Exception {
		// 保存到数据库
		favService.insertFav(fav);
		return "redirect:fav_list.action";
	}

	/**
	 * 跳转到更新关注界面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/fav_toUpdate")
	public String toUpdate(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出需要更新的记录
		Fav fav = favService.queryFavById(id);
		request.setAttribute("fav", fav);
		Blogger blogger = new Blogger();
		List<Blogger> bloggerList = bloggerService.queryBloggerList(blogger,
				null);
		request.setAttribute("bloggerList", bloggerList);
		return "/admin/fav/fav_update.jsp";
	}

	/**
	 * 更新关注
	 * 
	 * @param fav
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/fav_update")
	public String update(Fav fav, HttpServletRequest request) throws Exception {
		// 更新数据库
		favService.updateFav(fav);
		return "redirect:fav_list.action";
	}

	/**
	 * 删除关注
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/fav_delete")
	public String delete(HttpServletRequest request) throws Exception {
		// 根据id删除数据库记录
		int id = Integer.parseInt(request.getParameter("id"));
		favService.deleteFav(id);
		return "redirect:fav_list.action";
	}

	/**
	 * 查看关注详情
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/fav_toView")
	public String toView(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出记录放到request中，到前台jsp界面显示
		Fav fav = new Fav();
		fav.setId(id);
		List<Fav> list = favService.queryFavList(fav, null);
		fav = list.get(0);
		request.setAttribute("fav", fav);
		return "/admin/fav/fav_view.jsp";
	}
	
	@RequestMapping(value = "/favAdd")
	@ResponseBody
	public String favAdd(HttpServletRequest request) {
		String s = "false";
		try {
			int bzid = Integer.parseInt(request.getParameter("bzid"));

			Blogger blogger = (Blogger) request.getSession().getAttribute("user");
			Fav fav = new Fav();
			fav.setBzid(bzid);
			fav.setUid(blogger.getId());
			fav.setCdate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(new Date()));
			favService.insertFav(fav);
			s = "true";
		} catch (Exception e) {
			return s;
		}

		return s;
	}

	@RequestMapping(value = "/favDel")
	@ResponseBody
	public String favDel(HttpServletRequest request) throws Exception {
		String s = "false";
		try {
			int bzid = Integer.parseInt(request.getParameter("bzid"));
			Blogger blogger = (Blogger) request.getSession().getAttribute("user");

			int uid = blogger.getId();
			favService.deleteFav(uid, bzid);
			s = "true";
		} catch (Exception e) {
			return s;
		}

		return s;
	}

	@RequestMapping(value = "/fav_del")
	public String del(HttpServletRequest request) throws Exception {

		int bzid = Integer.parseInt(request.getParameter("bzid"));
		Blogger blogger = (Blogger) request.getSession().getAttribute("user");

		int uid = blogger.getId();
		favService.deleteFav(uid, bzid);
		request.setAttribute("message", "操作成功");
		request.setAttribute("path", "my_fav_list.action");
		return "common/succeed.jsp";
	}

	/**
	 * 我的收藏列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/my_fav_list")
	public String my_fav_list(HttpServletRequest request) throws Exception {

		int offset = 0; // 记录偏移量
		int counts = 0; // 总记录数
		try {
			offset = Integer.parseInt(request.getParameter("pager.offset"));
		} catch (Exception e) {
		}
		PageBean page = new PageBean(offset);
		Blogger user = (Blogger) request.getSession().getAttribute("user");
		Fav ser = new Fav();
		ser.setUid(user.getId());
		// 查询记录总数
		counts = favService.getCount(ser);
		List<Fav> favList = favService.queryFavList(ser, page);
		if (favList != null && favList.size() > 0) {
			for (Fav fav : favList) {
				Blogger bloggerVO = bloggerService.queryBloggerById(fav
						.getBzid());
				if (bloggerVO != null) {
					fav.setBloggerVO(bloggerVO);
				}
			}
		}

		request.setAttribute("favList", favList);
		request.setAttribute("itemSize", counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts
				/ PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		request.setAttribute("pageItem", PageBean.PAGE_IETM);
		request.setAttribute("pageTotal", page_count);
		request.setAttribute("nav", 3);
		return "/web/user/my_fav_list.jsp";
	}
	
	
	/****************************************************************/
	
	
	/**
	 * 关注列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/fan_list")
	public String fan_list(HttpServletRequest request) throws Exception {
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
		
		Blogger blogger = (Blogger) request.getSession().getAttribute("user");
		Fav fav = new Fav();
		fav.setBzid(blogger.getId());
		// 查询记录总数
		counts = favService.getCount(fav);
		// 获取当前页记录
		List<Fav> favList = favService.queryFavList(fav, page);
		if(favList!=null&&favList.size()>0){
			for (Fav fav2 : favList) {
				Blogger userVO = bloggerService.queryBloggerById(fav2.getUid());
				fav2.setUserVO(userVO);
			}
		}
		request.setAttribute("list", favList);
	
		// 将分页相关参数放到request中
		request.setAttribute("itemSize", counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts
				/ PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		request.setAttribute("pageItem", PageBean.PAGE_IETM);
		request.setAttribute("pageTotal", page_count);
		return "/admin/fav/fan_list.jsp";
	}
	
	
	/**
	 * 移除粉丝
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/fan_delete")
	public String fan_delete(HttpServletRequest request) throws Exception {
		// 根据id删除数据库记录
		int id = Integer.parseInt(request.getParameter("id"));
		favService.deleteFav(id);
		return "redirect:fan_list.action";
	}
}

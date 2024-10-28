package com.controller;

import com.model.Blogtype;
import com.service.BlogtypeService;
import com.util.PageBean;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 分类Controller业务控制类
 */
@Controller
public class BlogtypeController {
	/**
	 * 注入Service
	 */
	@Autowired
	private BlogtypeService blogtypeService;

	/**
	 * 分类列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blogtype_list")
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
		Blogtype blogtype = new Blogtype();
		// 查询记录总数
		counts = blogtypeService.getCount(blogtype);
		// 获取当前页记录
		List blogtypeList = blogtypeService.queryBlogtypeList(blogtype, page);
		request.setAttribute("list", blogtypeList);
		// 将分页相关参数放到request中
		request.setAttribute("itemSize", counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts
				/ PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		request.setAttribute("pageItem", PageBean.PAGE_IETM);
		request.setAttribute("pageTotal", page_count);
		return "/admin/blogtype/blogtype_list.jsp";
	}

	/**
	 * 跳转到新增分类界面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blogtype_toAdd")
	public String toAdd(HttpServletRequest request) throws Exception {
		return "/admin/blogtype/blogtype_add.jsp";
	}

	/**
	 * 保存新增分类
	 * 
	 * @param blogtype
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blogtype_add")
	public String add(Blogtype blogtype, HttpServletRequest request)
			throws Exception {
		// 保存到数据库
		blogtypeService.insertBlogtype(blogtype);
		return "redirect:blogtype_list.action";
	}

	/**
	 * 跳转到更新分类界面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blogtype_toUpdate")
	public String toUpdate(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出需要更新的记录
		Blogtype blogtype = blogtypeService.queryBlogtypeById(id);
		request.setAttribute("blogtype", blogtype);
		return "/admin/blogtype/blogtype_update.jsp";
	}

	/**
	 * 更新分类
	 * 
	 * @param blogtype
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blogtype_update")
	public String update(Blogtype blogtype, HttpServletRequest request)
			throws Exception {
		// 更新数据库
		blogtypeService.updateBlogtype(blogtype);
		return "redirect:blogtype_list.action";
	}

	/**
	 * 删除分类
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blogtype_delete")
	public String delete(HttpServletRequest request) throws Exception {
		// 根据id删除数据库记录
		int id = Integer.parseInt(request.getParameter("id"));
		blogtypeService.deleteBlogtype(id);
		return "redirect:blogtype_list.action";
	}

	/**
	 * 查看分类详情
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/blogtype_toView")
	public String toView(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出记录放到request中，到前台jsp界面显示
		Blogtype blogtype = blogtypeService.queryBlogtypeById(id);
		request.setAttribute("blogtype", blogtype);
		return "/admin/blogtype/blogtype_view.jsp";
	}
}

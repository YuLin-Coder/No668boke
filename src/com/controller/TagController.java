package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Tag;
import com.service.TagService;
import com.util.PageBean;

/**
 * 标签Controller业务控制类
 */
@Controller
public class TagController {
	/**
	 * 注入Service
	 */
	@Autowired
	private TagService tagService;

	/**
	 * 标签列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/tag_list")
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
		Tag tag = new Tag();
		// 查询记录总数
		counts = tagService.getCount(tag);
		// 获取当前页记录
		List tagList = tagService.queryTagList(tag, page);
		request.setAttribute("list", tagList);
		// 将分页相关参数放到request中
		request.setAttribute("itemSize", counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts
				/ PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		request.setAttribute("pageItem", PageBean.PAGE_IETM);
		request.setAttribute("pageTotal", page_count);
		return "/admin/tag/tag_list.jsp";
	}

	/**
	 * 跳转到新增标签界面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/tag_toAdd")
	public String toAdd(HttpServletRequest request) throws Exception {
		return "/admin/tag/tag_add.jsp";
	}

	/**
	 * 保存新增标签
	 * 
	 * @param tag
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/tag_add")
	public String add(Tag tag, HttpServletRequest request)
			throws Exception {
		// 保存到数据库
		tagService.insertTag(tag);
		return "redirect:tag_list.action";
	}

	/**
	 * 跳转到更新标签界面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/tag_toUpdate")
	public String toUpdate(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出需要更新的记录
		Tag tag = tagService.queryTagById(id);
		request.setAttribute("tag", tag);
		return "/admin/tag/tag_update.jsp";
	}

	/**
	 * 更新标签
	 * 
	 * @param tag
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/tag_update")
	public String update(Tag tag, HttpServletRequest request)
			throws Exception {
		// 更新数据库
		tagService.updateTag(tag);
		return "redirect:tag_list.action";
	}

	/**
	 * 删除标签
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/tag_delete")
	public String delete(HttpServletRequest request) throws Exception {
		// 根据id删除数据库记录
		int id = Integer.parseInt(request.getParameter("id"));
		tagService.deleteTag(id);
		return "redirect:tag_list.action";
	}

	/**
	 * 查看标签详情
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/tag_toView")
	public String toView(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出记录放到request中，到前台jsp界面显示
		Tag tag = tagService.queryTagById(id);
		request.setAttribute("tag", tag);
		return "/admin/tag/tag_view.jsp";
	}
}

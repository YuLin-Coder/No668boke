package com.controller;

import com.model.Blogger;
import com.model.Rizhi;
import com.service.BloggerService;
import com.service.RizhiService;
import com.util.PageBean;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 日志Controller业务控制类
 */
@Controller
public class RizhiController {
	/**
	 * 注入Service
	 */
	@Autowired
	private RizhiService rizhiService;
	@Autowired
	private BloggerService bloggerService;
	/**
	 * 日志列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/rizhi_list")
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
		Rizhi rizhi = new Rizhi();
	
		String cdate = request.getParameter("cdate");
		rizhi.setCdate(cdate);
		request.setAttribute("cdate", cdate);
		// 查询记录总数
		counts = rizhiService.getCount(rizhi);
		// 获取当前页记录
		List<Rizhi> rizhiList = rizhiService.queryRizhiList(rizhi, page);
		if(rizhiList!=null&&rizhiList.size()>0){
			for (Rizhi rizhi2 : rizhiList) {
				Blogger userVO = bloggerService.queryBloggerById(rizhi2.getUid());
				if(userVO!=null){
					rizhi2.setUserVO(userVO);
				}
			}
		}
		
		request.setAttribute("list", rizhiList);
		// 将分页相关参数放到request中
		request.setAttribute("itemSize", counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts
				/ PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		request.setAttribute("pageItem", PageBean.PAGE_IETM);
		request.setAttribute("pageTotal", page_count);
		return "/admin/rizhi/rizhi_list.jsp";
	}

	

	/**
	 * 删除日志
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/rizhi_delete")
	public String delete(HttpServletRequest request) throws Exception {
		// 根据id删除数据库记录
		int id = Integer.parseInt(request.getParameter("id"));
		rizhiService.deleteRizhi(id);
		return "redirect:rizhi_list.action";
	}


}

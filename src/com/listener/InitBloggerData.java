package com.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.model.Blogtype;
import com.service.BlogService;
import com.service.BloggerService;
import com.service.BlogtypeService;



@Component
/**
 * @Description 监听程序初始化
 */
public class InitBloggerData implements ServletContextListener, ApplicationContextAware {

	private static ApplicationContext applicationContext;

	public void contextInitialized(ServletContextEvent sce) {
		// 先获取servlet上下文
		ServletContext application = sce.getServletContext();

		// 同上，获取博客类别信息service
		BlogtypeService blogTypeService = applicationContext.getBean(BlogtypeService.class);
		// 获取博主信息service
		BloggerService bloggerService = applicationContext.getBean(BloggerService.class);
		
		// 获取博客service
		BlogService blogService = applicationContext.getBean(BlogService.class);
		// 获取博客信息
		List<Blogtype> blogTypeList;
		try {
			blogTypeList = blogTypeService.queryBlogtypeList(null, null);
			application.setAttribute("blogTypeList", blogTypeList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		// application.setAttribute("blogList",blogService);

	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		InitBloggerData.applicationContext = applicationContext;
	}

}

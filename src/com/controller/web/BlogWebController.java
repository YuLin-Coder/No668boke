package com.controller.web;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Blog;
import com.model.Blogger;
import com.model.Comment;
import com.model.Like;
import com.service.BlogService;
import com.service.BloggerService;
import com.service.CommentService;
import com.service.LikeService;
import com.util.PageBean;
import com.util.PageUtil;
import com.util.StringUtil;

/**
 * @Description 博客前台访问控制层
 */
@Controller
@RequestMapping(value = "blog")
public class BlogWebController {

    @Resource
    private BlogService blogService;
    @Resource
    private BloggerService bloggerService;
    
    @Resource
    private CommentService commentService;
    
    @Resource
    private LikeService likeService;
 

    // 请求博客详细信息
    @RequestMapping("/articles/{id}")
    public ModelAndView details(@PathVariable("id") Integer id,
                                HttpServletRequest request) throws Exception {

        ModelAndView modelAndView = new ModelAndView();
        Blog blog = new Blog();
		blog.setId(id);
		blog.setXq(1);
		List<Blog> list = blogService.queryBlogList(blog, null);
		blog = list.get(0);// 根据id获取博客

        // 获取关键字
        String keyWords = blog.getKeyword();
        if (StringUtil.isNotEmpty(keyWords)) {
            String[] strArray = keyWords.split(" ");
            List<String> keyWordsList = StringUtil.filterWhite(Arrays
                    .asList(strArray));
            modelAndView.addObject("keyWords", keyWordsList);
        } else {
            modelAndView.addObject("keyWords", null);
        }
        
        Blogger blogger = bloggerService.queryBloggerById(blog.getUid());
       
        if(blogger!=null){
        	blog.setBloggerVO(blogger);
        }
        //判断是否点赞
        boolean likebool=false;
        if(request.getSession().getAttribute("user")!=null){
        	Blogger user = (Blogger) request.getSession().getAttribute("user");
            Like like = new Like();
    		like.setBkid(blog.getUid());;
    		like.setUid(user.getId());
    		List<Like>  ls = likeService.queryLikeList(like, null);
    		if(ls!=null&&ls.size()>0){
    			likebool=true;
    		}
        }
        
		modelAndView.addObject("likebool", likebool);

        modelAndView.addObject("blog", blog);
        blog.setClickhit(blog.getClickhit() + 1); // 将博客访问量加1
        blogService.updateBlog(blog); // 更新博客

        // 查询评论信息
        Comment comment = new Comment();
        comment.setBlogid(blog.getId());
        comment.setState(1);
        List<Comment> commentList = commentService.queryCommentList(comment, null);

        modelAndView.addObject("commentList", commentList);
        modelAndView.addObject("commonPage", "foreground/blog/blogDetail.jsp");
        modelAndView.addObject("title", blog.getTitle() + " - 个人博客");

        // 存入上一篇和下一篇的显示代码
        modelAndView.addObject("pageCode", PageUtil.getPrevAndNextPageCode(
                blogService.getPrevBlog(id,null), blogService.getNextBlog(id,null),
                request.getContextPath()));

        modelAndView.setViewName("mainTemp.jsp");

        return modelAndView;
    }


    // 根据关键字查询博客信息
    @RequestMapping("/search")
    public ModelAndView search(
            @RequestParam(value = "q", required = false) String q,
            @RequestParam(value = "page", required = false) String page,
            HttpServletRequest request) throws Exception {

        int pageSize = 10;
        ModelAndView modelAndView = new ModelAndView();
 
        if(page == null) { //page为空表示第一次搜索
            page = "1";
        }
        // 获取分页的bean
        PageBean pageBean = new PageBean((Integer.parseInt(page)-1)*PageBean.PAGE_IETM); //每页显示10条数据

        // map中封装起始页和每页的记录
        Blog ser = new Blog();
        ser.setTitle(q);
        ser.setXq(1);
        // 获取博客信息
        List<Blog> blogList = blogService.queryBlogList(ser, pageBean);

//        for(Blog blog : blogList) {
//            List<String> imageList = blog.getImageList();
//            String blogInfo = blog.getContent(); //获取博客内容
//            Document doc = Jsoup.parse(blogInfo); //将博客内容(网页中也就是一些html)转为jsoup的Document
//            Elements jpgs = doc.select("img[src$=.jpg]");//获取<img>标签中所有后缀是.jpg的元素
//            for(int i = 0; i < jpgs.size(); i++) {
//                Element jpg = jpgs.get(i); //获取到单个元素
//                imageList.add(jpg.toString()); //把图片信息存到imageList中
//                if(i == 2)
//                    break; //只存三张图片信息
//            }
//        }
 
        modelAndView.addObject("blogList", blogList);
        modelAndView.addObject("commonPage", "foreground/blog/searchResult.jsp");
        modelAndView.addObject("title", "搜索'" + q + "'的结果");
        modelAndView.setViewName("mainTemp.jsp");
        return modelAndView;
    }
}

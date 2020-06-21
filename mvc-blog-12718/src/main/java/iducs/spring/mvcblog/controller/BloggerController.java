package iducs.spring.mvcblog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iducs.spring.mvcblog.domain.Blog;
import iducs.spring.mvcblog.domain.Blogger;
import iducs.spring.mvcblog.service.BloggerService;

@Controller
public class BloggerController {
	private BloggerService bloggerService;
	public BloggerController(BloggerService bloggerService)  { // 생성자를 활용한 주입
		this.bloggerService = bloggerService;
	}
    
    @GetMapping("/bloggers/all") // 관리자(admin2012718)만 회원 목록 
    public String getBloggers(Model model) throws Exception {    
    	List<Blogger> bloggerList = bloggerService.getBloggers();
    	model.addAttribute("bloggerList", bloggerList);
        return "/bloggers/get-bloggers";
    }    
    
    @GetMapping("/bloggers/{id}") // 조회
    public String getBlogger(@PathVariable("id") Long id, Model model) throws Exception {  
    	Blogger blogger = bloggerService.getBlogger(id);
        model.addAttribute("blogger", blogger);
        return "/bloggers/info-form";
    }
    
    @PostMapping("/bloggers") // 등록
    @Transactional    
    public String postBlogger(    		
    		@RequestParam final String bid,     		
    		@RequestParam final String bpw,
    		@RequestParam final String bname,
    		@RequestParam final String bemail,
    		//HttpServletRequest request,
    		Model model) throws IllegalStateException, IOException {     	
    	Blogger blogger = new Blogger();
    	/*
    	blogger.setBid(request.getParameter("bid"));    	
    	blogger.setBpw(request.getParameter("bpw"));    
    	blogger.setBname(request.getParameter("bname"));    	
    	blogger.setBemail(request.getParameter("bemail"));  
    	*/
    	blogger.setBid(bid);
    	blogger.setBpw(bpw);
    	blogger.setBname(bname);
    	blogger.setBemail(bemail);
    	
    	bloggerService.postBlogger(blogger);
		return "redirect:" + "/";
    }
    
    @GetMapping("/bloggers/new") // 등록폼
    public String getNewBlogger(Model model) throws Exception {
        return "/bloggers/new-form";
    }
    
    @PostMapping("/bloggers/login") 
    public String loginBlogger(
    		@RequestParam final String bid,     		
    		@RequestParam final String bpw,
    		HttpSession session,
    		HttpServletRequest request,
    		Model model) throws Exception {
    	Blogger blogger = bloggerService.getUserByBid(bid);
    	if(blogger != null && blogger.getBpw().equals(bpw)) {
    		session.setAttribute("blogger", blogger);
//    		return "redirect:" + session.getAttribute("uri").toString(); //서버 설정에 따라 다르므로 주석처리 후 메인으로 가도록 설정
    		System.out.println(session.getAttribute("uri").toString());
    		return "redirect:" + "/";
    	}
    	else {
//    		return "/bloggers/error";
    		throw new Exception("회원정보를 확인하십시오.");
    	}	
    }
       
    @GetMapping("/bloggers/login") 
    public String loginForm(Model model) throws Exception {    
        return "/bloggers/login-form";
    }
    
    @GetMapping("/bloggers/logout") 
    public String logoutBlogger(HttpSession session, Model model) throws Exception {
    	session.invalidate();
    	return "redirect:/";
    }

    // @PostMapping("/bloggers/{id}") // 업데이트 - hidden 
    @PutMapping("/bloggers/{id}") 
    @Transactional
    public String updateBlog(
    		@PathVariable long id,
    		@RequestParam String bid,     		
    		@RequestParam String bpw,
    		@RequestParam String bname,
    		@RequestParam String bemail,
    		//HttpServletRequest request,
    		Model model) throws IllegalStateException, IOException {
    	Blogger blogger = new Blogger();
    	blogger.setId(id);
    	blogger.setBid(bid);  
    	blogger.setBpw(bpw);
    	blogger.setBname(bname);
    	blogger.setBemail(bemail);
    	System.out.println(bname);
    	
    	int count = bloggerService.updateBlogger(blogger);
    	if(count > 0) {
    		return "redirect:/bloggers/" + id;
    	}
    	else 
    		return "redirect:/bloggers/error";
    }
    
    @GetMapping("/bloggers/edit") // 정보 확인과 수정을 구분하는 경우만 사용함
    public String editBlog(@RequestParam(name="id") long id, Model model) throws Exception {
    	Blogger blogger = bloggerService.getBlogger(id);
        model.addAttribute("blogger", blogger);
        return "/bloggers/edit-form";
    }
    
    @DeleteMapping("/bloggers/{id}")
    public String deleteBlog(@PathVariable long id, HttpSession session, Model model) throws Exception {
    	int count = bloggerService.deleteBlogger(id);
    	if(count > 0) {
    		session.invalidate();
    		return "redirect:/";
    	}
    	else     		
    		return "redirect:/bloggers/error";
    }    	
}
